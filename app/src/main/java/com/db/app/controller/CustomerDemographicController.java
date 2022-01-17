package com.db.app.controller;

import com.db.app.model.response.CustomerDemographicResponse;
import com.db.app.service.CustomerDemographicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customerDemographic")
public class CustomerDemographicController {
    @Autowired
    private CustomerDemographicService customerDemographicService;

    @GetMapping
    public ResponseEntity<List<CustomerDemographicResponse>> getAll() {
        return ResponseEntity.ok(customerDemographicService.getAll());
    }
}
