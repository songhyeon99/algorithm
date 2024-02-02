-- 코드를 입력하세요
SELECT MCDP_CD as "진료과코드", count(mcdp_cd) as "5월예약건수"
from appointment
where year(APNT_YMD) = 2022 and month(APNT_YMD) = 5
group by mcdp_cd
order by 5월예약건수, mcdp_cd;