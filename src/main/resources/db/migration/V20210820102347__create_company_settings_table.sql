create table company_settings
(
    id                  varchar(36),
    company_id          varchar(36),
    setting_name        varchar(255),
    setting_value       varchar(255),
    setting_description varchar(255),

    created_date        timestamp(3),
    last_modified_date  timestamp(3),
    deleted_date        timestamp(3),
    created_by          varchar(36),
    last_modified_by    varchar(36),
    primary key (id)
) engine = InnoDB;