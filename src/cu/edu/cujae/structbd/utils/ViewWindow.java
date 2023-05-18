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

    public ViewWindow(String windowName, AppCustomWindow frame) {
        this.windowName = windowName;
        this.frame = frame;
    }

    public String getWindowName() {
        return windowName;
    }

    public AppCustomWindow getFrame() {
        return frame;
    }
}
