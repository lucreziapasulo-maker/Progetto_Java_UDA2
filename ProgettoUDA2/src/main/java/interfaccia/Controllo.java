/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaccia;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 *
 * @author lucrezia.pasulo
 */
public class Controllo {

    public static boolean isVuoto(ArrayList listaDaControllare) {
        /* 
        -- Metodo isVuoto(ArrayList listaDaControllare) --
        Per controllare se tutti i campi sono compilati, verifico campo per 
        campo (differenziando String da int), se il campo non è vuoto o non è 0, 
        aumento un contatore "sommaEsito". Alla fine, se 
        sommaEsito = listaDaControllare.sile(), allora tutti i campi sono 
        compilati, quindi ritorno true
         */

        int sommaEsito = 0;

//        for (int i = 0; i < listaDaControllare.size(); i++) {
        for (Object n : listaDaControllare) {
            // Se l'oggetto stringa non è vuoto
            if (n != null) {
                if (!n.toString().equals("") && !n.toString().equals("null") && !n.toString().isEmpty()) {
                    sommaEsito += 1;
                } else {
                    // Non faccio nulla
                }
            }

        }

        if (sommaEsito == listaDaControllare.size()) {
            return true;
        } else {
            return false;
        }
    }

    public static int isNum(String numeroDaControllare) {
        int num = -1;
        try {
            num = Integer.parseInt(numeroDaControllare);
        } catch (Exception e) {
            System.out.println("Il valore inserito non è un numero");
        }
        return num;
    }
}
