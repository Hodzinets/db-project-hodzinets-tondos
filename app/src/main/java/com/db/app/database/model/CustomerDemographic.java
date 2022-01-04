package com.db.app.database.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CustomerDemographics")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CustomerDemographic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerTypeID")
    private Long id;

    @Column(name = "CustomerDesc")
    private String CustomerDesc;

    @ManyToMany(mappedBy = "customerDemographics")
    List<Customer> customers;
}
