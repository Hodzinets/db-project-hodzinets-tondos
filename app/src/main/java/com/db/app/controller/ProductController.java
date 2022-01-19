package com.db.app.controller;

import com.db.app.model.response.ProductResponse;
import com.db.app.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll() {
        long start = System.currentTimeMillis();
        var result = productService.getAll();
        log.info("Got products in " + (System.currentTimeMillis()-start) + " milliseconds");
        return ResponseEntity.ok(result);
    }
}
