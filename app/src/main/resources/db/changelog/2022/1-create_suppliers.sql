create table Suppliers
(
    SupplierID   bigserial not null,
    Address      varchar(255),
    City         varchar(255),
    CompanyName  varchar(255),
    ContactName  varchar(255),
    ContactTitle varchar(255),
    Country      varchar(255),
    Fax          varchar(255),
    HomePage     varchar(255),
    Phone        varchar(255),
    PostalCode   varchar(255),
    Region       varchar(255),
    primary key (SupplierID)
);