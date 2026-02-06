/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materiale;

/**
 *
 * @author lucrezia.pasulo
 */
public class Libro extends MaterialeBiblioteca {

    public String tipo = "Libro";

    public String titolo;
    public String autore;
    public genereMateriale genere;
    public int anno;

    public Libro() {
// Costruttore vuoto
    }

    public Libro(String titolo, genereMateriale genere, String autore, int anno) {
        this.titolo = titolo;
        this.genere = genere;
        this.autore = autore;
        this.anno = anno;
    }

    public void restituisci() {

    }

    public void presta() {

    }

    public boolean isDisponibile() {
        // Da modificare
        return false;
    }

}
