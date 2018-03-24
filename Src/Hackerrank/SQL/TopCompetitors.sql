/*
https://www.hackerrank.com/challenges/full-score
*/


WITH n as (
    SELECT  d.difficulty_level AS df, 
            c.challenge_id AS ci, 
            d.score AS ds 
    FROM    challenges c 
    JOIN    difficulty d 
    ON      c.difficulty_level = d.difficulty_level
)
SELECT  h.hacker_id,
        h.name 
FROM    hackers h 
RIGHT JOIN  submissions s 
ON      h.hacker_id = s.hacker_id 
JOIN    n 
ON      s.challenge_id = n.ci 
WHERE   s.score = n.ds 
GROUP BY    h.hacker_id, h.name 
HAVING COUNT(h.name) > 1 
ORDER BY COUNT(h.name) DESC, h.hacker_id;
