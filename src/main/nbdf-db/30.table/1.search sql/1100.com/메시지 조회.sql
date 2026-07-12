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
-- --------------------------------------------------------------
-- 메시지번호         번호범위       범위 용도
-- --------------------------------------------------------------
-- FMSG-CON-10000     10000 ~ 19990  Constants Layer
-- FMSG-TYP-10000     10000 ~ 19990  Type Mapping Layer
-- FMSG-MTD-10000     10000 ~ 19990  Metadata Layer
-- FMSG-MSG-10000     10000 ~ 19990  Message Layer
-- FMSG-VLD-10000     10000 ~ 19990  Validation Layer
-- FMSG-BLD-10000     10000 ~ 19990  Builder Layer
-- FMSG-RED-10000	    10000 ~ 19990  Reader Layer
-- FMSG-RST-10000     10000 ~ 19990  Result Layer
-- FMSG-CVT-10000     10000 ~ 19990  Converter Layer
-- FMSG-UTL-10000     10000 ~ 19990  Utility Layer
-- FMSG-ECP-10000     10000 ~ 19990  Exception Layer
-- FMSG-CNF-10000     10000 ~ 19990  Configuration Layer
-- FMSG-EXT-10000     10000 ~ 19990  Extension Layer


*/
