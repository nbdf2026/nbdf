-- 메시지 데이터 조회
select cm.message_num
      ,cm.MESSAGE_TYPE_CD
      ,cm.message_text_ko
      ,cm.message_text_en
      ,cm.message_text_zh
      ,cm.message_text_ja
      ,cm.message_text_ot
      ,cm.remark
      ,cm.create_date
      ,cm.create_by
      ,cm.update_date
      ,cm.update_by
      ,cm.rowid
  from com_message cm
 where 1=1
--   and cm.message_num = 'MSG-A-10010'
;


/*
비즈니스 메시지
-------------------------------------------------------
메시지번호         번호범위       범위 용도
-------------------------------------------------------
UMSG-ALT-10000     10000 ~ 19990  시스템 공통(alert)
UMSG-CNF-10000     10000 ~ 19990  시스템 공통(confirm)
UMSG-INF-10000     10000 ~ 19990  시스템 공통(Information)
UMSG-ERR-10000     10000 ~ 19990  시스템 공통(Error)

UMSG-ALT-20000     20000 ~ 29990  시스템 공통(alert)
UMSG-CNF-20000     20000 ~ 29990  시스템 공통(confirm)
UMSG-INF-20000     20000 ~ 29990  시스템 공통(Information)
UMSG-ERR-20000     20000 ~ 29990  시스템 공통(Error)


프레임워크 메시지
-------------------------------------------------------
메시지번호         번호범위       범위 용도
-------------------------------------------------------
FMSG-MTD-10000	   10000 ~ 19990  1. Metadata Layer
FMSG-BLD-10000	   10000 ~ 19990  2. Builder Layer
FMSG-CON-10000	   10000 ~ 19990  3. Constants Layer
FMSG-ECP-10000	   10000 ~ 19990  4. Exception Layer
FMSG-TYP-10000	   10000 ~ 19990  5. Type Mapping Layer
FMSG-UTL-10000	   10000 ~ 19990  6. Utility Layer
FMSG-RST-10000	   10000 ~ 19990  7. Result Layer
FMSG-MSG-10000	   10000 ~ 19990  8. Message Layer
FMSG-VLD-10000	   10000 ~ 19990  9. Validation Layer
FMSG-CVT-10000	   10000 ~ 19990  10. Converter Layer
FMSG-CNF-10000	   10000 ~ 19990  11. Configuration Layer
FMSG-EXT-10000	   10000 ~ 19990  12. Extension Layer
*/
