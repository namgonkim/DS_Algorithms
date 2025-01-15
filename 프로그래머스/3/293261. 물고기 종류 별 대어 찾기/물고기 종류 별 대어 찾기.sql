-- 코드를 작성해주세요

select b.id, a.fish_name, b.length
from fish_name_info a join (
    select id, fish_type, length
    from fish_info
    where (fish_type, length) in (
        select fish_type, max(length) as length
        from fish_info
        group by fish_type
        )
    ) b on a.fish_type=b.fish_type
order by b.id