delete from ncom.com_user;
insert into ncom.com_user
values
  ('20000001'
  ,'admin'
  ,encrypt_password_f('adminADMIN0101!@')
  ,encrypt_f('adminBuilt11.com')
  ,encrypt_f('010-1234-1234')
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
