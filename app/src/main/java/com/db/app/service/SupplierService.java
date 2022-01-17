package com.db.app.service;

import com.db.app.model.request.CreateCategoryRequest;
import com.db.app.model.request.UpdateCategoryRequest;
import com.db.app.model.response.CategoryResponse;
import com.db.app.model.response.SupplierResponse;

import java.util.List;

public interface SupplierService {
    List<SupplierResponse> getAll();

    SupplierResponse getById(Long id);

//    SupplierResponse create(CreateSupplierReques request);

//    SupplierResponse update(Long id, UpdateSupplierRequest request);

    void delete(Long id);
}
