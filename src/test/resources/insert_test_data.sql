-- DELETE FROM user_info WHERE info_id = X'c80d54d3500d453994798e8961477193';
INSERT INTO user_info (info_id, firstname, lastname, email, phone_number, username, password, updated_at)
VALUES (X'c80d54d3500d453994798e8961477193', 'Alice', 'Smith', 'alice@example.com', '111222333', 'alice', 'password789', CURRENT_TIMESTAMP),
        (CAST(UUID() as binary(16)), 'Bob', 'Johnson', 'bob@example.com', '444555666', 'bob', 'passwordabc',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'Charlie', 'Brown', 'charlie@example.com', '777888999', 'charlie', 'passwordxyz',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'Emily', 'Davis', 'emily@example.com', '101010101', 'emily', 'password1234',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'David', 'Wilson', 'david@example.com', '121212121', 'david', 'password5678',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'Mark', 'Miller', 'mark@example.com', '333444555', 'mark', 'password123',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'Anna', 'Anderson', 'anna@example.com', '666777888', 'anna', 'password456',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'Chris', 'Clark', 'chris@example.com', '999000111', 'chris', 'pass9',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'Sarah', 'Smith', 'sarah@example.com', '222333444', 'sarah', 'passwo23',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'Tom', 'Thompson', 'tom@example.com', '555666777', 'tom', 'password56',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'Rachel', 'Roberts', 'rachel@example.com', '888999000', 'rachel', 'password89',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'Michael', 'Martinez', 'michael@example.com', '112333', 'michael', 'passw3',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'Emma', 'Evans', 'emma@example.com', '444666', 'emma', 'passwor6',
        CURRENT_TIMESTAMP),
       (CAST(UUID() as binary(16)), 'Jason', 'Jackson', 'jason@example.com', '7778999', 'jason', 'passwo9',
        CURRENT_TIMESTAMP);



INSERT INTO managers (m_id, salary, hire_date, user_info_id)
VALUES (CAST('f9746e74-3712-498e-8603-ae6cdacc592d' as binary(16)), 4000.00, '2023-01-15 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'mark')),
       (UUID(), 4200.00, '2023-02-01 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'anna')),
       (UUID(), 4400.00, '2023-03-10 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'chris'));

INSERT INTO departments (d_id, address, created_at, updated_at, manager_id)
VALUES (CAST('b634ba10-3466-4764-9e40-fa1a808a0408'as binary(16)), '123 Main Street', NOW(), NOW(),
        (SELECT m_id FROM managers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'mark')));

INSERT INTO restaurants (r_id, title, address, registration_date, department_id)
VALUES (CAST('61954128-24ff-457b-8731-fd4a234ddc45'as binary(16)), 'Green Leaf Cafe', '123 Main Street, Cityville', NOW(),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), 'Chef''s Corner', '456 Elm Street, Townsville', NOW(),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), 'Seafood Haven', '789 Oak Street, Beachtown', NOW(),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), 'Pasta Palace', '101 Pine Street, Pastaville', NOW(),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), 'Pizza Pizzazz', '202 Cedar Street, Pizzatown', NOW(),
        (select d_id from departments where departments.address = '123 Main Street'));

INSERT INTO menu (menu_id, title, average_price, created_at, restaurant_id)
VALUES (CAST('8aca1844-a2a1-4f79-80fb-1ac77339e272'as binary(16)), 'Healthy Choices', 13.49, NOW(),
        (SELECT r_id FROM restaurants WHERE title = 'Green Leaf Cafe')),
       (UUID(), 'Chef Specials', 14.99, NOW(),
        (SELECT r_id FROM restaurants WHERE title = 'Chef''s Corner')),
       (UUID(), 'Ocean Delights', 16.49, NOW(),
        (SELECT r_id FROM restaurants WHERE title = 'Seafood Haven')),
       (UUID(), 'Italian Classics', 12.99, NOW(),
        (SELECT r_id FROM restaurants WHERE title = 'Pasta Palace')),
       (UUID(), 'Pizza Paradise', 14.99, NOW(),
        (SELECT r_id FROM restaurants WHERE title = 'Pizza Pizzazz'));

