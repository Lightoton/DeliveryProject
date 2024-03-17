INSERT INTO couriers (c_id, rating, status_courier, salary, status_employee, hire_date, user_info_id)
VALUES (UUID_TO_BIN(UUID()), 'STAR7', 'FREE', 2500.00, 'WORK', '2023-01-15 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'michael')),
       (UUID_TO_BIN(UUID()), 'STAR6', 'FREE', 2300.00, 'WORK', '2023-02-01 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'emma')),
       (UUID_TO_BIN(UUID()), 'STAR8', 'FREE', 2800.00, 'WORK', '2023-03-10 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'jason'));