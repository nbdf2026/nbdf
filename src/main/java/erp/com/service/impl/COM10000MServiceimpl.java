package erp.com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import erp.com.service.COM10000MService;

@Service
public class COM10000MServiceimpl implements COM10000MService {
	
	private COM10000MMapper com10000MMapper;
	
	@Override
	public List<Map<String, Object>> selectCodeList() {
		return com10000MMapper.selectCodeList();
	}

}
