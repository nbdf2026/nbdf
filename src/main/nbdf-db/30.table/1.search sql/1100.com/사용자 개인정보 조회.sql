/* 로그인 사용자 개인정보 조회 */
select cu.user_id            as user_id
      ,cu.user_name          as user_name
      ,''                    as email_address
      ,''                    as mobile_number
      ,''                    as company_code
      ,''                    as company_name
      ,''                    as business_place_code
      ,''                    as business_place_name
      ,''                    as dept_code
      ,''                    as dept_name
      ,''                    as job_code
      ,''                    as job_name
      ,''                    as position_code
      ,''                    as position_name      
  from com_user cu
 where 1=1
   and cu.user_id = '20000001'
   and cu.password = encrypt_password_f('adminADMIN0101!@')
;
