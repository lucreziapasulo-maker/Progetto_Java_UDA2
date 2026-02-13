/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.progettouda2;

import interfaccia.FrameBiblioteca;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import materiale.Libro;
import materiale.ListaMateriale;
import materiale.MaterialeBiblioteca;
import materiale.MaterialeBiblioteca.genereMateriale;
/**
 *
 * @author lucrezia.pasulo
 */
public class ProgettoUDA2 {


    
    /*
    Il progetto si propone di gestire una libreria, con utenti e libri
     */
    public static void main(String[] args) {

        Libro libro1 = new Libro();
        libro1.titolo = "LOTR";
        libro1.anno = 1920;
//        libro1.genere = genereMateriale.FANTASY;

//        System.out.println(libro1.toString());
//        List<MaterialeBiblioteca> listaMateriale = new ArrayList<>();
//        listaMateriale.add(libro1);
        // For each -> stampa
        //            System.out.println(n.toString());
        java.awt.EventQueue.invokeLater(() -> {
            new FrameBiblioteca().setVisible(true);
        });

    }

}
