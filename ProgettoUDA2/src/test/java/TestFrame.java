/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.ArrayList;
import materiale.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import gestioneFile.GestioneFile;
import java.io.File;
import java.util.List;
import materiale.AudioVisivo;
import materiale.Libro.genereMateriale;
import materiale.MaterialeBiblioteca;
import materiale.Rivista;
import org.junit.jupiter.api.TestInstance;

/**
 *
 * @author lu242
 */
public class TestFrame {

    ArrayList<MaterialeBiblioteca> libri;
    ArrayList<MaterialeBiblioteca> riviste;
    ArrayList<MaterialeBiblioteca> audiovisivi;

    public TestFrame() {
    }

    @BeforeEach
    public void setUpClass() {

        GestioneFile.initApp();

        Libro libro1 = new Libro("Il nome della rosa", "Umberto Eco", MaterialeBiblioteca.tipoMateriale.LIBRO, Libro.genereMateriale.STORICO, 1980, true);
        Libro libro2 = new Libro("Harry Potter e la pietra filosofale", "J.K. Rowling", MaterialeBiblioteca.tipoMateriale.LIBRO, Libro.genereMateriale.FANTASY, 1997, true);

        libri = new ArrayList<>();
        libri.add(libro1);
        libri.add(libro2);

//        for (int i = 0; i < libri.size(); i++) {
//            Libro libroToSave = (Libro) libri.get(i);
//            GestioneFile.creaMateriale(libroToSave);
//        }
        Rivista rivista1 = new Rivista("National Geographic", "Susan Goldberg", MaterialeBiblioteca.tipoMateriale.RIVISTA, Rivista.genereMateriale.SCIENZA, 1888, true);
        Rivista rivista2 = new Rivista("Focus", "Raffaele Leone", MaterialeBiblioteca.tipoMateriale.RIVISTA, Rivista.genereMateriale.SCIENZA, 1992, true);

        riviste = new ArrayList<>();
        riviste.add(rivista1);
        riviste.add(rivista2);

//        for (int i = 0; i < riviste.size(); i++) {
//            Rivista rivistaToSave = (Rivista) riviste.get(i);
//            GestioneFile.creaMateriale(rivistaToSave);
//        }
        AudioVisivo audioVisivo1 = new AudioVisivo("La vita è bella", "Roberto Benigni", MaterialeBiblioteca.tipoMateriale.AUDIOVISIVO, AudioVisivo.genereMateriale.DRAMMATICO, 1997, true);
        AudioVisivo audioVisivo2 = new AudioVisivo("Planet Earth", "David Attenborough", MaterialeBiblioteca.tipoMateriale.AUDIOVISIVO, AudioVisivo.genereMateriale.DOCUMENTARIO, 2006, true);

        audiovisivi = new ArrayList<>();
        audiovisivi.add(audioVisivo1);
        audiovisivi.add(audioVisivo2);

//        for (int i = 0; i < audiovisivi.size(); i++) {
//            AudioVisivo audioVisivoToSave = (AudioVisivo) audiovisivi.get(i);
//            GestioneFile.creaMateriale(audioVisivoToSave);
//        }
    }

    @Test
    public void isLibriPopulated() {
        assertNotNull(libri);
        assertEquals(libri.size(), 2);
    }

    @Test
    public void prestitoLibro() {
        Libro libro = (Libro) libri.get(0);
        libro.presta();
        assertEquals(libro.isDisponibile(), false);
    }

    @Test
    public void returnLibro() {
        Libro libro = (Libro) libri.get(0);
        libro.presta();
        assertEquals(libro.isDisponibile(), false);
        libro.restituisci();
        assertEquals(libro.isDisponibile(), true);
    }

    @Test
    public void isRivistePopulated() {
        assertNotNull(riviste);
        assertEquals(riviste.size(), 2);
    }

    @Test
    public void prestitoRivista() {
        Rivista rivista = (Rivista) riviste.get(0);
        rivista.presta();
        assertEquals(rivista.isDisponibile(), false);
    }

    @Test
    public void returnRivista() {
        Rivista rivista = (Rivista) riviste.get(0);
        rivista.presta();
        assertEquals(rivista.isDisponibile(), false);
        rivista.restituisci();
        assertEquals(rivista.isDisponibile(), true);
    }

    @Test
    public void isAudioVisiviPopulated() {
        assertNotNull(audiovisivi);
        assertEquals(audiovisivi.size(), 2);
    }

    @Test
    public void prestitoAudioVisivi() {
        AudioVisivo audioVisivo = (AudioVisivo) audiovisivi.get(0);
        audioVisivo.presta();
        assertEquals(audioVisivo.isDisponibile(), false);
    }

    @Test
    public void returnAudioVisivi() {
        AudioVisivo audioVisivo = (AudioVisivo) audiovisivi.get(0);
        audioVisivo.presta();
        assertEquals(audioVisivo.isDisponibile(), false);
        audioVisivo.restituisci();
        assertEquals(audioVisivo.isDisponibile(), true);
    }

}
