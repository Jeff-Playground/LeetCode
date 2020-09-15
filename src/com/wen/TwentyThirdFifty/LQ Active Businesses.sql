/*

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| business_id   | int     |
| event_type    | varchar |
| occurrences    | int     |
+---------------+---------+
(business_id, event_type) is the primary key of this table.
Each row in the table logs the info that an event of some type occurred at some business for a number of times.


Write an SQL query to find all active businesses.

An active business is a business that has more than one event type with occurrences greater than the average occurrences of that event type among all businesses.



The query result format is in the following example:

Events table:
+-------------+------------+------------+
| business_id | event_type | occurrences |
+-------------+------------+------------+
| 1           | reviews    | 7          |
| 3           | reviews    | 3          |
| 1           | ads        | 11         |
| 2           | ads        | 7          |
| 3           | ads        | 6          |
| 1           | page views | 3          |
| 2           | page views | 12         |
+-------------+------------+------------+

Result table:
+-------------+
| business_id |
+-------------+
| 1           |
+-------------+
Average for 'reviews', 'ads' and 'page views' are (7+3)/2=5, (11+7+6)/3=8, (3+12)/2=7.5 respectively.
Business with id 1 has 7 'reviews' events (more than 5) and 11 'ads' events (more than 8) so it is an active business.

*/

select business_id from
    (select event_type, avg(occurrences) as event_avgo
        from Events
        group_by event_type) as t1
    inner join
    (select business_id, event_type, avg(occurrences) as business_event_avgo
        from Events
        group_by business_id, event_type) as t2
    on t1.event_type=t2.event_type and t2.business_event_avgo>t1.event_avgo
group_by business_id
having count(1)>1
