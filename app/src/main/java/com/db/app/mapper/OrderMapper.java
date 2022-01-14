package com.db.app.mapper;

import com.db.app.database.model.Order;
import com.db.app.database.model.OrderDetails;
import com.db.app.database.repository.OrderDetailsRepository;
import com.db.app.model.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    ShipperMapper shipperMapper;
    @Autowired
    OrderDetailsMapper orderDetailsMapper;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public OrderResponse toOrderResponse(Order order){
        List<OrderDetails> orderDetails = orderDetailsRepository.findByIdOrderId(order.getId());

        return OrderResponse.builder()
                .id(order.getId())
                .customer(customerMapper.toCustomerResponse(order.getCustomer()))
                .employee(employeeMapper.toEmployeeResponse(order.getEmployee()))
                .orderDate(order.getOrderDate())
                .requiredDate(order.getRequiredDate())
                .shippedDate(order.getShippedDate())
                .shipper(shipperMapper.toShipperResponse(order.getShipper()))
                .freight(order.getFreight())
                .shipName(order.getShipName())
                .shipAddress(order.getShipAddress())
                .shipCity(order.getShipCity())
                .shipRegion(order.getShipRegion())
                .shipPostalCode(order.getShipPostalCode())
                .shipCountry(order.getShipCountry())
                .orderDetails(orderDetails.stream()
                        .map(orderDetail -> orderDetailsMapper.toOrderDetailsResponse(orderDetail))
                        .collect(Collectors.toList()))
                .build();
    }
}
