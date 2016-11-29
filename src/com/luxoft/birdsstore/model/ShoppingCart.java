package com.luxoft.birdsstore.model;

import com.luxoft.birdsstore.exceptions.NotEnoughGoodsException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * Created by VKhrishpens on 11/25/2016.
 */
public class ShoppingCart {
    List<Goods> goods = new ArrayList<>();

    public ShoppingCart() {
        this.totalPrice = new Money(BigDecimal.ZERO, Currency.getInstance("USD"));
    }

    public ShoppingCart(ShoppingCart copy){
        this.goods = new ArrayList<>(copy.getItems());
        this.totalPrice = copy.getTotal();
    }

    public String getTotalPrice() {
        return totalPrice.toString();
    }

    public Money getTotal() {
        return totalPrice;
    }

    private Money totalPrice;

    public void add(Goods good){
        BigDecimal temp= totalPrice.getAmount();
        temp= good.getPrice().getAmount().add(temp);
        totalPrice = Money.dollars(temp.toString());
        goods.add(good);
    }

    public void remove(Goods good){
        goods.remove(good);
    }

    public List<Goods> getItems(){
        return goods;
    }

    public void clearTotalPrice(){
        totalPrice = Money.dollars("0.00");
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
