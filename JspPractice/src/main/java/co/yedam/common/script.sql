conn / as sysdba;

drop user jsp cascade;

create user jsp identified by jsp;

grant sysdba, connect, resource to jsp;

connect jsp/jsp;



create table users (
    user_num            number(20),
    user_id             varchar2(20) primary key,
    user_pw             varchar2(30) not null,
    user_name           varchar2(20) not null,
    user_dob            date,
    user_signup_date    date default sysdate,
    user_tel            varchar2(20),
    user_email          varchar2(30) not null,
    user_address        varchar2(100),
    user_authority      varchar2(10) default 'user'
);
    
create sequence user_num_seq;

insert all
    into users values(0, 'admin', 'admin', 'admin', to_date('20220301', 'YYYYMMDD'), sysdate, '010-1111-1111', 'admin@admin', 'admin address', 'admin')
    into users values(user_num_seq.nextVal, 'asdf', 'asdf', 'asdf', to_date('20220302', 'YYYYMMDD'), sysdate, '010-1234-1234', 'asdf@asdf', 'asdf address', 'user')
    into users values(user_num_seq.nextVal, 'user1','user1','user1',to_date('20220303','YYYYMMDD'), sysdate,'010-1111-2222','user1@user1','user1 address', 'user')
select * from dual;




create table orders (
    order_num           varchar2(30) primary key,
    user_id             varchar2(20) not null,
    product_serial      number(20) not null,
    product_quantity    number(20),
    order_date          date not null,
    constraint fk_orders_user_id foreign key(user_id) references users(user_id)
);

create sequence order_num_seq;

insert all
    into orders values('1.1.11111111','asdf',1,10,sysdate)
    into orders values('1.2.22222222','asdf',2,20,sysdate)
    into orders values('2.1.33333333','user1',1,20,sysdate)
    into orders values('2.2.44444444','user1',2,30,sysdate)
select * from dual;



create table shipping_address (
    user_id            varchar2(20),
	shipping_address   varchar2(100) not null,
    recipient_name     varchar2(100),
    phone_number       varchar2(20) not null,
    shipping_comment   varchar2(100) default '-',
   constraint fk_shipping_address_user_id foreign key(user_id) references users(user_id)
);

insert all
    into shipping_address values('asdf','asdf address1','asdf recipient1','asdf phone1','-')
    into shipping_address values('asdf','asdf address2','asdf recipient2','asdf phone2','asdf comment2')
    into shipping_address values('user1','user1 address1','user1 recipient1','user1 phone1','user1 comment1')
    into shipping_address values('user1','user1 address2','user1 recipient2','user1 phone2','-')
select * from dual;




create table products(
    product_serial      number(20) primary key,
    product_name        varchar2(20),
    product_category1   varchar2(20),
    product_category2   varchar2(20),
    product_thumbnail   varchar2(200),
    product_info        varchar2(200),
    product_stock       number(20),
    product_price       number(20)
);

create sequence product_serial_seq;

insert into products values(product_serial_seq.nextVal,'product1','shirts','t_shirt','images/product/1.jpg','images/product/1_detail.jpg',10,1000);
insert into products values(product_serial_seq.nextVal,'product2','shirts','y_shirt','images/product/2.jpg','images/product/2_detail.jpg',50,400);
insert into products values(product_serial_seq.nextVal,'product3','outers','jumper','images/product/3.jpg','images/product/3_detail.jpg',100,3000);
insert into products values(product_serial_seq.nextVal,'product4','outers','fleece','images/product/4.jpg','images/product/4_detail.jpg',50,100000);
insert into products values(product_serial_seq.nextVal,'product5','pants','sweats','images/product/5.jpg','images/product/5_detail.jpg',30,5000);
insert into products values(product_serial_seq.nextVal,'product4','pants','jeans','images/product/6.jpg','images/product/6_detail.jpg',5,100);




create table cart (
    user_id             varchar2(20),
    product_serial      number(20),
    product_quantity    number(20),
    product_price       number(20),
    cart_date           date,
    constraint fk_cart_user_id foreign key(user_id) references users(user_id),
    constraint fk_cart_product_serial foreign key(product_serial) references products(product_serial)
);

create table qna (
    user_id             varchar2(20),
    qna_type            varchar2(20),
    order_num           varchar2(100),
    qna_date            date default sysdate,
    qna_title           varchar2(50),
    qna_content         varchar2(500),
    qna_photo           varchar2(200),
    qna_status          varchar2(20),
    response_date       date,
    constraint fk_qna_user_id foreign key(user_id) references users(user_id),
    constraint fk_qna_order_num foreign key(order_num) references orders(order_num)
);


insert into qna values('asdf','취소','1.1.11111111',sysdate,'asdf qna1 title','asdf qna1 content','asdf qna photo1','답변대기',null);
insert into qna values('asdf','환불','1.2.22222222',sysdate,'asdf qna2 title','asdf qna2 content','asdf qna photo1','답변대기',null);
insert into qna values('asdf','취소','2.1.33333333',sysdate,'asdf qna1 title','user1 qna1 content','user1 qna1 photo','답변완료',to_date('20220305','YYYYMMDD'));
insert into qna values('asdf','기타','2.2.44444444',sysdate,'asdf qna2 title','user1 qna2 content','user1 qna2 photo','답변대기',null);




create table shipping (
     order_num          varchar2(100) primary key,
     shipping_address   varchar2(100),
     recipient_name     varchar2(100),
     phone_number       varchar2(20),
     shipping_comment            varchar2(100),
     constraint fk_shipping_order_num foreign key(order_num) references orders(order_num)
);

insert all
    into shipping values('1.1.11111111','asdf address1','asdf recipient1','asdf phone1','-')
    into shipping values('1.2.22222222','asdf address2','asdf recipient2','asdf phone2','asdf comment2')
    into shipping values('2.1.33333333','user1 address1','user1 recipient1','user1 phone1','user1 comment1')
    into shipping values('2.2.44444444','user1 address2','user1 recipient2','user1 phone1','-')
select * from dual;
