package com.store.model.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.store.model.product.Product;
import com.store.model.user.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order", schema = "storedb")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_Quantity")
    private int totalQuantity;

    @Column(name = "total_Price")
    private double totalPrice;

    @Column(name = "paid")
    private boolean paid;

    @CreationTimestamp
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "order_product", schema = "storedb", joinColumns = {
            @JoinColumn(name = "order_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "id") })
    private List<Product> productList;

}
