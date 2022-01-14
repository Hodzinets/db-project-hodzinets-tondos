package com.db.app.mapper;

import com.db.app.database.model.Employee;
import com.db.app.model.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {
    @Autowired
    TerritoryMapper territoryMapper;

    public EmployeeResponse toEmployeeResponse(Employee employee) {
        Long reportsTo = Optional.ofNullable(employee.getReportsTo()).map(item -> item.getId()).orElse(null);

        return EmployeeResponse.builder()
                .id(employee.getId())
                .lastName(employee.getLastName())
                .firstName(employee.getFirstName())
                .title(employee.getTitle())
                .titleOfCourtesy(employee.getTitleOfCourtesy())
                .birthDate(employee.getBirthDate())
                .hireDate(employee.getHireDate())
                .address(employee.getAddress())
                .city(employee.getCity())
                .region(employee.getRegion())
                .postalCode(employee.getPostalCode())
                .country(employee.getCountry())
                .homePhone(employee.getHomePhone())
                .extension(employee.getExtension())
                .photo(employee.getPhoto())
                .notes(employee.getNotes())
                .reportsTo(reportsTo)
                .photoPath(employee.getPhotoPath())
                .territories(employee.getTerritories().stream()
                        .map(territory -> territoryMapper.toTerritoryResponse(territory))
                        .collect(Collectors.toList()))
                .build();
    }
}
