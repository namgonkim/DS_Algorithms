-- 만원 단위 가격대 별 상품 갯수 구하기 
select floor(price / 10000) * 10000 as price_group,
        count(*) as products
from    product
group by 1
order by 1