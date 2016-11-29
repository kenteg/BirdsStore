package com.luxoft.birdsstore.DAO;

import com.luxoft.birdsstore.model.Order;

import java.util.List;

/**
 * Created by VKhrishpens on 11/29/2016.
 */
public interface DAOOrder {
    void WriteToStorage(Order order);
    List ReadFromStorage();
}
