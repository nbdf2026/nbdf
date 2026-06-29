-- 암호화
select encrypt_f('강정기')
  from dual;

-- 복호화  
select decrypt_f('0DF254A42E4D134BA1EFDA85C13827BB')
  from dual;

-- 비밀번호 암호화  
select encrypt_password_f('kjgKKK0527!@')
  from dual;
