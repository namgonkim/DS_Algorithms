-- 코드를 입력하세요
SELECT member_id, member_name, gender, to_char(date_of_birth, 'YYYY-MM-DD') as date_of_birth
from   member_profile
where  tlno is not null
and    gender = 'W'
and    to_char(date_of_birth, 'MM') like '03'
order by member_id asc;