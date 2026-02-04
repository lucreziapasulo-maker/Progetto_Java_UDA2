/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioneFile;

import java.io.File;

/**
 *
 * @author lucrezia.pasulo
 */
public class gestioneFile {

    public static final String FOLDER_MAIN = System.getProperty("user.dir");
    public static final String FOLDER_LIBRI = "Libri";
//    public final String FOLDER_RIVISTE = "Riviste";

    public static void initApp() {

        // Creo le cartelle principali
        File nuovaCartella = new File(FOLDER_MAIN, FOLDER_LIBRI);
       
        if (nuovaCartella.mkdir()) {
            System.out.println("Creazione cartella: " + nuovaCartella.toString());
        } else {
            // Non faccio nulla
        }
    }

    public static void apriFile(File fileDaAprire) {

    }

}
