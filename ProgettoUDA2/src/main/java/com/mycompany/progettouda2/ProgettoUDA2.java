/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.progettouda2;

import interfaccia.FrameBiblioteca;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author lucrezia.pasulo
 */
public class ProgettoUDA2 {

    public static void main(String[] args) {
            public static final Logger LOG_PRINCIPALE = LogManager.getLogger(ProgettoUDA2.class);

        LOG_FRAMEINVENTARIO.info("Materiale eliminato con successo sia dalla lista che dalla cartella");

        java.awt.EventQueue.invokeLater(() -> {
            new FrameBiblioteca().setVisible(true);
        });

    }

    public ProgettoUDA2() {
    }

}
