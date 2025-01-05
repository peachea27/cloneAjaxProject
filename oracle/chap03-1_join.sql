--JOIN
--두개 이상의 테이블에서 결과를 얻기 위한 sql문

--사번이 100번인 사원의 정보(사번, 이름, 부서번호)와 그가 속한 부서명까지 출력
select employee_id, first_name,employees.department_id, department_name-----department_id는 employees에서 찍든 departments에서 찍든 상관없음
from employees,departments
where employees.department_id = departments.department_id
and employee_id =100;

select e.employee_id, e.first_name,e.department_id, d.department_name
from employees e,departments d
where e.department_id = d.department_id --조인조건
and e.employee_id =100;

select e.employee_id, e.first_name,e.department_id, d.department_name
from employees e,departments d, table3, table4
where e.department_id = d.department_id --조인조건
and d.id=t3.id
and t3.id= t4.id
and e.employee_id =100;

--문제)CEO가 휴가철을 맞이하여 모든 직원에게 선물을 택배로 보내려 한다.
--모든 직원들이 택배를 무사히 받을 수 있도록
--사무실의 주소, 사원 정보 출력

select  e.first_name || ' ' || e.last_name,c.country_name, l.street_address,l.postal_code, l.city, l.state_province, r.region_name  
from locations l, employees e, departments d,countries c, regions r
where e.department_id=d.department_id
and d.location_id=l.location_id
and r.region_id = c.region_id
and c.country_id= l.country_id;

--------------------------------------------------------------------------------
--조인의 종류
--------------------------------------------------------------------------------
--1)Cross join (교차조인) : 단순하게 두개 이상의 테이블을 
--곱연산의 결과를 냄.
--조인 조건에 해당하는 where절이 존재하지 않기 때문에,
--테이블간의 관계를 파악해서 조인하지 않음.
select * from employees;
select * from employees, departments;
select count(*) from employees, departments; --2889

select count(*) from employees; --107
select count(*) from departments; --27
select 107*27 from dual;

--2) Equal Join (등가 조인, equal join) : 가장 많이 사용되는 조인
--조인 대상이 되는 테이블에서 공통적으로 존재하는 칼럼을 연결("="로 연결)하여
--결과를 생성하는 조인
select e.first_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id; --null이 한명 빠져서 106명

--조인 문장이 지켜야 할 조건
-- 1) 기본키(primary key)와 외래키(foreign key)칼럼을 통해서 서로 다른 테이블을 연결한다.
-- 2) where 절을 사용하여 조인 조건을 기술한다. (조인 조건의 개수 = 연결하는 테이블 수 -1)
-- 3) 명확성을 위해 컬럼명 앞에 테이블 별칭을 기술한다.

-- 3) Non-Equi Join (비등가 조인) : 조인할 테이블 사이의 컬럼 값이 직접적으로 일치하지 않을 때
-- : 조인할 테이블 사이의 칼럼 값이 직접적으로 일치하지 않을 때 사용하는 조언
select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal >= s.losal and e.sal <=s.hisal;

--4) -Self join
--하나의 테이블에서 조인을 하여 원하는 데이터를 얻는 조인------hr
select worker.employee_id,worker.first_name || '의 직속 상사는' || manager.first_name || '입니다.' as 직속상사
from employees worker, employees manager
where worker.manager_id = manager.employee_id
order by worker.employee_id;
---사장님은 null이라서 빠져있음

--5) outer join (외부조인)
-- :행이 조인 조건에 만족하지 않는 경우, 그 행은 조인 결과에 나타나지 않는다.
--그러나 가끔 조인 조건에 만족하지 않는 행들도 나타내기 위해 outer join을 사용해야 할 때가 있다.
--left outer join(왼쪽 외부 조인)
select e.first_name, d.department_name
from employees e, departments d
where e.department_id = 
d.department_id;
--위의 결과에서 178번 Kimberly사원이 부서번호가 null이라서 누락되어 있다. 
--아무 부서에도 배치되지 않은 178번 사원의 정보까지 출력하고 싶다면,
--아래처럼 outer join사용한다.

