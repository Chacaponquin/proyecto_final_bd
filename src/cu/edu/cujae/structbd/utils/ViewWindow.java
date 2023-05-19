/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

import javax.swing.JFrame;

/**
 *
 * @author Hector Angel Gomez
 */
public class ViewWindow {
    private final String windowName;
    private final AppCustomWindow frame;
    private final boolean condition;

    public ViewWindow(String windowName, AppCustomWindow frame, boolean condition) {
        this.windowName = windowName;
        this.frame = frame;
        this.condition = condition;
    }
    
    public boolean getCondition(){
        return this.condition;
    }

    public String getWindowName() {
        return windowName;
    }

    public AppCustomWindow getFrame() {
        return frame;
    }
}
