package com.db.app.mapper;

import com.db.app.database.model.CustomerDemographic;
import com.db.app.model.response.CustomerDemographicResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerDemographicMapper {
    public CustomerDemographicResponse toCustomerDemographicResponse(CustomerDemographic customerDemographic) {
        return  CustomerDemographicResponse.builder()
                .id(customerDemographic.getId())
                .customerDesc(customerDemographic.getCustomerDesc())
                .build();
    }
}
