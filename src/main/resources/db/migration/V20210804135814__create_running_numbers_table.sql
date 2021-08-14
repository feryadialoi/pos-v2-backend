create table running_numbers
(
    id          varchar(36),
    prefix      varchar(255),
    description varchar(255),
    number      int,
    primary key (id)
) engine = InnoDB;