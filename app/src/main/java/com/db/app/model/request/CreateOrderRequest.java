package com.db.app.model.request;

import com.db.app.model.response.CustomerResponse;
import com.db.app.model.response.EmployeeResponse;
import com.db.app.model.response.OrderDetailsResponse;
import com.db.app.model.response.ShipperResponse;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Value
@Builder
@RequiredArgsConstructor
@ApiModel
public class CreateOrderRequest {
    private String customerId;
    private Long employeeId;
    private LocalDate requiredDate;
    private Long shipperId;
    private Boolean freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;
    private List<CreateOrderDetailsRequest> orderDetails = new ArrayList<>();
}
