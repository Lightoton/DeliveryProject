INSERT INTO order_details (order_d_id, quantity_foods, order_id, food_id)
VALUES (UUID_TO_BIN(UUID()),5,(select o_id from orders where status_order = 'AWAITING_PAYMENT'),(select f_id from foods where title = 'Grilled Chicken Salad')),
       (UUID_TO_BIN(uuid()),2,(select o_id from orders where status_order = 'AWAITING_PAYMENT'),(select f_id from foods where title = 'Vegetarian Salad'));