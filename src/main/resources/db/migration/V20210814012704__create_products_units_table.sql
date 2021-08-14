create table products_units
(
    product_id varchar(36),
    unit_id    varchar(36),
    primary key (product_id, unit_id)
) engine = InnoDB;