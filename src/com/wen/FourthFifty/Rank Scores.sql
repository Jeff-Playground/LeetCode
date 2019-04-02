# Write your MySQL query statement below
select s1.Score, COUNT(distinct s2.Score) as Rank
from Scores s1
inner join Scores s2 on s1.Score<=s2.Score
group by s1.Id
order by s1.Score desc;

SELECT Score,
@rank := @rank + (@pre <> (@pre := Score)) Rank
FROM Scores, (SELECT @rank := 0, @pre := -1) INIT
ORDER BY Score DESC;

select s1.Score, (select count(distinct Score) from Scores s2 where s2.Score>=s1.Score) as Rank
from Scores s1
order by Score desc;