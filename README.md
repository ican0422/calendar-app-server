## 나만의 일정 관리 앱 서버 만들기

### 일정 API 명세서

![일정 API 명세서](https://github.com/user-attachments/assets/3851bd6b-7c9e-4aa0-a845-9e1f38787b3b)

### 담당자 API 명세서

![담당자 API 명세서](https://github.com/user-attachments/assets/1d3af228-7080-4b1f-a3eb-d0f7ea415fec)

### ([ERD 다이어그램](https://viewer.diagrams.net/?tags=%7B%7D&lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1&title=%EC%9D%BC%EC%A0%95%20%EB%93%B1%EB%A1%9D%20ERD.drawio#R%3Cmxfile%3E%3Cdiagram%20id%3D%22R2lEEEUBdFMjLlhIrx00%22%20name%3D%22Page-1%22%3E7Zxtc6I6GIZ%2FjTN7PrSjIGo%2FrlZ3d47ueOy%2BfE4hYmYxcUJ8219%2FnkAQMWih1WqBGaclDzGQ575z8ZKMNbM333zhaDEbMQd7NaPubGrmY80wOo0H%2BCsD2zDQlCUZcDlxwlA9DjyRvzgMNqLokjjYV7EwJBjzBFkkgzajFNsiEUOcs3Wy2pR5TiKwQC7WAk828vTob%2BKImeqWVY%2FjXzFxZ9GRG3W1Z46iyirgz5DD1okQ3ogBo0Kd4hjzOaKYCtgzQvwP5jWrPxNC9vRzzRjAZypr37uMuR5GC%2BLf22wOYduHKoMpmhNPpnmvoa5qCA5n9mtmjzMmwq35poc9KVVShsGRvbs8cNluhi%2F07lbb4Z%2B6oF%2FX5i8xGrnj9vOdamWFvKXKr8qN2EYJxw7kXxXhUERsJ9hDgjDaj%2Fd0MXU%2BS3WhUn%2FyF3P2g40Qhc53fYG4iPcxqqoPCJye%2BdiIqqhyHcp619R5%2BmzJbXyiP0ZTWRJxF4sTFVtKcCfhNpW5L5jNseBbqLCOPbZz0mzfX1GQB0lZJV2KlJPcXYO7Y4wZCYylxqXZVO2oYdmOLBk1EXZdfWtf5oOGmgcNtQ4bClOjNQQbex2PQ4GLcjjK0Bz1ZM%2BwswSXHDoLBuBCbgr0HHgosIEijil9AAwRiFAYLqFPbOZ5aOGToHoYmRHPGaItW4qooajUnZINdiYhcGRdcOAQGvOVyeTQjXwtdyOPuBS2bTCdPGKXYx%2FOZYh8oWocteUKc4E3J30UqWMl1XlQxT2bGVaKzXb4TXNUQsK8epkvEyDSCXouCPImgHVE3UCypCIyrQ5nix%2FR6JOBhXQa5v0VDsEa5B7Geo95TApLQyIE1YLOWV34QHd79XurZsEJ9KDciMvwkdW56DHqC45IoAYGndZYatUVbKGO4%2BFpdBpcJVNuPzMhgNPHVD3p65elVtKaGaU1L6VsU1N2%2FG8ebRn0deoF2J4Rx8E0HJHyqo5ivVOkTM3%2FLueHYhyOw4x6mJn12BPAzJl%2F1VicldytIQ%2B8T5HAXbakjn8J4lqazt8cKH%2BCcfHPDeodcTas2%2FUXyCbUHYbfbB0YwrqEITa1owPUOKtBMjX3Dg5plZnx6TeU52F869qMb2vKDm6R8Rnz38qc%2F6IzvaPpCk9T8GgLD471j033s1uhdDR%2FqGh%2BGZpnfRi7GM2jh7xXSntbMH%2FInP6iw7yhv2WDgSDCF4ufVojbM8SLDPPsVigyzAlijP5H513ne6f16D01bPrzrl3RPN0bWQF%2FlOYN4x1xnqpt5wPh%2FIX8n%2FBuoXmerqvO8zHy%2FTXjTjGAfk4zlI7oHUNzR0X08xDdujrR3zZbcvNE7xwRoPBE1%2BdKJtglcizIiW7Y8wjHl3CX%2F0tG9mOmKB%2FZ9ZmWiuznIXvn6mR%2F2xzJ7ZPdKinZ9RmSCV4Rv6L6EUMUmerpZNLv6XZzLUcMUaIFS41ovWjOd%2BQ7op%2F9Jbmh36uV6CqcZ8VS9hURt7JkydDvsIq0Zmln3WpOxNDvtz72vPYrVy3lsET5rsz6vVuJSJ9npjs36a%2B%2BcMnQV7jc4KjPmv925vwXnuv6fOZ3NA8esj7%2BvMg5jVBkmqc%2BcDarVaivf3tmnqT5ey5cStdWv1L%2FvMX79kwKnHBvoXme3m%2F9Ot2fI%2BIVA%2BjndELpgG4ZFdAvBPTrr12yCj7THZq3fDy3qpnu%2FKYoH9rf9nReof2WFzFZb1tyfPto75QT7dE7vWqqO6MhCoR1KMa%2FJBNWj3%2F9x%2Bz%2FDw%3D%3D%3C%2Fdiagram%3E%3C%2Fmxfile%3E))
![ERD 다이어그램](https://github.com/user-attachments/assets/f515dc53-5dab-4ba7-8d59-c59d150d6137)

---
### SQL
```mysql
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
    Manager_Id int not null,
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
```
