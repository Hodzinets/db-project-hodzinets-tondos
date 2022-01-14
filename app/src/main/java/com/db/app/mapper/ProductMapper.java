package com.db.app.mapper;

import com.db.app.database.model.Product;
import com.db.app.model.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    @Autowired
    SupplierMapper supplierMapper;
    @Autowired
    CategoryMapper categoryMapper;

    public ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .supplier(supplierMapper.toSupplierResponse(product.getSupplier()))
                .category(categoryMapper.toCategoryResponse(product.getCategory()))
                .quantityPerUnit(product.getQuantityPerUnit())
                .unitPrice(product.getUnitPrice())
                .unitsInStock(product.getUnitsInStock())
                .unitsOnOrder(product.getUnitsOnOrder())
                .reorderLevel(product.getReorderLevel())
                .discontinued(product.getDiscontinued())
                .build();
    }
}
