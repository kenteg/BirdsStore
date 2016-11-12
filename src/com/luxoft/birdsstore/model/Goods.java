package com.luxoft.birdsstore.model;

/**
 * Created by kente on 12.11.2016.
 */
public interface Goods {

    void setPrice(Money money);
    Money getPrice();

    void sell(int amount);
    String getDescription();
}
