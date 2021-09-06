create table sale_orders
(
    id                       varchar(36),
    customer_id              varchar(36),
    salesman_id              varchar(36),
    code                     varchar(255),
    reference                varchar(255),

    is_taxed                 boolean,
    tax                      decimal(19, 2),

    is_discounted            boolean,
    discount                 decimal(19, 2),

    entry_date               timestamp(3),
    due_date                 timestamp(3),
    term                     int,

    payment_type             enum ('CASH', 'CREDIT'),

    status                   enum ('DRAFT', 'SENT', 'DECLINED', 'ACCEPTED'),

    total                    decimal(19, 2),
    grand_total              decimal(19, 2),

    note                     varchar(255),
    attachment               varchar(255),

    shipping_fee             decimal(19, 2),
    shipping_fee_description varchar(255),
    other_fee                decimal(19, 2),
    other_fee_description    varchar(255),

    created_date             timestamp(3),
    last_modified_date       timestamp(3),
    deleted_date             timestamp(3),
    created_by               varchar(36),
    last_modified_by         varchar(36),
    primary key (id)
) engine = InnoDB;