/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Hector Angel Gomez
 */
public class ViewMessagesUtils {
    public void showErrorMessage(Component component, String message){
        JOptionPane.showMessageDialog(component, message,
                                   "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void showSuccessMessage(Component component, String message){
        JOptionPane.showMessageDialog(component, message,
                                   "Error", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showConecctionErrorMessage(Component component, Exception ex){
        this.showErrorMessage(component, "Error de conexión");
        System.out.println(ex);
    }
    
    
}
