-- CAR_RENTAL_COMPANY_RENTAL_HISTORY 
-- 평균 대여 기간 7일 이상인 자동차들 아이디와 평균 대여 기간 AVERAGE_DURATION
select car_id, to_char(AVERAGE_DURATION, 'FM9990.09')
from (
    select car_id,
            round(avg(END_DATE - START_DATE + 1),1) as AVERAGE_DURATION
    from   CAR_RENTAL_COMPANY_RENTAL_HISTORY
    group by car_id
    )
where AVERAGE_DURATION >= 7
order by AVERAGE_DURATION desc, car_id desc;