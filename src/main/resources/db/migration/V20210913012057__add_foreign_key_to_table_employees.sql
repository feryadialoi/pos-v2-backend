alter table employees
    add constraint fk_employees_user_id
        foreign key (user_id)
            references users (id);

alter table employees
    add constraint fk_employees_company_id
        foreign key (company_id)
            references companies (id);