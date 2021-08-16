create table unit_conversions
(
    id                 varchar(36) primary key,
    product_id         varchar(36),
    from_unit_id       varchar(36),
    multiplier         decimal(19, 2),
    to_unit_id         varchar(36),

    created_date       timestamp(3),
    last_modified_date timestamp(3),
    deleted_date       timestamp(3),
    created_by         varchar(36),
    last_modified_by   varchar(36)
) engine = InnoDB;