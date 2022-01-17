package com.db.app.service.implementation;

import com.db.app.database.model.Region;
import com.db.app.database.repository.RegionRepository;
import com.db.app.mapper.RegionMapper;
import com.db.app.model.response.RegionResponse;
import com.db.app.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    RegionMapper regionMapper;

    @Override
    public List<RegionResponse> getAll() {
        List<Region> employees = regionRepository.findAll();
        return employees.stream().map(item -> regionMapper.toRegionResponse(item)).collect(Collectors.toList());
    }
}
