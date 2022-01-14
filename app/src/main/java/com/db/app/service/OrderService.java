package com.db.app.service;

import com.db.app.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getAll();

    OrderResponse getById(Long id);
}
