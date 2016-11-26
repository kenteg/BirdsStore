package com.luxoft.birdsstore.model;

import com.luxoft.birdsstore.exceptions.NotEnoughGoodsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VKhrishpens on 11/25/2016.
 */
public class ShoppingCart {
    List<Goods> goods = new ArrayList<>();

    public void add(Goods good){
        goods.add(good);
    }

    public void remove(Goods good){
        goods.remove(good);
    }

    public void pay(){
        try {
            for(Goods item:goods) item.sell(1);
        }
        catch (NotEnoughGoodsException e){
            e.printStackTrace();
        }
            
        }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(Goods item:goods) sb.append(item+"\n");
        return sb.toString();
    }
}
