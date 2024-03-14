# INSERT INTO foods (f_id, title, calorie, price, finishing_cooking_at, created_at)
# VALUES (UUID_TO_BIN(UUID()), 'Grilled Chicken Salad', '350 calories', 12.99, '2024-03-12 12:00:00', NOW()),
#        (UUID_TO_BIN(UUID()), 'Vegetable Stir Fry', '250 calories', 9.99, '2024-03-12 12:30:00', NOW()),
#        (UUID_TO_BIN(UUID()), 'Salmon Fillet', '400 calories', 15.99, '2024-03-12 13:00:00', NOW()),
#        (UUID_TO_BIN(UUID()), 'Spaghetti Carbonara', '600 calories', 11.99, '2024-03-12 13:30:00', NOW()),
#        (UUID_TO_BIN(UUID()), 'Vegetarian Pizza', '500 calories', 14.99, '2024-03-12 14:00:00', NOW());
#
# INSERT INTO foods_category (category_id, title, food_id)
# VALUES (UUID_TO_BIN(UUID()), 'Salads', (SELECT f_id FROM foods WHERE title = 'Grilled Chicken Salad')),
#        (UUID_TO_BIN(UUID()), 'Main Dishes', (SELECT f_id FROM foods WHERE title = 'Vegetable Stir Fry')),
#        (UUID_TO_BIN(UUID()), 'Seafood', (SELECT f_id FROM foods WHERE title = 'Salmon Fillet')),
#        (UUID_TO_BIN(UUID()), 'Pasta', (SELECT f_id FROM foods WHERE title = 'Spaghetti Carbonara')),
#        (UUID_TO_BIN(UUID()), 'Pizza', (SELECT f_id FROM foods WHERE title = 'Vegetarian Pizza'));
#
# INSERT INTO menu (menu_id, title, average_price, created_at, category_food_id)
# VALUES (UUID_TO_BIN(UUID()), 'Healthy Choices', 13.49, NOW(),
#         (SELECT category_id FROM foods_category WHERE title = 'Salads')),
#        (UUID_TO_BIN(UUID()), 'Chef Specials', 14.99, NOW(),
#         (SELECT category_id FROM foods_category WHERE title = 'Main Dishes')),
#        (UUID_TO_BIN(UUID()), 'Ocean Delights', 16.49, NOW(),
#         (SELECT category_id FROM foods_category WHERE title = 'Seafood')),
#        (UUID_TO_BIN(UUID()), 'Italian Classics', 12.99, NOW(),
#         (SELECT category_id FROM foods_category WHERE title = 'Pasta')),
#        (UUID_TO_BIN(UUID()), 'Pizza Paradise', 14.99, NOW(),
#         (SELECT category_id FROM foods_category WHERE title = 'Pizza'));
#
# INSERT INTO restaurants (r_id, title, address, registration_date, menu_id)
# VALUES (UUID_TO_BIN(UUID()), 'Green Leaf Cafe', '123 Main Street, Cityville', NOW(),
#         (SELECT menu_id FROM menu WHERE title = 'Healthy Choices')),
#        (UUID_TO_BIN(UUID()), "Chef's Corner", '456 Elm Street, Townsville', NOW(),
#         (SELECT menu_id FROM menu WHERE title = 'Chef Specials')),
#        (UUID_TO_BIN(UUID()), 'Seafood Haven', '789 Oak Street, Beachtown', NOW(),
#         (SELECT menu_id FROM menu WHERE title = 'Ocean Delights')),
#        (UUID_TO_BIN(UUID()), 'Pasta Palace', '101 Pine Street, Pastaville', NOW(),
#         (SELECT menu_id FROM menu WHERE title = 'Italian Classics')),
#        (UUID_TO_BIN(UUID()), 'Pizza Pizzazz', '202 Cedar Street, Pizzatown', NOW(),
#         (SELECT menu_id FROM menu WHERE title = 'Pizza Paradise'));
# -- Вставка данных в таблицу roles
# INSERT INTO roles (role_id, role_name, updated_at, authority_id)
# VALUES (UUID_TO_BIN(UUID()), 'Admin', NOW(), (UUID_TO_BIN(UUID()))),
#        (UUID_TO_BIN(UUID()), 'User', NOW(), (UUID_TO_BIN(UUID()))),
#        (UUID_TO_BIN(UUID()), 'Employee', NOW(), (UUID_TO_BIN(UUID()))),
#        (UUID_TO_BIN(UUID()), 'Manager', NOW(), (UUID_TO_BIN(UUID())));
#
# -- Вставка данных в таблицу authority
# INSERT INTO authority (auth_id, authority, updated_at, role_id)
# VALUES (UUID_TO_BIN(UUID()), 'Admin Access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'Admin')),
#        (UUID_TO_BIN(UUID()), 'Employee Access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'Employee')),
#        (UUID_TO_BIN(UUID()), 'Manager Access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'Manager')),
#        (UUID_TO_BIN(UUID()), 'User access', NOW(), (SELECT role_id FROM roles WHERE role_name = 'User'));
#
# -- Вставка данных о user в таблицу user_info
# INSERT INTO user_info (info_id, firstname, lastname, email, phone_number, username, password, role_id, updated_at)
# VALUES (UUID_TO_BIN(UUID()), 'Alice', 'Smith', 'alice@example.com', '111222333', 'alice', 'password789',
#         (SELECT role_id FROM roles WHERE role_name = 'User'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Bob', 'Johnson', 'bob@example.com', '444555666', 'bob', 'passwordabc',
#         (SELECT role_id FROM roles WHERE role_name = 'User'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Charlie', 'Brown', 'charlie@example.com', '777888999', 'charlie', 'passwordxyz',
#         (SELECT role_id FROM roles WHERE role_name = 'User'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Emily', 'Davis', 'emily@example.com', '101010101', 'emily', 'password1234',
#         (SELECT role_id FROM roles WHERE role_name = 'User'), NOW()),
#        (UUID_TO_BIN(UUID()), 'David', 'Wilson', 'david@example.com', '121212121', 'david', 'password5678',
#         (SELECT role_id FROM roles WHERE role_name = 'User'), NOW());
# -- Добавление данных для менеджеров
# INSERT INTO user_info (info_id, firstname, lastname, email, phone_number, username, password, role_id, updated_at)
# VALUES (UUID_TO_BIN(UUID()), 'Mark', 'Miller', 'mark@example.com', '333444555', 'mark', 'password123',
#         (SELECT role_id FROM roles WHERE role_name = 'Admin'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Anna', 'Anderson', 'anna@example.com', '666777888', 'anna', 'password456',
#         (SELECT role_id FROM roles WHERE role_name = 'Admin'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Chris', 'Clark', 'chris@example.com', '999000111', 'chris', 'password789',
#         (SELECT role_id FROM roles WHERE role_name = 'Admin'), NOW());
#
# -- Добавление данных для менеджеров поддержки
# INSERT INTO user_info (info_id, firstname, lastname, email, phone_number, username, password, role_id, updated_at)
# VALUES (UUID_TO_BIN(UUID()), 'Sarah', 'Smith', 'sarah@example.com', '222333444', 'sarah', 'password123',
#         (SELECT role_id FROM roles WHERE role_name = 'Manager'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Tom', 'Thompson', 'tom@example.com', '555666777', 'tom', 'password456',
#         (SELECT role_id FROM roles WHERE role_name = 'Manager'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Rachel', 'Roberts', 'rachel@example.com', '888999000', 'rachel', 'password789',
#         (SELECT role_id FROM roles WHERE role_name = 'Manager'), NOW());
#
# -- Добавление данных для курьеров
# INSERT INTO user_info (info_id, firstname, lastname, email, phone_number, username, password, role_id, updated_at)
# VALUES (UUID_TO_BIN(UUID()), 'Michael', 'Martinez', 'michael@example.com', '111222333', 'michael', 'password123',
#         (SELECT role_id FROM roles WHERE role_name = 'Employee'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Emma', 'Evans', 'emma@example.com', '444555666', 'emma', 'password456',
#         (SELECT role_id FROM roles WHERE role_name = 'Employee'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Jason', 'Jackson', 'jason@example.com', '777888999', 'jason', 'password789',
#         (SELECT role_id FROM roles WHERE role_name = 'Employee'), NOW());
#
# -- Добавление клиентов
# INSERT INTO clients (u_id, date_of_birth, rating, address, registration_date, user_info_id)
# VALUES (UUID_TO_BIN(UUID()), '1990-01-01', 'STAR5', '123 Main Street', NOW(),
#         (SELECT info_id FROM user_info WHERE username = 'alice')),
#        (UUID_TO_BIN(UUID()), '1985-05-15', 'STAR4', '456 Elm Street', NOW(),
#         (SELECT info_id FROM user_info WHERE username = 'bob')),
#        (UUID_TO_BIN(UUID()), '1978-12-30', 'STAR3', '789 Oak Street', NOW(),
#         (SELECT info_id FROM user_info WHERE username = 'charlie')),
#        (UUID_TO_BIN(UUID()), '1995-06-20', 'STAR6', '101 Pine Street', NOW(),
#         (SELECT info_id FROM user_info WHERE username = 'emily')),
#        (UUID_TO_BIN(UUID()), '1982-09-10', 'STAR5', '202 Cedar Street', NOW(),
#         (SELECT info_id FROM user_info WHERE username = 'david'));
# -- Добавление курьеров
# INSERT INTO couriers (c_id, rating, status_courier, salary, status_employee, hire_date, user_info_id)
# VALUES (UUID_TO_BIN(UUID()), 'STAR7', 'FREE', 2500.00, 'WORK', '2023-01-15 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'michael')),
#        (UUID_TO_BIN(UUID()), 'STAR6', 'FREE', 2300.00, 'WORK', '2023-02-01 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'emma')),
#        (UUID_TO_BIN(UUID()), 'STAR8', 'FREE', 2800.00, 'WORK', '2023-03-10 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'jason'));
# -- Добавление сап менеджеров
# INSERT INTO support_managers (sm_id, salary, status_employee, hire_date, user_info_id)
# VALUES (UUID_TO_BIN(UUID()), 3500.00, 'WORK', '2023-01-15 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'sarah')),
#        (UUID_TO_BIN(UUID()), 3700.00, 'WORK', '2023-02-01 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'tom')),
#        (UUID_TO_BIN(UUID()), 3900.00, 'WORK', '2023-03-10 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'rachel'));
# -- Добавление менеджеров
# INSERT INTO managers (m_id, salary, hire_date, user_info_id)
# VALUES (UUID_TO_BIN(UUID()), 4000.00, '2023-01-15 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'mark')),
#        (UUID_TO_BIN(UUID()), 4200.00, '2023-02-01 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'anna')),
#        (UUID_TO_BIN(UUID()), 4400.00, '2023-03-10 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'chris'));
# -- Добавление заказов
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
#
# -- Добавление департаментов
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
#
#
#







