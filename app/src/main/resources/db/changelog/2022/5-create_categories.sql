create table Categories
(
    CategoryID   bigserial not null,
    CategoryName varchar(255),
    Description  varchar(255),
    Picture      varchar(255),
    primary key (CategoryID)
);