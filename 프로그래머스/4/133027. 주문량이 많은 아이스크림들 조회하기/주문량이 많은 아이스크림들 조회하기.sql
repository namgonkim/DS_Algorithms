-- 7월 아이스크림 총 주문량과 상반기 아이스크림의 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회하는 쿼리
-- 아이스크림 가게의 상반기 주문 정보를 담은 FIRST_HALF
--  7월의 아이스크림 주문 정보를 담은 JULY 테이블

select flavor
from 
    (
    select a.flavor, (a.total_order+b.total_order) as total_order
    from 
        (
        SELECT   flavor, sum(total_order) as total_order 
        from     july
        group by flavor
        ) a,
        (
        SELECT   flavor, sum(total_order) as total_order 
        from     FIRST_HALF 
        group by flavor
        ) b
    where a.flavor = b.flavor
    order by total_order desc
    )
where rownum <= 3;