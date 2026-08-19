# Write your MySQL query statement below
select round(count(distinct a1.player_id)/
(select count(distinct player_id) from Activity),2) as fraction from Activity a2 join Activity a1 on a2.player_id=a1.player_id and datediff(a1.event_date,a2.event_date)=1 where a2.event_date=(select min(event_date) from Activity where player_id=a2.player_id);