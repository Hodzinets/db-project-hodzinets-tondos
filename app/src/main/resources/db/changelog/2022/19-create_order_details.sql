create table OrderDetails
(
    Discount  float8,
    Quantity  int4,
    UnitPrice float8,
    ProductID int8 not null,
    OrderID   int8 not null,
    primary key (OrderID, ProductID)
);

alter table OrderDetails
    add constraint OrderDetails_Product_FK_Constraint
        foreign key (ProductID)
            references Products;

alter table OrderDetails
    add constraint OrderDetails_Order_FK_Constraint
        foreign key (OrderID)
            references Orders;