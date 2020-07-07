package com.store.model.product;

import com.store.model.productCategory.ProductCategoryConverter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProductConverter {

    public ProductDto map(Product product) {

        ProductCategoryConverter categoryConverter = new ProductCategoryConverter();

        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getUnitPrice(),
                product.getImageUrl(),
                product.isActive(),
                product.getUnitsInStock(),
                categoryConverter.map(product.getCategory())
        );
    }

    public Product map(ProductDto productDto) {
        ProductCategoryConverter categoryConverter = new ProductCategoryConverter();

        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setActive(productDto.isActive());
        product.setUnitsInStock(productDto.getUnitsInStock());
        product.setCategory(categoryConverter.map(productDto.getCategory()));
        return product;
    }

    public List<ProductDto> map(List<Product> entityObjects){
        return entityObjects.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public List<Product> map(Collection<ProductDto> entityObjects){
        return entityObjects.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

}
