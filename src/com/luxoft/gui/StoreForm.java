package com.luxoft.gui;

import com.luxoft.birdsstore.BirdsStore;
import com.luxoft.birdsstore.DAO.DAOGoods;
import com.luxoft.birdsstore.DAO.DAOGoodsFileImpl;
import com.luxoft.birdsstore.DAO.DAOOrder;
import com.luxoft.birdsstore.DAO.DAOOrderFileImpl;
import com.luxoft.birdsstore.Store;
import com.luxoft.birdsstore.model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.*;

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
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JButton addToShoppingCartButton;
    private JButton payButton;
    private JButton addNewGoodButton;
    private JTextField editType;
    private JTextField editPrice;
    private JLabel labelTotal;
    private JList list3;
    private Vector<Goods> goodsList;
    private ShoppingCart tempCart=null;
    private Vector<Goods> shoppingCartList;
    private Vector<Order> orders;

    public StoreForm(){
        super("BirdStore");
        Store birdStore = init();
        addNewGoodButton.addActionListener(e -> {
            OnAddNewGood(birdStore);
        });
        addToShoppingCartButton.addActionListener(e -> {
            OnAddInShopCart();
        });
        payButton.addActionListener(e -> {
            OnPayOrder(birdStore);
        });

        table1.getSelectionModel().addListSelectionListener(e -> {
            OnTableSelectChanged();
        });
    }




    
    private void OnTableSelectChanged() {
        Goods[] array = new Goods[orders.get(table1.getSelectedRow()).getShoppingCart().getItems().size()];
        orders.get(table1.getSelectedRow()).getShoppingCart().getItems().toArray(array);
        list3.setListData(array);
    }

    private void OnPayOrder(Store birdStore) {
        Buyer tempBuyer = new Buyer(firstNameField.getText(),lastNameField.getText(),emailField.getText(),new ShoppingCart(tempCart));
        Order tempOrder = new Order(tempBuyer,tempBuyer.getShoppingCart());
        birdStore.addOrder(tempOrder);
        DAOOrder daoOrder = new DAOOrderFileImpl();
        daoOrder.WriteToStorage(tempOrder);
        orders = new Vector<Order>(birdStore.getOrders());
        //tablemodel
        shoppingCartList.clear();
        tempCart.getItems().clear();
        tempCart.clearTotalPrice();
        list2.setListData(shoppingCartList);
        list2.updateUI();
        table1.updateUI();
    }

    private void OnAddInShopCart() {
        if(tempCart==null){
            tempCart = new ShoppingCart();
        }
        tempCart.add(goodsList.get(list1.getSelectedIndex()));
        shoppingCartList = new Vector<Goods>(tempCart.getItems());
        labelTotal.setText(tempCart.getTotalPrice());
        list2.setListData(shoppingCartList);
        list2.updateUI();
    }

    private void OnAddNewGood(Store birdStore) {
        birdStore.addItem(new Bird(editType.getText(), Money.dollars(editPrice.getText())));
        goodsList = new Vector<Goods>(birdStore.getItems());
        DAOGoods flStrg = new DAOGoodsFileImpl();
        flStrg.WriteInStorage(new Bird(editType.getText(),Money.dollars(editPrice.getText())));
        list1.setListData(goodsList);
        list1.updateUI();
    }

    private Store init() {
        setContentPane(panel1);
        Goods bird1 = new Bird("Eagle", Money.dollars("100"));
        Goods bird2 = new Bird("Parrot", Money.dollars("50.5"));
        Store birdStore = BirdsStore.getInstance();
        birdStore.addItem(bird1);
        birdStore.addItem(bird2);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        goodsList = new Vector<Goods>(birdStore.getItems());
        orders = new Vector<Order>(birdStore.getOrders());
        list1.setListData(goodsList);
        table1.setModel(new OrderTableModel(birdStore.getOrders()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        return birdStore;
    }

}
