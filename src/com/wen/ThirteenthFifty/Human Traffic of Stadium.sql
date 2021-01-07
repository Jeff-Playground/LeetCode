select s1.* from Stadium as s1, Stadium as s2, Stadium as s3 where
(s1.people>=100
and s2.people>=100
and s3.people>=100)
and
((s1.id=s2.id-1 and s1.id=s3.id-2)
or (s1.id=s2.id+1 and s1.id=s3.id-1)
or (s1.id=s2.id+2 and s1.id=s3.id+1))
group by id
order by id


select * from Stadium where people >=100 and
(
(
id+1 in (select id from stadium where people>=100) and
id+2 in (select id from stadium where people>=100)
)
or
(
id-1 in (select id from stadium where people>=100) and
id+1 in (select id from stadium where people>=100)
)
or
(
id-1 in (select id from stadium where people>=100) and
id-2 in (select id from stadium where people>=100)
)
)