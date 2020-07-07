package com.store.model.productCategory;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductCategoryDto {
    private final Long id;
    private final String name;
}
