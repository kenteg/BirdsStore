package com.luxoft.birdsstore.DAO;

import com.luxoft.birdsstore.model.Bird;
import com.luxoft.birdsstore.model.Goods;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by VKhrishpens on 11/29/2016.
 */
public class DAOGoodsMemoryImpl implements DAOGoods {
    Set<Goods> inMemorySet = new HashSet<>();
    @Override
    public void WriteInStorage(Bird bird) {
    inMemorySet.add(bird);
    }

    @Override
    public Set<Goods> ReadFromStorage() {
        return inMemorySet;
    }
}
