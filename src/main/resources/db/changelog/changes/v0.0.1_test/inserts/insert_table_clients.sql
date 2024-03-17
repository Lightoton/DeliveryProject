INSERT INTO clients (u_id, date_of_birth, rating, address, registration_date, user_info_id)
VALUES (UUID_TO_BIN(UUID()), '1990-01-01', 'STAR5', '123 Main Street', NOW(),
        (SELECT info_id FROM user_info WHERE username = 'alice')),
       (UUID_TO_BIN(UUID()), '1985-05-15', 'STAR4', '456 Elm Street', NOW(),
        (SELECT info_id FROM user_info WHERE username = 'bob')),
       (UUID_TO_BIN(UUID()), '1978-12-30', 'STAR3', '789 Oak Street', NOW(),
        (SELECT info_id FROM user_info WHERE username = 'charlie')),
       (UUID_TO_BIN(UUID()), '1995-06-20', 'STAR6', '101 Pine Street', NOW(),
        (SELECT info_id FROM user_info WHERE username = 'emily')),
       (UUID_TO_BIN(UUID()), '1982-09-10', 'STAR5', '202 Cedar Street', NOW(),
        (SELECT info_id FROM user_info WHERE username = 'david'));