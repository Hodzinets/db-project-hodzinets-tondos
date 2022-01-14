package com.db.app.database.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Long id;

    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Picture")
    private String picture;
}
