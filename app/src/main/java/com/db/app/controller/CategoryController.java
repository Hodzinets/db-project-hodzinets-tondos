package com.db.app.controller;

import com.db.app.model.request.CreateCategoryRequest;
import com.db.app.model.request.UpdateCategoryRequest;
import com.db.app.model.response.CategoryResponse;
import com.db.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable("categoryId") Long id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CreateCategoryRequest request) {
        return ResponseEntity.ok(categoryService.create(request));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> update(@PathVariable("categoryId") Long id,
                                                   @RequestBody UpdateCategoryRequest request) {
        return ResponseEntity.ok(categoryService.update(id, request));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity delete(@PathVariable("categoryId") Long id) {
        categoryService.delete(id);

        return ResponseEntity.ok().build();
    }
}
