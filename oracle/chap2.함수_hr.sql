select 5+3 from employees;--8이 50행 출력
select 5+3 from dual;--결과만 딱 보여줌

---------------------------------------------------------------------
--(1) 문자 함수
---------------------------------------------------------------------
-- 1) lower() : 소문자 변환
select 'DataBase', lower( 'DataBase') from dual;

-- 이름이 lex인 사원의 모든 정보를 출력해보자.
select * from employees where first_name ='lex';--no result
select * from employees where lower(first_name)='lex';
-- 2) upper() : 대문자 변환
select 'DataBase', upper( 'DataBase') from dual;
select * from employees where upper(first_name)='LEX';

-- 직급이 'it_prog'인 사원의 모든 정보를 출력
select * from employees where job_id=upper('it_prog');
select * from employees where lower(job_id) = 'it_prog';

-- 3) initcap()첫글자만 대문자로, 나머지는 소문자로 변환
select 'database', initcap('database') from dual;

--이름이 lex인 사원의 모든 정보를 출력해보자
select * from employees where first_name = initcap('lex');

-- 4) 문자를 연결하는 concat 함수(문자열 2개만 연결할 수 있다)
select concat('data','base') from dual;
select concat('data','base','oracle') from dual;--ORA-00909: invalid number of arguments
select concat('data',concat('base','oracle')) from dual;
select 'data' || 'base' || 'oracle' from dual;

--모든 사원의 이름과 성을 합하여 성, 이름으로 출력하고, 컬럼명을 full_name으로 하세요
select last_name || ',' || first_name as full_name from employees;

-- 5) length() : 문자의 길이를 구하는 함수
select length('database') from dual;--8
select length('데이터베이스') from dual;--6
select lengthb('database') from dual;--byte수 8
select lengthb('데') from dual;--3byte(포맷에 따라 2바이트이기도)
select lengthb('데이터베이스') from dual;--18

-- 이름이 6글자 이하인 사원들의 이름을 소문자로 출력하는 쿼리문 작성하세요.
select lower(first_name) from employees where length(first_name) <= 6;
select lower(first_name) from employees where length(first_name) <=6;

-- 6) substsr() : 문자열의 일부를 추출하는 함수
select substr('database',1) from dual;--시작위치 1번째(인덱스가 아님,0아님)
select substr('database',1,3) from dual;--추출할 개수 3
select substr('database',-4) from dual;--뒤에서부터 셈

--입사연도가 2005년인 사원들의 모든 정보를 출력
select * from employees where substr(hire_date,1,2) = '05';

-- 7) instr(): 특정 문자의 위치를 구하는 함수
-- instr(대상문자열, 찾을 문자, (시작위치))
select instr('database','b') from dual; --5/ 번째에 있음
select instr('database','a') from dual;--2
select instr('database','a',3) from dual;--4

--이름의 세번째 자리가 i인 사람들의 모든 정보를 출력
select * from employees where instr(first_name,'i') = 3;
select * from employees where substr(first_name, 3, 1) ='i';
select * from employees where first_name like '__i%';

-- 8) trim : 문자열의 앞뒤에 있는 특정 문자를 잘라주는 함수
select trim('a' from 'aaaaDataBaseaaaa') from dual;--앞뒤의 a가 잘림
select trim(' ' from '    Data Base   ') from dual;
select trim('   database') from dual;

-- 8-1) ltrim()
select '00011000', ltrim('00011000','0') from dual;--trim left side
select '00011000', rtrim('00011000','0') from dual;--right side

-- 8-3)trim(삭제 옵션 삭제할 문자 대상문자열)
--삭제 옵션: leading(왼쪽 문자 삭제),trailing(오른쪽 삭제),both(왼,오 둘 다 삭제)
select '[' || trim('_' from '__database__') || ']'from dual;--양쪽이
select '[' || trim(leading '_' from '__databse__')||']' from dual;--leading: 앞만 잘림
select '[' || trim(trailing '_' from '__databse__')||']' from dual;--trailing: 뒤만 잘림
select '[' || trim(both '_' from '__databse__')||']' from dual;

