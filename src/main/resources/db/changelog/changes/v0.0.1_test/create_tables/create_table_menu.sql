create table if not exists menu
(
    menu_id          BINARY(16) primary key,
    title            varchar(80) not null unique,
    average_price    double      not null,
    created_at       timestamp   not null,
    category_food_id BINARY(16)  not null,
    foreign key (category_food_id) references foods_category (category_id)
);
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