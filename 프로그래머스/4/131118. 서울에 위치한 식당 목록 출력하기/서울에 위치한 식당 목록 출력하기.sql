-- 서울에 위치한 식당들의 rest_id, rest_name, food_type, favorites, address, 리뷰 평균 점수 
-- 리뷰 평균 점수는 소수점 세 번째 자리에서 반올림
-- order by 평균 점수 desc, favorites desc 

select a.rest_id, a.rest_name, a.food_type, a.favorites, a.address, b.score
from rest_info a, 
    (
    select rest_id, round(avg(review_score), 2) as score
    from   rest_review
    group by rest_id
    ) b
where a.rest_id=b.rest_id
and   a.address like '서울%'
order by b.score desc, a.favorites desc;