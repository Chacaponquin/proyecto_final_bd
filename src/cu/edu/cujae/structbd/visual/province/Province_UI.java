/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cu.edu.cujae.structbd.visual.province;

import cu.edu.cujae.structbd.dto.province.ReadProvinceDTO;
import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.utils.AppCustomWindow;
import cu.edu.cujae.structbd.utils.UtilsConnector;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class Province_UI extends AppCustomWindow
{
    private LinkedList<ReadProvinceDTO> provinces_list;
    
    public void start(){
        initComponents();
        this.updateUI();
    }
    
    public void updateUI(){
        try
        {

            this.provinces_list = new LinkedList<>(ServicesLocator.ProvinceServices.readAllProvince());
            for (ReadProvinceDTO rpdt : provinces_list)
            {
                ((DefaultTableModel) table.getModel()).addRow(new Object[]
                {
                    rpdt.getName()
                });
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
        menuMod = new javax.swing.JMenuItem();
        menuDel = new javax.swing.JMenuItem();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        menuMod.setText("jMenuItem1");
        menuMod.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuModActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuMod);

        menuDel.setText("jMenuItem2");
        menuDel.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuDelActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuDel);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
                "Nombre"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 144, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void menuModActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuModActionPerformed
    {//GEN-HEADEREND:event_menuModActionPerformed
        int row = table.getSelectedRow();
        if (row > 0)
        {

        }
        else
        {

        }
    }//GEN-LAST:event_menuModActionPerformed

    private void menuDelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuDelActionPerformed
    {//GEN-HEADEREND:event_menuDelActionPerformed
        int row = table.getSelectedRow();
        if (row > 0)
        {

        }
        else
        {

        }
    }//GEN-LAST:event_menuDelActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_formFocusGained
    {//GEN-HEADEREND:event_formFocusGained
        try
        {
            this.provinces_list.clear();
            this.provinces_list = new LinkedList<>(ServicesLocator.ProvinceServices.readAllProvince());
            for (ReadProvinceDTO rpdt : provinces_list)
            {
                ((DefaultTableModel) table.getModel()).addRow(new Object[]
                {
                    rpdt.getName()
                });
            }
        }
        catch (SQLException | ClassNotFoundException ex)
        {
            UtilsConnector.viewMessagesUtils.showConecctionErrorMessage(this, ex);
        }
    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuDel;
    private javax.swing.JMenuItem menuMod;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
