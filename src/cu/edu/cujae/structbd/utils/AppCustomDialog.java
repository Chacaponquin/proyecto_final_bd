/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

import java.awt.Component;
import java.awt.Frame;
import javax.swing.JDialog;

/**
 *
 * @author Hector Angel Gomez
 */
public abstract class AppCustomDialog extends JDialog{
    public abstract void start();
    
    public AppCustomDialog(Component parent, boolean modal){
        super((Frame)parent, modal);
    }
}
