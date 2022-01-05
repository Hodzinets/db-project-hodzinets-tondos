package com.db.app.database.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Products")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Long id;

    @Column(name = "ProductName")
    private String productName;

    @ManyToOne
    @JoinColumn(name="SupplierID")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name="CategoryID")
    private Category category;

    @Column(name = "QuantityPerUnit")
    private String quantityPerUnit;

    @Column(name = "UnitPrice")
    private Double unitPrice;

    @Column(name = "UnitsInStock")
    private Integer unitsInStock;

    @Column(name = "UnitsOnOrder")
    private Integer unitsOnOrder;

    @Column(name = "ReorderLevel")
    private Integer reorderLevel;

    @Column(name = "Discontinued", nullable = false, columnDefinition = "SMALLINT")
    private Boolean discontinued;
}
