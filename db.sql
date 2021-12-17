create table users
(
    id                bigint       not null
        constraint users_pk
            primary key,
    email             varchar(255) not null,
    address           varchar(255) not null,
    registration_date timestamp    not null,
    name              varchar(255)
);

create unique index users_email_uindex
    on users (email);

create table product
(
    id       bigint           not null
        constraint product_pk
            primary key,
    name     varchar(255)     not null,
    price    double precision not null,
    category varchar(255)     not null
);

create table orders
(
    id             bigint       not null
        constraint order_pk
            primary key,
    creation_date  timestamp    not null,
    status         varchar(255) not null,
    payment_status varchar(255) not null,
    user_id        bigint       not null
        constraint order_user_id_fk
            references users
);

create table wallet
(
    id      bigint                       not null
        constraint wallet_pk
            primary key,
    user_id bigint                       not null
        constraint wallet_users_id_fk
            references users,
    funds   double precision default 0.0 not null
);

create table discount
(
    id          bigint not null
        primary key,
    name        varchar(255),
    valid_from  timestamp,
    valid_until timestamp
);

create table percentage_discount
(
    percentage double precision,
    id     bigint not null
        primary key references discount(id)
);

create table amount_discount
(
    amount integer,
    id     bigint not null
        primary key references discount(id)
);

create table order_product
(
    order_id       bigint           not null
        constraint order_product_order_id_fk
            references orders,
    product_id     bigint           not null
        constraint order_product_product_id_fk
            references product,
    purchase_price double precision not null,
    constraint order_product_pk
        primary key (order_id, product_id)
);

