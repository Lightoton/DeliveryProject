create table if not exists managers
(
    m_id             BINARY(16) primary key,
    salary           double     not null,
    hire_date        timestamp  not null,
    termination_date timestamp,
    user_info_id     BINARY(16) not null,
    foreign key (user_info_id) references user_info (info_id)
);