-- 코드를 입력하세요


# select count(user_id)
# from user_info
# where joined = 2021

select  year(b.sales_date) year, 
        month(b.sales_date) month,
        count(distinct(b.user_id)) as PURCHASED_USERS,
        -- 구매한 회원의 상품 비율 
        ROUND(count(distinct(b.user_id))/c.total_user ,1) as PUCHASED_RATIO
from    user_info a, online_sale b, 
        -- 2021년도에 가입한 전체 회원 수 
        (
            select  count(user_id) as total_user 
            from    user_info
            where   year(joined) = 2021
        ) as c
where   a.user_id = b.user_id
and     year(a.joined) = 2021
group by year(b.sales_date), month(b.sales_date)
order by year(b.sales_date), month(b.sales_date)