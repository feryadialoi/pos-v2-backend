create table delivery_orders
(
    id                 varchar(34),
    sale_id            varchar(24),
    company_id         varchar(34),
    code               varchar(255),
    note               varchar(255),
    status             enum ('DRAFT', 'PROCESSING', 'SHIPPED', 'DELIVERED', 'VOID'),

    created_date       timestamp(3),
    last_modified_date timestamp(3),
    deleted_date       timestamp(3),
    created_by         varchar(36),
    last_modified_by   varchar(36),
    primary key (id)
) engine = InnoDB;