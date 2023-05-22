/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package cu.edu.cujae.structbd.visual.pitcher;

import cu.edu.cujae.structbd.dto.pitcher.CreatePitcherDTO;
import cu.edu.cujae.structbd.dto.team.ReadTeamDTO;
import cu.edu.cujae.structbd.exceptions.team_member.EmptyMemberNameException;
import cu.edu.cujae.structbd.exceptions.team_member.DuplicateMemberNumberException;
import cu.edu.cujae.structbd.exceptions.team_member.WrongMemberNumberException;
import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.utils.UtilsConnector;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Amaya
 */
public class CreatePitcherUI extends javax.swing.JDialog {
    PitcherUI parentWindow;
    private final String SELECT_TEXT = "<Seleccione>";
    private List<ReadTeamDTO> teamsToInsert = new LinkedList<>();
    
    /**
     * Creates new form CreatePitcherUI
     */
    public CreatePitcherUI(PitcherUI parent, boolean modal) {
        super(parent, modal);
        this.parentWindow = parent;
        
        initComponents();
        this.updateUI();
    }
    
    private void updateUI(){
        try {
            this.jComboBoxTeamName.removeAllItems();
            this.jComboBoxTeamName.addItem(SELECT_TEXT);
              
            teamsToInsert = ServicesLocator.TeamServices.getTeamsForInsertPitcher();
            
            if(teamsToInsert.isEmpty()){
                this.jButtonInsert.setEnabled(false);
                this.jComboBoxTeamName.setEnabled(false);
                
                UtilsConnector.viewMessagesUtils.showErrorMessage(this, "Todos los equipos se encuentran con el máximo de pitchers admitidos.");
                this.dispose();
            }else {
                for(ReadTeamDTO t: teamsToInsert){
                    this.jComboBoxTeamName.addItem(t.getTeam_name());
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
           UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
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

        jButtonClose = new javax.swing.JButton();
        jButtonInsert = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jSpinnerNumber = new javax.swing.JSpinner();
        jLabelNumber = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxTeamName = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insertar Pitcher");

        jButtonClose.setText("Cerrar");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonInsert.setText("Insertar");
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        jLabelName.setText("Nombre:");

        jSpinnerNumber.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

        jLabelNumber.setText("Número de jugador:");

        jLabel1.setText("Equipo:");

        jComboBoxTeamName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClose))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBoxTeamName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldName))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelNumber)
                            .addGap(18, 18, 18)
                            .addComponent(jSpinnerNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonInsert))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        // TODO add your handling code here:
        String name = jTextFieldName.getText();
        int team_index = jComboBoxTeamName.getSelectedIndex();
        Integer number = (Integer) jSpinnerNumber.getValue();
        
        if(team_index == 0){
           UtilsConnector.viewMessagesUtils.showErrorMessage(this, "Debe seleccionar un equipo para el pitcher");
        }else {
            CreatePitcherDTO createPitcherDTO = new CreatePitcherDTO(name, number, this.teamsToInsert.get(team_index - 1).getTeam_id());
        
            try {
                ServicesLocator.PitcherServices.createPitcher(createPitcherDTO);
                this.parentWindow.updateUI();
                UtilsConnector.viewMessagesUtils.showSuccessMessage(this, "Lanzador insertado correctamente");
                this.parentWindow.updateUI();
                this.dispose();
            } catch (SQLException | ClassNotFoundException ex) {
                UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
            } catch (EmptyMemberNameException ex) {
                UtilsConnector.viewMessagesUtils.showErrorMessage(this, "El pitcher tiene que tener un nombre");
            } catch (WrongMemberNumberException ex) {
                UtilsConnector.viewMessagesUtils.showErrorMessage(this, ex.getMessage());
            } catch (DuplicateMemberNumberException ex) {
                UtilsConnector.viewMessagesUtils.showErrorMessage(this, "Ya existe un miembro del equipo con ese número");
            } 
        }        
    }//GEN-LAST:event_jButtonInsertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JComboBox<String> jComboBoxTeamName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JSpinner jSpinnerNumber;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
