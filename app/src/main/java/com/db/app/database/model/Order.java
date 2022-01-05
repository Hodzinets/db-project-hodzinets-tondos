package com.db.app.database.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Orders")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeID", nullable = false)
    private Employee employee;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @Column(name = "RequiredDate")
    private LocalDate requiredDate;

    @Column(name = "ShippedDate")
    private LocalDate shippedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipVia")
    private Shipper shipper;

    @Column(name = "Freight", nullable = false, columnDefinition = "SMALLINT")
    private Boolean freight;

    @Column(name = "ShipName")
    private String shipName;

    @Column(name = "ShipAddress")
    private String shipAddress;

    @Column(name = "ShipCity")
    private String shipCity;

    @Column(name = "ShipRegion")
    private String shipRegion;

    @Column(name = "ShipPostalCode")
    private String shipPostalCode;

    @Column(name = "ShipCountry")
    private String shipCountry;
}
