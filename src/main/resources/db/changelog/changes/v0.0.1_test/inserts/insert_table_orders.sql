INSERT INTO orders (o_id, status_order, final_amount, created_at, restaurant_id, client_id, sm_id,
                    courier_id)
VALUES (UUID_TO_BIN(UUID()), 'AWAITING_PAYMENT', 25.99, NOW(),
        (SELECT r_id FROM restaurants WHERE title = 'Green Leaf Cafe'),
        (SELECT u_id FROM clients
                     WHERE user_info_id = (select info_id from user_info WHERE username = 'Alice')), (SELECT sm_id
                                                               FROM support_managers
                                                               WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'sarah')),
        (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'michael'))),
       (UUID_TO_BIN(UUID()), 'IN_PROGRESS', 30.49, NOW(),
        (SELECT r_id FROM restaurants WHERE title = 'Chef''s Corner'),
        (SELECT u_id FROM clients WHERE user_info_id = (select info_id from user_info WHERE username = 'Bob')), (SELECT sm_id
                                                             FROM support_managers
                                                             WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'tom')),
        (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'emma'))),
       (UUID_TO_BIN(UUID()), 'COMPLETED', 20.99, NOW(),
        (SELECT r_id FROM restaurants WHERE title = 'Seafood Haven'),
        (SELECT u_id FROM clients WHERE user_info_id = (select info_id from user_info WHERE username = 'Charlie')), (SELECT sm_id
                                                                 FROM support_managers
                                                                 WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'rachel')),
        (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'jason')));