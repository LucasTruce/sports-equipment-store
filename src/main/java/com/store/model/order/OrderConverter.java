package com.store.model.order;

import com.store.model.product.ProductConverter;
import com.store.model.user.UserConverter;

import java.util.List;
import java.util.stream.Collectors;

public class OrderConverter {

    public OrderDto map(Order order) {
        UserConverter userConverter = new UserConverter();
        ProductConverter productConverter = new ProductConverter();

        return new OrderDto(
                order.getId(),
                order.getTotalQuantity(),
                order.getTotalPrice(),
                order.isPaid(),
                order.getDate(),
                userConverter.map(order.getUser()),
                productConverter.map(order.getProductList()));
    }

    public Order map(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setDate(orderDto.getDate());
        order.setPaid(orderDto.isPaid());
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setTotalQuantity(orderDto.getTotalQuantity());
        UserConverter userConverter = new UserConverter();
        order.setUser(userConverter.map(orderDto.getUserIdentificationDto()));
        ProductConverter productConverter = new ProductConverter();
        order.setProductList(productConverter.map(orderDto.getProductList()));
        return order;
    }

    public List<OrderDto> map(List<Order> entityObjects){
        return entityObjects.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
