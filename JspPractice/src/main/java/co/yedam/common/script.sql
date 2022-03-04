create user jsp identified by jsp;

grant sysdba, connect, resource to jsp;

connect jsp/jsp;

create table users (
    user_num            varchar2(20) primary key,
    user_id             varchar2(20) not null,
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

create table orders (
    order_num   varchar2(100) primary key,
    user_num    varchar2(20) not null,
    product_num varchar2(20) not null,
    order_date  date not null,
    constraint fk_orders_user_num foreign key(user_num) references users(user_num)
);

create sequence order_num_seq;

create table shipping_address (
	user_num            varchar2(20) primary key,
    is_defalut          number(1) default 0,
    phone_number        number(20) not null,
    shipping_address    varchar2(100) not null,
	constraint fk_shipping_address_user_num foreign key(user_num) references users(user_num)
);

create table products(
    product_num         varchar2(20),
    product_thumbnail   varchar2(200),
    product_info        varchar2(200),
    product_category1   varchar2(20),
    product_category2   varchar2(20),
    product_stock       number(20),
    product_price       number(20),
    constraint pk_products  primary key(product_num, product_category1, product_category2)
);

create sequence product_num_seq;

create table cart (
    user_num            varchar2(20),
    product_thumbnail   varchar2(200),
    product_category1   varchar2(20),
    product_category2   varchar2(20),
    product_quantity    number(20),
    product_price       number(20),
    cart_date           date,
    constraint fk_cart_user_num foreign key(user_num) references users(user_num)
);

create table qna (
    user_num    varchar2(20),
    qna_type    varchar2(20),
    order_num   varchar2(100),
    qna_title   varchar2(50),
    qna_content varchar2(200),
    qna_photo   varchar2(200),
    constraint fk_qna_user_num foreign key(user_num) references users(user_num),
    constraint fk_qna_order_num foreign key(order_num) references orders(order_num)
);