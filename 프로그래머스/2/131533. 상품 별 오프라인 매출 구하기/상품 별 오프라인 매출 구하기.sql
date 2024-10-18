-- product_code 별 매출액(price*sales_amount)
select p.product_code, (p.price * t.sales_amount) as sales
from   product p, 
(
SELECT product_id, sum(sales_amount) as sales_amount
from   offline_sale
group by product_id
)t
where  p.product_id=t.product_id
order by sales desc, p.product_code asc;