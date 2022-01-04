package com.db.app.database.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customers")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @Id
    @Column(name = "CustomerID")
    private String id;

    @Column(name = "CompanyName")
    private String CustomerDesc;

    @Column(name = "ContactName")
    private String contactName;

    @Column(name = "ContactTitle")
    private String contactTitle;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Region")
    private String region;

    @Column(name = "PostalCode")
    private String postalCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Fax")
    private String fax;

    @ManyToMany
    @JoinTable(
            name = "CustomerCustomerDemo",
            joinColumns = @JoinColumn(name = "CustomerID"),
            inverseJoinColumns = @JoinColumn(name = "CustomerTypeID"))
    List<CustomerDemographic> customerDemographics;
}
