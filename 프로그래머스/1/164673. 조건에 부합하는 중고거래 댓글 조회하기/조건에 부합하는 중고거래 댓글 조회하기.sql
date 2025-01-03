-- USED_GOODS_BOARD / USED_GOODS_REPLY
-- 2022년 10월에 작성된 b.title, r.board_id, r.reply_id, r.writer_id, r.contents, r.created_date
-- order by creatd_date asc, title asc
SELECT b.title, r.board_id, r.reply_id, r.writer_id, r.contents, to_char(r.created_date, 'YYYY-MM-DD') as created_date
from   USED_GOODS_BOARD b join USED_GOODS_REPLY r on b.board_id=r.board_id
where  to_char(b.created_date, 'YYYY-MM') = '2022-10'
order by r.created_date asc, b.title asc;