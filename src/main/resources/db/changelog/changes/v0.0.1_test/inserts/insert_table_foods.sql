

INSERT INTO foods (f_id, title, calorie, price, finishing_cooking_at, created_at)
VALUES (UUID_TO_BIN(UUID()), 'Grilled Chicken Salad', '350 calories', 12.99, '2024-03-12 12:00:00', NOW()),
       (UUID_TO_BIN(UUID()), 'Vegetable Stir Fry', '250 calories', 9.99, '2024-03-12 12:30:00', NOW()),
       (UUID_TO_BIN(UUID()), 'Salmon Fillet', '400 calories', 15.99, '2024-03-12 13:00:00', NOW()),
       (UUID_TO_BIN(UUID()), 'Spaghetti Carbonara', '600 calories', 11.99, '2024-03-12 13:30:00', NOW()),
       (UUID_TO_BIN(UUID()), 'Vegetarian Pizza', '500 calories', 14.99, '2024-03-12 14:00:00', NOW());