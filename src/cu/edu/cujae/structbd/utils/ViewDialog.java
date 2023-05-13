/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

import javax.swing.JDialog;

/**
 *
 * @author Hector Angel Gomez
 */
public class ViewDialog {
    private final String viewName;
    private final JDialog dialog;

    public ViewDialog(String viewName, JDialog dialog) {
        this.viewName = viewName;
        this.dialog = dialog;
    }

    public String getViewName() {
        return viewName;
    }

    public JDialog getDialog() {
        return dialog;
    }
}
