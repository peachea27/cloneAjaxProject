--서브쿼리(hr)

--100번 사원이 소속되어 있는 부서의 부서명을 알아보자.
--1) 100번 사원이 소속되어 있는 부서번호를 알아낸다(employees 테이블)
select department_id from employees where employee_id = 100; --90

--2) 1번에서 알아낸 부서번호의 부서 이름을 알아낸다.(departments 테이블)
select department_name from departments where department_id = 90; --Executive

--서브쿼리를 사용하면....
select department_name from departments 
where department_id = (select department_id from employees where employee_id = 100);--괄호 먼저 실행

--사원들이 소속되어 있는 부서의 사번, 이름, 소속되어 있는 부서의 부서명을 출력하자.
select employee_id, first_name, department_name from departments, employees 
where department_id =(select department_id from employees);
--ORA-00918: column ambiguously defined//department_id는 둘 다 속해있는데 어디서 가져와야 할까요--join필요
--서브쿼리는 메인 쿼리문의 테이블에 있는 컬럼 정보밖에 얻지 못함, 문제 해결을 위해 join
--join을 많이 쓰면 부하가 걸릴수도 있기 때문에 서브쿼리로 가능한 건 서브쿼리로 해결하기

-- executive부서의 국가코드, 주, 시, 도로명 주소를 출력해보자.
--locations,departments
-subquery이용
--1)executive부서의 location_id를 조회(하나씩 직접 찾아보는건 데이터많으면 불가능)
select location_id from departments where department_name= initcap('executive');--1700
--이렇게 행 하나만 반환하는 걸 단일행 서브쿼리라고 부름

--2)location_id=1700인 국가코드, 주, 시, 도로명 주소를 조회
select country_id, state_province, city, street_address from locations where location_id=1700;
--
select country_id, state_province, city, street_address from locations 
where location_id=
(select location_id from departments where DEPARTMENT_NAME='Executive');

--------------------------------------------------------------------------------
서브쿼리의 종류
--------------------------------------------------------------------------------
--1)단일행 서브쿼리(single row subquery):내부 select 문장으로부터 하나의 행만
--반환받으며 연산자로 =,<,>,<=,>=,!=를 사용할 수 있다
--문제)
-Diana와 같은 부서에 다니는 동료들의 모든 정보를 출력하세요
select * from employees where department_id=(select department_id from employees where first_name ='Diana');

-사원들의 평균 급여보다 더 많은 급여를 받는 사원의 사번, 이름 ,급여를 출력하세요
select employee_id, first_name, salary from employees 
where salary >avg(salary);--ORA-00934: group function is not allowed here

select avg(salary) from employees;

select employee_id, first_name, salary from employees 
where salary > 6461.831775700934579439252336448598130841;

select employee_id, first_name, salary from employees 
where salary >(select avg(salary) from employees);
--------------------------------------------------------------------------------
--2)다중행 서브쿼리(MUltiple-row subquery)
--서브쿼리에서 반환되는 행의 갯수가 2개 이상일 때
--다중행 서브쿼리에서 사용하는 연산자
--1) in : 메인 쿼리의 비교 조건이 서브쿼리의 절과 중에서 하나라도 일치하면 참, 
--2) any : 메인 쿼리의 비교조건이 서브쿼리의 결과와 하나 이상이 일치하면 참.
--3) all : 메인 쿼리의 비교조건이 서브쿼리의 결과와 모든 값이 일치하면 참.


--급여를 7000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의 정보를 출력,
--1)급여를 7000이상 받는 사원이 소속된 부서
select salary from employees where salary >= 7000;
--2)동일한 부서에서 근무하는 사람들의 정보를 출력
select * from employees
where department_id=(select department_id from employees where salary >= 7000);--하나의 값이 와야 하는 자리인데 
--ORA-01427: single-row subquery returns more than one row

select * from employees where department_id in(select department_id from employees where salary >= 7000);

select * from employees where department_id in(select distinct department_id from employees where salary >= 12000);
--100,90,20,110,80 중 하나라도 일치되는게 있으면 출력,, 숫자는 걍 보기 편하라고 올림
select * from employees where department_id in(100,90,20,110,80);

--all 연산자
--문제) 30번 부서에 소속된 사원 중에서 급여를 가장 많이 받는 사원보다
--더 많이 받는 사원의 이름,급여를 출력해보자
--방법 a)

select department_id,first_name,salary from employees where salary > all(select salary from employees where department_id=30;  

select first_name, salary from employees 
where salary > (select max(salary) from employees where department_id=30);

--방법 b)
--all : 메인 쿼리의 비교조건이 서브쿼리의 결과와 모든 값이 일치하면 참
select salary, department_id from employees where department_id=30;

select first_name, salary from employees
where salary > all(select salary fro m employees where department_id = 30);

select first_name, salary from employees
where salary > all(11000,3100,2900,2600,2500);
--이걸 다 만족시켜야 함, 결국 11000보다 커야 한다는 것, 이렇게 짜면 데이터가 많을 시엔 좀 곤란

--any : 메인 쿼리의 비교조건이 서브쿼리의 결과와 하나 이상이 일치하면 참.
--(1) < any()
select first_name, salary from employees where salary < any(4000, 6000, 9000, 12000);

--(2) > any() : 결과적으로 가장 적은 값인 4000보다 크기만 하면 조건을 만족
select first_name, salary from employees where salary > any(4000,6000,9000,12000;

--(3) = any() :
select first_name, salary from employees where salary = any(4000,6000,9000,12000);
select first_name, salary from employees where salary in (4000,6000,9000,12000);

---문제: 30번 부서에 소속된 사원 중에서 급여를 가장 적게 받는 사원보다 더 많이 받는 사원의 이름, 급여를 출력하세요
select min(salary) from employees where department_id =30;--2500
select first_name, salary from employees where salary > (select min(salary) from employees where department_id =30);
select first_name, salary from employees where salary > any (select salary from employees where department_id =30);

--다중열 서브쿼리
select * from employees 
where (department_id, salary) 
in (select department_id, max(salary) from employees
group by department_id);

--select절에 사용하는 서브쿼리
select employee_id, first_name, salary, department_id,
(select department_name from departments
where employees.department_id = departments.department_id)--컬럼 둘이 이름이 달라도(department_id) 걍 쓰면 됨
from employees;

서브쿼리 연습문제(scott)
1. smith와 동일한 직급을 가진 사원의 이름과 직급 출력
select ename, job from emp where job = (select job from emp where ename = upper('smith'));

1-1) smith는 빼고 출력
select ename, job from emp where job = (select job from emp where ename = 'SMITH') and  ename <> upper('smith');
2. 부서별로 가장 급여를 많이 받는 사원의 정보를 출력
select * from emp where sal in(select max(sal) from emp group by deptno);
-- 3. 직급이 salesman인 사원이 받는 급여 중 최소 급여 보다 많이 받는 사원의 이름과 급여를 출력하되, 부서번호가 20번인 사원은 제외하여 출력
select ename, sal from emp where sal> any(select sal from emp where job=upper('salesman')) and deptno ^= 20;
-- 4. 직급이 salesman인 사원이 받는 급여 중 최대 급여 보다 많이 받는 사원의 이름과 급여를 출력하되, 부서번호가 30번인 사원은 제외하여 출력
select ename, sal from emp where sal > all (select sal from emp where job=upper('salesman')) and deptno !=30;