/*link:https://www.hackerrank.com/challenges/binary-search-tree-1/problem*/

select distinct(t1.n), 
  (CASE WHEN 
   t1.p is null 
   	then 'Root' 
   WHEN t2.n is null 
   	then 'Leaf' 
   ELSE 'Inner' 
   END) 
  from BST 
  t1 left join BST t2 
  on t1.n=t2.p;
