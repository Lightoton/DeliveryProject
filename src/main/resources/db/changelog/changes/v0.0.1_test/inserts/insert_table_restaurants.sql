INSERT INTO restaurants (r_id, title, address, registration_date, menu_id)
VALUES (UUID_TO_BIN(UUID()), 'Green Leaf Cafe', '123 Main Street, Cityville', NOW(),
        (SELECT menu_id FROM menu WHERE title = 'Healthy Choices')),
       (UUID_TO_BIN(UUID()), "Chef's Corner", '456 Elm Street, Townsville', NOW(),
        (SELECT menu_id FROM menu WHERE title = 'Chef Specials')),
       (UUID_TO_BIN(UUID()), 'Seafood Haven', '789 Oak Street, Beachtown', NOW(),
        (SELECT menu_id FROM menu WHERE title = 'Ocean Delights')),
       (UUID_TO_BIN(UUID()), 'Pasta Palace', '101 Pine Street, Pastaville', NOW(),
        (SELECT menu_id FROM menu WHERE title = 'Italian Classics')),
       (UUID_TO_BIN(UUID()), 'Pizza Pizzazz', '202 Cedar Street, Pizzatown', NOW(),
        (SELECT menu_id FROM menu WHERE title = 'Pizza Paradise'));