alter table categories
    add column deleted_by varchar(36) after last_modified_by;