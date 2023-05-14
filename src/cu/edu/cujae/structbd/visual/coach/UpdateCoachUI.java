/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package cu.edu.cujae.structbd.visual.coach;

import cu.edu.cujae.structbd.dto.coach.UpdateCoachDTO;
import cu.edu.cujae.structbd.dto.team.ReadTeamDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class UpdateCoachUI extends javax.swing.JDialog
{
    private UpdateCoachDTO updateCoachDTO;
    /**
     * Creates new form CreateCoachUI
     */
    public UpdateCoachUI(java.awt.Frame parent, boolean modal, UpdateCoachDTO updateCoachDTO)
    {
        super(parent, modal);
        initComponents();
         
        try
        {
            this.updateCoachDTO = updateCoachDTO;
            this.field_name.setText(this.updateCoachDTO.getTeam_member_name());
            this.spinner_exp.setValue(this.updateCoachDTO.getExperience_years());
            this.spinner_number.setValue(this.updateCoachDTO.getMember_number());
            this.spinner_team.setValue(this.updateCoachDTO.getYears_in_team());
            ArrayList<ReadTeamDTO> teams_list = ServicesLocator.TeamServices.readTeams();
            for (int i = 0; i < teams_list.size(); i++)
            {
                combo_box_team.addItem(teams_list.get(i).getTeam_name());
            }
            
             this.activate_button();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(UpdateCoachUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(UpdateCoachUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        field_name = new javax.swing.JTextField();
        combo_box_team = new javax.swing.JComboBox<>();
        spinner_number = new javax.swing.JSpinner();
        spinner_exp = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spinner_team = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insertar Entrenador");
        setModal(true);

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel2.setText("Equipo:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setText("Número:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel4.setText("Años de experiencia:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        field_name.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                field_nameActionPerformed(evt);
            }
        });
        field_name.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                field_nameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                field_nameKeyTyped(evt);
            }
        });
        jPanel2.add(field_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 180, -1));

        combo_box_team.setMaximumRowCount(18);
        jPanel2.add(combo_box_team, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 180, -1));

        spinner_number.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        jPanel2.add(spinner_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 180, -1));

        spinner_exp.setModel(new javax.swing.SpinnerNumberModel(0, 0, 40, 1));
        jPanel2.add(spinner_exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 120, -1));

        jLabel5.setText("Años en el equipo:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        jPanel2.add(spinner_team, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void field_nameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_field_nameActionPerformed
    {//GEN-HEADEREND:event_field_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        if (validate_name())
        {
            try
        {
            String name = field_name.getText();
            String team = combo_box_team.getSelectedItem().toString();
            int number = (int) spinner_number.getValue();
            int y_exp = (int) spinner_exp.getValue();
            int y_team = (int) spinner_team.getValue();
            ArrayList<ReadTeamDTO> teams_list_2 = ServicesLocator.TeamServices.readTeams();
            boolean found_team = false;
            String team_id = null;
            for (int i = 0; i < teams_list_2.size() && !found_team; i++)
            {
                if (teams_list_2.get(i).getTeam_name().equalsIgnoreCase(team))
                {
                    found_team = true;
                    team_id = teams_list_2.get(i).getTeam_id();
                }
            }
            updateCoachDTO.setTeam_name(team_id);
            updateCoachDTO.setExperience_years(y_exp);
            updateCoachDTO.setMember_number(number);
            updateCoachDTO.setTeam_member_name(name);
            updateCoachDTO.setYears_in_team(y_team);

            ServicesLocator.CoachServices.updateCoach(updateCoachDTO);
            JOptionPane.showMessageDialog(null, name + " se ha modificado correctamente", "Confirmación", HEIGHT);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(UpdateCoachUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(UpdateCoachUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }
        else
        {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void field_nameKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_field_nameKeyTyped
    {//GEN-HEADEREND:event_field_nameKeyTyped
        char key = evt.getKeyChar();
        if (!Character.isAlphabetic(key) && !Character.isSpaceChar(key))
        {
            evt.consume();
        }
    }//GEN-LAST:event_field_nameKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void field_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_nameKeyReleased
this.activate_button();        // TODO add your handling code here:
    }//GEN-LAST:event_field_nameKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(UpdateCoachUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(UpdateCoachUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(UpdateCoachUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(UpdateCoachUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        /*java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                UpdateCoachUI dialog = new UpdateCoachUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });*/
    }
    
    public boolean validate_name()
    {
        boolean result = true;
        boolean flag;
        String nombre = field_name.getText();
        for (int i = 0; i < nombre.length() && result; i++)
        {
            flag = Character.isUpperCase(nombre.charAt(0)) && nombre.charAt(0) != ' ' && (Character.isLetter(nombre.
                                                                                          charAt(i)) || nombre.charAt(i) == ' ');
            if (!flag)
            {
                result = false;
                JOptionPane.showMessageDialog(null, "El nombre debe iniciar con letra mayúscula", "Nombre incorrecto",
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
        return result;
    }
    
    public void activate_button(){
        if (field_name.getText().isEmpty()){
            jButton2.setEnabled(false);
        } else {
            jButton2.setEnabled(true);
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_box_team;
    private javax.swing.JTextField field_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner spinner_exp;
    private javax.swing.JSpinner spinner_number;
    private javax.swing.JSpinner spinner_team;
    // End of variables declaration//GEN-END:variables
}
