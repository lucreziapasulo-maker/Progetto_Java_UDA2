/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioneFile;

import interfaccia.PopupFrame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import materiale.AudioVisivo;
import materiale.Libro;
import materiale.MaterialeBiblioteca;
import materiale.Rivista;

/**
 *
 * @author lucrezia.pasulo
 */
public class GestioneFile {

    /*
    Vengono create tante cartelle quanti sono i tipi di MaterialeBiblioteca 
    (presi da enum tipoMateriale).
     */
    public static final String FOLDER_MAIN = System.getProperty("user.dir");
    public static final String FOLDER_LIBRI = MaterialeBiblioteca.tipoMateriale.LIBRO.toString();
    public static final String FOLDER_RIVISTE = MaterialeBiblioteca.tipoMateriale.RIVISTA.toString();
    public static final String FOLDER_AUDIOVISIVO = MaterialeBiblioteca.tipoMateriale.AUDIOVISIVO.toString();
    private static final String ESTENSIONE = ".txt";

    /*
    -- Metodo per prima creazione cartelle di default
     */
    public static void initApp() {

        // Creazione delle cartelle principali
        ArrayList listaFolder = new ArrayList();
        listaFolder.add(FOLDER_LIBRI);
        listaFolder.add(FOLDER_RIVISTE);
        listaFolder.add(FOLDER_AUDIOVISIVO);

        for (Object each : listaFolder) {
            String folderAttuale = each.toString();
            File nuovaCartella = new File(FOLDER_MAIN, folderAttuale);

            if (nuovaCartella.mkdir()) {
                System.out.println("Creazione cartella: " + nuovaCartella.toString());
            } else {
                // Non faccio nulla
            }
        }
    }

    //------
    // TODO: non funziona!! Quando richiamo materiale.[cose] 
    public static void creaLibroTEST(String titolo, Libro materiale) {
        String fileName = titolo + ESTENSIONE;
        File fileTOwrite = new File(FOLDER_LIBRI, fileName);

        System.out.println("Creazione file: " + fileTOwrite.getName());

        String testo;

//      Creazione file
        if (!fileTOwrite.exists()) {
            try {
                fileTOwrite.createNewFile();
                // Scrivo il file
                PrintWriter writer = new PrintWriter(fileTOwrite);

                // Scrivo il contenuto nel file
                writer.write(materiale.contenutoTOwrite());

                // Pulisco il writer e lo chiudo
                writer.flush();
                writer.close();

            } catch (Exception e) {
                testo = "Errore nella creazione del file " + fileTOwrite.getName();
                System.out.println(testo);
                PopupFrame.alertPopup(testo);
            }
        } else {
            // Chiedo se sovrascrivere il file
            testo = "Esiste già un file di questo libro, si intende sovrascriverlo?";
            int ok = PopupFrame.confirmPopup(testo);

            if (ok == 1) {
                try {
                    fileTOwrite.createNewFile();
                } catch (Exception e) {
                    testo = "Errore nella creazione del file " + fileTOwrite.getName();
                    System.out.println(testo);
                }
            } else {
                // Non faccio nulla
            }
        }
    }

    /*
    -- 
     */
    public static void creaLibro(String titolo, Libro materiale) {
        String fileName = titolo + ESTENSIONE;
        File fileTOwrite = new File(FOLDER_LIBRI, fileName);

        creaFile(fileTOwrite, materiale);
    }

    public static void creaRivista(String titolo, Rivista materiale) {
        String fileName = titolo + ESTENSIONE;
        File fileTOwrite = new File(FOLDER_RIVISTE, fileName);

        creaFile(fileTOwrite, materiale);
    }

    public static void creaAudioVisivo(String titolo, AudioVisivo materiale) {
        String fileName = titolo + ESTENSIONE;
        File fileTOwrite = new File(FOLDER_AUDIOVISIVO, fileName);

        creaFile(fileTOwrite, materiale);
    }


    /*
    -- Metodo per creare il file
     */
    private static void creaFile(File fileTOwrite, MaterialeBiblioteca materiale) {
        System.out.println("Creazione file: " + fileTOwrite.getName());

        String testo;

//      Creazione file
        if (!fileTOwrite.exists()) {
            try {
                fileTOwrite.createNewFile();
                // Scrivo il file
                materiale.contenutoTOwrite();
                boolean esito = scriviFile(fileTOwrite, materiale);
                if (esito) {
                    PopupFrame.alertPopup("File " + fileTOwrite.getName() + " creato correttamente");
                } else {
                    PopupFrame.alertPopup("Problemi nella scrittura del file " + fileTOwrite.getName());
                }
            } catch (Exception e) {
                testo = "Errore nella creazione del file " + fileTOwrite.getName();
                System.out.println(testo);
                PopupFrame.alertPopup(testo);
            }
        } else {
            // Chiedo se sovrascrivere il file
            testo = "Esiste già un file di questo libro, si intende sovrascriverlo?";
            int ok = PopupFrame.confirmPopup(testo);

            if (ok == 1) {
                try {
                    fileTOwrite.createNewFile();
                } catch (Exception e) {
                    testo = "Errore nella creazione del file " + fileTOwrite.getName();
                    System.out.println(testo);
                }
            } else {
                // Non faccio nulla
            }
        }
    }