INSERT INTO foods_category (category_id, title, created_at, menu_id)
VALUES (CAST('59c04fb7-2182-413e-acda-7438fa448757'as binary(16)), 'Salads', NOW(), (select menu_id from menu where menu.title = 'Healthy Choices')),
       (UUID(), 'Main Dishes', NOW(), (select menu_id from menu where menu.title = 'Chef Specials')),
       (UUID(), 'Seafood', NOW(), (select menu_id from menu where menu.title = 'Ocean Delights')),
       (UUID(), 'Pasta', NOW(), (select menu_id from menu where menu.title = 'Italian Classics')),
       (UUID(), 'Pizza', NOW(), (select menu_id from menu where menu.title = 'Pizza Paradise'));

INSERT INTO foods (f_id, title, calorie, price, finishing_cooking_at, created_at, category_id)
VALUES (CAST('cb9bdf6e-3488-4437-92d2-37e34361e5fb'as binary(16)), 'Grilled Chicken Salad', 350, 12.99, '2024-03-12 12:00:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Salads')),
       (UUID(), 'Vegetable Stir Fry', 250, 9.99, '2024-03-12 12:30:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Main Dishes')),
       (UUID(), 'Salmon Fillet', 400, 15.99, '2024-03-12 13:00:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Seafood')),
       (UUID(), 'Spaghetti Carbonara', 600, 11.99, '2024-03-12 13:30:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Pasta')),
       (UUID(), 'Vegetarian Pizza', 500, 14.99, '2024-03-12 14:00:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Pizza')),
       (UUID(), 'Vegetarian Salad', 500, 14.99, '2024-03-12 14:00:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Salads'));

INSERT INTO authority (auth_id, authority, updated_at)
VALUES (CAST('71f6ee8a-980b-40d7-b0ab-8ff050a3ed62'as binary(16)), 'Admin Access', NOW()),
       (UUID(), 'Employee Access', NOW()),
       (UUID(), 'Manager Access', NOW()),
       (UUID(), 'User access', NOW());

INSERT INTO roles (role_id, role_name, updated_at)
VALUES (CAST('9a040bf8-1a92-4cc1-9ce6-e9c30de2d3ed'as binary(16)), 'Admin', NOW()),
       (UUID(), 'User', NOW()),
       (UUID(), 'Employee', NOW()),
       (UUID(), 'Manager', NOW());

INSERT INTO role_authority (role_id, authority_id)
values ((select role_id from roles where role_name = 'Admin'),
        (select auth_id from authority where authority = 'Admin Access')),
       ((select role_id from roles where role_name = 'User'),
        (select auth_id from authority where authority = 'User access')),
       ((select role_id from roles where role_name = 'Employee'),
        (select auth_id from authority where authority = 'Employee Access')),
       ((select role_id from roles where role_name = 'Manager'),
        (select auth_id from authority where authority = 'Manager Access'));

INSERT INTO user_roles (user_info_id, role_id)
VALUES ((SELECT info_id FROM user_info WHERE username = 'alice'), (SELECT role_id FROM roles WHERE role_name = 'User')),
       ((SELECT info_id FROM user_info WHERE username = 'bob'), (SELECT role_id FROM roles WHERE role_name = 'User')),
       ((SELECT info_id FROM user_info WHERE username = 'charlie'),
        (SELECT role_id FROM roles WHERE role_name = 'User')),
       ((SELECT info_id FROM user_info WHERE username = 'emily'), (SELECT role_id FROM roles WHERE role_name = 'User')),
       ((SELECT info_id FROM user_info WHERE username = 'david'), (SELECT role_id FROM roles WHERE role_name = 'User')),
       ((SELECT info_id FROM user_info WHERE username = 'michael'),
        (SELECT role_id FROM roles WHERE role_name = 'Employee')),
       ((SELECT info_id FROM user_info WHERE username = 'emma'),
        (SELECT role_id FROM roles WHERE role_name = 'Employee')),
       ((SELECT info_id FROM user_info WHERE username = 'jason'),
        (SELECT role_id FROM roles WHERE role_name = 'Employee')),
       ((SELECT info_id FROM user_info WHERE username = 'mark'), (SELECT role_id FROM roles WHERE role_name = 'Admin')),
       ((SELECT info_id FROM user_info WHERE username = 'anna'), (SELECT role_id FROM roles WHERE role_name = 'Admin')),
       ((SELECT info_id FROM user_info WHERE username = 'chris'),
        (SELECT role_id FROM roles WHERE role_name = 'Admin')),
       ((SELECT info_id FROM user_info WHERE username = 'sarah'),
        (SELECT role_id FROM roles WHERE role_name = 'Manager')),
       ((SELECT info_id FROM user_info WHERE username = 'tom'),
        (SELECT role_id FROM roles WHERE role_name = 'Manager')),
       ((SELECT info_id FROM user_info WHERE username = 'rachel'),
        (SELECT role_id FROM roles WHERE role_name = 'Manager'));

