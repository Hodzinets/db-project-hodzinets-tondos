create table CustomerDemographics
(
    CustomerTypeID bigserial not null,
    CustomerDesc   varchar(255),
    primary key (CustomerTypeID)
);