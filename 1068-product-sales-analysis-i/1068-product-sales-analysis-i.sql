# Write your MySQL query statement below
select sales.year,price,product.product_name from sales inner join product using(product_id);