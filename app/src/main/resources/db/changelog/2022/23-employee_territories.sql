create table EmployeeTerritories
(
    EmployeeID  int8 not null,
    TerritoryID int8 not null
);

alter table EmployeeTerritories
    add constraint EmployeeTerritories_Territory_FK_Constraint
        foreign key (TerritoryID)
            references Territories;

alter table EmployeeTerritories
    add constraint EmployeeTerritories_Employee_FK_Constraint
        foreign key (EmployeeID)
            references Employees;