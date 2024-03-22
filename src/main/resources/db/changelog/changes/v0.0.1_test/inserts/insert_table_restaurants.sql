INSERT INTO restaurants (r_id, title, address, registration_date, department_id)
VALUES (UUID_TO_BIN(UUID()), 'Green Leaf Cafe', '123 Main Street, Cityville', NOW(),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID_TO_BIN(UUID()), 'Chef''s Corner', '456 Elm Street, Townsville', NOW(),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID_TO_BIN(UUID()), 'Seafood Haven', '789 Oak Street, Beachtown', NOW(),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID_TO_BIN(UUID()), 'Pasta Palace', '101 Pine Street, Pastaville', NOW(),
        (select d_id from departments where departments.address = '123 Main Street')),
       (UUID_TO_BIN(UUID()), 'Pizza Pizzazz', '202 Cedar Street, Pizzatown', NOW(),
        (select d_id from departments where departments.address = '123 Main Street'));
