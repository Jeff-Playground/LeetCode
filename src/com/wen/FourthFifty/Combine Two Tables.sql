# Write your MySQL query statement below
select Person.FirstName, Person.LastName, Address.City, Address.State
from Person
left join Address on Person.PersonId=Address.PersonId;

SELECT Person.FirstName, Person.LastName, Address.City, Address.State
FROM Person
LEFT JOIN Address USING(PersonId);