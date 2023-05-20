/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Jose
 */
public class Export
{
    public void exportToPDF(String report_name, HashMap<String, Object> parameters, String information) throws
        JRException, SQLException,                                                                                           ClassNotFoundException
    {
        String jrxPath = "src/cu/edu/cujae/structbd/reports/" + report_name + ".jrxml";
        JasperReport report = JasperCompileManager.compileReport(jrxPath);
        JasperPrint print = JasperFillManager.fillReport(report, parameters, Connector.getConnection());
        String exportPath = null;
        if (information != null)
        {
            exportPath = "src/cu/edu/cujae/structbd/reports/" + report_name + information + ".pdf";
        }
        else
        {
            exportPath = "src/cu/edu/cujae/structbd/reports/" + report_name + ".pdf";
        }
        File file = new File(exportPath);
        if (file.exists())
        {
            file.delete();
        }
        JasperExportManager.exportReportToPdfFile(print, exportPath);
    }
}
