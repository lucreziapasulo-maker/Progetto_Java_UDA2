/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.progettouda2;

import interfaccia.FrameBiblioteca;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author lucrezia.pasulo
 */
public class ProgettoUDA2 {
    
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            new FrameBiblioteca().setVisible(true);            
        });

    }

    public ProgettoUDA2() {
    }

}
