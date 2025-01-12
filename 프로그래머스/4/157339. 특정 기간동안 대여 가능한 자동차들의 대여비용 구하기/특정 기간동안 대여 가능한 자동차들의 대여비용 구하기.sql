-- CAR_RENTAL_COMPANY_CAR / CAR_RENTAL_COMPANY_RENTAL_HISTORY / CAR_RENTAL_COMPANY_DISCOUNT_PLAN
-- 세단, suv 자동차 중 2022.11.01-30대여 가능하고 30일간 대여 금액이 50이상 200만 미만인 자동차에 대해
-- car_id, car_type, fee(대여금액) 리스트 출력 
-- order by fee desc, car_type asc, car_id desc 

select  car_id, car_type, fee
from    
    (

    select  a.car_id,
            a.car_type,
            (a.daily_fee * ((100-c.discount_rate) / 100) * 30) as fee
    from    CAR_RENTAL_COMPANY_CAR a,
            CAR_RENTAL_COMPANY_DISCOUNT_PLAN c
    where   a.car_id not in 
        (
        select  car_id
        from    CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where   to_char(start_date, 'YYYY-MM-DD') <= '2022-11-30' 
        and     to_char(end_date, 'YYYY-MM-DD') >= '2022-11-01'
        )
    and     a.car_type in ('세단', 'SUV')
    and     a.car_type = c.car_type
    and     c.duration_type = '30일 이상'
    )
where fee >= 500000 and fee <= 2000000
order by fee desc, car_type asc, car_id desc 
