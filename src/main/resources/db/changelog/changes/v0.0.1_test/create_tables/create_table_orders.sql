create table if not exists orders
(
    o_id            BINARY(16) primary key,
    status_order    varchar(60) not null default 'AWAITING_PAYMENT',
    final_amount    double      not null,
    created_at      timestamp   not null,
    updated_at      timestamp,
    restaurant_id   BINARY(16)  not null,
    client_id       BINARY(16)  not null,
    support_manager BINARY(16)  not null,
    courier_id      BINARY(16)  not null,
    foreign key (restaurant_id) references restaurants (r_id),
    foreign key (client_id) references clients (u_id),
    foreign key (support_manager) references support_managers (sm_id),
    foreign key (courier_id) references couriers (c_id)
);