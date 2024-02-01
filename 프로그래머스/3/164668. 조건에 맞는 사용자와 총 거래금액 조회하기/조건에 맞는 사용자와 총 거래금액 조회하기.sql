-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, sum(price) as TOTAL_SALES
from USED_GOODS_BOARD ugb
join USED_GOODS_USER ugu
on ugb.writer_id = ugu.user_id
where ugb.status = "DONE"
group by user_id
having TOTAL_SALES >= 700000
order by TOTAL_SALES;