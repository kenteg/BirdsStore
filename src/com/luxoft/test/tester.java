package com.luxoft.test;

import com.luxoft.birdsstore.BirdsStore;
import com.luxoft.birdsstore.model.Bird;
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

    public tester(){
    }

    @Before
    public void init(){
        testStore = BirdsStore.getInstance();
        Bird bird1 = new Bird("Eagle", Money.dollars("100"));
        Bird bird2 = new Bird("Parrot", Money.dollars("50.5"));
        testStore.addBird(bird1);
        testStore.addBird(bird2);
    }

    @Test
    public void test() {
        assertEquals(testStore.getItems().toString(),"[type Parrot\n" +
                "count 0\n" +
                "price USD 50.50\n" +
                "description null, type Eagle\n" +
                "count 0\n" +
                "price USD 100.00\n" +
                "description null]");
    }

}