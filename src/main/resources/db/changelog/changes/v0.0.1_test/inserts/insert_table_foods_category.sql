INSERT INTO foods_category (category_id, title, created_at,menu_id)
VALUES
    (UUID_TO_BIN(UUID()), 'Salads', NOW(),(select menu_id from menu where menu.title = 'Healthy Choices')),
    (UUID_TO_BIN(UUID()), 'Main Dishes', NOW(),(select menu_id from menu where menu.title = 'Chef Specials')),
    (UUID_TO_BIN(UUID()), 'Seafood', NOW(),(select menu_id from menu where menu.title = 'Ocean Delights')),
    (UUID_TO_BIN(UUID()), 'Pasta', NOW(),(select menu_id from menu where menu.title = 'Italian Classics')),
    (UUID_TO_BIN(UUID()), 'Pizza', NOW(),(select menu_id from menu where menu.title = 'Pizza Paradise'));
