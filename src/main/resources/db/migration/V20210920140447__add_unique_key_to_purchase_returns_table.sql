alter table purchase_returns
    add constraint uk_purchase_returns_code
        unique key (code);