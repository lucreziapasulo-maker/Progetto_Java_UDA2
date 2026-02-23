/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioneFile;

import interfaccia.PopupFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import materiale.AudioVisivo;
import materiale.Libro;
import materiale.MaterialeBiblioteca;
import materiale.Rivista;
import interfaccia.FrameLettura;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JTextArea;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author lucrezia.pasulo
 */
public class GestioneFile {

    /*
    Vengono create tante cartelle quanti sono i tipi di MaterialeBiblioteca 
    (presi da enum tipoMateriale).
     */
    public static final String FOLDER_MAIN = System.getProperty("user.dir") + "\\Materiale";
    public static final String FOLDER_LIBRI = MaterialeBiblioteca.tipoMateriale.LIBRO.toString();
    public static final String FOLDER_RIVISTE = MaterialeBiblioteca.tipoMateriale.RIVISTA.toString();
    public static final String FOLDER_AUDIOVISIVO = MaterialeBiblioteca.tipoMateriale.AUDIOVISIVO.toString();
    public static final String FOLDER_PRESTITO = "In prestito";
    public static final String FOLDER_LISTA = "Lista";

    private static final String ESTENSIONE = ".txt";

    public static final Logger LOG_FILE = LogManager.getLogger(GestioneFile.class);

    /*
    -- Metodo per prima creazione cartelle di default
     */
    public static void initApp() {

        // Creazione delle cartelle principali
        ArrayList listaFolder = new ArrayList();
        listaFolder.add(FOLDER_LIBRI);
        listaFolder.add(FOLDER_RIVISTE);
        listaFolder.add(FOLDER_AUDIOVISIVO);
        listaFolder.add(FOLDER_LISTA);

        LOG_FILE.info("Inizializzazione cartelle");

        for (Object each : listaFolder) {
            String folderAttuale = each.toString();
            File nuovaCartella = new File(FOLDER_MAIN, folderAttuale);
            File nuovaCartellaPrestito = new File(nuovaCartella, FOLDER_PRESTITO);

            if (nuovaCartella.mkdirs()) {
                System.out.println("Creazione cartella: " + nuovaCartella.toString());
                LOG_FILE.debug("Creazione cartella: " + nuovaCartella.toString());
            } else {
                // Non faccio nulla
            }
            if (!each.equals(FOLDER_LISTA)) {
                if (nuovaCartellaPrestito.mkdirs()) {
                    System.out.println("Creazione cartella: " + nuovaCartellaPrestito.toString());
                } else {
                    // Non faccio nulla
                }
            }
        }
    }

    /*
    -- 
     */
    public static void creaMateriale(MaterialeBiblioteca materiale) {
        if (materiale instanceof Libro) {
            Libro libri = (Libro) materiale;
            creaLibro(libri.getTitolo(), libri);

        } else if (materiale instanceof Rivista) {
            Rivista rivista = (Rivista) materiale;
            creaRivista(rivista.getTitolo(), rivista);

        } else if (materiale instanceof AudioVisivo) {
            AudioVisivo audioVisivo = (AudioVisivo) materiale;
            creaAudioVisivo(audioVisivo.getTitolo(), audioVisivo);
        }
    }

    public static void creaLibro(String titolo, Libro materiale) {
        String fileName = titolo + ESTENSIONE;
        File fileTOwrite = new File(FOLDER_MAIN + "\\" + FOLDER_LIBRI, fileName);

        creaFile(fileTOwrite, materiale);
    }

    public static void creaRivista(String titolo, Rivista materiale) {
        String fileName = titolo + ESTENSIONE;
        File fileTOwrite = new File(FOLDER_MAIN + "\\" + FOLDER_RIVISTE, fileName);

        creaFile(fileTOwrite, materiale);
    }

