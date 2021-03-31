/*
merging two tables with intervals
e.g.: marks and grade
*/

select  s.name, 
        g.grades
from    grades g 
join    students s 
on      s.marks 
between g.min_mark and g.max_mark;
