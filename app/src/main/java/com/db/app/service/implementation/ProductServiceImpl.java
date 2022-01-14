package com.db.app.service.implementation;

import com.db.app.database.model.Product;
import com.db.app.database.repository.ProductRepository;
import com.db.app.mapper.ProductMapper;
import com.db.app.model.response.ProductResponse;
import com.db.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAll() {
        List<Product> employees = productRepository.findAll();
        return employees.stream().map(item -> productMapper.toProductResponse(item)).collect(Collectors.toList());
    }
}
