package com.db.app.controller;

import com.db.app.model.response.CustomerDemographicResponse;
import com.db.app.service.CustomerDemographicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customerDemographic")
public class CustomerDemographicController {
    @Autowired
    private CustomerDemographicService customerDemographicService;

    @GetMapping
    public ResponseEntity<List<CustomerDemographicResponse>> getAll() {
        long start = System.currentTimeMillis();
        var result = customerDemographicService.getAll();
        log.info("Got customer demographics in " + (System.currentTimeMillis()-start) + " milliseconds");
        return ResponseEntity.ok(result);
    }
}
