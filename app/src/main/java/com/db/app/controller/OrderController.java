package com.db.app.controller;

import com.db.app.database.model.Customer;
import com.db.app.database.model.Order;
import com.db.app.database.repository.CustomerRepository;
import com.db.app.database.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
