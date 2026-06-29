/* 사용자 데이터 조회 */
select cu.user_id
      ,cu.user_name
      ,cu.password
      ,cu.email_address
      ,decrypt_f(cu.email_address) as email_address_decrypt
      ,cu.mobile_number
      ,decrypt_f(cu.mobile_number) as mobile_number_decrypt
      ,cu.user_yn
      ,cu.lock_yn
      ,cu.login_fail_count
      ,cu.last_login_date
      ,cu.last_pw_change_date
      ,cu.remark
      ,cu.create_date
      ,cu.create_by
      ,cu.update_date
      ,cu.update_by
  from com_user cu
 where 1=1
;
