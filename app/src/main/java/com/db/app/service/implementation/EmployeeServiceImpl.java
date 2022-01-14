package com.db.app.service.implementation;

import com.db.app.database.model.Employee;
import com.db.app.database.repository.EmployeeRepository;
import com.db.app.mapper.EmployeeMapper;
import com.db.app.model.response.EmployeeResponse;
import com.db.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(item -> employeeMapper.toEmployeeResponse(item)).collect(Collectors.toList());
    }
}
