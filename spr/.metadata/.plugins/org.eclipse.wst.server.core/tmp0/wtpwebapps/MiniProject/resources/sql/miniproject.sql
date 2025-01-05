
CREATE TABLE `sky`.`member` (
  `userId` VARCHAR(8) NOT NULL,
  `userPwd` VARCHAR(200) NOT NULL,
  `userName` VARCHAR(12) NULL,
  `mobile` VARCHAR(13) NULL,
  `email` VARCHAR(50) NULL,
  `registerDate` DATETIME NULL DEFAULT now(),
  `userImg` VARCHAR(50) NOT NULL DEFAULT 'avatar.png',
  `userPoint` INT NULL DEFAULT 100,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `mobile_UNIQUE` (`mobile` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
  
  CREATE TABLE `lyh`.`hboard` (
  `boardNo` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(20) NOT NULL,
  `content` VARCHAR(2000) NULL,
  `writer` VARCHAR(8) NULL,
  `postDate` DATETIME NULL DEFAULT now(),
  `readCount` INT NULL DEFAULT 0,
  `ref` INT NULL DEFAULT 0,
  `step` INT NULL DEFAULT 0,
  `refOrder` INT NULL DEFAULT 0,
  PRIMARY KEY (`boardNo`),
  INDEX `hboard_member_fk_idx` (`writer` ASC) VISIBLE,
  CONSTRAINT `hboard_member_fk`
    FOREIGN KEY (`writer`)
    REFERENCES `lyh`.`member` (`userId`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
COMMENT = '계층형게시판';

-- 회원가입
insert into member(userId,userPwd,userName,mobile,email)
values('tosimi',sha1(md5('1234')),'토심이','010-2222-2222','tosimi@abc.com');

insert into member(userId,userPwd,userName,mobile,email)
values('tomoong',sha1(md5('1234')),'토뭉이','010-3333-2222','tomoong@abc.com');

select * from mempointdefber;

-- 게시판에 게시글 등록
insert into hboard (title, content, writer)
values ('아싸~~','내용 무','tosimi');

insert into hboard (title, content, writer)
values ('야호~~','내용','tomoong');

select * from hboard;
select * from member;

insert into hboard(title, content, writer) values ('', '', '');

select * from pointdef;
select * from pointlog;
-- pointlog테이블
CREATE TABLE `lyh`.`pointlog` (
  `pointLogNo` INT NOT NULL AUTO_INCREMENT,
  `pointWho` VARCHAR(8) NOT NULL,
  `pointWhen` DATETIME NULL DEFAULT now(),
  `pointWhy` VARCHAR(20) NOT NULL,
  `pointScore` INT NOT NULL,
  PRIMARY KEY (`pointLogNo`),
  INDEX `pointlog_member_fk_idx` (`pointWho` ASC) VISIBLE,
  CONSTRAINT `pointlog_member_fk`
    FOREIGN KEY (`pointWho`)
    REFERENCES `lyh`.`member` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
COMMENT = '어떤 멤버에게 어떤 사유로 몇 포인트가 언제 지급되었는지 기록 테이블';

-- 글 작성시 멤버에게 포인트 로그를 저장하는 쿼리문
 
 insert into pointlog(pointWho, pointWhy, pointScore)
 values('tosimi','글작성',(select pointScore from pointdef where pointWhy='글작성'));

 -- 내가 잘못짠 쿼리
update member set userPoint = (m.userPoint+g.pointScore)
from member m, pointlog g where m.userId = g.pointWho;
-- 정답
update member set userpoint =userPoint+(select pointScore from pointlog where pointWho='tosimi')
where userId='tosimi';
 
CREATE TABLE `lyh`.`boardupfiles` (
  `boardUpFileNo` INT NOT NULL AUTO_INCREMENT,
  `newFileName` VARCHAR(100) NOT NULL,
  `originFileName` VARCHAR(100) NOT NULL,
  `thumbFileName` VARCHAR(100) NULL,
  `ext` VARCHAR(20) NULL,
  `size` INT NULL,
  `boardNo` INT NULL,
  `base64img` TEXT NULL,
  PRIMARY KEY (`boardUpFileNo`),
  INDEX `boardupfiles_boardNo_fk_idx` (`boardNo` ASC) VISIBLE,
  CONSTRAINT `boardupfiles_boardNo_fk`
 --   FOREIGN KEY (`boardNo`)boardUpFileNo
  --  REFERENCES `lyh`.`hboard` (`boardNo`)
   -- ON DELETE CASCADE
   -- ON UPDATE NO ACTION)
-- COMMENT = '게시판에 업로드되는 파일을 기록하는 테이블  ';


CREATE TABLE `boardreadlog` (
  `boardReadLogNo` int(11) NOT NULL AUTO_INCREMENT,
  `readWho` varchar(130) NOT NULL,
  `readWhen` datetime DEFAULT CURRENT_TIMESTAMP,
  `boardNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`boardReadLogNo`),
  KEY `boardreadlog_boardno_fk_idx` (`boardNo`),
  CONSTRAINT `boardreadlog_boardno_fk` FOREIGN KEY (`boardNo`) REFERENCES `hboard` (`boardNo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='조회수 처리를 위한 클라이언트 ip와 게시글을 읽은 시간, 게시글 번호를 저장하기 위한 테이블'



-- 멤버에게 지급된 point를 더해서 수정하는 쿼리문
update member set userPoint = userPoint + (select pointScore from pointdef where pointWhy = '글작성') where userId = 'tosimi';

-- 게시글에 첨푸한 파일 정보를 저장
select max(boardNo) from hboard;

-- 업로드된 첨부파일을 저장하는 쿼리문
-- insert into boardupfiles (newFileName, originFileName, thumbFileName, ext, size, boardNo, base64Img)
-- values(#{newFileName}, #{originFileName}, #{thumbFileName, #{ext}, #{size}, #{boardNo}, #{base64Img});

-- 게시글 번호로 조회
select * from hboard where boardNo = 21;

-- 업로드 파일 조회
select * from boardupfiles where boardNo = 18;

select h.* , b.*, m.userName, m.email
from hboard h inner join member m
on h.writer = m.userId
inner join boardupfiles b
on h.boardNo = b.boardNo
where h.boardNo = 21;

select h.boardNo, h.title, h.content, h.writer, h.postDate, h.readCount,
h.ref, h.step, h.refOrder, f.*, m.userName, m.email
from hboard h left outer join boardupfiles f
on h.boardNo = f.boardNo
inner join member m
on h.writer = m.userId
where h.boardNo = 21;

insert into boardreadlog(readWho,boardNo) values('127.0.0.1',21);
select * from boardreadlog;
commit;

-- ipAddr의 유저가 boardNo글을 언제 조회했는지 날짜 차이 계산
select datediff(now(),(select readWhen from boardreadlog where readWho = '127.0.0.1' and boardNo = 21));

-- 한번도 2번글을 '127.0.0.1'가 조회한 적이 없음. (최초조회)
select datediff(now(),(select readWhen from boardreadlog where readWho = '127.0.0.1' and boardNo = 2));

-- 1) ipAddr의 유저가 21번 글을 언제 조회했는지
select readwhen from boardreadlog where readWho = '127.0.0.1' and boardNo = 21;

-- 2) 1)번에서 나온 결과가 null이면 insert
insert into boardreadlog(readwho, boardNo) values(?, ?);

-- 1)번에서 나온 결과가 null이 아니면... 현재시간과 이전에 읽은 날짜 시간의 차이를 구해야 한다.
select readWhen from boardreadlog where readWho = ? and boardNo = ?;
-- <!-- ipAddr의 유저가 boardNo글을 언제 조회했는지 날짜차이(단, 조회한 적이 없다면 -1 반환) -->
select ifnull(datediff(now(),
(select readWhen from boardreadlog where readWho = '127.0.0.1' and boardNo = 21)) , -1)
    as datediff;
   
select ifnull(datediff(now(),
(select readWhen from boardreadlog where readWho = '?' and boardNo = ?)) , -1)
    as datediff;
   
-- 조회수 증가 (update)
update hboard set readCount = readCount + 1 where boardNo = 21;

-- 24시간 지난 아이피 주소가 기존에 읽었던 글을 다시 읽을때 타임 업데이트
update boardreadlog set readWhen = now() where readWho = #{readWho} and boardNo = #{boardNo};
