/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cu.edu.cujae.structbd.visual.phase;

import cu.edu.cujae.structbd.dto.phase.DeletePhaseDTO;
import cu.edu.cujae.structbd.dto.phase.ReadPhaseDTO;
import cu.edu.cujae.structbd.dto.phase.UpdatePhaseDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hector Angel Gomez
 */
public class PhaseUI extends javax.swing.JFrame {

    private LinkedList<ReadPhaseDTO> readPhaseDTO_list;
    /**
     * Creates new form PhaseUI
     */
    public PhaseUI() {
        initComponents();
        try
        {
            this.readPhaseDTO_list = new LinkedList<>(ServicesLocator.PhaseServices.readAllPhase());
            Iterator<ReadPhaseDTO> it_readPhaseDTO_list = readPhaseDTO_list.iterator();
            while (it_readPhaseDTO_list.hasNext())
            {
                ReadPhaseDTO readPhaseDTO = it_readPhaseDTO_list.next();
                ((DefaultTableModel) table.getModel()).addRow(new Object[]
                {
                    readPhaseDTO.getPhase_name(), readPhaseDTO.getStart_date().toString(),
                    readPhaseDTO.getFinish_date().toString(), readPhaseDTO.getTeams_amount()
                });
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(PhaseUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(PhaseUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuUpdate = new javax.swing.JMenuItem();
        menuDelete = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        menuUpdate.setText("Modificar fase");
        menuUpdate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuUpdateActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuUpdate);

        menuDelete.setText("Eliminar fase");
        menuDelete.setToolTipText("");
        menuDelete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuDeleteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuDelete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                formFocusGained(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Insertar");
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Nombre", "Fecha de inicio", "Fecha de fin", "Equipos"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        table.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuUpdateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuUpdateActionPerformed
    {//GEN-HEADEREND:event_menuUpdateActionPerformed
        int row = table.getSelectedRow();
        if (row > 0)
        {
            String name = table.getValueAt(row, 0).toString();
            String start_date = table.getValueAt(row, 1).toString();
            String finish_date = table.getValueAt(row, 2).toString();
            int teams_amount = Integer.valueOf(table.getValueAt(row, 3).toString());
            Iterator<ReadPhaseDTO> it_list = this.readPhaseDTO_list.iterator();
            String id = null;
            boolean found = false;

            //Buscando el id de la fase seleccionada 
            while (it_list.hasNext() && !found)
            {
                ReadPhaseDTO readPhaseDTO = it_list.next();
                if (readPhaseDTO.getPhase_name().equals(name))
                {
                    id = readPhaseDTO.getPhase_id();
                    found = true;
                }
            }

            //Llamada a la funcion de modificar
            if (found)
            {
                LocalDate sd = LocalDate.of(Integer.valueOf(start_date.substring(0, 4)), Integer.valueOf(start_date.
                                            substring(5, 7)), Integer.valueOf(start_date.substring(8, 10)));
                LocalDate fd = LocalDate.of(Integer.valueOf(finish_date.substring(0, 4)), Integer.valueOf(finish_date.
                                            substring(5, 7)), Integer.valueOf(finish_date.substring(8, 10)));
                UpdatePhaseDTO updatePhaseDTO = new UpdatePhaseDTO(id, name, sd, fd, teams_amount);
                UpdatePhaseUI ufui = new UpdatePhaseUI(null, true, updatePhaseDTO);
                ufui.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "La fase no se encuentra en la base de datos", "Información",
                                              HEIGHT);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una fase para poder modificarla", "Información",
                                          HEIGHT);
        }
    }//GEN-LAST:event_menuUpdateActionPerformed

    private void menuDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuDeleteActionPerformed
    {//GEN-HEADEREND:event_menuDeleteActionPerformed
        int row = table.getSelectedRow();
        System.out.println(String.valueOf(row));
        if (row > 0)
        {
            String name = table.getValueAt(row, 0).toString();
            System.out.println(name);
            String start_date = table.getValueAt(row, 1).toString();
            String finish_date = table.getValueAt(row, 2).toString();
            int teams_amount = Integer.valueOf(table.getValueAt(row, 3).toString());
            Iterator<ReadPhaseDTO> it_list = this.readPhaseDTO_list.iterator();
            String id = null;
            boolean found = false;

            //Buscando el id de la fase seleccionada 
            while (it_list.hasNext() && !found)
            {
                ReadPhaseDTO readPhaseDTO = it_list.next();
                if (readPhaseDTO.getPhase_name().equals(name))
                {
                    id = readPhaseDTO.getPhase_id();
                    found = true;
                }
            }

            //Llamada a la funcion de eliminar
            if (found)
            {
                try
                {
                    DeletePhaseDTO deletePhaseDTO = new DeletePhaseDTO(id);
                    ServicesLocator.PhaseServices.deletePhase(deletePhaseDTO);
                }
                catch (SQLException ex)
                {
                    Logger.getLogger(PhaseUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(PhaseUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_menuDeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        CreatePhaseUI cpui = new CreatePhaseUI(this, rootPaneCheckingEnabled);
        cpui.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_formFocusGained
    {//GEN-HEADEREND:event_formFocusGained
        try
        {
            this.readPhaseDTO_list.clear();
            this.readPhaseDTO_list = new LinkedList<>(ServicesLocator.PhaseServices.readAllPhase());
            Iterator<ReadPhaseDTO> it_readPhaseDTO_list = readPhaseDTO_list.iterator();
            while (it_readPhaseDTO_list.hasNext())
            {
                ReadPhaseDTO readPhaseDTO = it_readPhaseDTO_list.next();
                ((DefaultTableModel) table.getModel()).addRow(new Object[]
                {
                    readPhaseDTO.getPhase_name(), readPhaseDTO.getStart_date().toString(),
                    readPhaseDTO.getFinish_date().toString(), readPhaseDTO.getTeams_amount()
                });
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(PhaseUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(PhaseUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formFocusGained

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
            java.util.logging.Logger.getLogger(PhaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhaseUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuDelete;
    private javax.swing.JMenuItem menuUpdate;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}