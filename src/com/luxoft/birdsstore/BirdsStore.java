package com.luxoft.birdsstore;

import com.luxoft.birdsstore.exceptions.NotEnoughGoodsException;
import com.luxoft.birdsstore.model.Bird;
import com.luxoft.birdsstore.model.Goods;
import com.luxoft.birdsstore.model.Money;
import com.luxoft.gui.StoreForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BirdsStore implements Store {
    String name;

    Set<Goods> items = new HashSet<Goods>();
    private static BirdsStore instance;

    private BirdsStore() {

    }

    public static BirdsStore getInstance() {
        if (instance == null) {
            instance = new BirdsStore();
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
