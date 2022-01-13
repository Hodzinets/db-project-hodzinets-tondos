package com.db.app.model.request;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
@ApiModel
public class CreateCategoryRequest {
    private String categoryName;
    private String description;
    private String picture;
}
