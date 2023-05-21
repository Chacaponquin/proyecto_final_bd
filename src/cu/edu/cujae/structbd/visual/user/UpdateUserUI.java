/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package cu.edu.cujae.structbd.visual.user;

import cu.edu.cujae.structbd.dto.user.ActualUserDTO;
import cu.edu.cujae.structbd.dto.user.ReadUserDTO;
import cu.edu.cujae.structbd.dto.user.UpdateUserDTO;
import cu.edu.cujae.structbd.dto.user_role.FindUserRoleDTO;
import cu.edu.cujae.structbd.dto.user_role.ReadUserRoleDTO;
import cu.edu.cujae.structbd.exceptions.app.EmptyFieldFormException;
import cu.edu.cujae.structbd.exceptions.user.DuplicateUserException;
import cu.edu.cujae.structbd.exceptions.user.ShortUsernameException;
import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.utils.AppCustomDialog;
import cu.edu.cujae.structbd.utils.UtilsConnector;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Hector Angel Gomez
 */
public class UpdateUserUI extends AppCustomDialog{
    private ReadUserDTO user = null;
    private List<ReadUserRoleDTO> selectRoles = new LinkedList<>();
    private boolean currentUserUpdate;

    /**
     * Creates new form UpdateUserUI
     */
    public UpdateUserUI(java.awt.Frame parent, ActualUserDTO actualUser) {
        super(parent, true);
        this.user = new ReadUserDTO(actualUser.getID(), actualUser.getUsername(), actualUser.getRole(), null, actualUser.getRoleID());
        this.currentUserUpdate = true;
    }
    
    public UpdateUserUI(java.awt.Frame parent, ReadUserDTO user) {
        super(parent, true);
        this.user = user;
        this.currentUserUpdate = false;
    }

    @Override
    public void start() {
        initComponents();
        this.updateUI();
    }
    
    public void updateUI(){
        this.jTextField1.setText(user.getUsername());  
        this.jComboBox1.removeAllItems();
        
        if(this.currentUserUpdate){   
            this.jComboBox1.addItem(user.getRole());
            this.jComboBox1.setEnabled(false);
        }else {
            try {
                this.selectRoles.clear();
                List<ReadUserRoleDTO> allRoles = ServicesLocator.UserRoleServices.readUserRoles();
                
                ReadUserRoleDTO foundRole = ServicesLocator.UserRoleServices.findRole(new FindUserRoleDTO(this.user.getRoleID()));
                this.selectRoles.add(foundRole);
                
                for(ReadUserRoleDTO r: allRoles){
                    if(r.getUserRoleID() != foundRole.getUserRoleID())
                        this.selectRoles.add(r);
                }
                
                for(ReadUserRoleDTO r: this.selectRoles){
                    this.jComboBox1.addItem(r.getRoleName());
                }
               
            } catch (SQLException | ClassNotFoundException  ex) {
                UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
            } 
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre de Usuario:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Cancelar");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Rol:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addGap(1, 1, 1))
                            .addComponent(jComboBox1, 0, 227, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String newUsername = this.jTextField1.getText();
            if(currentUserUpdate){
                UpdateUserDTO updateUser = new UpdateUserDTO(user.getUserID(), newUsername, null, null, this.user.getRoleID());
                ServicesLocator.UserServices.updateUser(updateUser);              
            }
            else {
                int selRol = this.jComboBox1.getSelectedIndex();
                ReadUserRoleDTO sr = this.selectRoles.get(selRol);
                
                UpdateUserDTO updateUser = new UpdateUserDTO(user.getUserID(), newUsername, null, null, sr.getUserRoleID());
                ServicesLocator.UserServices.updateUser(updateUser);
            }
            
            UtilsConnector.viewMessagesUtils.showSuccessMessage(this, "Usuario actualizado."); 
            this.dispose();
        } catch (SQLException | ClassNotFoundException ex) {
            UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
        } catch (EmptyFieldFormException ex) {
            UtilsConnector.viewMessagesUtils.showErrorMessage(this, ex.getMessage());
        } catch (DuplicateUserException ex) {
            UtilsConnector.viewMessagesUtils.showErrorMessage(this, "Ya existe un usuario con ese nombre.");
        } catch (ShortUsernameException ex) {
            UtilsConnector.viewMessagesUtils.showErrorMessage(this, ex.getMessage());
        } 
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
