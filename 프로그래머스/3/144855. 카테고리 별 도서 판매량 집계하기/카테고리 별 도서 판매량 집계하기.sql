-- 2022년 1월의 카테고리 별 도서 판매량을 합산하고 카테고리, 총 판매량(TOTAL_SALES) 리스트 출력
-- order by category asc 


select category, sum(sales) as total_sales
from (
    select b.book_id, b.category, ms.sales
    from (
        SELECT book_id, to_char(sales_date, 'YYYY-MM') as sales_date, sum(sales) as sales
        from book_sales 
        group by book_id, to_char(sales_date, 'YYYY-MM')
        having to_char(sales_date, 'YYYY-MM') = '2022-01'
        ) ms, book b
    where ms.book_id=b.book_id
    )
group by category
order by category asc