alter table suppliers
    add constraint uk_suppliers
        unique key (code);