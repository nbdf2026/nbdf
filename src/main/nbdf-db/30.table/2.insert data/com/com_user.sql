insert into ncom.com_user
values
  ('20260001'
  ,'강정기'
  ,encrypt_password_f('kjgSYR0527!@')
  ,encrypt_f('jgkang@built1.com')
  ,encrypt_f('010-3038-8977')
  ,'Y'
  ,'N'
  ,0
  ,sysdate
  ,null
  ,'시스템 등록 데이터'
  , to_date('1900-01-01', 'yyyy-mm-dd')
  , 'admin'
  , to_date('1900-01-01', 'yyyy-mm-dd')
  , 'admin');
commit;
