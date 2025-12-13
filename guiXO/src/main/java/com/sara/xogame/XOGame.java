
package com.sara.xogame;
import javax.swing.JOptionPane;
public class XOGame {
    public static void main(String[] args) {
        gui gd = new gui(630, 630);
        gd.setUpGUI();
        gd.setUpButtonListeners();
    }
}
