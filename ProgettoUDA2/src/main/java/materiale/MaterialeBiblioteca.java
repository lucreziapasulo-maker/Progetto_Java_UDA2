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

    public enum tipoMateriale {
        LIBRO,
        RIVISTA,
        AUDIOVISIVO
    }

    public enum genereMateriale {

    }

    String titolo;
    String autore;
    public tipoMateriale tipo;
    public genereMateriale genere;
    int anno;

    public String getTipo(MaterialeBiblioteca biblioteca) {
        return biblioteca.tipo.toString();
    }

    public String getGenere(MaterialeBiblioteca biblioteca) {
        return biblioteca.genere.toString();
    }

    public String getAnno(MaterialeBiblioteca biblioteca) {
        return String.valueOf(biblioteca.anno);
    }

    public String getAutore(MaterialeBiblioteca biblioteca) {
        return biblioteca.autore;
    }

    public String getTitolo(MaterialeBiblioteca biblioteca) {
        return biblioteca.titolo;
    }

    public abstract String contenutoTOwrite();

}
