package com.luxoft.birdsstore;

import com.luxoft.birdsstore.model.Bird;
import com.luxoft.birdsstore.model.Goods;
import com.luxoft.birdsstore.model.Money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
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
    }

    public void addItem(Goods item) {
        items.add(item);
    }

    public Set<Goods> getItems() {
        return items;
    }

    public void sell(Goods item, int amount){
        
    }

}
