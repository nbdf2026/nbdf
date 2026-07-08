declare
    l_current_date  date           default to_date('1900-01-01', 'yyyy-mm-dd');
    l_user_id       varchar2(50)   default 'admin';
    l_remark        varchar2(4000) default '시스템 등록 데이터';
begin
    delete from com_message;
    
    -- --------------------------------------------------------------
    -- 메시지번호         번호범위       범위 용도
    -- --------------------------------------------------------------
    -- UMSG-ALT-10000     10000 ~ 19990  시스템 공통(alert)
    -- UMSG-CNF-10000     10000 ~ 19990  시스템 공통(confirm)
    -- UMSG-INF-10000     10000 ~ 19990  시스템 공통(Information)
    -- UMSG-ERR-10000     10000 ~ 19990  시스템 공통(Error)

    -- UMSG-ALT-20000     20000 ~ 29990  시스템 공통(alert)
    -- UMSG-CNF-20000     20000 ~ 29990  시스템 공통(confirm)
    -- UMSG-INF-20000     20000 ~ 29990  시스템 공통(Information)
    -- UMSG-ERR-20000     20000 ~ 29990  시스템 공통(Error)
    -- --------------------------------------------------------------
    
    -- --------------------------------------------------------------
    -- UI System Confirm message
    -- --------------------------------------------------------------    
    insert into com_message values('UMSG-CNF-10000', 'A', '선택된 데이터를 삭제하시겠습니까?'
                                                        , 'Would you like to delete the selected data?', '중', '일', '기', l_remark, l_current_date, l_user_id, l_current_date, l_user_id);
    
    -- --------------------------------------------------------------
    -- UI System Alert message
    -- --------------------------------------------------------------
    insert into com_message values('UMSG-ALT-10000', 'A', '정상적으로 저장 되었습니다.'
                                                        , 'It was saved normally.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
                                                        
    insert into com_message values('UMSG-ALT-10010', 'A', '{1} 항목은 필수입니다.'
                                                        , 'Item {1} is required.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
                                                        
    insert into com_message values('UMSG-ALT-10020', 'A', '변경된 데이터가 존재하지 않습니다.'
                                                        , 'There is no changed data.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
                                                        
    insert into com_message values('UMSG-ALT-10030', 'A', '조회 조건에 일치하는 데이터가 존재하지 않습니다.'
                                                        , 'No data matching the search criteria exists.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
                                                        
    insert into com_message values('UMSG-ALT-10040', 'A', '공통 메시지정보(gds_message)가 생성되지 않았습니다.'
                                                        , 'Common message information (gds_message) was not generated.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
                                                        
    insert into com_message values('UMSG-ALT-10050', 'A', '공통 사용자정보(gds_user)가 생성되지 않았습니다.'
                                                        , 'Common user information (gds_user) was not created.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
                                                        
    -- --------------------------------------------------------------
    -- UI Business Confirm message
    -- --------------------------------------------------------------
    
    
    -- --------------------------------------------------------------
    -- UI Business Alert message
    -- --------------------------------------------------------------
    
    
    -- --------------------------------------------------------------
    -- 메시지번호         번호범위       범위 용도
    -- --------------------------------------------------------------
    -- FMSG-MTD-10000     10000 ~ 19990  1. Metadata Layer
    -- FMSG-BLD-10000     10000 ~ 19990  2. Builder Layer
    -- FMSG-CON-10000     10000 ~ 19990  3. Constants Layer
    -- FMSG-ECP-10000     10000 ~ 19990  4. Exception Layer
    -- FMSG-TYP-10000     10000 ~ 19990  5. Type Mapping Layer
    -- FMSG-UTL-10000     10000 ~ 19990  6. Utility Layer
    -- FMSG-RST-10000     10000 ~ 19990  7. Result Layer
    -- FMSG-MSG-10000     10000 ~ 19990  8. Message Layer
    -- FMSG-VLD-10000     10000 ~ 19990  9. Validation Layer
    -- FMSG-CVT-10000     10000 ~ 19990  10. Converter Layer
    -- FMSG-CNF-10000     10000 ~ 19990  11. Configuration Layer
    -- FMSG-EXT-10000     10000 ~ 19990  12. Extension Layer
    -- -------------------------------------------------------------- 
    
    -- --------------------------------------------------------------
    -- FRAMEWORK Alert message
    -- --------------------------------------------------------------
    insert into com_message values('FMSG-RST-10000', 'A', '데이터맵 저장시 키 값이 존재하지 않습니다.'
                                                        , 'The key value does not exist when saving the data map.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
                                                        
    insert into com_message values('FMSG-RST-10010', 'A', '변수명은 필수입니다.'
                                                        , 'Variable names are required.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
                                                        
    insert into com_message values('FMSG-BLD-10000', 'A', 'NBDFTransferData 객체에 값이 존재하지 않습니다.'
                                                        , 'NBDFTransferData is null.', '중', '일', '기', l_remark, l_current_date, 'admin', l_current_date, l_user_id);
    
    --
    commit;
end;