--left outer join(왼쪽 외부조인)
select e.first_name, d.department_name
from employees e, departments d
where e.department_id = 
d.department_id(+);

--right outer join(오른쪽 외부 조인)
--사원이 있든 없든 부서테이블에 있는 모든 부서를 다 보겠다
select e.first_name, d.department_name
from employees e, departments d
where e.department_id(+) = d.department_id;

select e.first_name, d.department_name
from employees e, departments d
where e.department_id(+) = d.department_id(+);
--이런걸 full outer join이라고 부르는데 에러가 남. 이렇게는 안된다고 한다(둘 다 붙일 수는 없음)
--ORA-01468: a predicate may reference only one outer-joined table

--ANSI join :(american national standard institute) 미국 표준 연구소에서 제정한 다른 DBMS와의 호환성을 위해 만든 것
--1)ANSI Cross join
select * from employees cross join departments;
select count(*) from employees cross join departments;

--2) ANSI INNER JOIN : EQUI JOIN과 동일
--join 조건을 where절이 아니라 on절에 기술한다.
--일반조건은 where절에 기술하면 됨
select e.first_name, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id;

select count(*)
from employees e inner join departments d
on e.department_id = d.department_id;
--106명 킴벌리가 또 빠짐

select e.first_name, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id
where first_name like '%n';


select e.first_name, d.department_name
from employees e inner join departments d
where first_name like '%n'
on e.department_id = d.department_id;
--ORA-00905: missing keyword 순서 이렇게는 안됨

--using()절을 이용하여 join조건을 지정하기.  
--조인되는 컬럼명이 동일해야 하고,
--using절에는 테이블 별칭을 사용하지 못하고, 괄호로 생략하지 않는다.
select e.first_name, d.department_name
from employees e inner join departments d
using(department_id);

select e.first_name, d.department_name
from employees e inner join departments d
using(e.department_id);
--e.이렇게 하면 오히려 에러가 난다
--괄호도 필수

--natural join
--조인이 되는 컬럼명이 동일할 때,
--DBMS가 알아서 테이블을 살펴보고 동일한 칼럼으로 inner join 진행(자동으로 동일명 찾아서 조인시켜줌)
--단, 동일한 칼럼명이 2개 이상 나오면 and조건으로 inner join을 진행
select e.employee_id, e.first_name, d.department_name
from employees e natural join departments d;
--중복컬럼인 매니저아이디와 디파트먼트아이디가 겹치는 사람들만 추출

--3)ANSI outer join
select e.first_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id(+);
--왼쪽 테이블에 누락된 정보를 보임
select e.first_name, d.department_name
from employees e left outer join departments d
on e.department_id = d.department_id;
--오른쪽 테이블에 누락된 정보를 보임
select e.first_name, d.department_name
from employees e right outer join departments d
on e.department_id = d.department_id;

--양쪽 테이블에 누락된 정보를 모두 보임

select e.first_name, d.department_name
from employees e full outer join departments d
on e.department_id = d.department_id;

<scott>
1. 급여가 3000에서 5000사이인 직원의 이름과 소속 부서명을 출력
select ename, dname
from emp e, dept d where e.deptno=d.deptno and sal between 3000 and 5000; 
2. 직급이 manager인 사원의 이름, 부서명을 출력하세요
select ename, dname,job 
from emp e, dept d  where e.deptno=d.deptno and job = upper('manager');
3. accounting 부서 소속 사원의 이름과 입사일 출력하세요
select ename, hiredate from emp e, dept d
where e.deptno=d.deptno and dname=upper('accounting');

4. 커미션을 받는 사원의 이름과 그가 속한 부서명을 출력----null이 아닌 사원, 0인 사원 포함
select ename, dname from emp e, dept d where e.deptno = d.deptno and comm is not null;

