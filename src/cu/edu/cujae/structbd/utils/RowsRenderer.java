/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class RowsRenderer extends DefaultTableCellRenderer
{

    private int columna;

    public RowsRenderer(int Colpatron)
    {
        this.columna = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused,
                                                   int row, int column)
    {

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        int rouw_count = ((DefaultTableModel) table.getModel()).getRowCount() / 2;
        if (Integer.valueOf(table.getValueAt(row, columna).toString()) <= rouw_count)
        {
            Color color = new Color(10, 150, 50);
            this.setForeground(color);
        }
        else
        {
            this.setForeground(Color.BLACK);
        }
        return this;
    }
}
