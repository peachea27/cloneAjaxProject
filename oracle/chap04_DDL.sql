-- 쿼리문을 이용하여 테이블을 생성
-- 제약조건은 복사가 되지 않는다.
create table copyEMP
as (select * from employees);

create table copyEMP1
as select employee_id, first_name, salary, hire_date from employees
where department_id = 30;

insert into copyemp1 values('300', '김삼백', 3000, '2001/01/02');
insert into copyemp1 values('301', '김삼백일', 3100, '2001-01-02');

select * from copyemp1;

-- 테이블의 구조만 복사 
create table copyEMP3
as select * from employees
where 1 = 0;

drop table copyemp9;
drop table copyemp1;
drop table copyemp;
drop table emp01;
-- member01테이블 생성
-- (1) create
create table member01 (
    userid varchar2(12),
    passwd varchar2(16),
    name varchar2(10),
    mobile varchar2(13),
    birthday date,
    gender char(1)
);

insert into member01 values('dooly123', '1234', '둘리', '010-1234-5678', '1998-01-01', 'M');
insert into member01 values('doner', '1234', '도우너', '010-5555-1010', '1998-12-01', 'M');

-- 다음 문장은 에러 : ORA-00947: not enough values
insert into member01 values('huidong', '1234', '희동이', '010-9999-1313', '2002-03-01');

-- 다음 문장은 에러 : ORA-00913: too many values
insert into member01 values('huidong', '1234', '희동이', '010-9999-1313', '2002-03-01', 'M', 'U');

-- 원하는 컬럼에만 데이터 넣기 
insert into member01(userid, passwd, name) values('abc123', '1234', '홍길동');

-- 아래 문장은 에러 : ORA-12899: value too large for column "HR"."MEMBER01"."NAME" (actual: 21, maximum: 10)
insert into member01(userid, passwd, name) values('cdf456', '1234', '김수한무거북이');

-- (2) alter table : 테이블 구조 수정
create table emp01 (
    empno number(4),
    ename varchar2(10),
    sal number(6),
    hiredate date
);

-- 1) add column : 새로운 컬럼 추가
alter table emp01
add (job varchar2(10));

-- member01테이블에 hobby라는 컬럼을 가변문자열 (크기50) 저장할 수 있도록 추가하세요.
alter table member01
add hobby varchar2(50);

-- 2) modify column : 기존 컬럼 수정
-- a) 해당 컬럼에 데이터가 없는 경우 : 데이터 타입, 사이즈 모두 변경 가능
-- b) 해당 컬럼에 데이터가 있는 경우 : 데이터 타입 
alter table emp01
modify ename varchar2(6);

alter table member01
modify gender varchar2(1); 

-- 다음문장은 에러 : 
-- ORA-01439: column to be modified must be empty to change datatype
alter table member01
modify birthday varchar2(15);

alter table member01
modify userid varchar2(10); -- varchar2(12) -> varchar2(10), 가장긴 userid : 8byte

-- 다음문장은 에러
-- ORA-01441: cannot decrease column length because some value is too big
alter table member01
modify userid varchar2(6); -- varchar2(10) -> varchar2(6)

alter table member01
modify userid varchar2(26); -- varchar2(10) -> varchar2(26)

--3) drop column : 기존 칼럼 삭제
alter table member01
drop column birthday;

--4) rename Column으로 기존 컬럼 삭제
alter table members
rename column userid to memberid;

--(4)truncate table로 테이블의 데이터 삭제
truncate table member01;

--(5)rename to로  테이블 이름 변경하기
rename member01 to members;

--(6) drop table로 테이블 삭제하기
drop table emp01;
drop table members;
