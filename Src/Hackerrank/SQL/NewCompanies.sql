/*
link: https://www.hackerrank.com/challenges/the-company/problem
*/

with lm as (
    select  company_code as cclm, 
            count(distinct(lead_manager_code)) as lm_count 
    from    lead_manager 
    group by company_code
),
sm as (
    select  company_code as ccsm, 
            count(distinct(senior_manager_code)) as sm_count 
    from    senior_manager 
    group by company_code
),
m as (
    select  company_code as ccm, 
            count(distinct(manager_code)) as m_count 
    from    manager 
    group by company_code
),
e as (
    select  company_code as cce, 
            count(distinct(employee_code)) as e_count 
    from    employee 
    group by company_code
)
select  company_code, 
        founder, 
        lm.lm_count, 
        sm.sm_count, 
        m.m_count, 
        e.e_count 
from    company 
join    lm 
on      company_code = lm.cclm 
join    sm 
on      lm.cclm = sm.ccsm 
join    m 
on      sm.ccsm = m.ccm 
join    e 
on      m.ccm = e.cce 
order   by company_code asc;
