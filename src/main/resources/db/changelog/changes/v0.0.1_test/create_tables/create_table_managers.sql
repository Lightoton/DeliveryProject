create table if not exists managers
(
    m_id             BINARY(16) primary key,
    salary           double     not null,
    hire_date        timestamp  not null,
    termination_date timestamp,
    user_info_id     BINARY(16) not null,
    foreign key (user_info_id) references user_info (info_id)
);
# INSERT INTO managers (m_id, salary, hire_date, user_info_id)
# VALUES (UUID_TO_BIN(UUID()), 4000.00, '2023-01-15 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'mark')),
#        (UUID_TO_BIN(UUID()), 4200.00, '2023-02-01 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'anna')),
#        (UUID_TO_BIN(UUID()), 4400.00, '2023-03-10 08:00:00',
#         (SELECT info_id FROM user_info WHERE username = 'chris'));