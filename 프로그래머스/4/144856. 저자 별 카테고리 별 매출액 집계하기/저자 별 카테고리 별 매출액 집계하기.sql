-- 코드를 입력하세요
SELECT a.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum((price * sales)) as TOTAL_SALES
from author a
join book b
on a.author_id = b.author_id
join book_sales bs
on b.book_id = bs.book_id
where year(sales_date) = 2022 and month(sales_date) = 1
group by category, author_id
order by a.author_id, b.category desc;