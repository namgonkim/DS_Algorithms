-- USER_INFO / ONLINE_SALE 
-- year, month, gender 별 상품 구매한 회원수 집계 (gender null 인 경우는 제외) 
-- order by year, month, gender asc
select  year(b.sales_date) year,
        month(b.sales_date) month,
        a.gender, 
        count(distinct b.user_id) users -- 동일 상품 구매한 회원은 제외 
from    user_info a,
        online_sale b
where   a.user_id=b.user_id
and     a.gender is not null 
group by 1, 2, 3
order by 1, 2, 3
