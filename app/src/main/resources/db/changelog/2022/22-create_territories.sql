create table Territories
(
    TerritoryID          bigserial not null,
    TerritoryDescription varchar(255),
    RegionID             int8,
    primary key (TerritoryID)
);

alter table Territories
    add constraint Territory_Region_FK_Constraint
        foreign key (RegionID)
            references Region;