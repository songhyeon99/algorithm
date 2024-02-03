-- 코드를 입력하세요
SELECT month(start_date) as MONTH, CAR_ID, count(history_id) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date>="2022-08-01" and start_date<"2022-11-01" and car_id in 
(select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY where start_date>="2022-08-01" and start_date<"2022-11-01" group by car_id having count(history_id)>4) 
group by month, car_id
having records >0
order by month, car_id desc;