-- 코드를 작성해주세요

select a.score, a.emp_no, b.emp_name, b.position, b.email
from (
    select  hr1.emp_no,
            (hr1.score+hr2.score) as score,
            row_number() over (order by (hr1.score+hr2.score) desc) as rn
    from    hr_grade hr1, hr_grade hr2
    where   hr1.emp_no = hr2.emp_no
    and     hr1.half_year=1 
    and     hr2.half_year=2
    order by 2 desc
    ) a, hr_employees b
where a.rn = 1
and a.emp_no=b.emp_no
;