package com.db.app.service.implementation;

import com.db.app.database.model.Territory;
import com.db.app.database.repository.TerritoryRepository;
import com.db.app.mapper.TerritoryMapper;
import com.db.app.model.response.TerritoryResponse;
import com.db.app.service.TerritoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TerritoryServiceImpl implements TerritoryService {
    @Autowired
    TerritoryRepository territoryRepository;
    @Autowired
    TerritoryMapper territoryMapper;

    @Override
    public List<TerritoryResponse> getAll() {
        List<Territory> employees = territoryRepository.findAll();
        return employees.stream().map(item -> territoryMapper.toTerritoryResponse(item)).collect(Collectors.toList());
    }
}
