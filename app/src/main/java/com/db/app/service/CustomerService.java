package com.db.app.service;

import com.db.app.model.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerResponse> getAll();
}