    public static void creaAudioVisivo(String titolo, AudioVisivo materiale) {
        String fileName = titolo + ESTENSIONE;
        File fileTOwrite = new File(FOLDER_MAIN + "\\" + FOLDER_AUDIOVISIVO, fileName);

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

    public static boolean scriviLista(ArrayList<MaterialeBiblioteca> listaMateriale) {
        boolean esito = false;

        String folder = FOLDER_MAIN + "\\" + FOLDER_LISTA;
        String fileLista = folder + "\\" + "ListaMateriale" + ESTENSIONE;

        try {
            FileOutputStream f = new FileOutputStream(fileLista);
            ObjectOutputStream fOUT = new ObjectOutputStream(f);

            fOUT.writeObject(listaMateriale);
            esito = true;

        } catch (Exception e) {
            System.out.println("Errore nello scrivere la lista: " + e.getMessage());
        }

        return esito;
    }

    public static ArrayList<MaterialeBiblioteca> leggiLista() {
        ArrayList<MaterialeBiblioteca> listaMateriale = new ArrayList<MaterialeBiblioteca>();

        String folder = FOLDER_MAIN + "\\" + FOLDER_LISTA;
        String fileLista = folder + "\\" + "ListaMateriale" + ESTENSIONE;

        try {
            FileInputStream f = new FileInputStream(fileLista);
            ObjectInputStream fIN = new ObjectInputStream(f);

            listaMateriale = (ArrayList<MaterialeBiblioteca>) fIN.readObject();

        } catch (Exception e) {
            System.out.println("Errore nel leggere la lista: " + e.getMessage());
        }

        return listaMateriale;
    }

    public static String[] cercaFile(String tipo, String titolo, String prestito) {
        String folderString;
        String fileDaAprire;

        if (prestito.equals("SI")) {
            // Se devo visulizzare i file in prestito
            folderString = FOLDER_MAIN + "\\" + tipo + "\\" + FOLDER_PRESTITO;
            fileDaAprire = folderString + "\\" + titolo + ESTENSIONE;
        } else {
            // Se devo visualizzare file NON in prestito
            folderString = FOLDER_MAIN + "\\" + tipo;
            fileDaAprire = folderString + "\\" + titolo + ESTENSIONE;
            System.out.println("fileDaAprire = " + fileDaAprire);
        }

        // ArrayList che conterrà i file trovati
        ArrayList<String> listaMateriale = new ArrayList<String>();

        String strTmp;
        String[] strTmp2 = new String[1];

        // Carico la lista di tutti i file
        File folder = new File(folderString);
        File[] listFiles = folder.listFiles();
        try {
            //System.out.println("\nstrToFind = " + strToFind);// Tengo in considerazione sono i file che mi interessano        
            for (int i = 0; i <= listFiles.length - 1; i++) {
                strTmp = listFiles[i].getName();

                strTmp = strTmp.toLowerCase();
                titolo = titolo.toLowerCase();

                if (strTmp.contains(titolo)) {
                    listaMateriale.add(listFiles[i].getName());
                }
            }

            // Converto la ArrayList in String[], altrimenti non riesco visualizzarla sul frame
            strTmp2 = new String[listaMateriale.size()];
            for (int i = 0; i < listaMateriale.size(); i++) {
                String tmp = listaMateriale.get(i);
                if (!tmp.toLowerCase().equals(FOLDER_PRESTITO.toLowerCase())) {
                    // Tolgo l'estensione per una visualizzazione più pulita; gestisco l'estensione solo in questa classe
                    String stringa = tmp.replace(ESTENSIONE, "");
                    strTmp2[i] = stringa;
                }
            }

        } catch (Exception e) {
            strTmp2[0] = "";
        }

        return strTmp2;
    }

    public static void apriFile(String tipo, String titolo) {
        String fileDaAprire = FOLDER_MAIN + "\\" + tipo + "\\" + titolo + ESTENSIONE;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileDaAprire));
            mostraSuFrame(reader);

        } catch (Exception e) {
            System.out.println("Errore nell'apertura del file");
        }
    }

    private static void mostraSuFrame(BufferedReader reader) {
        // Creo il frame
        FrameLettura frameLettura = new FrameLettura();

        // Aggiungo l'area di lettura
        JTextArea areaLettura = frameLettura.getAreaTesto();

        // Estrapolo il testo della ricetta
        try {
            System.out.println("Leggo dal file");

            String line = reader.readLine();
            // Uso StringBuilder al posto di una lista o ArrayList per non visualizzare caratteri separatori
            StringBuilder testo = new StringBuilder();

            testo.append(line).append("\n");

            while ((line = reader.readLine()) != null) {
                testo.append(line).append("\n");
                //System.out.println("testo = " + testo);
            }

            //System.out.println("testo = " + testo);
            // Scrivo sull'area
            areaLettura.setText(testo.toString());

        } catch (Exception e) {
            System.out.println("Errore nella lettura del file");
        }
    }

    public static boolean eliminaFile(String titolo, String tipo) {
        boolean esito = false;
        String folderString = FOLDER_MAIN + "\\" + tipo;
        String titoloDaEliminare = folderString + "\\" + titolo + ESTENSIONE;

        try {
            File fileDaEliminare = new File(titoloDaEliminare);
            fileDaEliminare.delete();
            esito = true;
        } catch (Exception e) {
            LOG_FILE.debug("Eliminazione file fallita.\n" + e.getMessage());
        }

        return esito;
    }

    public static boolean spostaFile(String titolo, String tipo, String statoPrestito) {
        boolean esito = false;
        String folderString = FOLDER_MAIN + "\\" + tipo;
        String titoloDaSpostare;
        String nuovaPosizioneString;

        if (statoPrestito.equals("Richiesta prestito")) {
            titoloDaSpostare = folderString + "\\" + titolo + ESTENSIONE;
            nuovaPosizioneString = folderString + "\\" + FOLDER_PRESTITO + "\\" + titolo + ESTENSIONE;
        } else if (statoPrestito.equals("Richiesta restituzione")) {
            titoloDaSpostare = folderString + "\\" + FOLDER_PRESTITO + "\\" + titolo + ESTENSIONE;
            nuovaPosizioneString = folderString + "\\" + titolo + ESTENSIONE;
        } else {
            nuovaPosizioneString = "";
            titoloDaSpostare = "";
        }
        File fileDaSpostare = new File(titoloDaSpostare);

        if (nuovaPosizioneString.isEmpty()) {
            return esito;
        } else {
            File nuovaPosizione = new File(nuovaPosizioneString);
            fileDaSpostare.renameTo(nuovaPosizione);
            esito = true;
        }
        return esito;
    }
}
