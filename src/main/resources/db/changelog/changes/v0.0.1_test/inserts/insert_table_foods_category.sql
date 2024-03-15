INSERT INTO foods_category (category_id, title, food_id,created_at)
VALUES (UUID_TO_BIN(UUID()), 'Salads', (SELECT f_id FROM foods WHERE title = 'Grilled Chicken Salad'),NOW()),
       (UUID_TO_BIN(UUID()), 'Main Dishes', (SELECT f_id FROM foods WHERE title = 'Vegetable Stir Fry'),NOW()),
       (UUID_TO_BIN(UUID()), 'Seafood', (SELECT f_id FROM foods WHERE title = 'Salmon Fillet'),NOW()),
       (UUID_TO_BIN(UUID()), 'Pasta', (SELECT f_id FROM foods WHERE title = 'Spaghetti Carbonara'),NOW()),
       (UUID_TO_BIN(UUID()), 'Pizza', (SELECT f_id FROM foods WHERE title = 'Vegetarian Pizza'),NOW());