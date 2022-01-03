create table Products
(
    ProductID       bigserial not null,
    Discontinued    SMALLINT  not null,
    ProductName     varchar(255),
    QuantityPerUnit varchar(255),
    ReorderLevel    int4,
    UnitPrice       float8,
    UnitsInStock    int4,
    UnitsOnOrder    int4,
    CategoryID      int8,
    SupplierID      int8,
    primary key (ProductID)
);

alter table Products
    add constraint Product_Category_FK_Constraint
        foreign key (CategoryID)
            references Categories;

alter table Products
    add constraint Product_Supplier_FK_Constraint
        foreign key (SupplierID)
            references Suppliers;