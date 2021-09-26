alter table users_companies
    add constraint fk_users_companies_user_id
        foreign key (user_id) references users (id);

alter table users_companies
    add constraint fk_users_companies_company_id
        foreign key (company_id) references companies (id);
