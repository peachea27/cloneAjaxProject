--함수 연습문제
--
--1. 사번이 짝수인 사원들의 사번, 이름, 직무 출력
desc emp;
select empno,ename, job from emp where mod(empno,2) = 0;
--2. 'Smith'란 이름을 가진 사원의 사번, 이름, 급여, 커미션을 출력하라
--- initcap 이용
select empno,ename,sal,comm from emp
where initcap(ename)='Smith';
--- upper 이용
select empno,ename,sal,comm from emp
where ename=upper('Smith');
--3. 이름의 두번째 자리에 A 가 있는 사원의 사번, 이름, 직무을 출력
--    1. substr 이용
select empno,ename,job from emp
where substr(ename,2,1)='A';

--    2. instr 이용
select empno,ename,job from emp
where instr(ename,'A')=2;
--    3. like 이용
select empno,ename,job from emp where ename like '_A%'; 
--4. 이름이 K로 끝나는 사원의 사번, 이름, 직무 출력
select empno,ename,job from emp
where ename like '%K';

select empno,ename, job from emp where substr(ename, -1,1)='K';--문제풀때는 다른 방법 없는지 다양하게 고민하기!

--5. 82년도에 입사한 사원의 사번, 이름, 입사일 출력
select empno,ename,hiredate from emp where substr(hiredate,1,2)=82;

select empno,ename,hiredate from emp where hiredate like '82%';
select empno,ename,hiredate from emp where instr(hiredate,'82')=1;
--6. 이름이 6글자 이상인 사원의 사번, 이름, 급여 출력
select empno,ename,sal from emp where length(ename)>=6;

--7.emp 테이블에 유일하게 상관이 없는 행이 있는데 그 사원의 mgr 컬럼에는 null이 있다. 상관이 없는 사원만 출력하되 mgr 컬럼 값에 null대신 'CEO'를 출력하세요??????????????
select ename,decode(mgr,null,'CEO') as MGR from emp where mgr is null;

select empno,ename, nvl(to_char(mgr,'9999'),'CEO') from emp where mgr is null;
select empno,ename, nvl(to_char(mgr,'9999'),'CEO') from emp where mgr is null;--invalid number, mgr는 number타입인데 ceo는 스트링이라서 발생하는 문제, char로 바꿔줌
--8. 직무에 따라 급여를 인상하여 출력하도록 한다. 직무가 'analyst'인 사원은 5%, 'salesman'인 사원은 10%,
--'manager'인 사원은 15%, 'clerk'인 사원은 20% 인상한다.
select ename,job, decode(JOB,'ANALYST',SAL*1.05, 'SALESMAN',SAL*1.1,'MANAGER',SAL*1.2,'CLERK',SAL*1.2,'MANAGER',SAL*1.15,sal) as SAL from emp;

--인상된 월급= sal+sal*0.05 =sal+1.05
select empno,ename, job, sal, decode(lower(job), 'analyst',sal*1.05,'salesman',SAL*1.1,'manager',SAL*1.15,'clerk',SAL*1.2,sal) 인상된월급 from emp;
select 800*1.2 from dual;--(검산 꼭 하기)

--9. 직업의 종류가 몇개인지 즉, 중복되지 않은 직업의 수를 카운트 하세요
select count(distinct job) from emp;
--10. 부서별 사원의 수와 커미션을 받는 사원의 수를 카운트 하세요.
select count(comm),deptno, count(*) from emp  group by deptno;

select deptno, count(*), count(comm) from emp group by deptno;

select deptno, count(*), sum(case when comm>0 then 1 else 0 end) from emp group by deptno;--comm이 0인 사원 한명을 빼고 count

select deptno, count(*), count(case when comm is not null and comm >0 then 1 end) as 커미션을받는사원수 from emp group by deptno;
--11. emp테이블에서 사원 이름이 다섯 글자 이상이고, 여섯글자 미만인 사원 정보를 출력한다.
select * from emp where length(ename) >= 5 and length(ename)<6;

--masking_empno 열에는 사원 번호 앞 두 자리와 뒷자리를 * 기호로 출력합니다.
--그리고 masking_ename열에는 이름의 첫 글자만 보여주고 나머지 글자 수 만큼 *기호로 출력하세요.
select rpad(lpad(substr(empno,3,1),3,'*'),4,'*') as masking_empno,  rpad(substr(ename,1,1),length(ename)-1,'*') as masking_ename from emp;

