create table units
(
    id                 varchar(36) primary key,
    name               varchar(255),

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         varchar(36),
    last_modified_by   varchar(36)
) engine = InnoDB;