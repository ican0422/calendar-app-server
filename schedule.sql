-- 관리자 테이블 생성
create table Manager
(
    Id int AUTO_INCREMENT primary key,
    Name varchar(255) not null,
    Email varchar(255) not null unique,
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