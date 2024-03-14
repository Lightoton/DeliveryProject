
create table if not exists user_info
(
    info_id      BINARY(16) primary key,
    firstname    varchar(50) not null,
    lastname     varchar(50) not null,
    email        varchar(60) not null unique,
    phone_number varchar(20) not null unique,
    username     varchar(50) not null unique,
    password     varchar(32) not null unique,
    role_id      BINARY(16)  not null,
    updated_at   timestamp   not null,
    foreign key (role_id) references roles (role_id)
);
-- Вставка данных о user в таблицу user_info
# INSERT INTO user_info (info_id, firstname, lastname, email, phone_number, username, password, role_id, updated_at)
# VALUES (UUID_TO_BIN(UUID()), 'Alice', 'Smith', 'alice@example.com', '111222333', 'alice', 'password789',
#         (SELECT role_id FROM roles WHERE role_name = 'User'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Bob', 'Johnson', 'bob@example.com', '444555666', 'bob', 'passwordabc',
#         (SELECT role_id FROM roles WHERE role_name = 'User'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Charlie', 'Brown', 'charlie@example.com', '777888999', 'charlie', 'passwordxyz',
#         (SELECT role_id FROM roles WHERE role_name = 'User'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Emily', 'Davis', 'emily@example.com', '101010101', 'emily', 'password1234',
#         (SELECT role_id FROM roles WHERE role_name = 'User'), NOW()),
#        (UUID_TO_BIN(UUID()), 'David', 'Wilson', 'david@example.com', '121212121', 'david', 'password5678',
#         (SELECT role_id FROM roles WHERE role_name = 'User'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Mark', 'Miller', 'mark@example.com', '333444555', 'mark', 'password123',
#         (SELECT role_id FROM roles WHERE role_name = 'Admin'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Anna', 'Anderson', 'anna@example.com', '666777888', 'anna', 'password456',
#         (SELECT role_id FROM roles WHERE role_name = 'Admin'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Chris', 'Clark', 'chris@example.com', '999000111', 'chris', 'password789',
#         (SELECT role_id FROM roles WHERE role_name = 'Admin'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Sarah', 'Smith', 'sarah@example.com', '222333444', 'sarah', 'password123',
#         (SELECT role_id FROM roles WHERE role_name = 'Manager'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Tom', 'Thompson', 'tom@example.com', '555666777', 'tom', 'password456',
#         (SELECT role_id FROM roles WHERE role_name = 'Manager'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Rachel', 'Roberts', 'rachel@example.com', '888999000', 'rachel', 'password789',
#         (SELECT role_id FROM roles WHERE role_name = 'Manager'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Michael', 'Martinez', 'michael@example.com', '111222333', 'michael', 'password123',
#         (SELECT role_id FROM roles WHERE role_name = 'Employee'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Emma', 'Evans', 'emma@example.com', '444555666', 'emma', 'password456',
#         (SELECT role_id FROM roles WHERE role_name = 'Employee'), NOW()),
#        (UUID_TO_BIN(UUID()), 'Jason', 'Jackson', 'jason@example.com', '777888999', 'jason', 'password789',
#         (SELECT role_id FROM roles WHERE role_name = 'Employee'), NOW());