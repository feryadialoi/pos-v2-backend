alter table running_numbers
    add column created_date       timestamp(3),
    add column last_modified_date timestamp(3),
    add column deleted_date       timestamp(3),
    add column created_by         varchar(36),
    add column last_modified_by   varchar(36);