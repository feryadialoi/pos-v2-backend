alter table company_settings
    add constraint fk_company_settings_company_id
        foreign key (company_id)
            references companies (id);