create table unit_conversions
(
    id                 varchar(36) primary key,
    product_id         varchar(36),
    from_unit_id       varchar(36),
    multiplier         decimal(19, 2),
    to_unit_id         varchar(36),

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         varchar(36),
    last_modified_by   varchar(36)
) engine = InnoDB;