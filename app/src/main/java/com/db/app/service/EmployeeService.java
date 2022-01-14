package com.db.app.service;

import com.db.app.model.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getAll();
}
