/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utenti;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author lucrezia.pasulo
 */
public class Utenti {

    public enum genereUtente {
        FEMMINA,
        MASCHIO,
        NON_DEFINITO
    }

    String nome;
    String cognome;
    String genere;
    int eta;
    ArrayList materialeInPrestito = new ArrayList();

    public Utenti() {
// Costruttore vuoto
    }

    public Utenti(String nome, String cognome, String genere, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.genere = genere;
        this.eta = eta;
    }

    @Override
    public String toString() {
        String stringa = "\nNome: " + this.nome
                + "\nCognome: " + this.cognome
                + "\nEtà: " + this.eta
                + "\nGenere: " + this.genere + "\n";

        return stringa;
    }

    public void aggiungiInPrestito() {

    }

    public void togliDaPrestito() {

    }

    public void mostraInPrestito() {

    }
}