    /*
    -- Metodo per scrivere il contenuto nel file
     */
    public static boolean scriviFile(File fileTOwrite, MaterialeBiblioteca materiale) {
        try {
            PrintWriter writer = new PrintWriter(fileTOwrite);

            // Scrivo il contenuto nel file
            writer.write(materiale.contenutoTOwrite());

            // Pulisco il writer e lo chiudo
            writer.flush();
            writer.close();

            return true;

        } catch (Exception e) {

        }
        return false;
    }

}

//////
//////
//////   // Apro il file
//////    public static void mostraContenutoFile(String ricDaAprire) {
//////
//////        String fileDaAprire = DEF_BASE_FOLDER + "\\" + ricDaAprire;
//////        //System.out.println("fileDaAprire = " + fileDaAprire);
//////
//////        // set della current recipe        
//////        Recipe.currentRecipeName = ricDaAprire;
//////
//////        try {
//////            BufferedReader reader = new BufferedReader(new FileReader(fileDaAprire));
//////
//////            scriviFrameLettura(reader);
//////
//////        } catch (Exception e) {
//////            System.out.println("Errore nell'apertura del file");
//////        }
//////    }
//////
//////    // Cerco la ricetta che vuole l'utente
//////    public static String[] cercaFile(String strToFind) {
//////        // Cartella ricette
//////        String defBaseFolder = Recipe.DEF_BASE_FOLDER;
//////        // ArrayList che conterrà le ricette trovate
//////        ArrayList<String> listaRicette = new ArrayList<String>();
//////
//////        String strTmp;
//////
//////        // Carico la lista di tutti i file
//////        File folder = new File(defBaseFolder);
//////        File[] listFiles = folder.listFiles();
//////
//////        //System.out.println("\nstrToFind = " + strToFind);// Tengo in considerazione sono i file che mi interessano        
//////        for (int i = 0; i <= listFiles.length - 1; i++) {
//////            strTmp = listFiles[i].getName();
//////
//////            strTmp = strTmp.toLowerCase();
//////            strToFind = strToFind.toLowerCase();
//////
//////            if (strTmp.contains(strToFind)) {
//////                listaRicette.add(strTmp);
//////            }
//////        }
//////
//////        // Converto la ArrayList in String[], altrimenti non riesco visualizzarla sul frame
//////        String[] strTmp2 = new String[listaRicette.size()];
//////        for (int i = 0; i < strTmp2.length; i++) {
//////            strTmp2[i] = listaRicette.get(i);
//////        }
//////
//////        return strTmp2;
//////    }
//////
//////    // Creo il frame per visualizzare la ricetta richiesta
//////    public static void scriviFrameLettura(BufferedReader reader) {
//////
//////        // Creo il frame
//////        FrameLettura frameLettura = new FrameLettura();
//////
//////        // Aggiungo l'area di lettura
//////        JTextArea areaLettura = frameLettura.getAreaTesto();
//////
//////        // Estrapolo il testo della ricetta
//////        try {
//////            System.out.println("Leggo dal file");
//////
//////            String line = reader.readLine();
//////            // Uso StringBuilder al posto di una lista o ArrayList per non visualizzare caratteri separatori
//////            StringBuilder testo = new StringBuilder();
//////
//////            testo.append(line);
//////
//////            while ((line = reader.readLine()) != null) {
//////                testo.append(line).append("\n");
//////                //System.out.println("testo = " + testo);
//////            }
//////
//////            //System.out.println("testo = " + testo);
//////            // Scrivo sull'area
//////            areaLettura.setText(testo.toString());
//////
//////        } catch (Exception e) {
//////            System.out.println("Errore nella lettura del file");
//////        }
//////    }
//////
//////    // Creo il file con dentro la ricetta
//////    public static int creaNuovaRicetta(Recipe recipeToWrite) {
//////
//////        // Nome del file + percorso
//////        String fileName = DEF_BASE_FOLDER + "\\" + recipeToWrite.recipe_name + ".txt";
//////
//////        int esito; // int perché voglio gestire più casi con la stessa variabile
//////
//////        int result = controllaRicettaEsiste(recipeToWrite.recipe_name);
//////
//////        // reuslt = 0 -> sovrascivi/scrivi ricetta
//////        if (result == 0) {
//////            System.out.println("Sovrascrivo la ricetta");
//////
//////            try {
//////                PrintWriter writer = new PrintWriter(fileName);
//////
//////                File fileTOwrite = creaFile(fileName);
//////
//////                // Scrivo il file - dati per ricerche complesse (TODO)
//////                writer.write("Nome ricetta: " + recipeToWrite.recipe_name);
//////                writer.write("\nTipo ricetta: " + recipeToWrite.recipe_type);
//////                writer.write("\nIngredienti chiave: " + recipeToWrite.keyIngredients);
//////
//////                // Scrivo il file - il corpo della ricetta
//////                writer.write("\n\n" + recipeToWrite.recipe_body);
//////
//////                // Pulisco il writer e lo chiudo
//////                writer.flush();
//////                writer.close();
//////
//////                esito = 1;
//////
//////            } catch (Exception e) {
//////                esito = 0;
//////            }
//////        } else {
//////            esito = -2;
//////            System.out.println("Non ho scritto la ricetta");
//////        }
//////
//////        return esito;
//////    }
//////
//////    public static void controllaFolder(String defBaseFolder) {
//////        // Se non ho la cartella, la creo
//////
//////        boolean esito = false;
//////
//////        File folder = new File(defBaseFolder);
//////        String fullPath = folder.getAbsolutePath();
//////        //System.out.println("fullPath = " + fullPath);
//////
//////        if (!folder.exists()) {
//////            esito = folder.mkdir();
//////            System.out.println("Esito creazione cartella " + esito);
//////        }
//////    }
//////
//////    public static int sovrascriviRicetta(String fileName) {
//////        int esito; // int perché voglio gestire più cafileNamesi con la stessa variabile
//////
//////        String testo = FrameLettura.getTesto();
//////
//////        String fileNameCompleto = DEF_BASE_FOLDER + "\\" + fileName;
//////
//////        try {
//////            // Creo il writer e il file
//////            PrintWriter writer = new PrintWriter(fileName);
//////            File fileTOwrite = creaFile(fileName);
//////
//////            // Scrivo il file - il corpo della ricetta
//////            writer.write(testo);
//////            System.out.println("Testo = " + testo);
//////
//////            // Pulisco il writer e lo chiudo
//////            writer.flush();
//////            writer.close();
//////
//////            esito = 1;
//////
//////        } catch (Exception e) {
//////            esito = 0;
//////        }
//////
//////        return esito;
//////    }
//////
//////    private static File creaFile(String fileName) {
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
//////
//////    public static int controllaRicettaEsiste(String recipeName) {
//////
//////        String[] listaRicette = cercaFile(recipeName);
//////        int result;
//////        // Se trovo qualche ricetta
//////        if (listaRicette.length > 0) {
//////            String testo = "Attenzione, questa ricetta esiste già, si intende sovrascirvera?";
//////            result = creaPopup(testo);
//////        } else {
//////            result = 0; // se non trovo la ricetta, la creo di default (SI = 0, NO = 1, CANCEL = 2)
//////        }
//////        return result;
//////    }
//////
//////    public static StringBuilder leggiFileIndice(String fileIndice) {
//////
//////        StringBuilder testo = new StringBuilder();
//////
//////        try {
//////            BufferedReader reader = new BufferedReader(new FileReader(fileIndice));
//////
//////            String line = reader.readLine();
//////            // Uso StringBuilder al posto di una lista o ArrayList per non visualizzare caratteri separatori
//////
//////            testo.append(line);
//////
//////            while ((line = reader.readLine()) != null) {
//////                testo.append(line).append("\n");
//////                System.out.println("testo = " + testo);
//////            }
//////            System.out.println("testo.toString() = " + testo.toString());
//////        } catch (Exception e) {
//////            System.out.println("Errore nella lettura del file");
//////
//////        }
//////
//////        return testo;
//////    }
//////
//////    public static int aggiungiRicettaAIndice(Recipe recipeToWrite) {
//////        int esito;
//////
//////        String folder = "Indice";
//////        String nameFileIndice = "File indice.txt";
//////
//////        String fileCompleto = folder + "\\" + nameFileIndice;
//////
//////        // Creo la cartella Indice
//////        controllaFolder(folder);
//////        File fileTOwrite = new File(fileCompleto);
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
//////        try {
//////
//////            StringBuilder testo = leggiFileIndice(fileCompleto);
//////
//////            // Creo il writer e il file
//////            PrintWriter writer = new PrintWriter(fileCompleto);
//////            System.out.println("fileName = " + fileCompleto);
//////
//////            System.out.println("testo.length() = " + testo.length());
//////
//////            // 
//////            if (testo.length() > 4) {
//////                writer.write(testo.toString());
//////            }
//////            writer.write("\nNome ricetta: " + recipeToWrite.recipe_name);
//////            writer.write(", Tipo ricetta: " + recipeToWrite.recipe_type);
//////            writer.write(", Ingredienti chiave: " + recipeToWrite.keyIngredients);
//////
//////            // Pulisco il writer e lo chiudo
//////            writer.flush();
//////            writer.close();
//////
//////            esito = 1;
//////
//////        } catch (Exception e) {
//////            System.out.println("Errore nell'apertura del file");
//////            esito = 0;
//////        }
//////        return 1;
//////    }
