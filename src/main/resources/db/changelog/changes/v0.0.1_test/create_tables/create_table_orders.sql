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
# INSERT INTO orders (o_id, status_order, final_amount, created_at, restaurant_id, client_id, support_manager,
#                     courier_id)
# VALUES (UUID_TO_BIN(UUID()), 'AWAITING_PAYMENT', 25.99, NOW(),
#         (SELECT r_id FROM restaurants WHERE title = 'Green Leaf Cafe'),
#         (SELECT u_id FROM clients WHERE firstname = 'Alice'), (SELECT sm_id
#                                                                FROM support_managers
#                                                                WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'sarah')),
#         (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'michael'))),
#        (UUID_TO_BIN(UUID()), 'IN_PROGRESS', 30.49, NOW(),
#         (SELECT r_id FROM restaurants WHERE title = 'Chef''s Corner'),
#         (SELECT u_id FROM clients WHERE firstname = 'Bob'), (SELECT sm_id
#                                                              FROM support_managers
#                                                              WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'tom')),
#         (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'emma'))),
#        (UUID_TO_BIN(UUID()), 'COMPLETED', 20.99, NOW(),
#         (SELECT r_id FROM restaurants WHERE title = 'Seafood Haven'),
#         (SELECT u_id FROM clients WHERE firstname = 'Charlie'), (SELECT sm_id
#                                                                  FROM support_managers
#                                                                  WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'rachel')),
#         (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'jason')));