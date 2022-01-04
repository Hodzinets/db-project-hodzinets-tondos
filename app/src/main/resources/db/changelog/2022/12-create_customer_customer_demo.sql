create table CustomerCustomerDemo
(
    CustomerID     varchar(255) not null,
    CustomerTypeID int8         not null
);

alter table CustomerCustomerDemo
    add constraint CustomerCustomerDemo_CustomerType_FK_Constraint
        foreign key (CustomerTypeID)
            references CustomerDemographics;

alter table CustomerCustomerDemo
    add constraint CustomerCustomerDemo_Customer_FK_Constraint
        foreign key (CustomerID)
            references Customers;