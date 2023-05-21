/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cu.edu.cujae.structbd.visual.player;

import cu.edu.cujae.structbd.dto.pitcher.DeletePitcherDTO;
import cu.edu.cujae.structbd.dto.pitcher.ReadAPitcherDTO;
import cu.edu.cujae.structbd.dto.pitcher.ReadPitcherDTO;
import cu.edu.cujae.structbd.dto.pitcher.UpdatePitcherDTO;
import cu.edu.cujae.structbd.dto.player.ReadPlayerDTO;
import cu.edu.cujae.structbd.dto.team.ReadTeamDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.utils.AppCustomWindow;
import cu.edu.cujae.structbd.utils.UtilsConnector;
import cu.edu.cujae.structbd.visual.pitcher.UpdatePitcherUI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class Player_UI extends AppCustomWindow
{

    private LinkedList<ReadPlayerDTO> list_player;

    public void start()
    {
        initComponents();
        update_list();
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
        menuMod = new javax.swing.JMenuItem();
        menuDel = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        menuMod.setText("Modificar jugador");
        menuMod.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuModActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuMod);

        menuDel.setText("Eliminar jugador");
        menuDel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuDelActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuDel);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jugadores");
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                formFocusGained(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Nombre", "Equipo", "Número", "Posición", "Años en el equipo"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuModActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuModActionPerformed
    {//GEN-HEADEREND:event_menuModActionPerformed
        int row = table.getSelectedRow();
        if (row > 0)
        {
            String name = table.getValueAt(row, 0).toString();
            String team = table.getValueAt(row, 1).toString();
            Integer number = Integer.valueOf(table.getValueAt(row, 2).toString());
            String position = table.getValueAt(row, 3).toString();
            Integer years_in_team = Integer.valueOf(table.getValueAt(row, 4).toString());
            Iterator<ReadPlayerDTO> it_list = this.list_player.iterator();
            int id = 0;
            boolean found = false;

            //Buscando el id del player seleccionado 
            while (it_list.hasNext() && !found)
            {
                ReadPlayerDTO readPlayerDTO = it_list.next();
                if (readPlayerDTO.getTeam_name().
                    equalsIgnoreCase(team) && readPlayerDTO.getMember_number() == number)
                {
                    id = readPlayerDTO.getTeam_member_ID();
                    found = true;
                }
            }
            if (found)
            {
                //Llamadas a los servicios de update
                if (position == "P")
                {
                    try
                    {
                        ReadAPitcherDTO readAPitcherDTO = new ReadAPitcherDTO(id);
                        ReadPitcherDTO readPitcherDTO = ServicesLocator.PitcherServices.readPitcher(readAPitcherDTO);
                        ArrayList<ReadTeamDTO> teams_list = ServicesLocator.TeamServices.readTeams();
                        boolean found_team = false;
                        int team_id = 0;
                        for (int i = 0; i < teams_list.size() && !found_team; i++)
                        {
                            if (teams_list.get(i).getTeam_name().equalsIgnoreCase(team))
                            {
                                found_team = true;
                                team_id = teams_list.get(i).getTeam_id();
                            }
                        }
                        UpdatePitcherDTO updatePitcherDTO = new UpdatePitcherDTO(readPitcherDTO.getTeamMemberID(),
                                                                                 "P", readPitcherDTO.getTeamMemberName(),
                                                                                 readPitcherDTO.getMemberNumber(),
                                                                                 team_id, readPitcherDTO.
                                                                                     getYearsInTeam(), readPitcherDTO.
                                                                                     getInningsPitched(),
                                                                                 readPitcherDTO.
                                                                                     getRunsAllowed());
                        UpdatePitcherUI updatePitcherUI = new UpdatePitcherUI(null, true, updatePitcherDTO);
                        updatePitcherUI.setVisible(true);
                    }
                    catch (SQLException | ClassNotFoundException ex)
                    {
                        UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(rootPane, ex);
                    }

                }
                else
                {
                    //ReadABatterDTO readABatterDTO = new ReadABatterDTO(id);
                    //ReadBatterDTO readBatterDTO = ServicesLocator.BatterServices.readABatter(   );
                    //UpdateBatterDTO updateBatterDTO = new UpdatePitcherDTO(          );
                }
                update_list();
            }
            else
            {
                UtilsConnector.viewMessagesUtils.showSuccessMessage(rootPane,
                                                                    "El identificador del jugador no se encuentra en la base de datos");
            }
        }
        else
        {
            UtilsConnector.viewMessagesUtils.
                showSuccessMessage(rootPane, "Seleccione un jugador para poder modificarlo");
        }
    }//GEN-LAST:event_menuModActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void menuDelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuDelActionPerformed
    {//GEN-HEADEREND:event_menuDelActionPerformed
        int row = table.getSelectedRow();
        if (row >= 0)
        {
            String name = table.getValueAt(row, 0).toString();
            String team = table.getValueAt(row, 1).toString();
            Integer number = Integer.valueOf(table.getValueAt(row, 2).toString());
            String position = table.getValueAt(row, 3).toString();
            Integer years_in_team = Integer.valueOf(table.getValueAt(row, 4).toString());
            Iterator<ReadPlayerDTO> it_list = this.list_player.iterator();
            int id = 0;
            boolean found = false;

            //Buscando el id del player seleccionado 
            while (it_list.hasNext() && !found)
            {
                ReadPlayerDTO readPlayerDTO = it_list.next();
                if (readPlayerDTO.getTeam_name().
                    equalsIgnoreCase(team) && readPlayerDTO.getMember_number() == number)
                {
                    id = readPlayerDTO.getTeam_member_ID();
                    found = true;
                }
            }
            if (found)
            {
                //Llamada a los servicios de delete
                if (position == "P")
                {
                    try
                    {
                        DeletePitcherDTO deletePitcherDTO = new DeletePitcherDTO(id);
                        ServicesLocator.PitcherServices.deletePitcher(deletePitcherDTO);
                    }
                    catch (SQLException | ClassNotFoundException ex)
                    {
                        UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(rootPane, ex);
                    }

                }
                else
                {
                    //DeleteBatterDTO deleteBatterDTO = new DeleteBatterDTO(id);
                    //ServicesLocator.BatterServices.deleteBatter(deleteBatterDTO);
                }
                update_list();
            }
            else
            {
                UtilsConnector.viewMessagesUtils.showSuccessMessage(rootPane,
                                                                    "El identificador del jugador no se encuentra en la base de datos");
            }
        }
        else
        {
            UtilsConnector.viewMessagesUtils.showSuccessMessage(rootPane, "Seleccione un jugador para poder eliminarlo");
        }
    }//GEN-LAST:event_menuDelActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_formFocusGained
    {//GEN-HEADEREND:event_formFocusGained
        update_list();
    }//GEN-LAST:event_formFocusGained

    public void update_list()
    {
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();

        int count = model.getRowCount();
        for (int i = 0; i < count; i++)
        {
            model.removeRow(0);
        }
        try
        {
            this.list_player = new LinkedList<>(ServicesLocator.PlayerServices.readAllPlayer());
            Iterator<ReadPlayerDTO> it_list_player = list_player.iterator();
            while (it_list_player.hasNext())
            {
                ReadPlayerDTO readPlayerDTO = it_list_player.next();
                ((DefaultTableModel) table.getModel()).addRow(new Object[]
                {
                    readPlayerDTO.getTeam_member_name(), readPlayerDTO.getTeam_name(), readPlayerDTO.getMember_number(),
                    readPlayerDTO.getPosition_name(), readPlayerDTO.getYears_in_team()
                });
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuDel;
    private javax.swing.JMenuItem menuMod;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
