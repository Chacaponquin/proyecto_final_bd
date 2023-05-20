/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package cu.edu.cujae.structbd.visual.team;

import cu.edu.cujae.structbd.dto.batter.ReadBatterDTO;
import cu.edu.cujae.structbd.dto.coach.ReadCoachDTO;
import cu.edu.cujae.structbd.dto.pitcher.ReadPitcherDTO;
import cu.edu.cujae.structbd.dto.player.ReadPlayerDTO;
import cu.edu.cujae.structbd.dto.team.ReadTeamDTO;
import cu.edu.cujae.structbd.dto.team_member.ReadTeamMemberDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.utils.UtilsConnector;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hector Angel Gomez
 */
public class TeamMembersUI extends javax.swing.JDialog {
    private ReadTeamDTO team;
    private List<ReadTeamMemberDTO> members = new LinkedList<>();
    private List<ReadPlayerDTO> players = new LinkedList<>();
    private List<ReadCoachDTO> coachs = new LinkedList<>();
    private List<ReadPitcherDTO> pitchers = new LinkedList<>();
    private List<ReadBatterDTO> batters = new LinkedList<>();

    /**
     * Creates new form TeamMembersUI
     */
    public TeamMembersUI(java.awt.Frame parent, boolean modal, ReadTeamDTO team) {
        super(parent, modal);
        this.team = team;
        initComponents();
        this.updateUI();
    }
    
    public void updateUI(){
        try {
            this.members = ServicesLocator.TeamServices.readMembersFromTeam(this.team);
            this.players = ServicesLocator.TeamServices.readPlayerFromTeam(this.team);
            this.coachs = ServicesLocator.TeamServices.readCoachsFromTeam(this.team);
            this.pitchers = ServicesLocator.TeamServices.readPitchersFromTeam(this.team);
            this.batters = ServicesLocator.TeamServices.readBatterFromTeam(this.team);
            
            DefaultTableModel membersModel = (DefaultTableModel) this.jTable1.getModel();
            DefaultTableModel playersModel = (DefaultTableModel) this.jTable2.getModel();
            DefaultTableModel coachsModel = (DefaultTableModel) this.jTable3.getModel();
            DefaultTableModel pitchersModel = (DefaultTableModel) this.jTable4.getModel();
            DefaultTableModel battersModel = (DefaultTableModel) this.jTable5.getModel();
            
            for(ReadTeamMemberDTO m: this.members){
                membersModel.addRow(new Object[]{m.getName(), m.getNumber(), m.getYearsInTeam(), m.getMemberType()});
            }
            
            for(ReadPlayerDTO p: this.players){
                playersModel.addRow(new Object[]{p.getTeam_member_name(), p.getMember_number(), p.getPosition_name(), p.getYears_in_team()});
            }
            
            for(ReadCoachDTO c: this.coachs){
                coachsModel.addRow(new Object[]{c.getTeam_member_name(), c.getMember_number(), c.getExperience_years(),c.getExperience_years()});
            }
            
            for(ReadPitcherDTO p: this.pitchers){
                pitchersModel.addRow(new Object[]{p.getTeamMemberName(), p.getYearsInTeam(), p.getMemberNumber(), p.getInningsPitched(), p.getRunsAllowed(), p.getPCL()});
            }
            
            for(ReadBatterDTO b: this.batters){
                battersModel.addRow(new Object[]{b.getName(), b.getYearsInTeam(), b.getNumber(), b.getPosition(), b.getAtBats(), b.getTotalHits(), b.getAverage()});
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

        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        membersTable = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        playersTable = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        coachsTable = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        pitchersTable = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        battersTable = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Miembros de un Equipo");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dorsal", "Años en el Equipo", "Tipo"
            }
        ));
        membersTable.setViewportView(jTable1);

        jTabbedPane1.addTab("Miembros", membersTable);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dorsal", "Posición", "Años en el Equipo"
            }
        ));
        playersTable.setViewportView(jTable2);

        jTabbedPane1.addTab("Jugadores", playersTable);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Dorsal", "Años en el Equipo", "Años de Experiencia"
            }
        ));
        coachsTable.setViewportView(jTable3);

        jTabbedPane1.addTab("Entrenadores", coachsTable);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Años en el Equipo", "Dorsal", "Entradas Lanzadas", "Carreras Permitidas", "PCL"
            }
        ));
        pitchersTable.setViewportView(jTable4);

        jTabbedPane1.addTab("Pitchers", pitchersTable);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Años en el Equipo", "Dorsal", "Posición", "Veces al Bate", "Total de Hits", "Average"
            }
        ));
        battersTable.setViewportView(jTable5);

        jTabbedPane1.addTab("Bateadores", battersTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 809, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Miembros");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane battersTable;
    private javax.swing.JScrollPane coachsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JScrollPane membersTable;
    private javax.swing.JScrollPane pitchersTable;
    private javax.swing.JScrollPane playersTable;
    // End of variables declaration//GEN-END:variables
}
