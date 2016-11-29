package com.luxoft.birdsstore.test;

import com.luxoft.birdsstore.model.Bird;
import com.luxoft.birdsstore.model.Money;
import com.luxoft.birdsstore.model.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 30 2016
 */


public class testShoppingCart {
    ShoppingCart shoppingCart;

    @Before
    public void init() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void testAdd(){
        shoppingCart.add(new Bird("Sparrow", Money.dollars("100")));
        assertEquals(shoppingCart.getItems().get(0).toString(),"Sparrow "+Money.dollars("100"));
    }

    @Test
    public void testTotal(){
        shoppingCart.add(new Bird("Sparrow", Money.dollars("100")));
        shoppingCart.add(new Bird("Aaaa", Money.dollars("100")));
        shoppingCart.add(new Bird("Bbbbb", Money.dollars("100")));
        assertEquals(shoppingCart.getTotal().toString(),Money.dollars("300").toString());
    }


}
