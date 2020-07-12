create table tbl_member(
email varchar2(100),
pwd varchar2(1000) not null,
nickname varchar2(100) not null,
regd8 date default sysdate);

alter table tbl_member add constraint pk_member
primary key(email);

-----------------------product part------------------------
create table tbl_product(
pno number(10,0),
title varchar2(200) not null,
content varchar2(4000) not null,
writer varchar2(100) not null,
price number(8,0) default 0,
readcount number(11,0) default 0,
regd8 date default sysdate,
modd8 date default sysdate,
imgfile varchar2(1000) default 'NONE'
);

alter table tbl_product add constraint pk_product
primary key(pno);

create SEQUENCE  seq_product_pno
start with 1
increment by 1
nocycle nocache;

---------------------------comment ------------------------------
 CREATE TABLE tbl_comment(
     cno number(10,0),
     pno number(10,0) NOT NULL,
     content varchar2(1000) NOT NULL,
     writer varchar2(1000) NOT NULL,
     regd8 DATE DEFAULT sysdate,
     modd8 DATE DEFAULT sysdate);
    
    ALTER TABLE tbl_comment
    ADD constraint pk_comment PRIMARY key(cno);
    
   ALTER TABLE TBL_COMMENT 
   ADD CONSTRAINT fk_comment_product
   FOREIGN key(pno) REFERENCES tbl_product(pno);
   
  CREATE SEQUENCE seq_comment_cno
  START WITH 1
  INCREMENT BY 1
 nocycle nocache;
