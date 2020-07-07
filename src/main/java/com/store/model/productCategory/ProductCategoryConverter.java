package com.store.model.productCategory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductCategoryConverter {

    public ProductCategoryDto map(ProductCategory productCategory) {

        return new ProductCategoryDto(
                productCategory.getId(),
                productCategory.getName()
        );
    }

    public ProductCategory map(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryDto.getId());
        productCategory.setName(productCategoryDto.getName());
        return productCategory;
    }

    public List<ProductCategoryDto> map(List<ProductCategory> entityObjects){
        return entityObjects.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
