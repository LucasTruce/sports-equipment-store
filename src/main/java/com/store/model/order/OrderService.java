package com.store.model.order;

import com.store.model.product.Product;
import com.store.model.product.ProductRepository;
import com.store.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderConverter = new OrderConverter();
    }

    public OrderDto save(OrderDto orderDto) {
        Order order = orderConverter.map(orderDto);
        order.setUser(userRepository.getOne(orderDto.getUserIdentificationDto().getId()));
        List<Product> products = new ArrayList<>();
        orderDto.getProductList().forEach(p -> products.add(productRepository.getOne(p.getId())));
        order.setProductList(products);

        return orderConverter.map(orderRepository.save(order));
    }

    public List<OrderDto> getOrders() {
        return orderConverter.map(orderRepository.findAll());
    }
}
