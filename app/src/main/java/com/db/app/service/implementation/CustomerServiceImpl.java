package com.db.app.service.implementation;

import com.db.app.database.model.Customer;
import com.db.app.database.repository.CustomerRepository;
import com.db.app.mapper.CustomerMapper;
import com.db.app.model.response.CustomerResponse;
import com.db.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<CustomerResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(item -> customerMapper.toCustomerResponse(item)).collect(Collectors.toList());
    }
}
