ALTER TABLE Employees
    ALTER COLUMN ReportsTo TYPE int8
        USING case when ReportsTo = '0' then null else ReportsTo::int8 end;

alter table Employees
    add constraint Employee_ReportsToEmployee_FK_Constraint
        foreign key (ReportsTo)
            references Employees;
