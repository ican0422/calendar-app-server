-- 관리자 테이블 생성
create table Manager
(
    Id int AUTO_INCREMENT primary key,
    Name varchar(255) not null,
    Email varchar(255) unique,
    Registration_Date datetime default current_timestamp,
    Revision_Date datetime default  current_timestamp on update current_timestamp
);
-----------------------------------------------------------------------------------------------------
-- 게시물 테이블 생성
create table Schedule
(
    Id int AUTO_INCREMENT primary key,
    Manager_Id int,
    Content text not null,
    Password varchar(255) not null,
    Registration_Date datetime default current_timestamp,
    Revision_Date datetime default  current_timestamp on update current_timestamp,
    foreign key (Manager_Id) references Manager(Id) on delete cascade
);
-----------------------------------------------------------------------------------------------------
-- 모든 데이터는 삭제 하되, 테이블은 남기는 방법
TRUNCATE TABLE schedule;

-- 컬럼 이름 변경 및 타입 변경
ALTER TABLE schedule CHANGE Name Manager_Id int(255);

-- 게시물 등록
INSERT INTO schedule (Name, Content, Password) VALUES(?, ?, ?);

-- 게시물 단건 조회
SELECT * FROM Schedule WHERE id = ?;

-- 게시물 전체 조회
SELECT * FROM schedule
WHERE 1=1
AND Revision_Date = ?
AND Name = ?
ORDER BY Revision_Date DESC;

-- 게시물 수정
UPDATE schedule SET Name = ?, Content = ? WHERE Id = ?

-- 게시물 삭제
DELETE FROM schedule WHERE id = ?

-- 아이디 찾기
SELECT Id FROM schedule WHERE Id = ?

-- 비밀번호 찾기
SELECT Password FROM schedule WHERE Id = ?