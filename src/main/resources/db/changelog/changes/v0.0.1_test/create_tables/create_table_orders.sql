create table if not exists orders
(
    o_id          BINARY(16) primary key,
    status_order  varchar(60) not null default 'AWAITING_PAYMENT',
    final_amount  decimal      not null,
    created_at    timestamp   default NOW(),
    updated_at    timestamp ON UPDATE NOW(),
    restaurant_id BINARY(16)  not null,
    client_id     BINARY(16)  ,
    sm_id         BINARY(16)  ,
    department_id BINARY(16)  not null,
    foreign key (restaurant_id) references restaurants (r_id)
        ON DELETE CASCADE,
    foreign key (client_id) references clients (u_id)
        ON DELETE SET NULL,
    foreign key (sm_id) references support_managers (sm_id)
        ON DELETE SET NULL,
    foreign key (department_id) references departments (d_id)
        ON DELETE CASCADE
);