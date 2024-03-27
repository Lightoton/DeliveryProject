create table if not exists menu
(
    menu_id       BINARY(16) primary key,
    title         varchar(80) not null unique,
    average_price decimal     not null,
    created_at    timestamp   default NOW(),
    restaurant_id BINARY(16)  ,
    foreign key (restaurant_id) references restaurants (r_id)
        ON DELETE SET NULL
);