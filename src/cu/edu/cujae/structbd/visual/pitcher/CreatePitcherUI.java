/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package cu.edu.cujae.structbd.visual.pitcher;

import cu.edu.cujae.structbd.dto.pitcher.CreatePitcherDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Amaya
 */
public class CreatePitcherUI extends javax.swing.JDialog {
    
    PitcherUI parentWindow;
    
    /**
     * Creates new form CreatePitcherUI
     */
    public CreatePitcherUI(PitcherUI parent, boolean modal) {
        super(parent, modal);
        this.parentWindow = parent;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonClose = new javax.swing.JButton();
        jButtonInsert = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jSpinnerNumber = new javax.swing.JSpinner();
        jLabelNumber = new javax.swing.JLabel();
        jSpinnerYearsInTeam = new javax.swing.JSpinner();
        jLabelYearsInTeam = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxTeamName = new javax.swing.JComboBox<>();
        jLabelInnings = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinnerInnings = new javax.swing.JSpinner();
        jSpinnerRuns = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insertar Pitcher");

        jButtonClose.setText("Cerrar");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonInsert.setText("Insertar");
        jButtonInsert.setEnabled(false);
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jLabelName.setText("Nombre:");

        jSpinnerNumber.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabelNumber.setText("Número de jugador:");

        jSpinnerYearsInTeam.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabelYearsInTeam.setText("Años en el equipo:");

        jLabel1.setText("Equipo:");

        jComboBoxTeamName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTeamName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTeamNameActionPerformed(evt);
            }
        });

        jLabelInnings.setText("Entradas lanzadas:");

        jLabel3.setText("Carreras permitidas:");

        jSpinnerInnings.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jSpinnerRuns.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClose))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBoxTeamName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelNumber)
                                .addComponent(jLabelYearsInTeam)
                                .addComponent(jLabelInnings)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSpinnerNumber)
                                .addComponent(jSpinnerInnings)
                                .addComponent(jSpinnerRuns)
                                .addComponent(jSpinnerYearsInTeam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelName)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxTeamName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerYearsInTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelYearsInTeam))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinnerInnings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelInnings)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinnerRuns)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonInsert))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
        if(jTextFieldName.getText().strip() != "" && jComboBoxTeamName.getSelectedIndex() != 0){
            jButtonInsert.setEnabled(true);
        }
        else{
            jButtonInsert.setEnabled(false);
        }
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        // TODO add your handling code here:
        String name = jTextFieldName.getText();
        Integer team_index = jComboBoxTeamName.getSelectedIndex()-1;
        String team = jComboBoxTeamName.getSelectedItem().toString();
        Integer yearsInTeam = (Integer) jSpinnerYearsInTeam.getValue();
        Integer number = (Integer) jSpinnerNumber.getValue();
        Integer innings = (Integer) jSpinnerInnings.getValue();
        Integer runs = (Integer) jSpinnerRuns.getValue();
        
        if(name == ""){
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío", "ERROR", JOptionPane.ERROR);
        }
        if(jComboBoxTeamName.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Debe elegir un equipo", "ERROR", JOptionPane.ERROR);
        }
        
        //FALTA VALIDAR Y BUSCAR CODIGO DEL EQUIPO Y PONER LOS ERRORES QUE PUEDEN DARSE
        CreatePitcherDTO createPitcherDTO = new CreatePitcherDTO("", "P", name, number, 
                "", yearsInTeam, innings, runs);
        this.dispose();
        try {
            ServicesLocator.PitcherServices.createPitcher(createPitcherDTO);
        } catch (SQLException ex) {
            Logger.getLogger(CreatePitcherUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreatePitcherUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonInsertActionPerformed

    private void jComboBoxTeamNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTeamNameActionPerformed
        // TODO add your handling code here:
        if(jTextFieldName.getText().strip() != "" && jComboBoxTeamName.getSelectedIndex() != 0){
            jButtonInsert.setEnabled(true);
        }
        else{
            jButtonInsert.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxTeamNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreatePitcherUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatePitcherUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatePitcherUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatePitcherUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreatePitcherUI dialog = new CreatePitcherUI((PitcherUI) new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JComboBox<String> jComboBoxTeamName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelInnings;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JLabel jLabelYearsInTeam;
    private javax.swing.JSpinner jSpinnerInnings;
    private javax.swing.JSpinner jSpinnerNumber;
    private javax.swing.JSpinner jSpinnerRuns;
    private javax.swing.JSpinner jSpinnerYearsInTeam;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
