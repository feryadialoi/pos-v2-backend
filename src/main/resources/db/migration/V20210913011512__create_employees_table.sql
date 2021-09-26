create table employees
(
    id                             varchar(36),
    user_id                        varchar(36),
    company_id                     varchar(36),
    name                           varchar(255),
    national_identification_number varchar(255),
    place_of_birth                 varchar(255),
    date_of_birth                  date,
    address                        varchar(255),
    address_in_identity_card       varchar(255),
    religion                       varchar(255),
    education                      varchar(255),
    join_date                      date,
    phone                          varchar(255),
    phone2                         varchar(255),
    email                          varchar(255),
    marriage                       boolean,
    gender                         enum ('MALE','FEMALE'),
    tax_identification_number      varchar(255),
    insurance_and_social_security  varchar(255),
    bank_name                      varchar(255),
    bank_account_number            varchar(255),
    status                         enum ('ACTIVE','INACTIVE'),

    created_date                   timestamp(3),
    last_modified_date             timestamp(3),
    deleted_date                   timestamp(3),
    created_by                     varchar(36),
    last_modified_by               varchar(36),

    primary key (id)
) engine = InnoDB;