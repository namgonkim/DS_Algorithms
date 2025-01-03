-- 코드를 입력하세요
select to_char(sales_date, 'YYYY-MM-DD') as sales_date, product_id, user_id, sales_amount
from (
    SELECT sales_date, product_id, NULL as user_id, sales_amount
    from OFFLINE_SALE 
    where to_char(sales_date, 'MM') = '03'
    union all 
    SELECT sales_date, product_id, user_id, sales_amount
    from ONLINE_SALE 
    where to_char(sales_date, 'MM') = '03'
    )
order by sales_date asc, product_id asc, user_id asc;