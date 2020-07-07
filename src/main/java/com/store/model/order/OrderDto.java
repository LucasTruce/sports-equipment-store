package com.store.model.order;

import com.store.model.product.ProductDto;
import com.store.model.user.UserIdentificationDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class OrderDto {

    private final Long id;
    private final int totalQuantity;
    private final double totalPrice;
    private final boolean paid;
    private final LocalDateTime date;
    private final UserIdentificationDto userIdentificationDto;
    private final List<ProductDto> productList;
}
