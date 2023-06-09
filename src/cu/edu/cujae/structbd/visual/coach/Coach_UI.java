/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cu.edu.cujae.structbd.visual.coach;

import cu.edu.cujae.structbd.dto.coach.DeleteCoachDTO;
import cu.edu.cujae.structbd.dto.coach.ReadCoachDTO;
import cu.edu.cujae.structbd.dto.coach.UpdateCoachDTO;
import cu.edu.cujae.structbd.dto.team.ReadTeamDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.utils.AppCustomWindow;
import cu.edu.cujae.structbd.utils.UtilsConnector;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class Coach_UI extends AppCustomWindow
{
    
    private LinkedList<ReadCoachDTO> readCoachDTO_list;

    @Override
    public void start()
    {
        initComponents();
        UtilsConnector.viewUtils.disableButtonsByUser(insertButton, menuUpdate, menuDelete);
        this.updateList();
    }
    
    public void updateList()
    {
        try
        {
            DefaultTableModel model = (DefaultTableModel) this.table.getModel();
            
            int count = model.getRowCount();
            for (int i = 0; i < count; i++)
            {
                model.removeRow(0);
            }
            
            this.readCoachDTO_list = new LinkedList<>(ServicesLocator.CoachServices.readAllCoaches());
            Iterator<ReadCoachDTO> it_list = readCoachDTO_list.iterator();
            while (it_list.hasNext())
            {
                ReadCoachDTO readCoachDTO = it_list.next();
                ((DefaultTableModel) table.getModel()).addRow(new Object[]
                {
                    readCoachDTO.getTeam_member_name(),
                    readCoachDTO.getTeam_name(),
                    readCoachDTO.getMember_number(),
                    readCoachDTO.getExperience_years(),
                    readCoachDTO.getYears_in_team()
                }
                );
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuUpdate = new javax.swing.JMenuItem();
        menuDelete = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        insertButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        menuUpdate.setText("Modificar entrenador");
        menuUpdate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuUpdateActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuUpdate);

        menuDelete.setText("Eliminar entrenador");
        menuDelete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuDeleteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuDelete);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrenadores");
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                formFocusGained(evt);
            }
        });

        jButton2.setText("Cerrar");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2)
        );

        insertButton.setText("Insertar");
        insertButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                insertButtonActionPerformed(evt);
            }
        });

        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Nombre", "Equipo", "Número", "Años de experiencia", "Años en el equipo"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 489, Short.MAX_VALUE)
                        .addComponent(insertButton))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(insertButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_insertButtonActionPerformed
    {//GEN-HEADEREND:event_insertButtonActionPerformed
        CreateCoachUI ccui = new CreateCoachUI(this, rootPaneCheckingEnabled);
        ccui.setVisible(true);
    }//GEN-LAST:event_insertButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void menuUpdateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuUpdateActionPerformed
    {//GEN-HEADEREND:event_menuUpdateActionPerformed
        int row = table.getSelectedRow();
        if (row >= 0)
        {
            //Obteniendo los datos de la fila seleccionada
            String name = table.getValueAt(row, 0).toString();
            String team = table.getValueAt(row, 1).toString();
            Integer number = Integer.valueOf(table.getValueAt(row, 2).toString());
            Integer years_exp = Integer.valueOf(table.getValueAt(row, 3).toString());
            Integer years_team = Integer.valueOf(table.getValueAt(row, 4).toString());
            int id = -1;
            boolean found = false;
            Iterator<ReadCoachDTO> it = this.readCoachDTO_list.iterator();
            while (it.hasNext() && !found)
            {
                ReadCoachDTO rc = it.next();
                if (rc.getTeam_member_name().equalsIgnoreCase(name) && rc.getTeam_name().equalsIgnoreCase(team) && rc.
                    getMember_number() == number)
                {
                    id = rc.getTeam_member_ID();
                    found = true;
                }
            }

            if (found)
            {
                try
                {
                    //Buscando el id del equipo del entrenador para construir el UpdateCoachDTO
                    ArrayList<ReadTeamDTO> list_teams = ServicesLocator.TeamServices.readTeams();
                    boolean found_team = false;
                    int team_id = -1;
                    for (int i = 0; i < list_teams.size() && !found_team; i++)
                    {
                        ReadTeamDTO readTeamDTO = list_teams.get(i);
                        if (readTeamDTO.getTeam_name().equalsIgnoreCase(team))
                        {
                            found_team = true;
                            team_id = readTeamDTO.getTeam_id();
                        }
                    }

                    //Creando la ventana y pasando los datos para modificar al entrenador
                    UpdateCoachDTO updateCoachDTO = new UpdateCoachDTO(id, name, number, team_id, years_exp, years_team);
                    UpdateCoachUI upui = new UpdateCoachUI(this, true, updateCoachDTO);
                    upui.setVisible(true);
                    this.updateList();
                }
                catch (SQLException | ClassNotFoundException ex)
                {
                    UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
                }
            }
        }
        else
        {
            UtilsConnector.viewMessagesUtils.showErrorMessage(this,
                                                              "Seleccione un entrenador para poder modificar sus datos");
        }
    }//GEN-LAST:event_menuUpdateActionPerformed

    private void menuDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuDeleteActionPerformed
    {//GEN-HEADEREND:event_menuDeleteActionPerformed
        int row = table.getSelectedRow();
        if (row >= 0)
        {
            try
            {
                String name = table.getValueAt(row, 0).toString();
                if (JOptionPane.
                    showConfirmDialog(this, "¿Estás seguro que desea eliminar " + name + " ?", "Eliminar entrenador",
                                      JOptionPane.YES_NO_OPTION) == 0)
                {
                    //Obteniendo los valores de la fila seleccionada    
                    String team = table.getValueAt(row, 1).toString();
                    Integer number = Integer.valueOf(table.getValueAt(row, 2).toString());

                    //Obteniendo el id del equipo del entrenador
                    ArrayList<ReadTeamDTO> list_teams = ServicesLocator.TeamServices.readTeams();
                    boolean found_team = false;
                    int team_id = -1;
                    for (int i = 0; i < list_teams.size() && !found_team; i++)
                    {
                        ReadTeamDTO readTeamDTO = list_teams.get(i);
                        if (readTeamDTO.getTeam_name().equalsIgnoreCase(team))
                        {
                            found_team = true;
                            team_id = readTeamDTO.getTeam_id();
                        }
                    }
                    //Verificando si el equipo no tiene la mínima cantidad de entrenadores para poder eliminar al entrenador
                    LinkedList<ReadCoachDTO> list_coaches = new LinkedList<>(ServicesLocator.TeamServices.
                        readCoachsFromTeam(new ReadTeamDTO(team_id, null, 0, 0, null, null, null, null)));
                    if (list_coaches.size() > 5)
                    {
                        //Obteniendo el id del entrenador seleccionado
                        int id = -1;
                        boolean found = false;
                        Iterator<ReadCoachDTO> it = this.readCoachDTO_list.iterator();
                        while (it.hasNext() && !found)
                        {
                            ReadCoachDTO rc = it.next();
                            if (rc.getTeam_member_name().equalsIgnoreCase(name) && rc.getTeam_name().equalsIgnoreCase(
                                team) && rc.
                                    getMember_number() == number)
                            {
                                id = rc.getTeam_member_ID();
                                found = true;
                            }
                        }

                        //Eliminando al entrenador
                        if (found)
                        {
                            ServicesLocator.CoachServices.deleteCoach(new DeleteCoachDTO(id));
                            UtilsConnector.viewMessagesUtils.showSuccessMessage(this, "Entrenador eliminado satisfactoriamente.");
                            this.updateList();
                        }
                    }
                    else
                    {
                        UtilsConnector.viewMessagesUtils.showErrorMessage(this,
                                                                          "No es posible eliminar al entrenador " + name + " su equipo tiene la mínima cantidad de entrenadores necesaria");
                    }
                }
            }
            catch (SQLException | ClassNotFoundException ex)
            {
                UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
            }
        }
        else
        {
            UtilsConnector.viewMessagesUtils.showSuccessMessage(this,
                                                                "Seleccione un entrenador para poder modificar sus datos");
        }
    }//GEN-LAST:event_menuDeleteActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_formFocusGained
    {//GEN-HEADEREND:event_formFocusGained
        this.updateList();
    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton insertButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuDelete;
    private javax.swing.JMenuItem menuUpdate;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
