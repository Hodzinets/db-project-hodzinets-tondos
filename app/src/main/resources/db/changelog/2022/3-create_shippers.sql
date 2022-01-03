create table Shippers
(
    ShipperID   bigserial not null,
    CompanyName varchar(255),
    Phone       varchar(255),
    primary key (ShipperID)
);