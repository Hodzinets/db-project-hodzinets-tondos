package com.db.app.service.implementation;

import com.db.app.database.model.Shipper;
import com.db.app.database.repository.ShipperRepository;
import com.db.app.mapper.ShipperMapper;
import com.db.app.model.response.ShipperResponse;
import com.db.app.service.ShipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipperServiceImpl implements ShipperService {
    @Autowired
    ShipperRepository shipperRepository;
    @Autowired
    ShipperMapper shipperMapper;

    @Override
    public List<ShipperResponse> getAll() {
        List<Shipper> employees = shipperRepository.findAll();
        return employees.stream().map(item -> shipperMapper.toShipperResponse(item)).collect(Collectors.toList());
    }
}
