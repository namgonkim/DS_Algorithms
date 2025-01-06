-- 코드를 입력하세요

select t.category, t.price as max_price, t.product_name
from (
    select category, 
            product_name, 
            price,
            rank() over(partition by category order by price desc) as rank
    from food_product
    ) t
where t.rank = 1
and t.category in ('과자', '국', '김치', '식용유')
order by max_price desc;