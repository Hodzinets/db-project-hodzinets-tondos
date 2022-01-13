package com.db.app.service.implementation;

import com.db.app.database.model.Category;
import com.db.app.database.repository.CategoryRepository;
import com.db.app.mapper.CategoryMapper;
import com.db.app.model.request.CreateCategoryRequest;
import com.db.app.model.response.CategoryResponse;
import com.db.app.service.CategoryService;
import com.db.app.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(item -> categoryMapper.toCategoryResponse(item))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getById(Long id) {
        Category category = findById(id);
        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public CategoryResponse create(CreateCategoryRequest request) {
        Category newCategory = Category.builder()
                .categoryName(request.getCategoryName())
                .description(request.getDescription())
                .picture(request.getPicture()).build();

        Category category = categoryRepository.save(newCategory);
        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public void delete(Long id) {
        Category category = findById(id);
        categoryRepository.delete(category);
    }

    private Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
    }
}
