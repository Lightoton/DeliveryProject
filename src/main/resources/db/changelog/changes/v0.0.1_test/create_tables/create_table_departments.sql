create table if not exists departments
(
    d_id               BINARY(16) primary key,
    address            varchar(80),
    created_at         timestamp,
    updated_at         timestamp,
    manager_id         BINARY(16),
    support_manager_id BINARY(16),
    courier_id         BINARY(16),
    client_id          BINARY(16),
    order_id           BINARY(16),
    restaurant_id      BINARY(16),
    foreign key (manager_id) references managers (m_id),
    foreign key (support_manager_id) references support_managers (sm_id),
    foreign key (courier_id) references couriers (c_id),
    foreign key (client_id) references clients (u_id),
    foreign key (order_id) references orders (o_id),
    foreign key (restaurant_id) references restaurants (r_id)
);