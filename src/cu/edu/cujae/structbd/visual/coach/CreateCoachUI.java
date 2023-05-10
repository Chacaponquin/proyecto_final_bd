/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package cu.edu.cujae.structbd.visual.coach;

import cu.edu.cujae.structbd.dto.coach.CreateCoachDTO;
import cu.edu.cujae.structbd.dto.team_member.ReadTeamMemberDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.utils.UtilsConnector;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class CreateCoachUI extends javax.swing.JDialog
{

    /**
     * Creates new form CreateCoachUI
     */
    public CreateCoachUI(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Insertar Entrenador");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Aceptar");
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

        field_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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

        combo_box_team.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_box_team.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                combo_box_teamActionPerformed(evt);
            }
        });
        combo_box_team.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                combo_box_teamKeyReleased(evt);
            }
        });
        jPanel2.add(combo_box_team, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 180, -1));

        spinner_number.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        jPanel2.add(spinner_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        spinner_exp.setModel(new javax.swing.SpinnerNumberModel(0, 0, 80, 1));
        jPanel2.add(spinner_exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            String id = UtilsConnector.idUtils.generateUniqueID();
            CreateCoachDTO createCoachDTO = new CreateCoachDTO(id, name, number, team, y_exp);
            ServicesLocator.CoachServices.createCoach(createCoachDTO);
            JOptionPane.showMessageDialog(null, name + " se ha insertado correctamente", "Confirmación", HEIGHT);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(CreateCoachUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(CreateCoachUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void field_nameKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_field_nameKeyReleased
    {//GEN-HEADEREND:event_field_nameKeyReleased
        activate_button();
    }//GEN-LAST:event_field_nameKeyReleased

    private void combo_box_teamActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_combo_box_teamActionPerformed
    {//GEN-HEADEREND:event_combo_box_teamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_box_teamActionPerformed

    private void combo_box_teamKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_combo_box_teamKeyReleased
    {//GEN-HEADEREND:event_combo_box_teamKeyReleased
        activate_button();
    }//GEN-LAST:event_combo_box_teamKeyReleased

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
            java.util.logging.Logger.getLogger(CreateCoachUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CreateCoachUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CreateCoachUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CreateCoachUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                                                                                  ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                CreateCoachUI dialog = new CreateCoachUI(new javax.swing.JFrame(), true);
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
        });
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner spinner_exp;
    private javax.swing.JSpinner spinner_number;
    // End of variables declaration//GEN-END:variables
}
