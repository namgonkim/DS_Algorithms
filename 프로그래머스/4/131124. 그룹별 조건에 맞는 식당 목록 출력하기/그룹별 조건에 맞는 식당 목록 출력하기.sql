-- 고객의 정보를 담은 MEMBER_PROFILE / 식당의 리뷰 정보를 담은 REST_REVIEW
-- 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 쿼리 

SELECT  m.member_name, 
        r.review_text,
        to_char(r.review_date, 'YYYY-MM-DD') as review_date
from  MEMBER_PROFILE m, rest_review r
where m.member_id = r.member_id
and   r.member_id in (
    select member_id 
    from (
        select member_id, count(member_id)
        from   rest_review
        group by member_id
        order by count(member_id) desc
        )
    where rownum <= 1
    )
order by review_date asc, review_text asc;