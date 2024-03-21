INSERT INTO restaurants (r_id, title, address, registration_date)
VALUES
    (UUID_TO_BIN(UUID()), 'Green Leaf Cafe', '123 Main Street, Cityville', NOW()),
    (UUID_TO_BIN(UUID()), 'Chef''s Corner', '456 Elm Street, Townsville', NOW()),
    (UUID_TO_BIN(UUID()), 'Seafood Haven', '789 Oak Street, Beachtown', NOW()),
    (UUID_TO_BIN(UUID()), 'Pasta Palace', '101 Pine Street, Pastaville', NOW()),
    (UUID_TO_BIN(UUID()), 'Pizza Pizzazz', '202 Cedar Street, Pizzatown', NOW());
