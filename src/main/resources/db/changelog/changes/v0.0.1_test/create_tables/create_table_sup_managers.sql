create table if not exists support_managers
(
    sm_id            BINARY(16) primary key,
    salary           double      not null,
    status_employee  varchar(60) not null default 'WORK',
    hire_date        timestamp   not null,
    termination_date timestamp,
    user_info_id     binary(16)  not null,
    foreign key (user_info_id) references user_info (info_id)
);
# INSERT INTO support_managers (sm_id, salary, status_employee, hire_date, user_info_id)
# VALUES (UUID_TO_BIN(UUID()), 3500.00, 'WORK', '2023-01-15 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'sarah')),
#        (UUID_TO_BIN(UUID()), 3700.00, 'WORK', '2023-02-01 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'tom')),
#        (UUID_TO_BIN(UUID()), 3900.00, 'WORK', '2023-03-10 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'rachel'));