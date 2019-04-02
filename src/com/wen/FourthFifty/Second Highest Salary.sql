# Write your MySQL query statement below
select MAX(Salary) as SecondHighestSalary from Employee
where Salary<(select MAX(Salary) from Employee);

SELECT MAX(Salary) as SecondHighestSalary FROM Employee
WHERE Salary NOT IN
(SELECT MAX(Salary) FROM Employee);

SELECT MAX(Salary) as SecondHighestSalary FROM Employee E1
WHERE 1 =
(SELECT COUNT(DISTINCT(E2.Salary)) FROM Employee E2
WHERE E2.Salary > E1.Salary);