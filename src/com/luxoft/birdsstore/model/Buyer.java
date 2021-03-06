package com.luxoft.birdsstore.model;

/**
 * Created by VKhrishpens on 11/24/2016.
 */
public class Buyer {
    private String firstName;
    private String lastName;
    private String email;
    private ShoppingCart shoppingCart;

    public Buyer(String firstName, String lastName, String email, ShoppingCart shoppingCart) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart(){
        return this.shoppingCart;
    }

    public void addToShoppingCart(Goods good){
        shoppingCart.add(good);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
