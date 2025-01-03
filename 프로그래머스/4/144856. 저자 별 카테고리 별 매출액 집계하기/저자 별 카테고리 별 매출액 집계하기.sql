-- 코드를 입력하세요
select a.author_id, a.author_name, b.category, sum(b.price * c.sales) as total_sales
from author a, book b, book_sales c
where a.author_id=b.author_id
and b.book_id=c.book_id
and to_char(c.sales_date, 'YYYY-MM') = '2022-01'
group by a.author_id, a.author_name, b.category
order by a.author_id asc, b.category desc;