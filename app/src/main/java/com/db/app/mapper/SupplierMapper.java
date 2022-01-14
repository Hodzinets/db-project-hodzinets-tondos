package com.db.app.mapper;

import com.db.app.database.model.Supplier;
import com.db.app.model.response.SupplierResponse;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
    public SupplierResponse toSupplierResponse(Supplier supplier) {
        return SupplierResponse.builder()
                .id(supplier.getId())
                .companyName(supplier.getCompanyName())
                .contactName(supplier.getContactName())
                .address(supplier.getAddress())
                .city(supplier.getCity())
                .region(supplier.getRegion())
                .postalCode(supplier.getPostalCode())
                .country(supplier.getCountry())
                .phone(supplier.getPhone())
                .fax(supplier.getFax())
                .homePage(supplier.getHomePage())
                .build();
    }
}
