package com.luxoft.birdsstore.DAO;

import com.luxoft.birdsstore.model.Goods;
import com.luxoft.birdsstore.model.Order;
import com.luxoft.birdsstore.model.ShoppingCart;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by VKhrishpens on 11/29/2016.
 */
public class DAOOrderFileImpl implements DAOOrder {
    @Override
    public void WriteToStorage(Order order) {
        try(FileWriter fwOrder = new FileWriter("Orders.shop",true);
            FileWriter fwBuyer = new FileWriter("Buyer.shop", true);
            FileWriter fwShCart = new FileWriter("ShopCart.shop", true);
        )
        {
            WriteBuyer(order, fwBuyer);
            WriteShoppingCart(order, fwShCart);
            WriteOrder(order, fwOrder);
        }
        catch(IOException e){
        e.printStackTrace();
        }
    }

    private void WriteOrder(Order order, FileWriter fwOrder) throws IOException {
        fwOrder.append(order.getDateTime().toString()+System.lineSeparator());
    }

    private void WriteBuyer(Order order, FileWriter fwBuyer) throws IOException {
        fwBuyer.append(order.getBuyer().getFirstName()+','+order.getBuyer().getLastName()+','+order.getBuyer().getEmail()+System.lineSeparator());
    }

    private void WriteShoppingCart(Order order, FileWriter fwShCart) throws IOException {
        List<Goods> currentShpCartItems = order.getBuyer().getShoppingCart().getItems();
        fwShCart.append(order.getBuyer().getShoppingCart().getTotalPrice());
        for(Goods curGood:currentShpCartItems) {
            fwShCart.append(curGood.toString()+",");
        }
        fwShCart.append(System.lineSeparator());
    }

    @Override
    public List ReadFromStorage() {
        return null;
    }
}
