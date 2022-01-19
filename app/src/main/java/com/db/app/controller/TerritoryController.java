package com.db.app.controller;

import com.db.app.model.response.TerritoryResponse;
import com.db.app.service.TerritoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/territory")
public class TerritoryController {
    @Autowired
    private TerritoryService territoryService;

    @GetMapping
    public ResponseEntity<List<TerritoryResponse>> getAll() {
        long start = System.currentTimeMillis();
        var result = territoryService.getAll();
        log.info("Got territories in " + (System.currentTimeMillis()-start) + " milliseconds");
        return ResponseEntity.ok(result);
    }
}
