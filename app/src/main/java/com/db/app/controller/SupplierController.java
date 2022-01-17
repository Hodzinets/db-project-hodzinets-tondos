package com.db.app.controller;

import com.db.app.model.response.SupplierResponse;
import com.db.app.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
