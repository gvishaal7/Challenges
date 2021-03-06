/*
 * link: https://www.hackerrank.com/challenges/what-type-of-triangle/problem
 */

select  case when a+b <= c or c+a <= b or b+c <= a 
	then 'Not A Triangle'
    	when a = b and b = c 
	then 'Equilateral' 
    	when (a=b and b!=c) or (a=c and b!=a) or (b=c and a!=c) 
	then 'Isosceles' 
    	when a!=b and b!=c 
	then 'Scalene' 
    	end
from triangles;
