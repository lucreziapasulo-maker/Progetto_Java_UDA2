/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioneFile;

import java.io.File;
import materiale.MaterialeBiblioteca;

/**
 *
 * @author lucrezia.pasulo
 */
public class CreaFile {
    
    public static void creaFile (String fileName, MaterialeBiblioteca materiale){
        File fileTOwrite = new File(fileName);
        
        
    }
}
    
    
}


private static File creaFile(String fileName) {
//////        File fileTOwrite = new File(fileName);
//////
//////        // Creo il file
//////        System.out.println("fileName = " + fileName);
//////
//////        // Se non esiste il file, lo creo
//////        if (!fileTOwrite.exists()) {
//////            try {
//////                fileTOwrite.createNewFile();
//////            } catch (IOException ex) {
//////                Logger.getLogger(NewRecipeFrame.class.getName()).log(Level.SEVERE, null, ex);
//////            }
//////        }
//////
//////        return fileTOwrite;
//////    }