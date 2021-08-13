create table products
(
    id                 bigint unsigned auto_increment primary key,
    code               varchar(255),
    name               varchar(255),
    category_id        bigint unsigned,

    default_unit       ENUM ('LARGE', 'MEDIUM', 'SMALL'),

    unit_large_id      bigint unsigned,
    unit_medium_id     bigint unsigned,
    unit_small_id      bigint unsigned,

    unit_large_price   decimal(19, 2),
    unit_medium_price  decimal(19, 2),
    unit_small_price   decimal(19, 2),

    stock              decimal(19, 2),
    minimum_stock      decimal(19, 2),

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         bigint unsigned,
    last_modified_by   bigint unsigned
) engine = InnoDB;





















