package com.luxoft.birdsstore.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
    public Order(Buyer buyer, ShoppingCart shoppingCart, String dateTime) {
        this.buyer = buyer;
        this.shoppingCart = shoppingCart;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.dateTime = LocalDateTime.parse(dateTime,formatter);
    }
}
