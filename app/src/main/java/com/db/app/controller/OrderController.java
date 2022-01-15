package com.db.app.controller;

import com.db.app.model.request.CreateOrderRequest;
import com.db.app.model.response.OrderResponse;
import com.db.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAll() { return ResponseEntity.ok(orderService.getAll()); }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getById(@PathVariable("orderId") Long id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody CreateOrderRequest request) {
        return ResponseEntity.ok(orderService.create(request));
    }
}
