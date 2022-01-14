package com.db.app.mapper;

import com.db.app.database.model.Customer;
import com.db.app.model.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    @Autowired
    CustomerDemographicMapper customerDemographicMapper;

    public CustomerResponse toCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .companyName(customer.getCompanyName())
                .contactName(customer.getContactName())
                .address(customer.getAddress())
                .city(customer.getCity())
                .region(customer.getRegion())
                .postalCode(customer.getPostalCode())
                .country(customer.getCountry())
                .phone(customer.getPhone())
                .fax(customer.getFax())
                .customerDemographics(customer.getCustomerDemographics()
                        .stream()
                        .map(customerDemographic -> customerDemographicMapper.toCustomerDemographicResponse(customerDemographic))
                        .collect(Collectors.toList()))
                .build();
    }
}
