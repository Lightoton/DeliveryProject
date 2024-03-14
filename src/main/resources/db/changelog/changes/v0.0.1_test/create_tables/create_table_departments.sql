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
# INSERT INTO departments (d_id, address, created_at, updated_at, manager_id, support_manager_id, courier_id, client_id,
#                          order_id, restaurant_id)
# VALUES (UUID_TO_BIN(UUID()), '123 Main Street', NOW(), NOW(),
#         (SELECT m_id FROM managers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'mark')),
#         (SELECT sm_id
#          FROM support_managers
#          WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'sarah')),
#         (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'michael')),
#         (SELECT u_id FROM clients WHERE firstname = 'Alice'),
#         (SELECT o_id FROM orders WHERE client_id = (SELECT u_id FROM clients WHERE firstname = 'Alice')),
#         (SELECT r_id FROM restaurants WHERE title = 'Green Leaf Cafe')),
#        (UUID_TO_BIN(UUID()), '456 Elm Street', NOW(), NOW(),
#         (SELECT m_id FROM managers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'anna')),
#         (SELECT sm_id
#          FROM support_managers
#          WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'tom')),
#         (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'emma')),
#         (SELECT u_id FROM clients WHERE firstname = 'Bob'),
#         (SELECT o_id FROM orders WHERE client_id = (SELECT u_id FROM clients WHERE firstname = 'Bob')),
#         (SELECT r_id FROM restaurants WHERE title = 'Chef''s Corner')),
#        (UUID_TO_BIN(UUID()), '789 Oak Street', NOW(), NOW(),
#         (SELECT m_id FROM managers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'chris')),
#         (SELECT sm_id
#          FROM support_managers
#          WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'rachel')),
#         (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'jason')),
#         (SELECT u_id FROM clients WHERE firstname = 'Charlie'),
#         (SELECT o_id FROM orders WHERE client_id = (SELECT u_id FROM clients WHERE firstname = 'Charlie')),
#         (SELECT r_id FROM restaurants WHERE title = 'Seafood Haven'));
