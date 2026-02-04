/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materiale;

import java.util.Iterator;
import liste.Elemento;

/**
 *
 * @author lucrezia.pasulo
 */
public class ListaMateriale<T> { //implements Iterable<T> {

    //puntatore al primo elemento
    private Elemento<T> head = null;
    //puntatore all'ultimo elemento (serve per partire a scorrere dal fondo)
    private Elemento<T> tail = null;
    //contatore elementi presenti
    private int numeroElementi = 0;

    private final String APERTA = "[";
    private final String CHIUSA = "]";
    private final String SEPARATORE = "|";

    public ListaMateriale() {
    }

    public ListaMateriale(T valore) {
        this();
        inserisciPrimoElemento(valore);
    }

    public void inserisciPrimoElemento(T valore) {
        Elemento<T> elemento = new Elemento(valore);
        head = elemento;
        tail = elemento;
        numeroElementi++;
    }

    public int getNumeroElementi() {
        return numeroElementi;
    }

    //metodo toString()
    @Override
    public String toString() {
        if (numeroElementi == 0) {
            return "la lista è vuota";
        } else {
            Elemento<T> e = head;
            String tmp = APERTA;
            for (int i = 1; i <= numeroElementi; i++) {
                //mi faccio dare la stringa relativa al valore memorizzato
                //nell'elemento
                T tmpVal = e.getValore();
                tmp = tmpVal.toString();
                if (i < numeroElementi) {
                    tmp += SEPARATORE;
                } else {
                    //non lo aggiungo per l'ultimo elemento
                }
                //passo ora al prossimo elemento
                e = e.getNext();
            }

            tmp += CHIUSA;
            return tmp;
        }
    }
    
     public T estraiDaTesta() throws Exception {
        //controllo se ci sono elementi
        if (numeroElementi == 0) {
            throw new Exception("non ci sono elementi");
        }
        //se c'è un elemento solo, devo anche riposizionare la tail
        if (numeroElementi == 1) { //potevo anche controllare se head.next == null
            tail = null;
        }
        numeroElementi--;
        T valore = head.getValore();
        head = head.getNext();
        return valore;
    }
     
     
     
     

//    @Override
//    public Iterator<T> iterator() {
//        //devo ritornare un iteratore. NOTA: bisogna costruire prima un Iterator<T>...come fatto sotto
//        return new MioIterator();
//    }
//
//    //scrivo una inner class che implementi l'interfaccia Iterator<T>
//    class MioIterator implements Iterator<T> {
//
////        Elemento<T> corrente = head;
////        int posizione = 0;
//        @Override
//        public boolean hasNext() {
////            if (corrente != null) {
////                return true;
////            } else {
////                return false;
////            }
//        }
//
//        @Override
//        public T next() {
////            T valoreCorrente = corrente.getValore();
////            corrente = corrente.getNext();
////            posizione++;
////            return valoreCorrente;
//            
//        }
//
//        //per implementare il remove (non è obbligatorio farlo) bisogna 
//        //eliminare l'elemento corrente dalla collezione e puntare al successivo
//        @Override
//        public void remove() {
////            try {
////                //rimuovo il valore anche se non mi serve
////                estraiDaPos(posizione - 1);
////            } catch (Exception e) {
////                //non dovrebbero esserci eccezioni, la posizione esiste
////                System.out.println("Eccezione nel rimuovere un elemento: " + e.getMessage());
////            }
//        }
//
}
