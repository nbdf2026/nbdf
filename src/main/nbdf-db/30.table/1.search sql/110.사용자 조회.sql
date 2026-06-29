-- ------------------------------------------------------------------------------------------------
-- 사용자 조회
-- ------------------------------------------------------------------------------------------------
select *
  from dba_users du
 where 1=1
   and du.account_status     = 'OPEN'
   and du.default_tablespace = 'EBDF_DATA'
;

-- 사용자 커넥션 확인 및 종료
select sid, serial#, username,status
  from v$session
 where 1=1
   and username = 'XHR';

-- alter system kill session '502, 12289';
-- alter system kill session '751, 58037';
