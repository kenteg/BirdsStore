package com.luxoft.birdsstore.model;

import com.luxoft.birdsstore.exceptions.NotEnoughGoodsException;

/**
 * @author Khrishpens Viktor
 * created Ноябрь 12 2016
 */
public interface Goods {

    void setPrice(Money money);
    Money getPrice();

    void sell(int amount) throws NotEnoughGoodsException;
    String getDescription();
}
