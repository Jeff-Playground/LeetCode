# Write your MySQL query statement below
select d.Name as Department, e1.Name as Employee, e1.Salary
from Employee e1
join Department d on e1.DepartmentId=d.Id
where e1.Salary in (SELECT MAX(Salary) FROM Employee e2 WHERE e1.DepartmentId = e2.DepartmentId);

SELECT d.Name AS Department, e.Name AS Employee, e.Salary FROM Employee e, Department d
WHERE e.DepartmentId = d.Id AND e.Salary = (SELECT MAX(Salary) FROM Employee e2 WHERE e2.DepartmentId = d.Id);

SELECT d.Name AS Department, e.Name AS Employee, e.Salary FROM Employee e, Department d
WHERE e.DepartmentId = d.Id AND e.Salary >= ALL (SELECT Salary FROM Employee e2 WHERE e2.DepartmentId = d.Id);