/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

/**
 *
 * @author Hector Angel Gomez
 */
public class ViewDialog {
    private final String viewName;
    private final AppCustomDialog dialog;

    public ViewDialog(String viewName, AppCustomDialog dialog) {
        this.viewName = viewName;
        this.dialog = dialog;
    }

    public String getViewName() {
        return viewName;
    }

    public AppCustomDialog getDialog() {
        return dialog;
    }
}