select e.ename, d.dname, e.comm from emp e inner join dept d 
on deptno=deptno and e.comm is not null and e.comm !=0;
5. 뉴욕에서 근무하는 사원의 이름과 급여를 출력
select ename, sal from emp e, dept d where e.deptno = d.deptno and loc='NEW YORK';
6. 급여가 1200 이하인 사원 이름과 급여와 그가 근무하는 근무지를 출력하세요
select ename, sal, loc from emp e inner join dept d using(deptno) where sal<=1200;
7. smith와 동일한 근무지에서 근무하는 사원의 이름을 출력하세요
select ename, loc from emp e inner join dept d on e.deptno = d.deptno
where d.loc = (select loc from dept d, emp e where d.deptno=e.deptno and e.ename=upper('smith'))and e.ename<>upper('smith');

select coworker.ename, coworker.deptno from emp worker inner join emp coworker on worker.deptno = coworker.deptno 
where worker.ename= upper('smith') and coworker.ename <> upper('smith');-------같은 테이블에서 inner join하는 방법
8. 매니저가 king인 사원들의 이름과 직급을 출력하세요
select employee.ename,manager.ename, employee.job from emp employee, emp manager where manager.ename=upper('king');

select ename, job, mgr from emp where mgr = (select empno from emp where ename=upper('king'));

select worker.ename, worker.job, manager.ename as 매니저이름 from emp worker inner join emp manager
on worker.mgr = manager.empno
where manager.ename = upper('king');
9. 월급이 2000 초과인 사원들의 부서번호, 부서이름, 사원번호, 사원이름, 월급을 출력하세요
select e.deptno, d.dname, e.empno, e.ename, e.sal from emp e inner join dept d on e.deptno =d.deptno where e.sal >2000; 
10. 각 부서별 평균 급여, 최대급여, 최소급여, 사원수를 출력하되, 부서번호, 부서이름도 같이 출력하세요.
select d.deptno, d.dname,round(avg(e.sal)) 평균급여,max(e.sal) 최대급여,min(e.sal)최소급여,count(*)사원수 from emp e inner join dept d on e.deptno= d.deptno
group by d.deptno, d.dname;------------------------where과 having을 없애고 group by를 두가지 태그 모두로 해줌
select d.deptno, d.dname,avg(e.sal),max(e.sal),min(e.sal),count(*) from emp e, dept d having e.deptno(+)= d.deptno
group by d.deptno, d.dname;------------이건 안됨
11. '모든 부서' 정보와 사원 정보를 부서번호, 사원 이름순으로 정렬하여 출력하세요--사원이 있든 없든
select d.deptno, e.ename from emp e, dept d where e.deptno(+) = d.deptno order by d.deptno, e.ename;

select d.deptno, d.dname, d.loc, e.empno, e.ename, e.job, e.sal from emp e right outer join dept d
on e.deptno = d.deptno
order by d.deptno, e.ename;

12. '모든 부서' 정보, 사원 정보, 급여 등급 정보, 각 사원의 매니저의 정보를 
 부서번호, 사원 번호 순서로 정렬하여 다음과 같이 출력하세요.
부서번호, 부서이름, 사원번호, 사원이름, losal, hisal, grade, 매니저번호, 매니저이름-------------------------------------------?
select d.deptno, d.dname, e.empno, e.ename, s.losal, s.hisal, s.grade, e.mgr, m.ename from emp e right outer join dept d
on e.deptno =d.deptno
left outer join salgrade s
on e.sal between s.losal and s.hisal
left outer join emp m
on m.empno = e.mgr
order by d.deptno, e.empno;
------failed below------------------------------------------------------- 
select d.deptno, d.dname, worker.ename, s.losal, s.hisal, s.grade, manager.empno, manager.ename 
from emp worker, emp manager, dept d, sal s 
where worker.empno = manager.empno, manager.deptno=d.deptno, worker.sal>= s.losal and worker.sal<=s.hisal;
order by d.deptno, worker.empno; 