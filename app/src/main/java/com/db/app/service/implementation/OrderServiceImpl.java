package com.db.app.service.implementation;

import com.db.app.database.model.Order;
import com.db.app.database.repository.OrderRepository;
import com.db.app.mapper.OrderMapper;
import com.db.app.model.response.OrderResponse;
import com.db.app.service.OrderService;
import com.db.app.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
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

    private Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found"));
    }
}
