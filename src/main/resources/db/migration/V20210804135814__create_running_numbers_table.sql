create table running_numbers
(
    id          bigint unsigned auto_increment,
    prefix      varchar(255),
    description varchar(255),
    number      int,
    primary key (id)
) engine = InnoDB;