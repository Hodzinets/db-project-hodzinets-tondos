package com.db.app.database.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Territories")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Territory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TerritoryID")
    private Long id;

    @Column(name = "TerritoryDescription")
    private String territoryDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RegionID")
    private Region region;
}
