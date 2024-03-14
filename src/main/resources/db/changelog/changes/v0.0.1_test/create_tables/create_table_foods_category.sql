create table if not exists foods_category
(
    category_id BINARY(16) primary key,
    title       varchar(80) not null unique,
    food_id     BINARY(16)  not null,
    foreign key (food_id) references foods (f_id)
);
# INSERT INTO foods_category (category_id, title, food_id)
# VALUES (UUID_TO_BIN(UUID()), 'Salads', (SELECT f_id FROM foods WHERE title = 'Grilled Chicken Salad')),
#        (UUID_TO_BIN(UUID()), 'Main Dishes', (SELECT f_id FROM foods WHERE title = 'Vegetable Stir Fry')),
#        (UUID_TO_BIN(UUID()), 'Seafood', (SELECT f_id FROM foods WHERE title = 'Salmon Fillet')),
#        (UUID_TO_BIN(UUID()), 'Pasta', (SELECT f_id FROM foods WHERE title = 'Spaghetti Carbonara')),
#        (UUID_TO_BIN(UUID()), 'Pizza', (SELECT f_id FROM foods WHERE title = 'Vegetarian Pizza'));