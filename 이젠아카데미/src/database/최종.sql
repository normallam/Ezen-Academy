drop database if exists ezenacademy;
create database ezenacademy;
use ezenacademy;

drop table if exists employee;
create table employee(  #직원
   eno int auto_increment , #직원넘버
   era varchar(10) not null, #직급
    ename varchar(10) not null, #직원이름
    epay int not null, # 직원월급
    primary key(eno)
);
select format (epay,0) from employee; 


drop table if exists lesson;
create table lesson(
   lno int auto_increment not null, #수업코드
    lname varchar(20) not null unique,  #수업명
    ltotalday int not null,  #총수강일
    lopenday date not null,  # 개강일
    eno int, # 직원코드
    primary key(lno),
    foreign key (eno) references employee(eno)
);


drop table if exists student;
create table student(
   sno int auto_increment not null,
    sname varchar(10) not null,
   saddress varchar(10) not null,
    sphone varchar(13) not null unique,
   lno int, 
    primary key(sno),
    foreign key( lno ) references lesson (lno)
);

drop table if exists board;
create table board(
   bno int auto_increment,
    sno int,
    btitle longtext not null,
    bcontent longtext not null,
    bday datetime default now(),
    bview int default 0,
    primary key(bno),
    foreign key( sno) references student (sno) on delete cascade  
);

drop table if exists attendance;
create table attendance( 
   ano int auto_increment, 
    sno int,
    aday datetime default now(),
    primary key(ano),
    foreign key( sno) references student (sno) on delete cascade  
);


drop table if exists signup;
create table signup( # 강사회원가입
   jno int auto_increment, #회원가입 시 등록되는 강사 no
    jid varchar(20) unique, #회원가입 시 강사 아이디
    jpw varchar(20) ,   #회원가입 시 강사 비밀번호
    eno int default 0,    #강사번호              # 추후 자바에서 유효성 검사.
    primary key(jno),
    foreign key( eno) references employee (eno)
);

drop table if exists message;
create table message( 
   mno int auto_increment,      #보낸메세지넘버
    eno int null,   #메세지보내는 사람(직원만가능)
    mcontent text not null, #보낼내용
    sno int not null,  # 메세지 받을 사람
    mday datetime default now(),
   primary key (mno),
    foreign key(sno) references student(sno),
    foreign key(eno) references employee(eno)
);

/* drop table if exists T_incentives;
create table T_incentives (
	tno int auto_increment,
	sno int,
    tday datetime default now() ,
    tepisode int not null,
    
    primary key (tno),
    foreign key (sno ) references student (sno)
);
*/

#기준 추가 08/19
#후기게시판
drop table if exists reviewboard;
create table reviewboard(
   rno int auto_increment,      # 후기게시판번호
   sno int, # 작성코드fk
   rtitle longtext not null, #제목
    rcontent longtext not null, # 내용
   lno int, #수업코드  
   rgrade int not null, # 평점
   primary key(rno),
   foreign key(sno) references student (sno) on delete cascade,
   foreign key(lno) references lesson (lno) on delete cascade
);
select format (rgrade,1) from reviewboard; 



#기준 내용추가(08/18 수정)
insert into  employee(era,ename,epay) values ('원장','고연진',5690000);
insert into  employee(era,ename,epay) values ('강사','이진형',4454500);
insert into  employee(era,ename,epay) values ('강사','황기준',4162400);
insert into  employee(era,ename,epay) values ('행정','이성호',3159100);
insert into  employee(era,ename,epay) values ('강사','정희락',4545600);
insert into  employee(era,ename,epay) values ('강사','고명섭',3532200);
/*
#기준 내용추가(08/19)
insert into reviewboard (sno,rtitle,rcontent,lno,rgrade) values(1,'이런 반도 없음','선생님이 우리를 waiting',1,4.5);
insert into reviewboard (sno,rtitle,rcontent,lno,rgrade) values(2,'왜 수업 안끝내줌','학교종이 쌩쌩쌩',3,4.1);
insert into reviewboard (sno,rtitle,rcontent,lno,rgrade) values(3,'우리 강사님 최고임','어서모이자',2,3.4);
insert into reviewboard (sno,rtitle,rcontent,lno,rgrade) values(4,'있잖아','어그로끌었다',1,3.1);
*/

#기준추가(08/19)
select*from reviewboard;




insert into lesson(lname, ltotalday,lopenday,eno ) values ('자바', 120,'2023-07-14',2);
insert into lesson(lname, ltotalday,lopenday,eno ) values ('파이썬', 100, '2023-08-14',3);
insert into lesson(lname, ltotalday,lopenday,eno ) values ('빅데이터', 200, '2023-09-14',5);
insert into lesson(lname, ltotalday,lopenday,eno ) values ('AI', 130, '2023-10-14',6);



insert into student(sname,saddress,sphone,lno)values ('김규리', '시흥', '010-1111-1111', 1);
insert into student(sname,saddress,sphone,lno)values ('황태웅', '안양', '010-2222-2222', 1);
insert into student(sname,saddress,sphone,lno)values ('김준희', '안산', '010-3333-3333', 2);
insert into student(sname,saddress,sphone,lno)values ('김근배', '부산', '010-4444-4444', 3);
insert into student(sname,saddress,sphone,lno)values ('김찬희', '부산', '010-5555-5555', 2);

insert into board (sno,btitle,bcontent,bday) values(1,'고연진','고연진짱','2023-03-13 19:20');
insert into board (sno,btitle,bcontent,bday) values(1,'박상빈','고연진짱짱짱','2023-04-13 20:20');
insert into board (sno,btitle,bcontent,bday) values(2,'이진형','고연진짱짱','2023-03-13 21:20');
insert into board (sno,btitle,bcontent,bday) values(2,'황기준','고연진짱짱짱짱','2023-05-13 19:40');


insert into attendance(sno,aday )values ('1','2023-11-23 20:20:20');
insert into attendance(sno,aday )values ('2','2023-12-23 19:19:19');
insert into attendance(sno,aday )values ('2','2023-11-25 12:12:12');


insert into signup(jid,jpw,eno) values ('아이디1','1234',1);
insert into signup(jid,jpw,eno) values ('아이디2','1234',2);
insert into signup(jid,jpw,eno) values ('아이디3','1234',4);



insert into Message (eno,mcontent,sno) values (1,"원장이1번학생한테보냄",1);
insert into Message (eno,mcontent,sno) values (2,"강사가2번학생한테보냄",2);
insert into Message (eno,mcontent,sno) values (2,"강사가1번학생한테보냄",1);
insert into Message (eno,mcontent,sno) values (1,"원장이 2번학생한테보냄",2);

select*from lesson;
select*from student;
select*from board;
select*from attendance;
select*from signup;
select*from Message;
select*from employee;

