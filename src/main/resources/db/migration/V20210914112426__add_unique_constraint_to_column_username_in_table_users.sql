alter table users
    add constraint uk_users_username
        unique key (username);