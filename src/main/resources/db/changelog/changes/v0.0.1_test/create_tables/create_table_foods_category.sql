create table if not exists foods_category
(
    category_id BINARY(16) primary key,
    title       varchar(80) not null unique,
    created_at  timestamp   default NOW(),
    menu_id     binary(16)  ,
    foreign key (menu_id) references menu (menu_id)
        ON DELETE SET NULL
);