select fd.product_id, fd.product_name, sum(fo.amount*fd.price) as total_sales
from   food_order fo, food_product fd
WHERE  TO_CHAR(fo.PRODUCE_DATE, 'YYYY-MM') = '2022-05'
and    fo.product_id=fd.product_id
group by fd.product_id, fd.product_name
order by total_sales desc, fd.product_id asc