package com.luxoft.birdsstore.DAO;

import com.luxoft.birdsstore.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

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
     //   fwShCart.append(order.getBuyer().getShoppingCart().getTotalAmount()+System.lineSeparator());
        for(Goods curGood:currentShpCartItems) {
            fwShCart.append(curGood.getName()+","+curGood.getPrice().getAmount()+";");
        }
        fwShCart.append(System.lineSeparator());
    }

    @Override
    public List ReadFromStorage() {
        List <Order> returnList = new ArrayList<>();
        ShoppingCart shoppingCart;
        Buyer buyer;
        Order order;
        try (
                LineNumberReader reader = new LineNumberReader(
                new BufferedReader(new FileReader("ShopCart.shop")));
                LineNumberReader reader2 = new LineNumberReader(
                        new BufferedReader(new FileReader("Buyer.shop")));
                LineNumberReader reader3 = new LineNumberReader(
                        new BufferedReader(new FileReader("Orders.shop")));
        ){
            String line;
            String line1;
            String line2;
            while ((line = reader.readLine()) != null) {
                String[] tmp = line.split(";");
                shoppingCart = new ShoppingCart();
                for (String aTmp : tmp){
                    String[] item=aTmp.split(",");
                    String name=item[0];
                    Money price = Money.dollars(item[1]);
                    shoppingCart.add(new Bird(name,price));
                }
                line1=reader2.readLine();
                String[] tmp2 = line1.split(",");
                buyer=new Buyer(tmp2[0],tmp2[1],tmp2[2],shoppingCart);

                line2=reader3.readLine();
                order = new Order(buyer,buyer.getShoppingCart());
                returnList.add(order);

            }
        }
        catch (FileNotFoundException fnf) {
            return returnList;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

   return returnList;
    }
}
