/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materiale;

/**
 *
 * @author lucrezia.pasulo
 */
public class Libro extends MaterialeBiblioteca<Libro.genereMateriale>  {

    public static enum genereMateriale {
        THRILLER,
        FANTASY,
        STORICO,
        AVVENTURA,
        AZIONE,
        SAGGIO,
        ROMANTICO
    }

    public Libro() {
// Costruttore vuoto
    }

    public Libro(String titolo, String autore, tipoMateriale tipo, genereMateriale genere, int anno, boolean isDisponibile) {
        super(titolo, autore, tipo, genere, anno, isDisponibile);
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
}
