INSERT INTO user_roles (user_info_id, role_id)
VALUES
    ((SELECT info_id FROM user_info WHERE username = 'alice'), (SELECT role_id FROM roles WHERE role_name = 'User')),
    ((SELECT info_id FROM user_info WHERE username = 'bob'), (SELECT role_id FROM roles WHERE role_name = 'User')),
    ((SELECT info_id FROM user_info WHERE username = 'charlie'), (SELECT role_id FROM roles WHERE role_name = 'User')),
    ((SELECT info_id FROM user_info WHERE username = 'emily'), (SELECT role_id FROM roles WHERE role_name = 'User')),
    ((SELECT info_id FROM user_info WHERE username = 'david'), (SELECT role_id FROM roles WHERE role_name = 'User')),
    ((SELECT info_id FROM user_info WHERE username = 'michael'), (SELECT role_id FROM roles WHERE role_name = 'Employee')),
    ((SELECT info_id FROM user_info WHERE username = 'emma'), (SELECT role_id FROM roles WHERE role_name = 'Employee')),
    ((SELECT info_id FROM user_info WHERE username = 'jason'), (SELECT role_id FROM roles WHERE role_name = 'Employee')),
    ((SELECT info_id FROM user_info WHERE username = 'mark'), (SELECT role_id FROM roles WHERE role_name = 'Admin')),
    ((SELECT info_id FROM user_info WHERE username = 'anna'), (SELECT role_id FROM roles WHERE role_name = 'Admin')),
    ((SELECT info_id FROM user_info WHERE username = 'chris'), (SELECT role_id FROM roles WHERE role_name = 'Admin')),
    ((SELECT info_id FROM user_info WHERE username = 'sarah'), (SELECT role_id FROM roles WHERE role_name = 'Manager')),
    ((SELECT info_id FROM user_info WHERE username = 'tom'), (SELECT role_id FROM roles WHERE role_name = 'Manager')),
    ((SELECT info_id FROM user_info WHERE username = 'rachel'), (SELECT role_id FROM roles WHERE role_name = 'Manager'));

