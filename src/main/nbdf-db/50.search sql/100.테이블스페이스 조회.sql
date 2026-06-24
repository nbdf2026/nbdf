-- 테이블스페이스 조회
select df.status    as "상태"
      ,df.enabled   as "읽기쓰기"
      ,df.name      as "파일경로"
      ,ts.name      as "테이블스페이스명"
  from v$datafile df
       inner join v$tablespace ts on ts.ts# = df.ts#
 where 1=1
   and ts.name like 'XBDF%'
;

-- 데이터 파일 조회
select *
  from dba_data_files ddf
 where 1=1
   and ddf.tablespace_name like 'XBDF%'
;
