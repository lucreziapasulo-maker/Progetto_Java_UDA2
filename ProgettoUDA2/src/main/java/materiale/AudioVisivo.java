/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materiale;

/**
 *
 * @author lu242
 */
public class AudioVisivo extends MaterialeBiblioteca<AudioVisivo.genereMateriale> {

    public enum genereMateriale {
        DOCUMENTARIO,
        FANTASY,
        STORICO,
        AVVENTURA,
        AZIONE,
        SAGGIO,
        ROMANTICO,
        DRAMMATICO
    }

    public AudioVisivo() {
// Costruttore vuoto
    }

    public AudioVisivo(String titolo, String autore, tipoMateriale tipo, genereMateriale genere, int anno, boolean isDisponibile) {
        super(titolo, autore, tipo, genere, anno, isDisponibile);
    }

    @Override
    public String contenutoTOwrite() {
        String titolo = this.titolo;
        String autore = this.autore;
        String anno = String.valueOf(this.anno);
        String tipo = this.tipo.toString();
        String genere = this.genere.toString();

        return titolo + "\n" + autore + "\n" + anno + "\n" + tipo + "\n" + genere;
    }
}
