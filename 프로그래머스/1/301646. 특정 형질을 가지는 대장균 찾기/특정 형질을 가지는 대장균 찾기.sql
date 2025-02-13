-- 2번 형질이 없으면서 1번과 3번 형질을 하나라도 보유한 대장균 개체 수 찾기 
-- 비트 연산(&)을 통해 not 2번 2, have 1번 1 or 3번 4 
select count(*) as count
from ecoli_data
where (genotype & 2) = 0
and ((genotype & 1) > 0 or (genotype & 4) > 0)