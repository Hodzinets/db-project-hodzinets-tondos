create table Orders
(
    OrderID        bigserial not null,
    Freight        SMALLINT  not null,
    OrderDate      date,
    RequiredDate   date,
    ShipAddress    varchar(255),
    ShipCity       varchar(255),
    ShipCountry    varchar(255),
    ShipName       varchar(255),
    ShipPostalCode varchar(255),
    ShipRegion     varchar(255),
    ShippedDate    date,
    CustomerID     varchar(255),
    EmployeeID     int8,
    ShipVia        int8,
    primary key (OrderID)
);

alter table Orders
    add constraint Order_Customer_FK_Constraint
        foreign key (CustomerID)
            references Customers;

alter table Orders
    add constraint Order_Employee_FK_Constraint
        foreign key (EmployeeID)
            references Employees;

alter table Orders
    add constraint Order_Shipper_FK_Constraint
        foreign key (ShipVia)
            references Shippers;