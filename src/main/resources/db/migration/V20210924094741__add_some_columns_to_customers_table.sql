alter table customers
    drop column phone,
    add column phone                          varchar(255) after address,
    add column phone2                         varchar(255) after phone,
    add column national_identification_number varchar(255) after name,
    add column description                    varchar(255) after phone2;
