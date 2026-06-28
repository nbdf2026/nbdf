/* 암호화 권한 부여 */
conn sys/manager! as sysdba;

grant execute on dbms_crypto to nsys;
