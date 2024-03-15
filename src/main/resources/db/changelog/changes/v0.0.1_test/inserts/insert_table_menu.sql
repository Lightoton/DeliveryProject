INSERT INTO menu (menu_id, title, average_price, created_at, category_food_id)
VALUES (UUID_TO_BIN(UUID()), 'Healthy Choices', 13.49, NOW(),
        (SELECT category_id FROM foods_category WHERE title = 'Salads')),
       (UUID_TO_BIN(UUID()), 'Chef Specials', 14.99, NOW(),
        (SELECT category_id FROM foods_category WHERE title = 'Main Dishes')),
       (UUID_TO_BIN(UUID()), 'Ocean Delights', 16.49, NOW(),
        (SELECT category_id FROM foods_category WHERE title = 'Seafood')),
       (UUID_TO_BIN(UUID()), 'Italian Classics', 12.99, NOW(),
        (SELECT category_id FROM foods_category WHERE title = 'Pasta')),
       (UUID_TO_BIN(UUID()), 'Pizza Paradise', 14.99, NOW(),
        (SELECT category_id FROM foods_category WHERE title = 'Pizza'));