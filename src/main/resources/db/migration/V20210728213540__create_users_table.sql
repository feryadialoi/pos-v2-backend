create table users
(
    id                 varchar(36),
    name               varchar(255),
    username           varchar(255),
    email              varchar(255),
    phone              varchar(255),
    password           varchar(255),
    login_count        int,

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         varchar(36),
    last_modified_by   varchar(36),
    primary key (id)
) engine = InnoDB;