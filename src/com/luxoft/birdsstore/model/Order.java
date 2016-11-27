package com.luxoft.birdsstore.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 27 2016
 */
public class Order {

    private Buyer buyer;
    private ShoppingCart shoppingCart;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    private LocalDateTime dateTime;

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Order(Buyer buyer, ShoppingCart shoppingCart) {
        this.buyer = buyer;
        this.shoppingCart = shoppingCart;
        this.dateTime = LocalDateTime.now();
    }
}
