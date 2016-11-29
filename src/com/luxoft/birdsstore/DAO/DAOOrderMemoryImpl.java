package com.luxoft.birdsstore.DAO;

import com.luxoft.birdsstore.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 30 2016
 */
public class DAOOrderMemoryImpl implements DAOOrder{
    @Override
    public void WriteToStorage(Order order) {
        List<Order> memoryList = new ArrayList<>();
        memoryList.add(order);
    }

    @Override
    public List ReadFromStorage() {
        return null;
    }
}
