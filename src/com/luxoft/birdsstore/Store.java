package com.luxoft.birdsstore;

import com.luxoft.birdsstore.model.Goods;

import java.util.List;
import java.util.Set;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 12 2016
 */
public interface Store {
    void addItem(Goods item);
    List<Goods> getItems();
    void sell(Goods item,int amount);
}
