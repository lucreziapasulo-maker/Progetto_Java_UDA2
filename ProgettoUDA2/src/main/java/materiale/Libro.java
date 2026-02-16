/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materiale;

/**
 *
 * @author lucrezia.pasulo
 */
public class Libro extends MaterialeBiblioteca implements Prestabile {

    public enum genereMateriale {
        THRILLER,
        FANTASY,
        STORICO,
        AVVENTURA,
        AZIONE,
        SAGGIO,
        ROMANTICO
    }

//    public tipoMateriale tipo = MaterialeBiblioteca.tipoMateriale.LIBRO;
    public String titolo;
    public String autore;
    public genereMateriale genere;
    public int anno;
    public tipoMateriale tipo = tipoMateriale.LIBRO;
    public boolean isDisponibile;

    public Libro() {
// Costruttore vuoto
    }

    public Libro(String titolo, genereMateriale genere, String autore, int anno) {
        this.titolo = titolo;
        this.genere = genere;
        this.autore = autore;
        this.anno = anno;
        boolean isDisponibile = true;
    }

    public String getTipo(Libro biblioteca) {
        return biblioteca.tipo.toString();
    }

    public String getGenere(Libro biblioteca) {
        return biblioteca.genere.toString();
    }

    public String getAnno(Libro biblioteca) {
        return String.valueOf(biblioteca.anno);
    }

    public String getAutore(Libro biblioteca) {
        return biblioteca.autore;
    }

    public String getTitolo(Libro biblioteca) {
        return biblioteca.titolo;
    }

    @Override
    public String contenutoTOwrite() {
        String titolo = this.titolo;
        String autore = this.autore;
        String anno = String.valueOf(this.anno);
        String tipo = this.tipo.toString();
        String genere = this.genere.toString();
        String stringaTmp;
        if (isDisponibile) {
            stringaTmp = "è disponibile";
        } else {
            stringaTmp = "non è disponibile";
        }
        String isDisponibile = stringaTmp;

        return titolo + "\n" + autore + "\n" + anno + "\n" + tipo + "\n" + genere + "\n" + isDisponibile;
    }

    public void restituisci() {
        this.isDisponibile = true;
    }

    public void presta() {
        this.isDisponibile = false;
    }

}
