/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materiale;

/**
 *
 * @author lu242
 */
public class Rivista extends MaterialeBiblioteca {

    public enum genereMateriale {
        GOSSIP,
        SCIENZA,
        CUCINA,
        GIARDINAGGIO,
        SPORT,
        FAI_DA_TE
    }

    public tipoMateriale tipo = MaterialeBiblioteca.tipoMateriale.LIBRO;

    public String titolo;
    public String autore;
    public genereMateriale genere;
    public int anno;

    public Rivista() {
// Costruttore vuoto
    }

    public Rivista(String titolo, genereMateriale genere, String autore, int anno) {
        this.titolo = titolo;
        this.genere = genere;
        this.autore = autore;
        this.anno = anno;
    }

//    @Override
//    public String contenutoTOwrite() {
//        String titolo = this.getTitolo(this);
//        String autore = this.getAutore(this);
//        String anno = this.getAnno(this);
//        String tipo = this.getTipo(this);
//        String genere = this.getGenere(this);
//
//        return titolo + "\n" + autore + "\n" + anno + "\n" + tipo + "\n" + genere;
//    }
    @Override
    public String contenutoTOwrite() {
        String titolo = this.titolo;
        String autore = this.autore;
        String anno = String.valueOf(this.anno);
        String tipo = this.tipo.toString();
        String genere = this.genere.toString();

        return titolo + "\n" + autore + "\n" + anno + "\n" + tipo + "\n" + genere;
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
