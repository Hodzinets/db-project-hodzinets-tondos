package com.db.app.mapper;

import com.db.app.database.model.OrderDetails;
import com.db.app.model.response.OrderDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsMapper {
    @Autowired
    ProductMapper productMapper;

    public OrderDetailsResponse toOrderDetailsResponse(OrderDetails orderDetails) {
        return OrderDetailsResponse.builder()
                .product(productMapper.toProductResponse(orderDetails.getId().getProduct()))
                .unitPrice(orderDetails.getUnitPrice())
                .quantity(orderDetails.getQuantity())
                .discount(orderDetails.getDiscount())
                .build();
    }
}
