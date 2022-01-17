package com.db.app.service;

import com.db.app.model.response.SupplierResponse;

import java.util.List;

public interface SupplierService {
    List<SupplierResponse> getAll();
}
