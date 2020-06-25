package com.store.model.product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductConverter {

    public ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setUnitPrice(product.getUnitPrice());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setActive(product.isActive());
        productDto.setUnitsInStock(product.getUnitsInStock());
        productDto.setDateCreated(product.getDateCreated());
        productDto.setLastUpdated(product.getLastUpdated());
        productDto.setCategory(product.getCategory());
        return productDto;
    }

    public Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setActive(productDto.isActive());
        product.setUnitsInStock(productDto.getUnitsInStock());
        product.setDateCreated(productDto.getDateCreated());
        product.setLastUpdated(productDto.getLastUpdated());
        product.setCategory(productDto.getCategory());
        return product;
    }

    public List<ProductDto> convertAllToDto(List<Product> entityObjects){
        return entityObjects.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}
