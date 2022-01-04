package com.db.app.database.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Shippers")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShipperID")
    private Long id;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "Phone")
    private String phone;
}
