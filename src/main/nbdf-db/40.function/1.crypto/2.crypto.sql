--conn sys/manager! as sysdba;

/* 암호화 권한 부여 */
--grant execute on dbms_crypto to nsys;

--conn system/manager!;

/* 암호화 권한 조회 */
select *
from dba_tab_privs
where table_name='DBMS_CRYPTO';


/* 암호화(양방향) */
select encrypt_f('홍길동') as name
  from dual;

/* 복호화(양방향) */  
select decrypt_f('A7A61A1E72ED51110C435085AD34923F')
  from dual;

/* 암호화(단방향) */  
select encrypt_password_f('Password123!')
from dual;
