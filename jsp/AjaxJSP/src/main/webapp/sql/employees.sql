-- --------------- Ajax JSP 쿼리문

-- 모든 직원 목록 불러오기 (부서 이름 추가)
select e.*, d.department_name 
from employees e inner join departments d
on e.department_id = d.department_id;

-- 모든 직급 가져오기
select * from jobs;

-- 모든 부서 정보 가져오기
select * from departments;

-- 
select * from friends;

--CREATE OR REPLACE PROCEDURE PROC_SAVEEMP
--(
--    pFIRST_NAME IN EMPLOYEES.FIRST_NAME%TYPE,
--    pLAST_NAME IN EMPLOYEES.LAST_NAME%TYPE,
--    pEMAIL IN EMPLOYEES.EMAIL%TYPE,
--    pPHONE_NUMBER IN EMPLOYEES.PHONE_NUMBER%TYPE,
--    pHIRE_DATE IN EMPLOYEES.HIRE_DATE%TYPE, 
--    pJOB_ID IN EMPLOYEES.JOB_ID%TYPE,
--    pSALARY IN EMPLOYEES.SALARY%TYPE,
--    pCOMMISSION_PCT IN EMPLOYEES.COMMISSION_PCT%TYPE,
--    pMANAGER_ID IN EMPLOYEES.MANAGER_ID%TYPE,
--    pDEPARTMENT_ID IN EMPLOYEES.DEPARTMENT_ID%TYPE,
--    result OUT VARCHAR2
--)
--AS 
--    tmp_employee_id EMPLOYEES.EMPLOYEE_ID%TYPE;
--
--BEGIN
--    select max(employee_id) + 1 into tmp_employee_id from employees;
--    
--    insert into employees(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE,
--    JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) 
--    values (tmp_employee_id, initcap(pFIRST_NAME), initcap(pLAST_NAME), upper(pEMAIL), pPHONE_NUMBER, pHIRE_DATE,
--    pJOB_ID, pSALARY, pCOMMISSION_PCT, pMANAGER_ID, pDEPARTMENT_ID );
--    
--    result := 'SUCCESS';
--    COMMIT;
--    
--    EXCEPTION  -- Begin 부분에 있는 DML문장을 실행할 때 예외가 나면 처리될 문장
--        WHEN OTHERS THEN -- 모든 예외에 대해서...다음의 문장을 실행
--        result := 'ERROR';
--        ROLLBACK;
--END;

select * from employees;

-- 사원 정보 수정
-- 302번 사원 정보 수정
update employees set first_name = 'Thurs' where employee_id = 302;

update employees set email = ? where employee_id=?;

select * from employees where employee_id = 302;
commit;

-- 사원 정보를 수정할 때, 유저가 어떤 값을 수정할지 모른다.
-- 그래서 모든 경우의 쿼리문을 다 만들 수 없다.
-- 1) 먼저 수정할 사원의 정보를 데이터입력 UI 에 바인딩 시킨다. 
--      -> 유저가 특정 값을 수정한다.
--      -> 모든 값을 가져온다.
select e.*, d.department_name 
from employees e inner join departments d
on e.department_id = d.department_id where e.employee_id = 302;
-- 2) 모든 컬럼의 값을 update시켜준다.
-- 쿼리문 작성
update employees set first_name=?, last_name=?, email=?, phone_number=?, hire_date=?,
job_id=?, salary=?, commission_pct=?, manager_id=?, department_id=? where employee_id=?;

select * from employees where employees.employee_id = 302;




-- 사원 삭제
--1) 삭제 delete 문을 사용하는 경우
-- - oldEmp 테이블에 퇴사하는 사원을 옮긴 후, delete문을 수행.
-- 
--2) delete문을 사용하지 않는 경우
-- - employees테이블에 quit_date컬럼을 추가한 후, update수행
alter table employees
add quit_date date;

-- update문 
update employees set quit_date = ? where employee_id=?;

-- 전체 사원 목록 쿼리 수정
select e.*, d.department_name 
from employees e inner join departments d
on e.department_id = d.department_id
where quit_date is null 
order by employee_id;

-- 사원 이름으로 검색
select e.*, d.department_name 
from employees e inner join departments d
on e.department_id = d.department_id 
where (lower(first_name) like '%ev%' or lower(last_name) like '%?%') and quit_date is null;

-- 정렬하기
-- 1) 사번(오름차순)
select e.*, d.department_name 
from employees e inner join departments d
on e.department_id = d.department_id
where quit_date is null 
order by e.employee_id;

-- 2) 입사일순(내림차순)
select e.*, d.department_name 
from employees e inner join departments d
on e.department_id = d.department_id
where quit_date is null 
order by e.hire_date desc;

-- 3) 급여순 (내림차순)
select e.*, d.department_name 
from employees e inner join departments d
on e.department_id = d.department_id
where quit_date is null 
order by e.salary desc;
    

select e.*, d.department_name 
from employees e inner join departments d
on e.department_id = d.department_id
where quit_date is null and (lower(first_name) like '%st%' or lower(last_name) like '%st%') order by e.hire_date desc;


