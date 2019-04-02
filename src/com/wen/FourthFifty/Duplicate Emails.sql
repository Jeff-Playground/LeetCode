# Write your MySQL query statement below
select Email
from (select count(*) as count, Email from Person group by Email) counted
where counted.count>1;

SELECT Email FROM Person GROUP BY Email
HAVING COUNT(*) > 1;

SELECT DISTINCT p1.Email FROM Person p1
JOIN Person p2 ON p1.Email = p2.Email
WHERE p1.Id <> p2.Id;