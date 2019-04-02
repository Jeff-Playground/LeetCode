# Write your MySQL query statement below
select Name as Employee
from Employee e1
where Salary>(select Salary from Employee e2 where e2.Id=e1.ManagerId);

SELECT e1.Name as Employee FROM Employee e1
JOIN Employee e2 ON e1.ManagerId = e2.Id
WHERE e1.Salary > e2.Salary;

SELECT e1.Name as Employee FROM Employee e1, Employee e2
WHERE e1.ManagerId = e2.Id AND e1.Salary > e2.Salary;