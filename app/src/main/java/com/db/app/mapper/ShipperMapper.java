package com.db.app.mapper;

import com.db.app.database.model.Shipper;
import com.db.app.model.response.ShipperResponse;
import org.springframework.stereotype.Component;

@Component
public class ShipperMapper {
    public ShipperResponse toShipperResponse(Shipper shipper) {
        return ShipperResponse.builder()
                .id(shipper.getId())
                .companyName(shipper.getCompanyName())
                .phone(shipper.getPhone())
                .build();
    }
}
