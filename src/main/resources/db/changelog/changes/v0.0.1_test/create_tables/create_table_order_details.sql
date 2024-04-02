create table if not exists order_details
(
    order_d_id          BINARY(16) primary key,
    quantity_foods      INT not null,
    created_at          timestamp default NOW(),
    updated_at          timestamp on update NOW(),
    order_id            binary(16) not null,
    food_id             binary(16),
    foreign key (order_id) references orders(o_id)
        ON DELETE CASCADE,
    foreign key (food_id) references foods(f_id)
        ON DELETE SET NULL
);