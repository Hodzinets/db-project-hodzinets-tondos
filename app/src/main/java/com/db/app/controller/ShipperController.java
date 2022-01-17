package com.db.app.controller;

import com.db.app.model.response.ShipperResponse;
import com.db.app.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shipper")
public class ShipperController {
    @Autowired
    private ShipperService shipperService;

    @GetMapping
    public ResponseEntity<List<ShipperResponse>> getAll() {
        return ResponseEntity.ok(shipperService.getAll());
    }
}
