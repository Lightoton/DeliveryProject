INSERT INTO departments (d_id, address, created_at, updated_at, manager_id, support_manager_id, courier_id, client_id,
                         order_id, restaurant_id)
VALUES (UUID_TO_BIN(UUID()), '123 Main Street', NOW(), NOW(),
        (SELECT m_id FROM managers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'mark')),
        (SELECT sm_id
         FROM support_managers
         WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'sarah')),
        (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'michael')),
        (SELECT u_id FROM clients WHERE user_info_id = (select info_id from user_info WHERE username = 'Alice')),
        (SELECT o_id FROM orders WHERE final_amount = 25.99),
        (SELECT r_id FROM restaurants WHERE title = 'Green Leaf Cafe')),
       (UUID_TO_BIN(UUID()), '456 Elm Street', NOW(), NOW(),
        (SELECT m_id FROM managers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'anna')),
        (SELECT sm_id
         FROM support_managers
         WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'tom')),
        (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'emma')),
        (SELECT u_id FROM clients WHERE user_info_id = (select info_id from user_info WHERE username = 'Bob')),
        (SELECT o_id FROM orders WHERE final_amount = 30.49),
        (SELECT r_id FROM restaurants WHERE title = 'Chef''s Corner')),
       (UUID_TO_BIN(UUID()), '789 Oak Street', NOW(), NOW(),
        (SELECT m_id FROM managers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'chris')),
        (SELECT sm_id
         FROM support_managers
         WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'rachel')),
        (SELECT c_id FROM couriers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'jason')),
        (SELECT u_id FROM clients WHERE user_info_id = (select info_id from user_info WHERE username = 'Charlie')),
        (SELECT o_id FROM orders WHERE final_amount = 20.99),
        (SELECT r_id FROM restaurants WHERE title = 'Seafood Haven'));
