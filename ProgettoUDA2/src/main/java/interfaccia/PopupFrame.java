/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaccia;

import javax.swing.JOptionPane;

/**
 *
 * @author lu242
 */
public class PopupFrame {

    public static int confirmPopup(String testo) {
        int result = JOptionPane.showConfirmDialog(null, testo);          
        return result;
    }

    public static void alertPopup(String testo) {
        JOptionPane.showMessageDialog(null, testo);
    }

}
