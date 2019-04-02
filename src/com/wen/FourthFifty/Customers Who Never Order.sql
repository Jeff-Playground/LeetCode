# Write your MySQL query statement below
select Name as Customers from Customers where Id not in (select CustomerId from Orders);

SELECT Name AS Customers FROM Customers
LEFT JOIN Orders ON Customers.Id = Orders.CustomerId
WHERE Orders.CustomerId IS NULL;

SELECT Name AS Customers FROM Customers c
WHERE NOT EXISTS (SELECT * FROM Orders o WHERE o.CustomerId = c.Id);