package com.luxoft.gui;

import com.luxoft.birdsstore.BirdsStore;
import com.luxoft.birdsstore.Store;
import com.luxoft.birdsstore.model.Bird;
import com.luxoft.birdsstore.model.Goods;
import com.luxoft.birdsstore.model.Money;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import static javafx.scene.input.KeyCode.J;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 23 2016
 */
public class StoreForm extends JFrame{
    private JTable table1;
    private JPanel panel1;
    private JList list1;
    private JList list2;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton addToShoppingCartButton;
    private JButton payButton;
    private JButton addNewGoodButton;
    private JTextField editType;
    private JTextField editPrice;

    public StoreForm(){
        super("BirdStore");
        setContentPane(panel1);
        Goods bird1 = new Bird("Eagle", Money.dollars("100"));
        Goods bird2 = new Bird("Parrot", Money.dollars("50.5"));
        Store birdStore = BirdsStore.getInstance();
        birdStore.addItem(bird1);
        birdStore.addItem(bird2);
        Vector<Goods> goodsList = new Vector<Goods>(birdStore.getItems());
        list1.setListData(goodsList);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        addNewGoodButton.addActionListener(e -> {
            birdStore.addItem(new Bird(editType.getText(),Money.dollars(editPrice.getText())));
            Vector<Goods> goodsList1 = new Vector<Goods>(birdStore.getItems());
            list1.setListData(goodsList1);
            list1.updateUI();
        });
    }

    public static void main(String[] args) {

    }
}
