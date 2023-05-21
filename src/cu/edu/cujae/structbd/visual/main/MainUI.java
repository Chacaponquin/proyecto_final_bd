/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cu.edu.cujae.structbd.visual.main;

import cu.edu.cujae.structbd.dto.user.ActualUserDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.utils.AppCustomDialog;
import cu.edu.cujae.structbd.utils.AppCustomWindow;
import cu.edu.cujae.structbd.utils.UtilsConnector;
import cu.edu.cujae.structbd.utils.ViewDialog;
import cu.edu.cujae.structbd.utils.ViewWindow;
import cu.edu.cujae.structbd.visual.snb.SerieUI;
import cu.edu.cujae.structbd.visual.user.ChangePasswordUI;
import cu.edu.cujae.structbd.visual.user.LoginUI;
import cu.edu.cujae.structbd.visual.user.UpdateUserUI;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.util.List;
import javax.swing.JMenuItem;

/**
 *
 * @author Hector Angel Gomez
 */
public class MainUI extends javax.swing.JFrame {
    /**
     * Creates new form MainUI
     */
    public MainUI()
    {
        initComponents();
        this.updateMenuItems();

    }
    
    public void updateMenuItems(){
        ActualUserDTO actualUser = ServicesLocator.UserServices.getActualUser();
        boolean actualUserIsAdmin = ServicesLocator.UserServices.actualUserIsAdmin();
        
        List<ViewWindow> views = UtilsConnector.viewUtils.getViews();
        List<ViewDialog> reportsViews = UtilsConnector.viewUtils.getReportsViews();
        
        // añadir views
        views.forEach((view) -> {
            if(view.getCondition()){
                javax.swing.JMenuItem menuItem = new javax.swing.JMenuItem();
                menuItem.setText(view.getWindowName());

                menuItem.addActionListener(this.clickMenuItem(this, view.getFrame()));

                this.jMenu1.add(menuItem);
            }
        });
        
        
        // añadir reportes
        if(actualUserIsAdmin){
            this.jMenu2.setVisible(false);
        }else {
            reportsViews.forEach((view) -> {
                javax.swing.JMenuItem menuItem = new javax.swing.JMenuItem();
                menuItem.setText(view.getViewName());
                menuItem.addActionListener(this.clickReportMenuItem(this, view.getDialog()));
                this.jMenu2.add(menuItem);
            });
        }
        
        JMenuItem closeUserItem = new JMenuItem("Cerrar Sesión");
        closeUserItem.addActionListener(this.userSignOut(this));
 
        
        JMenuItem updateUserItem = new JMenuItem("Configurar Usuario");
        updateUserItem.addActionListener(this.userConfigAction(this));
        
        JMenuItem changePasswordItem = new JMenuItem("Cambiar Contraseña");
        changePasswordItem.addActionListener(this.userChangePasswordAction(this));
        
        this.jMenu3.add(changePasswordItem);
        this.jMenu3.add(updateUserItem);
        this.jMenu3.add(closeUserItem); 
    }
    
    public ActionListener userConfigAction(MainUI main){
        return new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                    UpdateUserUI w = new UpdateUserUI(main, ServicesLocator.UserServices.getActualUser());
                    w.start();
                    UtilsConnector.viewUtils.openDialog(main, w);
                } 
         };
    }
    
    public ActionListener userChangePasswordAction(MainUI main){
        return new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                    ChangePasswordUI w = new ChangePasswordUI(main);
                    w.start();
                    UtilsConnector.viewUtils.openDialog(main, w);
                } 
         };
    }
    
    public ActionListener userSignOut(MainUI main){
        return new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                    ServicesLocator.UserServices.signOutUser();
                    LoginUI w = new LoginUI();
                    
                    UtilsConnector.viewUtils.openWindow(main, w);
                } 
         };  
    }
     
    public ActionListener clickMenuItem(MainUI mainWindow, AppCustomWindow view) {
        return new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                mainWindow.setVisible(true);
                    view.setVisible(true);
                    view.setAlwaysOnTop(true);
                    view.start();
                    view.setLocationRelativeTo(null);
                } 
         };
    }
    
    public ActionListener clickReportMenuItem(MainUI mainWindow, AppCustomDialog view) {
        return new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                    mainWindow.setVisible(true);
                    view.setVisible(true);
                    view.start();
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
    private void initComponents()
    {

        imagePanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Serie Nacional de Béisbol");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        imagePanel = new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                Image img = Toolkit.getDefaultToolkit().getImage(MainUI.class.getResource("/cu/edu/cujae/structbd/assets/SNB.jpg"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        jMenu3.setText("Archivo");
        jMenuBar1.add(jMenu3);

        jMenu1.setText("Gestión");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reportes");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Ayuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel imagePanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
