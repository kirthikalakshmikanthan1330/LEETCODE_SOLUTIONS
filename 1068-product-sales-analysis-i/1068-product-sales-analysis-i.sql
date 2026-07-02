# Write your MySQL query statement below
select sales.year,price,product.product_name from sales left outer join product using(product_id);