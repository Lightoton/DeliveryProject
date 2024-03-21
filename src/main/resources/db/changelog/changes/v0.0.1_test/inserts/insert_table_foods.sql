INSERT INTO foods (f_id, title, calorie, price, finishing_cooking_at, created_at, category_id)
VALUES (UUID_TO_BIN(UUID()), 'Grilled Chicken Salad', 350 , 12.99, '2024-03-12 12:00:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Salads')),
       (UUID_TO_BIN(UUID()), 'Vegetable Stir Fry', 250 , 9.99, '2024-03-12 12:30:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Main Dishes')),
       (UUID_TO_BIN(UUID()), 'Salmon Fillet', 400 , 15.99, '2024-03-12 13:00:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Seafood')),
       (UUID_TO_BIN(UUID()), 'Spaghetti Carbonara', 600 , 11.99, '2024-03-12 13:30:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Pasta')),
       (UUID_TO_BIN(UUID()), 'Vegetarian Pizza', 500 , 14.99, '2024-03-12 14:00:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Pizza')),
        (UUID_TO_BIN(UUID()), 'Vegetarian Salad', 500 , 14.99, '2024-03-12 14:00:00', NOW(),
        (select category_id from foods_category where foods_category.title = 'Salads'));