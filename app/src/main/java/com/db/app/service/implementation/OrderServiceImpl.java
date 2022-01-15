package com.db.app.service.implementation;

import com.db.app.database.model.*;
import com.db.app.database.repository.*;
import com.db.app.exception.BadRequestException;
import com.db.app.mapper.OrderMapper;
import com.db.app.model.request.CreateOrderDetailsRequest;
import com.db.app.model.request.CreateOrderRequest;
import com.db.app.model.response.OrderResponse;
import com.db.app.service.OrderService;
import com.db.app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ShipperRepository shipperRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<OrderResponse> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(item -> orderMapper.toOrderResponse(item)).collect(Collectors.toList());
    }

    @Override
    public OrderResponse getById(Long id) {
        Order order = findById(id);
        return orderMapper.toOrderResponse(order);
    }

    @Override
    @Transactional
    public OrderResponse create(CreateOrderRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId()).orElseThrow(() -> new NotFoundException("Customer not found"));
        Employee employee = employeeRepository.findById(request.getEmployeeId()).orElseThrow(() -> new NotFoundException("Employee not found"));
        Shipper shipper = shipperRepository.findById(request.getShipperId()).orElseThrow(() -> new NotFoundException("Shipper not found"));

        Order newOrder = Order.builder()
                .customer(customer)
                .employee(employee)
                .orderDate(LocalDate.now())
                .requiredDate(request.getRequiredDate())
                .shipper(shipper)
                .freight(request.getFreight())
                .shipName(request.getShipName())
                .shipAddress(request.getShipAddress())
                .shipCity(request.getShipCity())
                .shipRegion(request.getShipRegion())
                .shipPostalCode(request.getShipPostalCode())
                .shipCountry(request.getShipCountry())
                .build();

        Order order = orderRepository.save(newOrder);

        List<OrderDetails> orderDetails = new ArrayList<>();
        for(CreateOrderDetailsRequest detailsRequest : request.getOrderDetails()) {
            Product product = productRepository.findById(detailsRequest.getProductId())
                    .orElseThrow(() -> new NotFoundException("Product " + detailsRequest.getProductId() + " not found"));

            if(product.getDiscontinued()) {
                throw new BadRequestException("Product " + detailsRequest.getProductId() + " is discontinued");
            }

            if(product.getUnitsInStock()<detailsRequest.getQuantity()) {
                throw new BadRequestException("There is no "+ detailsRequest.getQuantity() + " products " + detailsRequest.getProductId() + " in stock");
            }

            product.updateUnitsQuantity(detailsRequest.getQuantity());
            productRepository.save(product);
            orderDetails.add(OrderDetails.builder()
                    .id(OrderDetails.Id.builder()
                            .order(order)
                            .product(product)
                            .build())
                    .quantity(detailsRequest.getQuantity())
                    .unitPrice(product.getUnitPrice())
                    .discount(detailsRequest.getDiscount())
                    .build());
        }

        orderDetailsRepository.saveAll(orderDetails);
        return orderMapper.toOrderResponse(order);
    }

    private Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found"));
    }
}
