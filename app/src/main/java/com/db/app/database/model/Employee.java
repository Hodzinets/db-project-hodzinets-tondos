package com.db.app.database.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Employees")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private Long id;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "Title")
    private String title;

    @Column(name = "TitleOfCourtesy")
    private String titleOfCourtesy;

    @Column(name = "BirthDate")
    private LocalDate birthDate;

    @Column(name = "HireDate")
    private LocalDate hireDate;

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

    @Column(name = "HomePhone")
    private String homePhone;

    @Column(name = "Extension")
    private String extension;

    @Column(name = "Photo")
    private String photo;

    @Column(name = "Notes", columnDefinition="TEXT")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ReportsTo")
    private Employee reportsTo;

    @Column(name = "PhotoPath")
    private String photoPath;

    @ManyToMany
    @JoinTable(
            name = "EmployeeTerritories",
            joinColumns = @JoinColumn(name = "EmployeeID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "TerritoryID", nullable = false))
    List<Territory> territories;
}
