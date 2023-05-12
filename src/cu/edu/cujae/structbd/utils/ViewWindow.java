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
    private final JFrame frame;

    public ViewWindow(String windowName, JFrame frame) {
        this.windowName = windowName;
        this.frame = frame;
    }

    public String getWindowName() {
        return windowName;
    }

    public JFrame getFrame() {
        return frame;
    }
}
