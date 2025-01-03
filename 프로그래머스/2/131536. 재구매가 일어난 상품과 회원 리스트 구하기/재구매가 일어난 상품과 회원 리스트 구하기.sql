-- ONLINE_SALE 테이블에서 동일한 회원이 동일한 상품을 재구매한 데이터 구하기 
-- order by user_id asc, product_id desc 
select user_id, product_id
from 
    (
    SELECT user_id, product_id, count(product_id) as cnt
    from   ONLINE_SALE
    group by user_id, product_id
    )
where cnt > 1
order by user_id asc, product_id desc;