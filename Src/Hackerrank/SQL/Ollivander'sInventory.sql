/*
    question link : https://www.hackerrank.com/challenges/harry-potter-and-wands/problem
*/

WITH t AS(
    SELECT  MIN(w1.coins_needed) 
    FROM    wands w1 
    JOIN    wands_property wp1 
    ON      w1.code = wp1.code 
    WHERE   w1.power = w.power 
    AND     wp.age = wp1.age
)
SELECT  w.id, 
        wp.age, 
        w.coins_needed, 
        w.power 
FROM    wands w 
JOIN    wands_property wp 
ON      w.code = wp.code
WHERE   wp.is_evil = 0 
AND     w.coins_needed = t 
ORDER BY w.power DESC, wp.age DESC;
