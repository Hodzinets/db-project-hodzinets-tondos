package com.db.app.service;

import com.db.app.model.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAll();
}
