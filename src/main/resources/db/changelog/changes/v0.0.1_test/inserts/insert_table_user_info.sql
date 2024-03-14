
-- Вставка данных в таблицу user_info
INSERT INTO user_info (info_id, firstname, lastname, email, phone_number, username, password, updated_at)
VALUES
    (UUID_TO_BIN(UUID()), 'Alice', 'Smith', 'alice@example.com', '111222333', 'alice', 'password789', NOW()),
    (UUID_TO_BIN(UUID()), 'Bob', 'Johnson', 'bob@example.com', '444555666', 'bob', 'passwordabc', NOW()),
    (UUID_TO_BIN(UUID()), 'Charlie', 'Brown', 'charlie@example.com', '777888999', 'charlie', 'passwordxyz', NOW()),
    (UUID_TO_BIN(UUID()), 'Emily', 'Davis', 'emily@example.com', '101010101', 'emily', 'password1234', NOW()),
    (UUID_TO_BIN(UUID()), 'David', 'Wilson', 'david@example.com', '121212121', 'david', 'password5678', NOW()),
    (UUID_TO_BIN(UUID()), 'Mark', 'Miller', 'mark@example.com', '333444555', 'mark', 'password123', NOW()),
    (UUID_TO_BIN(UUID()), 'Anna', 'Anderson', 'anna@example.com', '666777888', 'anna', 'password456', NOW()),
    (UUID_TO_BIN(UUID()), 'Chris', 'Clark', 'chris@example.com', '999000111', 'chris', 'pass9', NOW()),
    (UUID_TO_BIN(UUID()), 'Sarah', 'Smith', 'sarah@example.com', '222333444', 'sarah', 'passwo23', NOW()),
    (UUID_TO_BIN(UUID()), 'Tom', 'Thompson', 'tom@example.com', '555666777', 'tom', 'password56', NOW()),
    (UUID_TO_BIN(UUID()), 'Rachel', 'Roberts', 'rachel@example.com', '888999000', 'rachel', 'password89', NOW()),
    (UUID_TO_BIN(UUID()), 'Michael', 'Martinez', 'michael@example.com', '112333', 'michael', 'passw3', NOW()),
    (UUID_TO_BIN(UUID()), 'Emma', 'Evans', 'emma@example.com', '444666', 'emma', 'passwor6', NOW()),
    (UUID_TO_BIN(UUID()), 'Jason', 'Jackson', 'jason@example.com', '7778999', 'jason', 'passwo9', NOW());
