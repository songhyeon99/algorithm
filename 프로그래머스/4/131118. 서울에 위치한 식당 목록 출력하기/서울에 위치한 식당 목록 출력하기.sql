-- 코드를 입력하세요
SELECT ri.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(review_score),2) as SCORE
from rest_info ri
join rest_review rr
on ri.rest_id = rr.rest_id
group by rest_id
having address like "서울%"
order by score desc, ri.favorites desc;