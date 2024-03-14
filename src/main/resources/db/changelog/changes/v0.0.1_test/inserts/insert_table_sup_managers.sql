
INSERT INTO support_managers (sm_id, salary, status_employee, hire_date, user_info_id)
VALUES (UUID_TO_BIN(UUID()), 3500.00, 'WORK', '2023-01-15 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'sarah')),
       (UUID_TO_BIN(UUID()), 3700.00, 'WORK', '2023-02-01 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'tom')),
       (UUID_TO_BIN(UUID()), 3900.00, 'WORK', '2023-03-10 08:00:00',
        (SELECT info_id FROM user_info WHERE username = 'rachel'));