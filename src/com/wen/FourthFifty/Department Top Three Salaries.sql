# Write your MySQL query statement below
select d.name as Department, e1.Name as Employee, e1.Salary from Employee e1
join Department d on e1.DepartmentId=d.Id
where (SELECT COUNT(DISTINCT Salary) FROM Employee e2 WHERE e2.Salary > e1.Salary
AND e2.DepartmentId = d.Id) < 3
order by d.Name, e1.Salary DESC;

SELECT d.Name AS Department, e.Name AS Employee, e.Salary FROM
(SELECT e1.Name, e1.Salary, e1.DepartmentId FROM Employee e1 JOIN Employee e2
ON e1.DepartmentId = e2.DepartmentId AND e1.Salary <= e2.Salary GROUP BY e1.Id
HAVING COUNT(DISTINCT e2.Salary) <= 3) e JOIN Department d ON e.DepartmentId = d.Id
ORDER BY d.Name, e.Salary DESC;

SELECT d.Name AS Department, e.Name AS Employee, e.Salary FROM
(SELECT Name, Salary, DepartmentId,
@rank := IF(@pre_d = DepartmentId, @rank + (@pre_s <> Salary), 1) AS rank,
@pre_d := DepartmentId, @pre_s := Salary
FROM Employee, (SELECT @pre_d := -1, @pre_s := -1, @rank := 1) AS init
ORDER BY DepartmentId, Salary DESC) e JOIN Department d ON e.DepartmentId = d.Id
WHERE e.rank <= 3 ORDER BY d.Name, e.Salary DESC;