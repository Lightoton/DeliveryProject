create table if not exists departments
(
    d_id               BINARY(16) primary key,
    address            varchar(80),
    created_at         timestamp,
    updated_at         timestamp,
    manager_id         BINARY(16),
    foreign key (manager_id) references managers (m_id)
        ON DELETE SET NULL
);