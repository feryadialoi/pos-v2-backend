create table unit_conversions
(
    id                 bigint unsigned auto_increment primary key,
    product_id         bigint unsigned,
    from_unit_id       bigint unsigned,
    multiplier         decimal(19, 2),
    to_unit_id         bigint unsigned,

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         bigint unsigned,
    last_modified_by   bigint unsigned
) engine = InnoDB;