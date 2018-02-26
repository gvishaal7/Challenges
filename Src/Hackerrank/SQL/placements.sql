/*
question link : https://www.hackerrank.com/challenges/placements/problem
*/

with t as (
    select f.id as id, p.salary as sal1, p1.salary as sal2
    from friends f
    left join packages p
    on f.id = p.id
    left join packages p1
    on f.friend_id = p1.id
    where p.salary < p1.salary
)   
select name
from students
join t 
on students.id = t.id 
order by t.sal2;
