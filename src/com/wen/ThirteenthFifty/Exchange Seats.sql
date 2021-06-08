SELECT IF(cnt % 2 = 1 AND id = cnt, id, IF(id % 2 = 1, id + 1, id - 1)) AS id, student FROM seat,
(SELECT COUNT(*) AS cnt FROM seat) AS t
ORDER BY id;