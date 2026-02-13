/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lucrezia.pasulo
 */
import java.util.ArrayList;
import materiale.Libro;
import materiale.Libro.genereMateriale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*; // per le assert function

public class appMainTest {

    @BeforeAll
    public static void setUpClass() {
        System.out.println("codice eseguito BeforeAll");
        // qua posso creare dei libri, riviste, etc pre-impostate sfruttando i metodi che ho già scritto per avere già del materiale su cui lavorare

        Libro libro1 = new Libro("Il nome della rosa", genereMateriale.STORICO, "Umberto Eco", 1980);
        Libro libro2 = new Libro("Harry Potter e la pietra filosofale", genereMateriale.FANTASY, "J.K. Rowling", 1997);
        Libro libro3 = new Libro("1984", genereMateriale.AZIONE, "George Orwell", 1949);
        Libro libro4 = new Libro("Il signore degli anelli", genereMateriale.FANTASY, "J.R.R. Tolkien", 1954);
        Libro libro5 = new Libro("Il codice Da Vinci", genereMateriale.THRILLER, "Dan Brown", 2003);
        Libro libro6 = new Libro("Orgoglio e pregiudizio", genereMateriale.ROMANTICO, "Jane Austen", 1813);
        Libro libro7 = new Libro("L'arte della guerra", genereMateriale.SAGGIO, "Sun Tzu", -500);

        ArrayList listaLibriDaCreare = new ArrayList<>();
        listaLibriDaCreare.add(libro1);
        listaLibriDaCreare.add(libro2);
        listaLibriDaCreare.add(libro3);
        listaLibriDaCreare.add(libro4);
        listaLibriDaCreare.add(libro5);
        listaLibriDaCreare.add(libro6);
        listaLibriDaCreare.add(libro7);
        
        // uso la arrayList per creare i file con un for e richiamando la funzione

        // Test creazione libro
        void testCreazioneLibro
        
        
        
            () {
    Libro libro = new Libro("Il Nome", "Eco");

            assertEquals("Il Nome", libro.getTitolo());
            assertEquals("Eco", libro.getAutore());
        }
    }

    // Metodo presta libro
    void testPrestito() {
        Libro libro = new Libro("Test", "Autore");

        libro.presta();
        assertTrue(libro.isPrestato());
    }

    // Test che deve fallire perché il libro è già in prestito
    @Test
    void testPrestitoGiaPrestato() {
        Libro libro = new Libro("Test", "Autore");

        libro.presta();

        assertThrows(IllegalStateException.class, () -> {
            libro.presta();
        });
    }

    // Test della classe main
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ProgettoUDA2.main(args);
        // TODO il codice fail viene inserito in automatico quando ci genera il metodo di test
        // per forzare un fallimento finché non abbiamo implementato il TEST
        //fail("The test case is a prototype.");

        // Per verificare l'istruzione fail, forzo un fallimento 
        boolean fallisciUnTest = false; // false true
        if (fallisciUnTest) {
            fail("Forzo un fallimento.");
        }
    }

    // Test del singolo metodo
/* 
    Creo una classe test per ogni classe.
     */
    @Test
    public void testSomma() {
        System.out.println("somma");
        int a = 5;
        int b = 3;
        Calcolatrice instance = new Calcolatrice();
        int expResult = 8;
        int result = instance.somma(a, b);
        System.out.println("test della somma");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
