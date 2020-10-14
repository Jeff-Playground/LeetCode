/*

The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column
for the manager Id.

+------+----------+-----------+----------+
|Id    |Name 	  |Department |ManagerId |
+------+----------+-----------+----------+
|101   |John 	  |A 	      |null      |
|102   |Dan 	  |A 	      |101       |
|103   |James 	  |A 	      |101       |
|104   |Amy 	  |A 	      |101       |
|105   |Anne 	  |A 	      |101       |
|106   |Ron 	  |B 	      |101       |
+------+----------+-----------+----------+

Given the Employee table, write a SQL query that finds out managers with at least 5 direct report. For the above table,
your SQL query should return:

+-------+
| Name  |
+-------+
| John  |
+-------+
Note:
No one would report to himself.

*/

SELECT Name FROM Employee WHERE Id IN
(SELECT ManagerId FROM Employee GROUP BY ManagerId HAVING COUNT(*) > 4);

select Name from Employee as e
inner join
(select ManagerId, count(*) as count from Employee group by ManagerId) as m
where e.MangerId=m.ManagerId and m.count>=5