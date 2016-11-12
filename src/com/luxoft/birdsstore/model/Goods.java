package com.luxoft.birdsstore.model;

/**
 * @author Khrishpens Viktor
 * created Ноябрь 12 2016
 */
public interface Goods {

    void setPrice(Money money);
    Money getPrice();

    void sell(int amount);
    String getDescription();
}
