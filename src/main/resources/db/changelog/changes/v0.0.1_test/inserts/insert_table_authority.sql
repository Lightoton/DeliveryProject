
-- Вставка данных в таблицу authority
INSERT INTO authority (auth_id, authority, updated_at)
VALUES
    (UUID_TO_BIN(UUID()), 'Admin Access', NOW()),
    (UUID_TO_BIN(UUID()), 'Employee Access', NOW()),
    (UUID_TO_BIN(UUID()), 'Manager Access', NOW()),
    (UUID_TO_BIN(UUID()), 'User access', NOW());