INSERT INTO role_authority (role_id, authority_id)
values ((select role_id from roles where role_name = 'Admin'),
        (select auth_id from authority where authority = 'Admin Access')),
       ((select role_id from roles where role_name = 'User'),
        (select auth_id from authority where authority = 'User access')),
       ((select role_id from roles where role_name = 'Employee'),
        (select auth_id from authority where authority = 'Employee Access')),
       ((select role_id from roles where role_name = 'Manager'),
        (select auth_id from authority where authority = 'Manager Access'));