-- 9)replace()
--replace(대상문자열, 교체할 문자, (대체할 문자))
select '010-5555-1234', replace('010-5555-1234','-',' ') from dual;
select '010-5555-1234', replace('010-5555-1234','-') from dual;--하이픈을 없애고 다 붙여서 출력

-- 10)lpad, rpad
-- 10-1) lpad
select lpad('DataBase',10,'$') from dual;--(10자리 중 빈 자리를 왼쪽부터 $로 채워줌)
select lpad('DataBase',10) from dual;--10자리 중 두자리를 왼쪽부터 비워놓은 상태

-- 10-2) rpad
select rpad('DataBase', 10, '0') from dual;


---------------------------------------------------------------------
--(2) 숫자 함수
---------------------------------------------------------------------
-- 1) abs() : 절대값을 구하는 함수
select abs(-15) from dual;--15
select abs(15) from dual;--15

--2)floor() : 소수점 아래를 버리는 함수
select floor(3.141592) from dual; --3
--2-1) cell() :
select ceil(3.141592) from dual;--4

--3) round() : 특정 자리수에서 반올림하는 함수
select round(3.141592,2) from dual; --3.14/반올림 혹은 반내림하여 소수점 아래 둘째자리까지 출력
select round(3.141592,4) from dual;--3.1416
select round(314.1592,-2) from dual;--300 / 소수점 위 둘째자리를 반올림 
select round(3.641592,0) from dual;--4 /

--4) trunc() 특정 자릿수에서 잘라내는 함수
select trunc(3.141592,2) from dual;--3.14
select trunc(3.141592,4) from dual;--3.1415
select trunc(314.1592,-2) from dual;--300
select trunc(3.141592) from dual;--3

-- 5)mod() 나머지 값을 반환하는 함수
select mod(34,2) from dual; --0
select mod(34,3) from dual;--1

--6)sign() : 양수, 음수, 0 구분
select sign(10) from dual;--1
select sign(-10) from dual;-- -1
select sign(0) from dual;-- 0

--7) power() : 거듭제곱
select power(2,3) from dual; --8 //2^3 

--8)sqrt() 제곱근
select sqrt(10) from dual;--3.16227766016837933199889354443271853372
select sqrt(16) from dual;--4

--문제) 사원들의 연봉을 구하려고 한다.
--연봉 = salary*12+(salary*12)*commission
--    = salary*12*(1+commission)
--연봉을 구해 소수점 이하 2자리까지만 출력되도록 하세요
--연봉 컬럼의 컬럼명은 annual salary라고 출력하세요
--사번 이름 연봉(annual salary)출력

select employee_id, first_name, round(salary*12*(1+commission_pct),2) 
as "annual Salary" from employees;


---------------------------------------------------------------------
--(3) 날짜(시간) 함수: 데이터 타입이 DATE인 데이터를 대상으로 하는 함수
---------------------------------------------------------------------
-- 1)현재 날짜를 반환하는 sysdate
select sysdate from dual;
select sysdate+1 내일 from dual;

--사원들이 입사일로부터 현재까지 입사한지 몇일 지났는지 구해보자.
select first_name,(sysdate - hire_date) as 입사일로부터몇일 from employees;
select first_name,floor(sysdate - hire_date)|| '일 지남' as 근무일수 from employees;

--2) 두 날짜 사이 간격(개월수)를 계산하는 months_between함수
select first_name, hire_date, floor(months_between(sysdate, hire_date)) as 근무개월수 from employees;

-- 3)개월 수를 더하는 add_months함수
select first_name, hire_date, add_months(hire_date,3) from employees;--3개월을 더해줌

-- 4) 해당 요일에 가장 가까운 날짜를 반환하는 next_day 함수
select sysdate, next_day(sysdate, '금요일') from dual;
select sysdate, next_day(sysdate, 'friday') from dual;--오류남 한글버전으로 설치했기 때문

