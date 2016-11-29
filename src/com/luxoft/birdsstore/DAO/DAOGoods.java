package com.luxoft.birdsstore.DAO;

import com.luxoft.birdsstore.model.Bird;
import com.luxoft.birdsstore.model.Goods;

import java.util.Set;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 28 2016
 */
public interface DAOGoods {
    void WriteInStorage(Bird bird);
    Set<Goods> ReadFromStorage();
}
