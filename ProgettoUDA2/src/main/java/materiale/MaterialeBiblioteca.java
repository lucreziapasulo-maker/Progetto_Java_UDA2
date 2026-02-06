/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materiale;

/**
 *
 * @author lucrezia.pasulo
 */
public abstract class MaterialeBiblioteca<T> {

    public enum genereMateriale {
        THRILLER,
        FANTASY,
        STORICO,
        AVVENTURA,
        AZIONE,
        SAGGIO,
        ROMANTICO
    }

    String titolo;
    String tipo;
    public genereMateriale genere;
    int anno;


    public String getTipo(MaterialeBiblioteca biblioteca) {
        return biblioteca.tipo;
    }

    public genereMateriale getGenere(MaterialeBiblioteca biblioteca) {
        return biblioteca.genere;
    }

    public String getTitolo(MaterialeBiblioteca biblioteca) {
        return biblioteca.titolo;
    }


    @Override
    public String toString() {
        String stringa = "\nTitolo: " + this.titolo
                + "\nGenere: " + this.genere
                + "\nAnno: " + this.anno
                + "\nTipologia: " + this.tipo + "\n";

        return stringa;
    }

}
