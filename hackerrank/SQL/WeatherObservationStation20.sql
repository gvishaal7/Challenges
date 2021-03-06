/*link:https://www.hackerrank.com/challenges/weather-observation-station-20/problem*/

with t as (
	select  'key' as k, 
            	lat_n as lat, 
            	ROW_NUMBER() OVER (order by lat_n asc) as rownumber 
	from 	station
),
s as (
    	select 	'key' as k ,
		count(*) as cnt 
	from 	station
),
u as (
    	select 	'key' as k, 
		lat as ulat 
	from 	t 
	join 	s 
	on 	t.k=s.k 
	where 	rownumber = s.cnt/2
)
select	(case 
	when 	s.cnt%2 !=0 
    	then 	cast(lat as decimal(10,4)) 
    	else 	cast((t.lat+u.ulat)/2 as decimal(10,4)) 
	end)
from 	t 
    	join 	s
    	on 	t.k = s.k
    	join 	u
    	on 	s.k = u.k
where 	rownumber = s.cnt/2 +1;
