package com.store.model.product;

import com.store.model.productCategory.ProductCategoryDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class ProductDto {

    private final Long id;
    private final String name;
    private final String description;
    private final BigDecimal unitPrice;
    private final String imageUrl;
    private final boolean active;
    private final int unitsInStock;
    private final ProductCategoryDto category;
}
