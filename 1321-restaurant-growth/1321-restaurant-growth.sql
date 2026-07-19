WITH daily AS
(
SELECT
visited_on,
SUM(amount) amount
FROM Customer
GROUP BY visited_on
),
temp AS
(
SELECT
visited_on,
SUM(amount) OVER(
ORDER BY visited_on
ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
) amount,
ROW_NUMBER() OVER(ORDER BY visited_on) rn
FROM daily
)

SELECT
visited_on,
amount,
ROUND(amount/7,2) average_amount
FROM temp
WHERE rn>=7;