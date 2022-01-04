create table Employees
(
    EmployeeID      bigserial not null,
    Address         varchar(255),
    BirthDate       date,
    City            varchar(255),
    Country         varchar(255),
    Extension       varchar(255),
    FirstName       varchar(255),
    HireDate        date,
    HomePhone       varchar(255),
    LastName        varchar(255),
    Notes           text,
    Photo           varchar(255),
    PhotoPath       varchar(255),
    PostalCode      varchar(255),
    Region          varchar(255),
    ReportsTo       varchar(255),
    Title           varchar(255),
    TitleOfCourtesy varchar(255),
    primary key (EmployeeID)
);