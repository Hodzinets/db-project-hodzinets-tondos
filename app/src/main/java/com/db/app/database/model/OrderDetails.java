package com.db.app.database.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OrderDetails")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetails {
    @EmbeddedId
    private Id id;

    @Column(name = "UnitPrice")
    private Double unitPrice;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Discount")
    private Double discount;


    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    public static class Id implements Serializable {
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "OrderID")
        private Order orderID;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ProductID")
        private Product productID;
    }
}
