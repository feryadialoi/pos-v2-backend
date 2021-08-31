create table journal_details
(
    id                  varchar(36),
    journal_id          varchar(36),
    chart_of_account_id varchar(36),
    entry_date          timestamp(3),
    debit               decimal(19, 2),
    credit              decimal(19, 2),
    description         varchar(255),

    created_date        timestamp(3),
    last_modified_date  timestamp(3),
    deleted_date        timestamp(3),
    created_by          varchar(36),
    last_modified_by    varchar(36),
    primary key (id)
) engine = InnoDB;