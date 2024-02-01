-- 코드를 입력하세요
SELECT CATEGORY, sum(sales) as TOTAL_SALES
from book b
join book_sales bs
on b.book_id = bs.book_id
where year(sales_date) = 2022 and month(sales_date) = 1
group by category
order by category;