select empno, rpad(substr(empno,1,2),4,'*') as masking_empno, ename,rpad(substr(ename,1,1),length(ename),'*')as masking_ename from emp 
where length(ename) >= 5 and length(ename) < 6;

--12. emp테이블에서 사원들의 평균 근무일 수는 21.5일이다. 하루 근무 시간을 8시간으로 보았을 때
--사원들의 하루 급여(Day_pay)와 시급 (time_pay)를 계산하여 결과를 출력한다.
--단, 하루 급여는 소수점 세번째 자리에서 버리고, 시급은 두번째 소수점에서 반올림하세요.
select trunc(sal/21.5,3) as Day_pay , round((sal/21.5)/8,2) as time_pay from emp;

select empno,ename, sal, trunc(sal/21.5,2) as day_pay, round(sal/21.5/8,1) as time_pay from emp; 

--13. emp테이블에서 사원들은 입사일을 기준으로 3개월이 지난 후 첫 월요일에 정직원이 된다.
--사원들이 정직원이 되는 날짜를 yyyy-mm-dd형식으로 출력하세요. 단, 커미션이 없는 사원의 커미션은 N/A로 출력하세요.
select ename, to_char(next_day(add_months(hiredate,3),'월요일'),'yyyy-mm-dd') as promotion, decode(comm,null,'N/A',comm)as COMM from emp;

select empno,ename, hiredate,to_char(next_day(add_months(hiredate,3),'월요일'),'yyyy-mm-dd') as 정직원되는날짜 
,nvl(to_char(comm),'N/A') as 커미션
from emp; 
--14. emp테이블의 모든 사원을 대상으로 직속 상관의 사원 번호를 다음과 같은 조건을 기준으로 변환해서 chg_mgr열에 출력하세요.
--- 직속 상관의 사원 번호가 전재하지 않을 경우 : 0000
--- 직속 상관의 사원 번호 앞 두 자리가 75인 경우 : 5555
--- 직속 상관의 사원 번호 앞 두 자리가 76인 경우 : 6666
--- 직속 상관의 사원 번호 앞 두 자리가 77인 경우 : 7777
--- 직속 상관의 사원 번호 앞 두 자리가 78인 경우 : 8888
--- 그외 직속 상관 사원 번호의 경우: 본래 직속 상관의 사원 번호 그대로 출력
select ename,mgr,
case when mgr is null then '0000'
    when substr(mgr,1,2)=75 then '5555'
    when substr (mgr,1,2)=76 then '6666'
    when substr (mgr,1,2)=77 then '7777'
     when substr (mgr,1,2)=78 then '8888'
   else to_char(mgr)--다 캐릭터인데 매니저사번만 넘버라서 출력안됨, 같은 칸이니 타입을 맞춰줘야 함
end
as chg_mgr
from emp;

--15. emp테이블을 이용하여 부서 번호(DEPTNO), 평균 급여(AVG_SAL), 최고급여 (MAX_SAL),
--최저급여(MIN_SAL), 사원수 (CNT)를 출력하세요.
--단, 평균 급여는 소수점을 제외하고 각 부서번호 별로 출력하세요.
select deptno, floor(avg(sal)) as avg_sal, max(sal) as max_sal, min(sal) as min_sel, count(*) from emp group by deptno;

select deptno, trunc(avg(sal)) as avg_sal, max(sal) as max_sal, min(sal) as min_sal, count(*) as cnt from emp group by deptno;
--16. 같은 직책(JOB)에 종사하는 사원이 3명 이상인 직책과 인원수를 출력하세요.
select job, count(*) from emp group by job having count(job)>=3 ;

select job, count(*) from emp group by job having count(*) >= 3;
--17. 사원들의 입사 연도(YYYY)를 기준으로 부서별로 몇 명이 입사했는지 출력하세요.
select lpad(substr(hiredate,1,2),4,19) 입사연도,deptno, count(*) from emp group by substr(hiredate,1,2),deptno;

select to_char(hiredate,'yyyy'), deptno, count(*) from emp group by to_char(hiredate,'yyyy'), deptno ;