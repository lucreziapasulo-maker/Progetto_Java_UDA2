/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlli;

/**
 *
 * @author lu242
 */
public class InvalidFieldsException extends Exception {

    public InvalidFieldsException(String field, Object valoreAct) {
        super("Il campo " + field + " ha una valore non valido (" + valoreAct + ")");
    }

}
