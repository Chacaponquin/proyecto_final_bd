/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
        if(component instanceof JFrame){
            ((JFrame) component).dispose();
        }
        else if(component instanceof JDialog){
            ((JDialog) component).dispose();
        }
        
        this.showErrorMessage(component, "Error de conexión " + ex.getMessage());
        Connector.restartConnection();
    }
    
    public boolean showConfirmDialog(Component component, String message){
        boolean retBoolean = false;
        
        int input = JOptionPane.showConfirmDialog(component, message);
        
        if(input == 0){
            retBoolean = true;
        }else {
            retBoolean = false;
        }
        
        return retBoolean;
    }
}
