alter table sale_returns
    add constraint uk_sale_returns_code
        unique key (code);