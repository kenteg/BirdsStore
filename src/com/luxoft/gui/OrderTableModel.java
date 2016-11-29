package com.luxoft.gui;

import com.luxoft.birdsstore.model.Order;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 27 2016
 */
class OrderTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private List<Order> orders;

    public OrderTableModel(List<Order> orders) {
        this.orders = orders;
    }

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getColumnCount() {
        return 3;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Buyer";
            case 1:
                return "Date";
            case 2:
                return "Total Price";
        }
        return "";
    }

    public int getRowCount() {
        return orders.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Order order = orders.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return order.getBuyer().getFirstName() + order.getBuyer().getLastName();
            case 1:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String formatDateTime = order.getDateTime().format(formatter);
                return order.getDateTime();
            case 2:
                return order.getBuyer().getShoppingCart().getTotalPrice();
        }
        return "";
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {

    }

}

