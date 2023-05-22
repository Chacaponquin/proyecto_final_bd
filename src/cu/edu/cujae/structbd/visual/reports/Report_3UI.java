/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package cu.edu.cujae.structbd.visual.reports;

import cu.edu.cujae.structbd.dto.game.ReadGameDTO;
import cu.edu.cujae.structbd.dto.stadium.ReadStadiumDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.utils.AppCustomDialog;
import cu.edu.cujae.structbd.utils.UtilsConnector;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Hector Angel Gomez
 */
public class Report_3UI extends AppCustomDialog {
    private List<ReadStadiumDTO> stadiums = new LinkedList<>();
    private final String SELECT_TEXT = "<Seleccione>";

    /**
     * Creates new form Report_3UI
     */
    public Report_3UI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }
    
    public void start(){
        initComponents();
        this.updateUI();
    }
    
    private void getStadiums(){
        try {
            this.jComboBox1.removeAllItems();
            this.stadiums = ServicesLocator.StadiumServices.getStadiums();
            
            this.jComboBox1.addItem(SELECT_TEXT);
            this.stadiums.forEach(s -> {
                this.jComboBox1.addItem(s.getStadiumName());
            });
        } catch (SQLException | ClassNotFoundException ex) {
            UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
        }
    }
    
    public void updateUI(){
        this.getStadiums();  
    }
    
    private void updateTable(){
        UtilsConnector.viewUtils.cleanTable(jTable1);
        List<ReadGameDTO> games = new LinkedList<>();
        
        Date gameDate = this.jCalendarDate.getDate();
        int stadiumIndex = this.jComboBox1.getSelectedIndex();
        
        
        if(gameDate != null){
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Instant iStart = gameDate.toInstant();
            LocalDate game_date = iStart.atZone(defaultZoneId).toLocalDate();

            try{
                if(stadiumIndex > 0){
                    ReadStadiumDTO selectStadium = this.stadiums.get(stadiumIndex - 1);
                    games = ServicesLocator.AppServices.getGamesByDateAndStadium(java.sql.Date.valueOf(game_date), selectStadium.getStadiumID());
                }else {
                    games = ServicesLocator.AppServices.getGamesByDateAndStadium(java.sql.Date.valueOf(game_date), null);
                }
            }catch(SQLException | ClassNotFoundException ex){
                UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
            }
        }  
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for(ReadGameDTO g: games){
            model.addRow(new Object[]{g.getPhaseName(), g.getDate().toString(), g.getHcTeamName(), g.getVisTeamName(), g.getResult(), g.getAudience()});
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

        jLabel1 = new javax.swing.JLabel();
        jCalendarDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Partidos jugados por fecha");
        setModal(true);
        setResizable(false);

        jLabel1.setText("Fecha:");

        jCalendarDate.addInputMethodListener(new java.awt.event.InputMethodListener()
        {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt)
            {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt)
            {
                jCalendarDateInputMethodTextChanged(evt);
            }
        });
        jCalendarDate.addPropertyChangeListener(new java.beans.PropertyChangeListener()
        {
            public void propertyChange(java.beans.PropertyChangeEvent evt)
            {
                jCalendarDatePropertyChange(evt);
            }
        });

        jLabel2.setText("Estadio");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Fase", "Fecha", "Home Club", "Visitante", "Marcador", "Audiencia"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Exportar");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendarDate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCalendarDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){ 
            this.updateTable();
        }     // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jCalendarDateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jCalendarDateInputMethodTextChanged
       // TODO add your handling code here:
    }//GEN-LAST:event_jCalendarDateInputMethodTextChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
    {//GEN-HEADEREND:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jCalendarDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarDatePropertyChange
        this.updateTable();
    }//GEN-LAST:event_jCalendarDatePropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Date gameDate = this.jCalendarDate.getDate();
        int stadiumIndex = this.jComboBox1.getSelectedIndex();
        
        if(gameDate != null){
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Instant iStart = gameDate.toInstant();
            LocalDate game_date = iStart.atZone(defaultZoneId).toLocalDate();
            
            HashMap<String, Object> parametros = new HashMap<>();
            parametros.put("date", game_date);
            
            if(stadiumIndex > 0){
                ReadStadiumDTO selectStadium = this.stadiums.get(stadiumIndex - 1);
                parametros.put("stadium", selectStadium.getStadiumID());
            }
            else{
                try {
                    UtilsConnector.export.exportToPDF("Report_3_2", parametros, null);
                } catch (JRException | SQLException | ClassNotFoundException ex) {
                    UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
                } 
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jCalendarDate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
