package com.db.app.service;

import com.db.app.model.request.CreateCategoryRequest;
import com.db.app.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAll();

    CategoryResponse getById(Long id);

    CategoryResponse create(CreateCategoryRequest request);

    void delete(Long id);
}
