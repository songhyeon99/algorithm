-- 코드를 입력하세요
SELECT TITLE, ugb.BOARD_ID, ugr.REPLY_ID, ugr.WRITER_ID, ugr.CONTENTS, date_format(ugr.CREATED_DATE, "%Y-%m-%d") as CREATED_DATE
from used_goods_board ugb
inner join used_goods_reply ugr
on ugb.board_id = ugr.board_id
where SUBSTR(ugb.CREATED_DATE,1,7) = '2022-10'
order by ugr.CREATED_DATE asc, ugb.title;