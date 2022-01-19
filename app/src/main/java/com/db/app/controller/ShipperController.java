package com.db.app.controller;

import com.db.app.model.response.ShipperResponse;
import com.db.app.service.ShipperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shipper")
public class ShipperController {
    @Autowired
    private ShipperService shipperService;

    @GetMapping
    public ResponseEntity<List<ShipperResponse>> getAll() {
        long start = System.currentTimeMillis();
        var result = shipperService.getAll();
        log.info("Got shippers in " + (System.currentTimeMillis()-start) + " milliseconds");
        return ResponseEntity.ok(result);
    }
}
