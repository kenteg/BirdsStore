package com.luxoft.test;

import com.luxoft.birdsstore.BirdsStore;
import com.luxoft.birdsstore.model.Bird;
import com.luxoft.birdsstore.model.Buyer;
import com.luxoft.birdsstore.model.Goods;
import com.luxoft.birdsstore.model.Money;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 12 2016
 */
public class tester {

    BirdsStore testStore;
    Bird bird1;
    Bird bird2;

    public tester() {
    }

    @Before
    public void init() {
        testStore = BirdsStore.getInstance();
        bird1 = new Bird("Eagle", Money.dollars("100"));
        bird2 = new Bird("Parrot", Money.dollars("50.5"));
        testStore.addItem(bird1);
        testStore.addItem(bird2);
        bird1.setCount(5);
        bird2.setCount(1);
    }

    @Test
    public void test() {
        Buyer buyer1 = new Buyer("Ivan","Ivanov","IvanIvanov@gmail.com");
        buyer1.addToShoppingCart(bird1);
        buyer1.addToShoppingCart(bird1);
        buyer1.addToShoppingCart(bird1);
        buyer1.addToShoppingCart(bird2);
        System.out.println(buyer1.getShoppingCart());
        buyer1.getShoppingCart().pay();
     //   testStore.sell(bird1, 10);
        //  testStore.sell(bird1, 5);

 /*       assertEquals(testStore.getItems().toString(), "[type Parrot\n" +
                "count 0\n" +
                "price USD 50.50\n" +
                "description null, type Eagle\n" +
                "count 0\n" +
                "price USD 100.00\n" +
                "description null]");
        assertEquals(bird1.getCount(), 0);

        */
    }


}