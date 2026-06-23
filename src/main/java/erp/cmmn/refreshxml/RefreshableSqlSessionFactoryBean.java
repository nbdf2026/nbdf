package erp.cmmn.refreshxml;


import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;


/**
* @packageName    : erp.cmmn.web
* @fileName       : RefreshableSqlSessionFactoryBean.java
* @author         : Built1
* @date           : 2026.06.18
* @description    : XML 서버 재시작 없이 실시간으로 반영 파일
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.18        Built1             최초 생성
*/
public class RefreshableSqlSessionFactoryBean extends SqlSessionFactoryBean {
    private static final Logger logger = LoggerFactory.getLogger(RefreshableSqlSessionFactoryBean.class);

    private SqlSessionFactory proxy;
    private int checkInterval = 5000; // 감시 주기 (기본 5초)
    private Timer timer;
    private Resource[] mapperLocations;

    @Override
    public void setMapperLocations(Resource... mapperLocations) {
        super.setMapperLocations(mapperLocations);
        this.mapperLocations = mapperLocations;
    }

    public void setCheckInterval(int checkInterval) {
        this.checkInterval = checkInterval;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        setRefreshable();
    }

    private void setRefreshable() {
        proxy = (SqlSessionFactory) Proxy.newProxyInstance(
                SqlSessionFactory.class.getClassLoader(),
                new Class[]{SqlSessionFactory.class},
                new InvocationHandler() {
                    private final SqlSessionFactory target = getTarget();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(getTarget(), args);
                    }
                }
        );

        task();
    }

    private SqlSessionFactory getTarget() {
        try {
            return super.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SqlSessionFactory getObject() {
        return this.proxy;
    }

    public void task() {
        this.timer = new Timer(true);
        this.timer.schedule(new TimerTask() {
            private final Map<Resource, Long> map = new HashMap<>();

            @Override
            public void run() {
                if (mapperLocations == null) return;
                boolean isModified = false;

                for (Resource resource : mapperLocations) {
                    try {
                        long lastModified = resource.lastModified();
                        if (map.containsKey(resource)) {
                            if (lastModified != map.get(resource)) {
                                isModified = true;
                            }
                        }
                        map.put(resource, lastModified);
                    } catch (IOException e) {
                        logger.error("XML 파일 수정 시간 확인 실패", e);
                    }
                }

                if (isModified) {
                    try {
                        logger.info("(*) SQL Mapper XML 변경 감지! MyBatis 재빌드 시작...");
                        afterPropertiesSet();
                        logger.info("(*) MyBatis XML 리로딩 완료.");
                    } catch (Exception e) {
                        logger.error("MyBatis 리로딩 실패", e);
                    }
                }
            }
        }, 0, checkInterval);
    }
}