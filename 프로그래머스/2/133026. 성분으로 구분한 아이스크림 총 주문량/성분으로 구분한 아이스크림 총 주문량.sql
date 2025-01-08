-- 아이스크림 가게 상반기 주문 정보 테이블 FIRST_HALF 
-- 아이스크림 성분 테이블 ICECREAM_INFO
-- 아이스크림 성분 타입 INGREDIENT_TYPE 과 아이스크림 총 주문량 TOTAL_ORDER 출력
-- 총 주문량이 작은 순서대로 조회 order by total_order asc

select ingredient_type, sum(total_order) as total_order
from 
(
SELECT f.flavor, i.ingredient_type, f.total_order
from FIRST_HALF f, ICECREAM_INFO i
where f.flavor = i.flavor
)
group by ingredient_type
order by total_order asc
