package com.luxoft.birdsstore;

import com.luxoft.birdsstore.DAO.DAOGoods;
import com.luxoft.birdsstore.DAO.DAOGoodsFileImpl;
import com.luxoft.birdsstore.DAO.DAOOrder;
import com.luxoft.birdsstore.DAO.DAOOrderFileImpl;
import com.luxoft.birdsstore.exceptions.NotEnoughGoodsException;
import com.luxoft.birdsstore.model.Goods;
import com.luxoft.birdsstore.model.Order;
import com.luxoft.gui.StoreForm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BirdsStore implements Store {
    String name;

    Set<Goods> items = new HashSet<Goods>();

    List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getOrders() {
        return orders;
    }
    private static BirdsStore instance;

    private BirdsStore() {

    }

    public static BirdsStore getInstance() {
        if (instance == null) {
            instance = new BirdsStore();
            DAOGoods daoGoods = new DAOGoodsFileImpl();
            instance.items=daoGoods.ReadFromStorage();
            DAOOrder daoOrder = new DAOOrderFileImpl();
            instance.orders = daoOrder.ReadFromStorage();
        }
        return instance;
    }

    public static void main(String[] args) {
        // write your code here
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StoreForm();
            }
        });
    }

    public void addItem(Goods item) {
        items.add(item);
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public List<Goods> getItems() {
        List<Goods> getGoods = new ArrayList<>();
        getGoods.addAll(items);
        return getGoods;
    }

    public void sell(Goods item, int amount){
        try {
            item.sell(amount);
        }
        catch (NotEnoughGoodsException nege){
            System.err.println(nege.getMessage());
        }
    }

}
