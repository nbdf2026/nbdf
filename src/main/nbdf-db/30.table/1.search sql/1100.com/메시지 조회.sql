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
메시지번호      번호범위       범위 용도
-------------------------------------------------------
UMSG-A-10000    10000 ~ 19990  시스템 공통(alert)
UMSG-C-10000    10000 ~ 19990  시스템 공통(confirm)
UMSG-I-10000    10000 ~ 19990  시스템 공통(Information)
UMSG-E-10000    10000 ~ 19990  시스템 공통(Error)

UMSG-A-20000    20000 ~ 29990  시스템 공통(alert)
UMSG-C-20000    20000 ~ 29990  시스템 공통(confirm)
UMSG-I-20000    20000 ~ 29990  시스템 공통(Information)
UMSG-E-20000    20000 ~ 29990  시스템 공통(Error)


프레임워크 메시지
-------------------------------------------------------
메시지번호      번호범위       범위 용도
-------------------------------------------------------
FMSG-M-10000	   10000 ~ 19990  1. Metadata Layer
FMSG-B-10000	   10000 ~ 19990  2. Builder Layer
FMSG-C-10000	   10000 ~ 19990  3. Constants Layer
FMSG-E-10000	   10000 ~ 19990  4. Exception Layer
FMSG-T-10000	   10000 ~ 19990  5. Type Mapping Layer
FMSG-U-10000	   10000 ~ 19990  6. Utility Layer
FMSG-R-10000	   10000 ~ 19990  7.Result Layer
FMSG-V-10000	   10000 ~ 19990  8.Validation Layer
FMSG-P-10000	   10000 ~ 19990  9.PlatformData Layer

*/
