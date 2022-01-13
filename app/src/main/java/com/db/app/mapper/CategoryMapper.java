package com.db.app.mapper;

import com.db.app.database.model.Category;
import com.db.app.model.response.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .description(category.getDescription())
                .picture(category.getPicture())
                .build();
    }
}
