/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaccia;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lucrezia.pasulo
 */
public class BCercaTitolo {
    
    
    public static void cercaTitolo(String stringa){
        System.out.println("Ciao");
        
    }
    
//     public static String[] cercaFile(String strToFind) {
//        // Cartella ricette
//        String defBaseFolder = class_Recipe.DEF_BASE_FOLDER;
//        // ArrayList che conterrà le ricette trovate
//        ArrayList<String> listaRicette = new ArrayList<String>();
//
//        String strTmp;
//
//        // Carico la lista di tutti i file
//        File folder = new File(defBaseFolder);
//        File[] listFiles = folder.listFiles();
//
//        //System.out.println("\nstrToFind = " + strToFind);// Tengo in considerazione sono i file che mi interessano        
//        for (int i = 0; i <= listFiles.length - 1; i++) {
//            strTmp = listFiles[i].getName();
//
//            // Faccio una ricerca case-insensitive
//            Pattern pttrn = Pattern.compile(strToFind, Pattern.CASE_INSENSITIVE);
//            Matcher mtchr = pttrn.matcher(strTmp);
//
//            if (mtchr.find()) {
//                listaRicette.add(strTmp);
//            }
//        }
//
//        // Converto la ArrayList in String[], altrimenti non riesco visualizzarla sul frame
//        String[] strTmp2 = new String[listaRicette.size()];
//        for (int i = 0; i < strTmp2.length; i++) {
//            strTmp2[i] = listaRicette.get(i);
//        }
//
//        return strTmp2;
//    }
    
}
