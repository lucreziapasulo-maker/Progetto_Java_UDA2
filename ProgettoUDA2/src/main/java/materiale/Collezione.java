/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package materiale;

import java.util.Iterator;

/**
 *
 * @author lucrezia.pasulo
 */
public class Collezione<T> implements Iterable<T>{
    
    
     @Override
    public Iterator<T> iterator() {
        //devo ritornare un iteratore. NOTA: bisogna costruire prima un Iterator<T>...come fatto sotto
        return new MioIterator();
    }

    //scrivo una inner class che implementi l'interfaccia Iterator<T>
    class MioIterator implements Iterator<T> {

//        Elemento<T> corrente = head;
//        int posizione = 0;

        @Override
        public boolean hasNext() {
            if (corrente != null) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public T next() {
            T valoreCorrente = corrente.getValore();
            corrente = corrente.getNext();
            posizione++;
            return valoreCorrente;
        }

        //per implementare il remove (non è obbligatorio farlo) bisogna 
        //eliminare l'elemento corrente dalla collezione e puntare al successivo
        @Override
        public void remove() {
            try {
                //rimuovo il valore anche se non mi serve
                estraiDaPos(posizione-1);
            } catch (Exception e) {
                //non dovrebbero esserci eccezioni, la posizione esiste
                System.out.println("Eccezione nel rimuovere un elemento: " + e.getMessage());
            }
        }
    
}
