package com.store.model.productCategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRep;
    private final ProductCategoryConverter productCategoryConverter;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository productCategoryRep) {
        this.productCategoryRep = productCategoryRep;
        this.productCategoryConverter = new ProductCategoryConverter();
    }

    public List<ProductCategoryDto> getCategories(){
        return productCategoryConverter.map(productCategoryRep.findAll());

    }
}
