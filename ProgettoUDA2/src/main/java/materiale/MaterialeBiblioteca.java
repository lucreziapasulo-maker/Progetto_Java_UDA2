/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materiale;

import java.io.Serializable;

/**
 *
 * @author lucrezia.pasulo
 */
public abstract class MaterialeBiblioteca<T> implements Prestabile, Serializable {

    public enum tipoMateriale {
        LIBRO,
        RIVISTA,
        AUDIOVISIVO
    }

//    public enum genereMateriale {
//    }
    protected String titolo;
    protected String autore;
    protected tipoMateriale tipo;
    protected T genere;
    protected int anno;
    protected boolean isDisponibile;

    public MaterialeBiblioteca() {

    }

    public MaterialeBiblioteca(String titolo, String autore, tipoMateriale tipo, T genere, int anno, boolean isDisponibile) {
        this.titolo = titolo;
        this.autore = autore;
        this.tipo = tipo;
        this.genere = genere;
        this.anno = anno;
        this.isDisponibile = isDisponibile;
    }

    public String getTipo() {
        return tipo.toString();
    }

    public String getGenere() {
        return genere.toString();
    }

    public String getAnno() {
        return String.valueOf(anno);
    }

    public String getAutore() {
        return autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public boolean isDisponibile() {
        return isDisponibile;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setTipo(tipoMateriale tipo) {
        this.tipo = tipo;
    }

    public void setGenere(T genere) {
        this.genere = genere;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setIsDisponibile(boolean isDisponibile) {
        this.isDisponibile = isDisponibile;
    }

    public abstract String contenutoTOwrite();

    @Override
    public void restituisci() {
        this.isDisponibile = true;
    }

    @Override
    public void presta() {
        this.isDisponibile = false;
    }
}
