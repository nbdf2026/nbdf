delete from com_code_type;
insert into com_code_type values('CREATE_TYPE_CD', '생성유형코드', '생성유형코드', to_date('1900-01-01', 'yyyy-mm-dd'), null, 'S', '시스템 등록 데이터', to_date('1900-01-01', 'yyyy-mm-dd'), 'admin', to_date('1900-01-01', 'yyyy-mm-dd'), 'admin');
insert into com_code_type values('GENDER_CD', '성별코드', '성별코드', to_date('1900-01-01', 'yyyy-mm-dd'), null, 'S', '시스템 등록 데이터', to_date('1900-01-01', 'yyyy-mm-dd'), 'admin', to_date('1900-01-01', 'yyyy-mm-dd'), 'admin');
commit;
