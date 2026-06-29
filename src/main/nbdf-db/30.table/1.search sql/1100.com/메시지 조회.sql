-- 메시지 데이터 조회
select cm.message_num
      ,cm.MESSAGE_TYPE_CD
      ,cm.message_text_ko
      ,cm.message_text_en
      ,cm.message_text_zh
      ,cm.message_text_ja
      ,cm.message_text_ot
      ,cm.button_yes
      ,cm.button_no
      ,cm.button_cancle
      ,cm.remark
      ,cm.create_date
      ,cm.create_by
      ,cm.update_date
      ,cm.update_by
  from com_message cm
 where 1=1
;

insert into ncom.com_message
values
  (
  'MSG-A-10000'
  ,'A'
  ,'정상적으로 처리 되었습니다.'
  ,'It was processed normally.'
  ,'v_message_text_zh'
  ,'v_message_text_ja'
  ,'v_message_text_ot'
  ,'Y'
  ,'N'
  ,'N'
  ,'시스템 등록 데이터'
  ,to_date('1900-01-01', 'yyyy-mm-dd')
  ,'admin'
  ,to_date('1900-01-01', 'yyyy-mm-dd')
  ,'admin'
  );
