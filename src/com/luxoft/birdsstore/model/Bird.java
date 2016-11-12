package com.luxoft.birdsstore.model;

/**
 * @author Khrishpens Viktor
 * created Ноябрь 12 2016
 */
public class Bird extends Animal implements Goods {
    private String type;
    private int count;
    private Money price;

    public void setType(String type) {
        this.type = type;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    @Override
    public void setPrice(Money money) {
        this.price=money;
    }

    @Override
    public Money getPrice() {
        return price;
    }

    @Override
    public void sell(int amount) {

    }

    @Override
    public String getDescription() {
        return description;
    }
}

