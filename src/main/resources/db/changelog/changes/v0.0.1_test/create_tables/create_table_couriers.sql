create table if not exists couriers
(
    c_id             BINARY(16) primary key,
    rating           varchar(10) not null,
    status_courier   varchar(60) not null default 'FREE',
    salary           double      not null,
    status_employee  varchar(60) not null default 'WORK',
    hire_date        timestamp   not null,
    termination_date timestamp,
    user_info_id     BINARY(16)  not null,
    order_id         BINARY(16),
    foreign key (user_info_id) references user_info (info_id),
    foreign key (order_id) references orders (o_id)
);
