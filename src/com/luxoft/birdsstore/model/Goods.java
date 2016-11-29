package com.luxoft.birdsstore.model;

import com.luxoft.birdsstore.exceptions.NotEnoughGoodsException;

public interface Goods {

    void setPrice(Money money);
    Money getPrice();

    void sell(int amount) throws NotEnoughGoodsException;
    String getDescription();
    String getName();
}