INSERT INTO clients (u_id, date_of_birth, rating, address, registration_date, user_info_id, department_id)
VALUES (CAST('bef076d4-9a54-49bd-bdb8-6cd0615bfbf5'as binary(16)), '1990-01-01', 'STAR5', '123 Main Street', '2024-03-25',
        (SELECT info_id FROM user_info WHERE username = 'alice'),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), '1985-05-15', 'STAR4', '456 Elm Street', NOW(),
        (SELECT info_id FROM user_info WHERE username = 'bob'),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), '1978-12-30', 'STAR3', '789 Oak Street', NOW(),
        (SELECT info_id FROM user_info WHERE username = 'charlie'),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), '1995-06-20', 'STAR6', '101 Pine Street', NOW(),
        (SELECT info_id FROM user_info WHERE username = 'emily'),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), '1982-09-10', 'STAR5', '202 Cedar Street', NOW(),
        (SELECT info_id FROM user_info WHERE username = 'david'),
        (select d_id from departments where departments.address = '123 Main Street'));

INSERT INTO support_managers (sm_id, salary, status_employee, hire_date, user_info_id, department_id)
VALUES (CAST('ff87c525-5d22-4845-b9be-653925e6f269'as binary(16)), 3500.00, 'WORK', '2023-01-15 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'sarah'),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), 3700.00, 'WORK', '2023-02-01 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'tom'),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), 3900.00, 'WORK', '2023-03-10 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'rachel'),
        (select d_id from departments where departments.address = '123 Main Street'));

INSERT INTO orders (o_id, status_order, final_amount, created_at, restaurant_id, client_id, sm_id, department_id)
VALUES (CAST('222103ef-b23b-48f5-85e2-07517c2f0fbf'as binary(16)), 'AWAITING_PAYMENT', 25.99, NOW(),
        (SELECT r_id FROM restaurants WHERE title = 'Green Leaf Cafe'),
        (SELECT u_id
         FROM clients
         WHERE ADDRESS = '123 Main Street'),
        (SELECT sm_id
         FROM support_managers
         WHERE user_info_id = (SELECT info_id FROM user_info WHERE USERNAME = 'sarah')),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), 'IN_PROGRESS', 30.49, NOW(),
        (SELECT r_id FROM restaurants WHERE title = 'Chef''s Corner'),
        (SELECT u_id FROM clients WHERE ADDRESS = '456 Elm Street'),
        (SELECT sm_id
         FROM support_managers
         WHERE user_info_id = (SELECT info_id FROM user_info WHERE USERNAME = 'tom')),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), 'COMPLETED', 20.99, NOW(),
        (SELECT r_id FROM restaurants WHERE title = 'Seafood Haven'),
        (SELECT u_id FROM clients WHERE ADDRESS = '789 Oak Street'),
        (SELECT sm_id
         FROM support_managers
         WHERE user_info_id = (SELECT info_id FROM user_info WHERE USERNAME = 'rachel')),
        (select d_id from departments where departments.address = '123 Main Street'));

INSERT INTO couriers (c_id, rating, status_courier, salary, status_employee, hire_date, user_info_id, order_id,
                      department_id)
VALUES (CAST('286abd49-a85b-4fc2-9c31-8fdcc5d42782'as binary(16)), 'STAR7', 'FREE', 2500.00, 'WORK', '2023-01-15 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'michael'),
        (SELECT o_id FROM orders WHERE status_order = 'AWAITING_PAYMENT'),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), 'STAR6', 'FREE', 2300.00, 'WORK', '2023-02-01 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'emma'),
        (SELECT o_id FROM orders WHERE status_order = 'IN_PROGRESS'),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID(), 'STAR8', 'FREE', 2800.00, 'WORK', '2023-03-10 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'jason'),
        (SELECT o_id FROM orders WHERE status_order = 'COMPLETED'),
        (select d_id from departments where departments.address = '123 Main Street'));