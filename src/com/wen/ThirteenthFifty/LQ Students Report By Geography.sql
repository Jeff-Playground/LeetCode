/*

A U.S graduate school has students from Asia, Europe and America. The students' location information are stored in table
student as below.

| name   | continent |
|--------|-----------|
| Jack   | America   |
| Pascal | Europe    |
| Xi     | Asia      |
| Jane   | America   |


Pivot the continent column in this table so that each name is sorted alphabetically and displayed underneath its
corresponding continent. The output headers should be America, Asia and Europe respectively. It is guaranteed that the
student number from America is no less than either Asia or Europe.



For the sample input, the output is:

| America | Asia | Europe |
|---------|------|--------|
| Jack    | Xi   | Pascal |
| Jane    |      |        |

*/

select t1.name as America, t2.name as Asia, t3.name as Europe
from
    (select (@cnt1 := @cnt1 + 1) as id, name
    from student
    cross join (select @cnt1 := 0) as dummy
    where continent='America'
    order by name) as t1
    left join
    (select (@cnt2 := @cnt2 + 1) as id, name
    from student
    cross join (select @cnt2 := 0) as dummy
    where continent='Asia'
    order by name) as t2
    on t1.id = t2.id
    left join
    (select (@cnt3 := @cnt3 + 1) as id, name
    from student
    cross join (select @cnt3 := 0) as dummy
    where continent='Europe'
    order by name) as t3
    on t1.id = t3.id