package com.luxoft;

import com.luxoft.gui.StoreForm;

/**
 * @author Khrishpens Viktor
 *         created Ноябрь 30 2016
 */
public class Launcher {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StoreForm();
            }
        });
    }
}
