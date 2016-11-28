package com.luxoft.birdsstore.DAO;

import com.luxoft.birdsstore.model.Bird;
import com.luxoft.birdsstore.model.Goods;
import com.luxoft.birdsstore.model.Money;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 28 2016
 */
public class DAOGoodsFileImpl implements DAOGoods {
    @Override
    public void WriteInStorage(Bird bird) {
        try(FileWriter fw = new FileWriter("Goods.shop",true)) {

            fw.append(bird.getType()+","+bird.getPrice().getAmount()+System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ReadFromStorage() {
        String fileName="Goods.shop";
        Set<Goods> returnSet=new HashSet<>();
        try {
            LineNumberReader reader =
                    new LineNumberReader(
                            new BufferedReader(
                                    new FileReader(fileName)));
            String line;
            while ((line = reader.readLine()) != null) {
                returnSet.add(extractGoods(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Goods extractGoods(String line) {
        String[] tmp = line.split(";");
        String type = tmp[0];
        Money price = Money.dollars(tmp[2]);
        return new Bird(type,price);
    }
}