--5)해당 달의 마지막 날짜를 반환하는 last_day함수
select sysdate, last_day(sysdate) from dual;--24/06/30

--6)특정 기준으로 반올림하는 round함수
select sysdate, round(sysdate,'month')from dual;--24/07/01//오늘이 6/25일이니까 반올림

--7)특정 기준으로 버리는 trunc함수
select sysdate, trunc(sysdate, 'month') from dual; --24/06/01

---------------------------------------------------------------------
--(4) 변환함수: 문자, 숫자, 날짜 값을 서로 다른 타입의 값으로 변환 
---------------------------------------------------------------------
--1)to_char() :숫자,날짜 데이터를 문자형으로 변환
--to_char(날짜, '출력형식') : 날짜를 문자열로 변환
--출력형식: 교재 155쪽 참고
select sysdate, to_char(sysdate,'yyyy-mm-dd') from dual;--2024-06-25
select sysdate, length(to_char(sysdate,'yyyy-mm-dd')) from dual;--10

select sysdate, to_char(sysdate, 'yyyy-mm-dd am HH24:mi:ss') from dual;--2024-06-25 오후 12:19:03
select sysdate, to_char(sysdate, 'yyyy-mm-dd am HH:mi:ss') from dual;--2024-06-25 오후 12:19:22

--숫자-->문자---
select to_char(123456,'9999999') from dual;--  123456//9는 자릿수를 나타내며 자릿수가 맞지 않으면 채우지 않는다
select to_char(123456,'0000000') from dual;-- 0123456//0개수는 자릿수를 나타내며 자릿수가 맞지 않으면 0으로 채운다

--1. L999999
select first_name,salary, to_char(salary,'L999,999') from employees;
select first_name,salary, to_char(salary,'$999,999') from employees;

--2) to_date() : 숫자형, 문자형 데이터를 날짜형으로 변환
--입사일이 2006년 1월 3일인 사원을 검색하려 한다고 하자.
select first_name,hire_date from employees where hire_date ='06/01/03';
select first_name,hire_date from employees where hire_date =20060103; 
--ORA-00932: inconsistent datatypes: expected DATE got NUMBER
select first_name,hire_date from employees where hire_date =to_date(20060103,'yyyymmdd');
select first_name, hire_date from employees where hire_date='06/01/03';

select to_date('2010-07-14','yyyy-mm-dd')from dual;
select to_date('2010-07-14')from dual;--생략해도 정상적으로 실행됨

--3)to_number() : 숫자형을 변환
select '10000' + '20000' from dual;--30000 자동으로 숫자타입으로 변환해서 계산
select '10,000' + '20,000' from dual;--ORA-01722: invalid number

select to_number('10,000','999,999') from dual;--숫자는 오른쪽 정렬
select '10,000' from dual;--왼쪽정렬
select to_number('10,000','999,999') + to_number('20,000','999,999') from dual;--30000 //999,999꼭 넣어줘야 한다

---------------------------------------------------------------------
--(5) 기타함수
---------------------------------------------------------------------
--1) nvl():첫번재 인자로 받은 값이 null이면 두번째 인자 값으로 변경
--문제) 사원들의 연봉을 구하려고 한다.
--연봉 = salary*12+(salary*12)*commission
--    = salary*12*(1+commission)
--연봉을 구해 소수점 이하 2자리까지만 출력되도록 하세요
--연봉 컬럼의 컬럼명은 annual salary라고 출력하세요
--사번 이름 연봉(annual salary)출력

select employee_id, first_name, round(salary*12*(1+commission_pct),2) 
as "annual Salary" from employees;--null이 나왔었다

select employee_id, first_name, round(salary*12*(1+nvl(commission_pct,0)),2) 
as "annual Salary" from employees;
--nvl2는 책 참고--값이 NULL인 경우 지정값을 출력하고, NULL이 아니면 원래 값을 그대로 출력한다.

