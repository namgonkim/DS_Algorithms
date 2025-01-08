-- CAR_RENTAL_COMPANY_RENTAL_HISTORY 에서 start_date 기준으로 2022.08-10까지 총 대여 횟수가 5회 이상인 자동차들
-- 월 / 자동차 id / 총 대여 횟수(RECORDS) 출력
-- 특정 월의 총 대여 횟수가 0인 경우 결과에서 제외 
-- order by month asc, car_id desc 

select to_number(to_char(start_date, 'MM')) as month, car_id, count(car_id) as records 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where to_char(start_date, 'YYYY-MM') >= '2022-08' and to_char(start_date, 'YYYY-MM') <= '2022-10' 
and car_id in
    -- 총 대여 횟수 5회 이상인 자동차들 
    (
    SELECT car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where to_char(start_date, 'YYYY-MM') >= '2022-08' and to_char(start_date, 'YYYY-MM') <= '2022-10'
    group by car_id
    having count(car_id) >= 5
    )
group by to_number(to_char(start_date, 'MM')), car_id
order by to_number(to_char(start_date, 'MM')) asc, car_id desc;