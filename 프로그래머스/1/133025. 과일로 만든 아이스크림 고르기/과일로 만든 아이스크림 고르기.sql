-- 코드를 입력하세요
SELECT fh.FLAVOR
from first_half fh
inner join icecream_info ii
on fh.flavor = ii.flavor
where fh.total_order > 3000 and ii.ingredient_type = "fruit_based"
order by fh.total_order desc;
