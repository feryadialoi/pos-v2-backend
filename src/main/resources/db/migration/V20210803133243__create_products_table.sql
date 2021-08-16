create table products
(
    id                 varchar(36) primary key,
    code               varchar(255),
    name               varchar(255),
    category_id        varchar(36),
    brand_id           varchar(36),

    idempotent_key     varchar(36),

    stock              decimal(19, 2),
    minimum_stock      decimal(19, 2),

    created_date       timestamp(3),
    last_modified_date timestamp(3),
    deleted_date       timestamp(3),
    created_by         varchar(36),
    last_modified_by   varchar(36)
) engine = InnoDB;





















