INSERT INTO menu (menu_id, title, average_price, created_at, restaurant_id)
VALUES
    (UUID_TO_BIN(UUID()), 'Healthy Choices', 13.49, NOW(), (SELECT r_id FROM restaurants WHERE title = 'Green Leaf Cafe')),
    (UUID_TO_BIN(UUID()), 'Chef Specials', 14.99, NOW(), (SELECT r_id FROM restaurants WHERE title = 'Chef''s Corner')),
    (UUID_TO_BIN(UUID()), 'Ocean Delights', 16.49, NOW(), (SELECT r_id FROM restaurants WHERE title = 'Seafood Haven')),
    (UUID_TO_BIN(UUID()), 'Italian Classics', 12.99, NOW(), (SELECT r_id FROM restaurants WHERE title = 'Pasta Palace')),
    (UUID_TO_BIN(UUID()), 'Pizza Paradise', 14.99, NOW(), (SELECT r_id FROM restaurants WHERE title = 'Pizza Pizzazz'));