select first_name, department_id, decode(department_id, 90, 'Executive',
60,'IT',100,'Finance',
'default') as "부서이름" from employees;

-- 3)case 함수
select first_name, department_id, 
case when department_id =90 then 'Executive'
     when department_id =60 then 'IT'
      when department_id =100 then 'Finance'
      else 'default'
end
as 부서명
from employees;


--4) rank()함수
select first_name, salary, 
    rank() over (order by salary desc) rank, 
    dense_rank() over (order by Salary desc) dense_rank,
    row_number() over (order by salary desc) row_number
from employees;


---------------------------------------------------------------------
---그룹함수
--1) sum():합계 구하는 함수
select sum(salary) from employees;
select first_name, sum(salary) from employees;--ORA-00937: not a single-group group function// 이름은 쭉 나오는데 값은 하나만 있으니 함께 출력 불가

--2)avg() : 평균을 구하는 함수
select to_char(round(avg(salary),2),'$9,999.99') from employees;
    
--3) max(),min() : 최대값, 최소값 구하는 함수
select max(salary), min(salary) from employees;

--4) count(): 행의 개수를 세어주는 함수
--**count함수는 null인 데이터는 세지 않는다
select count(*) as "전체 직원 수" from employees;
select count(commission_pct) as "커미션 받는 직원 수" from employees;
select count(department_id) from employees;--106//null데이터는 카운트하지 않는다 

--5)stddev() : 표준편차
select stddev(salary) from employees;
--6)variance() : 분산
select variance(salary) from employees;
select sqrt(variance(salary)) from employees;--stddev(salary)가 같은 값 square root// 루트분산은 표준편차와 같다

--group by 절 : 그룹화를 시킬 때 사용하는 절
--group by 컬럼명

--소속 부서별 급여 총액과 급여 평균
select department_id, sum(salary), avg(salary) from employees--아까는 많은 직원행의 속성과 +하나뿐인 sum 속성을 함께 출력하면 안나오더니 지금은 되는 이유는 묶어줘서
group by department_id;

--직무별 급여 총액과 급여 평균
select job_id, sum(salary) 합계, avg(salary)
from employees group by job_id
order by 합계 desc;

--그룹화를 시킨 컬럼은 where절로 조건을 제한을 하지 못한다. avg(salary)....?
select department_id, avg(salary)
from employees
where avg(salary) >=5000 --where에서 그룹펑션을 사용할 수 없다//ORA-00934: group function is not allowed here
group by department_id;

--대신 having 절을 쓴다 :그룹화를 시킨 컬럼에 조건을 부여할 때 쓴다. 
select department_id, avg(salary)
from employees group by department_id
having avg(salary) >= 5000;

select job_id, department_id, sum(salary), avg(salary)
from employees
where department_id between 50 and 100
group by job_id, department_id--우선 잡으로 그룹핑하고 이후 디파트먼트로
order by job_id;

--직급별(job_id) 급여 최대값과 급여 최소값을 구하되,
--최대 급여가 7000 이상인 직급만 출력하세요

select job_id, max(salary),min(salary)
from employees group by job_id
having max(salary) >=7000 ;--having절의 위치가 앞에가도 실행은 되지만 보통 맨뒤에 씀

SELECT CONCAT(first_name, last_name) AS full_name
FROM  employees
ORDER BY full_name;--실행순서 : from-(where,groupby,having) select - orderby

SELECT CONCAT(first_name, last_name) AS full_name
FROM employees
WHERE full_name = 'VioletBeach';--ORA-00904: "FULL_NAME": invalid identifier, where가 select보다 먼저 실행되기 때문에 인식 못함

select job_id, count(job_id) as cnt_job_id, department_id, sum(salary), avg(salary)
from employees
where department_id between 50 and 100
group by job_id, department_id
having avg(salary) >= 7000
order by cnt_job_id;