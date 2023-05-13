/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.exceptions.app;

/**
 *
 * @author Hector Angel Gomez
 */
public class EmptyFieldFormException extends Exception {
    private String fieldName;
    
    public EmptyFieldFormException(String fieldName){
        super("El campo " + fieldName + " no puede estar vacío");
        this.fieldName = fieldName;        
    }
}
