delete from Person where Id in (select Id from (select p1.Id from Person p1 left join Person p2 on p1.Email=p2.Email where p1.Id>p2.Id) Ids)

DELETE FROM Person WHERE Id NOT IN (SELECT Id FROM (SELECT MIN(Id) Id FROM Person GROUP BY Email) Ids)