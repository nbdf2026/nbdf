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
  from com_message cm
 where 1=1
   and cm.message_num = 'MSG-A-10010'
;
