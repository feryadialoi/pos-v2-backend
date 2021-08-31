create table chart_of_accounts
(
    id                 varchar(36),
    name               varchar(255),
    account_code       int,
    level              int,
    parent_id          varchar(36),
    path               varchar(255),

    created_date       timestamp(3),
    last_modified_date timestamp(3),
    deleted_date       timestamp(3),
    created_by         varchar(36),
    last_modified_by   varchar(36),
    primary key (id)
)