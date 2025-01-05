create table friends
    (friendNo number(4),
    friendName varchar2(15) not null,
    mobile varchar2(13),
    addr varchar2(50),
    CONSTRAINT fno_PK PRIMARY KEY(friendNo),
    CONSTRAINT mob_uq unique(mobile)
    );
    
    select * from friends;
    drop table friends;
    
insert into friends values(1,'둘리','010-111-2222','서울특별시 구로구');
insert into friends values((select max(friendNo)from friends)+1,'홍길동','010-222-2222','서울특별시 구로구');
--다음에 저장할 친구의 friendNo(pk)?
commit;
--전화번호 중복체크
select count(*) as cnt from friends where mobile ='010-111-2222';

--친구 이름으로 검색
select * from friends where friendname ="홍길동";
TRUNCATE table friends;--롤백안됨

select * from departments;
update departments set department_name = 'df' where department_id =310;