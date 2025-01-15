-- appointment에서 2022-05에 예약한 환자 수를  진료과 코드 별로 조회
-- 진료과 코드/5월예약건수 
-- order by 2,1
SELECT  mcdp_cd as '진료과 코드', count(*) as '5월예약건수'
from    appointment
where   date(apnt_ymd) between '2022-05-01' and '2022-05-31'
group by mcdp_cd
order by 2, 1