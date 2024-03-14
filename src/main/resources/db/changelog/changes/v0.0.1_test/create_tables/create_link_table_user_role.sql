CREATE TABLE IF NOT EXISTS user_role
(
    user_id BINARY(16) NOT NULL,
    role_id BINARY(16) NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES user_info (info_id),
    FOREIGN KEY (role_id) REFERENCES roles (role_id)
);