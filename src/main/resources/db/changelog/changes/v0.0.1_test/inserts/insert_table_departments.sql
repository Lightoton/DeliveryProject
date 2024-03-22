INSERT INTO departments (d_id, address, created_at, updated_at, manager_id)
VALUES (UUID_TO_BIN(UUID()), '123 Main Street', NOW(), NOW(),
        (SELECT m_id FROM managers WHERE user_info_id = (SELECT info_id FROM user_info WHERE username = 'mark')));
