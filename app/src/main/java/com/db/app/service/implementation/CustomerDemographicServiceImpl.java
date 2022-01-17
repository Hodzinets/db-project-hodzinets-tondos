package com.db.app.service.implementation;

import com.db.app.database.model.CustomerDemographic;
import com.db.app.database.repository.CustomerDemographicRepository;
import com.db.app.mapper.CustomerDemographicMapper;
import com.db.app.model.response.CustomerDemographicResponse;
import com.db.app.service.CustomerDemographicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerDemographicServiceImpl implements CustomerDemographicService {
    @Autowired
    CustomerDemographicRepository customerDemographicRepository;
    @Autowired
    CustomerDemographicMapper customerDemographicMapper;

    @Override
    public List<CustomerDemographicResponse> getAll() {
        List<CustomerDemographic> employees = customerDemographicRepository.findAll();
        return employees.stream().map(item -> customerDemographicMapper.toCustomerDemographicResponse(item)).collect(Collectors.toList());
    }
}
