/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cu.edu.cujae.structbd.visual.main;

import cu.edu.cujae.structbd.utils.UtilsConnector;
import cu.edu.cujae.structbd.utils.ViewDialog;
import cu.edu.cujae.structbd.utils.ViewWindow;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.*;
import javax.swing.JDialog;
import java.util.List;

/**
 *
 * @author Hector Angel Gomez
 */
public class MainUI extends javax.swing.JFrame {
    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        this.updateMenuItems();
    }
    
    public void updateMenuItems(){
        List<ViewWindow> views = UtilsConnector.viewUtils.getViews();
        List<ViewDialog> reportsViews = UtilsConnector.viewUtils.getReportsViews();
        
        this.jMenu1.setText("Entidades");
        this.jMenu2.setText("Reportes");
        
        views.forEach((view) -> {
            javax.swing.JMenuItem menuItem = new javax.swing.JMenuItem();
            menuItem.setText(view.getWindowName());
            
            menuItem.addActionListener(this.clickMenuItem(this, view.getFrame()));
            
            this.jMenu1.add(menuItem);
        });
        
        reportsViews.forEach((view) -> {
            javax.swing.JMenuItem menuItem = new javax.swing.JMenuItem();
            menuItem.setText(view.getViewName());
            
            menuItem.addActionListener(this.clickReportMenuItem(this, view.getDialog()));
            
            this.jMenu2.add(menuItem);
        });
    }
     
    public ActionListener clickMenuItem(MainUI mainWindow, JFrame view) {
        return new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                mainWindow.setVisible(true);
                    view.setVisible(true);
                    view.setLocationRelativeTo(null);
                } 
         };
    }
    
    public ActionListener clickReportMenuItem(MainUI mainWindow, JDialog view) {
        return new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                mainWindow.setVisible(true);
                    view.setVisible(true);
                    view.setLocationRelativeTo(null);
                } 
         };
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        imagePanel = new JPanel(){
            public void paintComponent(Graphics g) {
                Image img = Toolkit.getDefaultToolkit().getImage(MainUI.class.getResource("/cu/edu/cujae/structbd/assets/SNB.jpg"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel imagePanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
