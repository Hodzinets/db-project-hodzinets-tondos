package com.db.app.controller;

import com.db.app.model.request.CreateOrderRequest;
import com.db.app.model.request.CreateSupplierRequest;
import com.db.app.model.response.OrderResponse;
import com.db.app.model.response.SupplierResponse;
import com.db.app.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> getAll() {
        return ResponseEntity.ok(supplierService.getAll());
    }

    @GetMapping("/{supplierId}")
    public ResponseEntity<SupplierResponse> getById(@PathVariable("supplierId") Long id) {
        return ResponseEntity.ok(supplierService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SupplierResponse> create(@RequestBody CreateSupplierRequest request) {
        return ResponseEntity.ok(supplierService.create(request));
    }
}
