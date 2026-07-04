declare
    l_current_date  date           default to_date('1900-01-01', 'yyyy-mm-dd');
    l_user_id       varchar2(50)   default 'admin';
    l_remark        varchar2(4000) default '시스템 등록 데이터';
begin
    delete from com_message;
    
    --
    insert into com_message values('MSG-A-10000', 'A', '정상적으로 저장 되었습니다.', 'It was saved normally.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
    insert into com_message values('MSG-A-10010', 'A', '{1} 항목은 필수입니다.', 'Item {1} is required.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
    insert into com_message values('MSG-A-10020', 'A', '변경된 데이터가 존재하지 않습니다.', 'There is no changed data.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
    insert into com_message values('MSG-A-10030', 'A', '조회조건에 일치하는 데이터가 존재하지 않습니다.', 'No data matching the search criteria exists.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
    insert into com_message values('MSG-A-10040', 'A', '공통 메시지정보(gds_message)가 생성되지 않았습니다.', 'Common message information (gds_message) was not generated.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
    insert into com_message values('MSG-A-10050', 'A', '공통 사용자정보(gds_user)가 생성되지 않았습니다.', 'Common user information (gds_user) was not created.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
    insert into com_message values('MSG-A-20000', 'A', '데이터맵 조회시 키 값이 존재하지 않습니다.', 'The key value does not exist when saving the data map.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
    insert into com_message values('MSG-A-20010', 'A', '데이터맵 저장시 키 값이 존재하지 않습니다.', 'The key value does not exist when saving the data map.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
    
    insert into com_message values('MSG-C-10000', 'C', '선택된 데이터를 삭제하시겠습니까?', 'Would you like to delete the selected data?', '중', '일', '기', l_remark, l_current_date, l_user_id, l_current_date, l_user_id);
    
    --
    commit;
end;
