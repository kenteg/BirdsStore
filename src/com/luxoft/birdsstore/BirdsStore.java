package com.luxoft.birdsstore;

import com.luxoft.birdsstore.model.Bird;
import com.luxoft.birdsstore.model.Goods;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BirdsStore {
    String name;
    Set<Goods> items = new HashSet<Goods>();
    private static BirdsStore instance;

    private BirdsStore(){

    }

    public static BirdsStore getInstance(){
        if (instance==null){
            instance = new BirdsStore();
        }
        return instance;
    }
    public static void main(String[] args) {
	// write your code here
    }
}
