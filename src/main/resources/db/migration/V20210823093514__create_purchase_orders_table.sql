# create table
create table purchase_orders
(
    id                       varchar(36),
    supplier_id              varchar(36),
    code                     varchar(255),
    reference                varchar(255),

    is_taxed                 boolean,
    tax                      decimal(19, 2),

    is_discounted            boolean,
    discount                 decimal(19, 2),

    entry_date               timestamp(3),
    due_date                 timestamp(3),

    payment_type             enum ('CASH','CREDIT'),

    status                   enum ('DRAFT', 'APPROVED', 'AWAITING_APPROVAL'),

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

# add unique key
alter table purchase_orders
    add constraint uk_purchase_orders_code
        unique (code);