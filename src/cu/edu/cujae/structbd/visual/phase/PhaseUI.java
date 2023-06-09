/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cu.edu.cujae.structbd.visual.phase;

import cu.edu.cujae.structbd.dto.phase.DeletePhaseDTO;
import cu.edu.cujae.structbd.dto.phase.ReadPhaseDTO;
import cu.edu.cujae.structbd.dto.phase.UpdatePhaseDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.utils.AppCustomWindow;
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
public class PhaseUI extends AppCustomWindow {

    private LinkedList<ReadPhaseDTO> readPhaseDTO_list;
    
    public void start(){
        initComponents();
        this.updateList();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fases");
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                formFocusGained(evt);
            }
        });

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
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
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuUpdateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuUpdateActionPerformed
    {//GEN-HEADEREND:event_menuUpdateActionPerformed
        int row = table.getSelectedRow();
        if (row >= 0)
        {
            String name = table.getValueAt(row, 0).toString();
            String start_date = table.getValueAt(row, 1).toString();
            String finish_date = table.getValueAt(row, 2).toString();
            int teams_amount = Integer.valueOf(table.getValueAt(row, 3).toString());
            Iterator<ReadPhaseDTO> it_list = this.readPhaseDTO_list.iterator();
            int id = -1;
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
                UpdatePhaseDTO updatePhaseDTO = new UpdatePhaseDTO(id, name, sd, fd, teams_amount, false);
                
                this.updateList();
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

        if (row >= 0)
        {
            String name = table.getValueAt(row, 0).toString();
            System.out.println(name);
            String start_date = table.getValueAt(row, 1).toString();
            String finish_date = table.getValueAt(row, 2).toString();
            int teams_amount = Integer.valueOf(table.getValueAt(row, 3).toString());
            Iterator<ReadPhaseDTO> it_list = this.readPhaseDTO_list.iterator();
            int id = -1;
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
                    this.updateList();
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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


    public void updateList(){
                try
        {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
           int count = ((DefaultTableModel) table.getModel()).getRowCount();
           for(int i = 0; i < count; i++){
               model.removeRow(0);
           }

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuDelete;
    private javax.swing.JMenuItem menuUpdate;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
