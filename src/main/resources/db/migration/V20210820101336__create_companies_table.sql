create table companies
(
    id                        varchar(36),
    name                      varchar(255),
    address                   varchar(255),
    phone                     varchar(255),

    bank_name                 varchar(255),
    bank_branch               varchar(255),
    bank_account_number       varchar(255),

    taxable_firm_name         varchar(255),
    taxable_firm_address      varchar(255),
    tax_identification_number varchar(255),


    created_date              timestamp(3),
    last_modified_date        timestamp(3),
    deleted_date              timestamp(3),
    created_by                varchar(36),
    last_modified_by          varchar(36),
    primary key (id)
) engine = InnoDB;