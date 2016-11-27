package com.luxoft.birdsstore;

import com.luxoft.birdsstore.model.Goods;
import com.luxoft.birdsstore.model.Order;

import java.util.List;
import java.util.Set;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 12 2016
 */
public interface Store {
    void addItem(Goods item);
    void addOrder(Order order);
    List<Order> getOrders();
    List<Goods> getItems();
    void sell(Goods item,int amount);
}
