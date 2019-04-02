select Id from (select w1.Id from Weather w1 left join Weather w2 on TO_DAYS(w1.RecordDate)=TO_DAYS(w2.RecordDate)+1 where w1.Temperature>w2.Temperature)

SELECT w1.Id FROM Weather w1, Weather w2 WHERE w1.Temperature > w2.Temperature AND DATEDIFF(w1.Date, w2.Date) = 1

SELECT w1.Id FROM Weather w1, Weather w2 WHERE w1.Temperature > w2.Temperature AND SUBDATE(w1.Date, 1) = w2.Date