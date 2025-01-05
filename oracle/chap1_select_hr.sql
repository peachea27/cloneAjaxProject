--select 문으로 특정 데이터를 추출하자.
--select * : |{조회할컬럼명1, 조회할컬럼명2, 조회할컬럼명3, ....}
--from 테이블명;
--countries테이블의 모든 컬럼 조회
select * from countries;

--부서 테이블의 모든 컬럼 조회
select * from departments;

--사원 테이블의 모든 컬럼 조회

select * from employees;

select * from locations;

--사원 테이블의 사원 이름만 조회를 하자
select first_name from employees;

--부서테이블에서 부서명만 조회
select DEPARTMENT_NAME from departments;

--지역 테이블에서 도로명 주소만 조회
select STREET_ADDRESS from locations;

--사원 테이블에서 사원명과 급여를 조회하자
select FIRST_NAME,SALARY from employees;

--사원 테이블에서 사원, 이름, 입사일을 조회하자
select EMPLOYEE_ID, FIRST_NAME, HIRE_DATE from employees;

--부서 테이블에서 부서명, 부서번호를 조회
select DEPARTMENT_NAME,DEPARTMENT_ID from departments;

--2.컬럼명에 별칭을 지을 수 있다.
-- -- 1)컬럼명에 별칭을 지으면 컬럼명을 기술한 뒤 컬럼명 뒤에 as라는 키워드를 쓴다.
select first_name as name from employees;
select employee_id as 사번, first_name as 이름 from employees;

-- -- 2) as키워드를 생략해도 된다.
select first_name 이름 from employees;

-- -- 3)별칭에 공백이나 특수문자를 포함하는 경우에는 별칭을 "별칭"(큰따옴표)로 묶는다.
--select first_name 이 름 from employees;  :에러 발생
select first_name "이 름" from employees; 

-- 3. distinct 키워드는 중복된 데이터를 한번씩만 출력하게 한다.
select distinct job_id from employees;

-- 4.where 절을 사용하여 조건절을 사용할 수 있다.

select * 
from employees
where employee_id >= 150;

--1) 조건식에 사용되는 연산자 {>, <,>= , <= , =, !=(not equal} 등;
--사원 테이블에서 이름이 adam인 사원의 사번, 이름, 입사일을 조회
--sql에서 문자열이나 날짜를 표현할 때는 ''(작은 따옴표)를 이용한다.

select employee_id, first_name, hire_date
from employees
where first_name = 'Adam';--문자열은 대소문자 구분

--사원 테이블에서 급여가 5000이상인 사원들의 사번, 이름, 급여를 조회
select employee_id, first_name, salary from employees
where salary >= 5000;

--지역테이블 (locations)에서 지역번호가 1800번 이하인 지역의 모든 칼럼 조회

select * from locations where location_id <= 1800;

--사원테이블에서 입사일이 2002년 이전에 입사한 사원들의 사번, 이름, 급여, 입사일을 조회

select employee_id, first_name, salary, hire_date from employees
where hire_date < '02/01/01';

--2) 조건연산자를 연결할 때 논리연산자 ( and , or , not)를 사용할 수 있다.
--not equal : !=, <>, ^= 모두 같지 않음을 뜻한다
--사번에 130번 보다 작거나 급여가 5000보다 큰 사원들의 사번, 급여를 출력
select employee_id, salary from employees
where employee_id < 130 or salary > 5000;

--급여가 5000이상이고 부서번호가 30번보다 작은 사원들의 사번, 급여, 부서번호를 출력
select employee_id, salary, department_id from employees 
where salary >= 5000 and department_id <30;

--부서번호가 100번이 아닌 모든 사원들의 모든 칼럼을 조회
select * from employees where department_id != 100;
select * from employees where department_id <> 100;--100보다 작고 100보다 크다
select * from employees where department_id ^= 100;

--3) between A and B : A이상이고 B이하
--급여가 5000이상이고 급여가 7000이하인 사원들의 이름, 급여를 출력
select first_name, salary from employees where salary >= 5000 and salary <= 7000;

select first_name, salary from employees
where salary between 5000 and 7000;

--입사연도가 2003년에서 2005년인 사원들의 모든 정보를 출력
select * from employees where hire_date between '03/01/01' and '05/12/31';

-- 4) in (A, B, C) 연산자 : A 또는 B 또는 C 중에서 해당하는 걸 고름
--부서번호가 10번 또는 50번, 100번인 사원들의 모든 정보 출력
select * from employees where department_id in (10, 50, 100);   

