# Write your MySQL query statement below
select sales.year,price,product.product_name from sales inner join product on Sales.product_id=Product.product_id;