/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package liste;

/**
 *
 * @author lucrezia.pasulo
 */
public class Elemento<T> {
    public final T valore;
    private Elemento<T> next = null; //link all'elemento successivo. Non Ã¨ indispensabile porlo a null, perchÃ© contiene giÃ  null;
    
    public Elemento(T valore){
        this.valore = valore;
    }
    
    public T getValore(){
        return this.valore;
    }
    
    public void setNext(Elemento next){
        this.next = next;
    }
    
    public Elemento getNext(){
        return next;
    }
}
