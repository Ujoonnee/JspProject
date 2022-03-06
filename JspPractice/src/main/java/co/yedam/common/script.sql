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

create table orders (
    order_num           varchar2(30) primary key,
    user_id             varchar2(20) not null,
    product_serial      number(20) not null,
    product_quantity    number(20),
    order_date          date not null,
    constraint fk_orders_user_id foreign key(user_id) references users(user_id)
);

create sequence order_num_seq;

create table shipping_address (
    user_id             varchar2(20) primary key,
    is_defalut          number(1) default 0,
    phone_number        varchar2(20) not null,
    shipping_address    varchar2(100) not null,
   constraint fk_shipping_address_user_id foreign key(user_id) references users(user_id)
);

create table products(
    product_serial      number(20) primary key,
    product_name        varchar2(20),
    product_category1   varchar2(20),
    product_category2   varchar2(20),
    product_thumbnail   varchar2(200),
    product_info        varchar2(200),
    product_option1     varchar2(20),
    option1_detail      varchar2(200),
    product_option2     varchar2(20),
    option2_detail      varchar2(200),
    product_stock       number(20),
    product_price       number(20)
);

create sequence product_serial_seq;

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
    constraint fk_qna_user_num foreign key(user_id) references users(user_id),
    constraint fk_qna_order_num foreign key(order_num) references orders(order_num)
);

create table shipping (
     order_num          varchar2(100) primary key,
     shipping_address   varchar2(100),
     recipient_name     varchar2(100),
     phone_number       varchar2(20),
     shipping_comment            varchar2(100),
     constraint fk_shipping_order_num foreign key(order_num) references orders(order_num)
);