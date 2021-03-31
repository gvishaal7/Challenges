/*
    count the duplicate values and order them
*/

SELECT   col,
         COUNT(dupe_col) AS dupe_cnt
FROM     TABLE
GROUP BY col
HAVING   COUNT(dupe_col) > 1
ORDER BY COUNT(dupe_col) DESC
