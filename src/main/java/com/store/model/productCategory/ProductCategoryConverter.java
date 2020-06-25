package com.store.model.productCategory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductCategoryConverter {
    public ProductCategoryDto entityToDto(ProductCategory productCategory) {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setId(productCategory.getId());
        productCategoryDto.setName(productCategory.getName());
        return productCategoryDto;
    }

    public ProductCategory dtoToEntity(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryDto.getId());
        productCategory.setName(productCategoryDto.getName());
        return productCategory;
    }

    public List<ProductCategoryDto> convertAllToDto(List<ProductCategory> entityObjects){
        return entityObjects.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}
