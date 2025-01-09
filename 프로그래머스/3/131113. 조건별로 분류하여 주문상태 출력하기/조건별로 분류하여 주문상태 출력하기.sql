-- FOOD_ORDER 테이블에서 2022년 5월 1일을 기준으로 ORDER_ID PRODUCT_ID OUT_DATE, 출고여부 출력 
-- OUT_DATE가 null이면 '출고미정', OUT_DATE가 2022-05-01 이후면 '출고대기' 이전은 '출고완료'
-- order by order_id asc
SELECT order_id,
       product_id,
       to_char(out_date, 'YYYY-MM-DD') as out_date,
       case when to_char(out_date, 'YYYY-MM-DD') <= '2022-05-01' then '출고완료' 
            when to_char(out_date, 'YYYY-MM-DD') > '2022-05-01' then '출고대기' 
       else '출고미정'
       end as 출고여부
from   food_order 
order by order_id asc;