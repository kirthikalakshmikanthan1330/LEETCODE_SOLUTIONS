# Write your MySQL query statement below
select customer_id from Customer c group by customer_id having count(distinct c.product_key)=(select count(p.product_key) from Product p);