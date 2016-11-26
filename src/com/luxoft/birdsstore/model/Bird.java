package com.luxoft.birdsstore.model;

import com.luxoft.birdsstore.exceptions.NotEnoughGoodsException;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 12 2016
 */
public class Bird extends Animal implements Goods {
    private String type;
    private int count;
    private Money price;

    public Bird(String type, Money price) {
        this.type = type;
        this.price = price;
    }

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
        this.price = money;
    }

    @Override
    public Money getPrice() {
        return price;
    }

    @Override
    public void sell(int amount) throws NotEnoughGoodsException {
        if((count-amount)<0) {
            throw new NotEnoughGoodsException("Not enough Birds in Stock");
        }
        count -= amount;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return type+" "+price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bird bird = (Bird) o;

        return type.equals(bird.type);

    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    public int getCount() {
        return count;
    }

    public String getType() {
        return type;
    }
}

