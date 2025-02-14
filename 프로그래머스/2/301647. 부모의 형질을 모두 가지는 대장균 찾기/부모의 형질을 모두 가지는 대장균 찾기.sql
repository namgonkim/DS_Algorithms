-- 부모의 형질을 모두 보유한 대장균을 찾는다. 

select a.id as id, a.genotype as genotype, b.genotype as parent_genotype
from ecoli_data a join ecoli_data b on a.parent_id=b.id
where (a.genotype & b.genotype) = b.genotype -- 부모의 형질을 보유했는가
order by 1 