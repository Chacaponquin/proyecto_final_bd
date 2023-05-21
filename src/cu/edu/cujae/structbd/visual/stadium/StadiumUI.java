/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cu.edu.cujae.structbd.visual.stadium;

import cu.edu.cujae.structbd.dto.stadium.ReadStadiumDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.utils.AppCustomWindow;
import cu.edu.cujae.structbd.utils.UtilsConnector;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hector Angel Gomez
 */
public class StadiumUI extends AppCustomWindow {
    private List<ReadStadiumDTO> stadiumns = new LinkedList<>();
    
    public void start(){
        try {
            initComponents(); 
            this.jTable2.setComponentPopupMenu(jPopupMenu1);
            this.updateUI();
        } catch (SQLException | ClassNotFoundException ex) {
            UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
        }
    }
    
    public void updateUI() throws SQLException, ClassNotFoundException{
        UtilsConnector.viewUtils.cleanTable(jTable2);
        stadiumns = ServicesLocator.StadiumServices.getStadiums();
        
        DefaultTableModel model = (DefaultTableModel) this.jTable2.getModel();
        
        for(ReadStadiumDTO st:  stadiumns){
            model.addRow(new Object[]{st.getStadiumName(), st.getCapacity(), st.getProvince()});
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
        editMenu = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

<<<<<<< HEAD
=======
        jMenuItem1.setText("Eliminar Estadio");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
>>>>>>> 75770589af48dd0d984136ae4133c42cc47d1318
        editMenu.setText("Editar");
        editMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuActionPerformed(evt);
            }
        });
        jPopupMenu1.add(editMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stadiums");

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Nombre", "Capacidad", "Provincia"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton2.setText("Cerrar");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuActionPerformed
        int sel = this.jTable2.getSelectedRow();
        
        if(sel >= 0){
            ReadStadiumDTO s = this.stadiumns.get(sel);
            UtilsConnector.viewUtils.openDialog(this, new UpdateStadiumUI(this, s));
        }  
    }//GEN-LAST:event_editMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem editMenu;
    private javax.swing.JButton jButton2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
            
