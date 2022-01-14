package com.db.app.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private Long id;
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;
    private String photo;
    private String notes;
    private Long reportsTo;
    private String photoPath;
    List<TerritoryResponse> territories;
}
