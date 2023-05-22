/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

import cu.edu.cujae.structbd.services.ServicesLocator;
import cu.edu.cujae.structbd.visual.batter.BatterUI;

import cu.edu.cujae.structbd.visual.coach.Coach_UI;
import cu.edu.cujae.structbd.visual.game.GameUI;
import cu.edu.cujae.structbd.visual.phase.PhaseUI;

import cu.edu.cujae.structbd.visual.pitcher.PitcherUI;

import cu.edu.cujae.structbd.visual.player.Player_UI;
import cu.edu.cujae.structbd.visual.position.PositionUI;
import cu.edu.cujae.structbd.visual.province.Province_UI;
import cu.edu.cujae.structbd.visual.reports.Report_1UI;
import cu.edu.cujae.structbd.visual.reports.Report_2UI;
import cu.edu.cujae.structbd.visual.reports.Report_3UI;
import cu.edu.cujae.structbd.visual.reports.Report_4UI;
import cu.edu.cujae.structbd.visual.reports.Report_5UI;
import cu.edu.cujae.structbd.visual.reports.Report_6UI;
import cu.edu.cujae.structbd.visual.reports.Report_7UI;
import cu.edu.cujae.structbd.visual.snb.SerieUI;
import cu.edu.cujae.structbd.visual.stadium.StadiumUI;
import cu.edu.cujae.structbd.visual.team.TeamUI;
import cu.edu.cujae.structbd.visual.user.UserUI;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hector Angel Gomez
 */
public class ViewUtils {
    private final List<ViewWindow> views = new ArrayList<>();
    private final List<ViewDialog> reports = new ArrayList<>();
    
    public ViewUtils()
    {
        this.updateViews();
    }
    
    public void updateViews(){
        views.clear();
        reports.clear();
        boolean isAdmin = ServicesLocator.UserServices.actualUserIsAdmin();
        
        this.views.add(new ViewWindow("Estadios", new StadiumUI(), !isAdmin));
        this.views.add(new ViewWindow("Posiciones", new PositionUI(), !isAdmin));
        this.views.add(new ViewWindow("Pitchers", new PitcherUI(), !isAdmin));
        this.views.add(new ViewWindow("Fases", new PhaseUI(), !isAdmin));
        this.views.add(new ViewWindow("Juegos", new GameUI(), !isAdmin));
        this.views.add(new ViewWindow("Entrenadores", new Coach_UI(), !isAdmin));
        this.views.add(new ViewWindow("Equipos", new TeamUI(), !isAdmin));
        this.views.add(new ViewWindow("Bateadores", new BatterUI(), !isAdmin));
        this.views.add(new ViewWindow("Jugadores", new Player_UI(), !isAdmin));
        this.views.add(new ViewWindow("Provincias", new Province_UI(), !isAdmin));
        this.views.add(new ViewWindow("SNB", new SerieUI(), !isAdmin));
        this.views.add(new ViewWindow("Usuarios", new UserUI(), isAdmin));

        this.reports.add(new ViewDialog("Tabla de posiciones", new Report_1UI(null, false)));
        this.reports.add(new ViewDialog("Partidos por equipos", new Report_2UI(null, false)));
        this.reports.add(new ViewDialog("Partidos jugados por fecha", new Report_3UI(null, false)));
        this.reports.add(new ViewDialog("Entrenadores de más experiencia", new Report_4UI(null, false)));
        this.reports.add(new ViewDialog("Estadios con mayor audiencia", new Report_5UI(null, false)));
        this.reports.add(new ViewDialog("Estado de un equipo", new Report_6UI(null, false)));
        this.reports.add(new ViewDialog("Equipo todos estrellas", new Report_7UI(null, false))); 
    }
    
    public void openWindow(Frame actualWindow, Frame newWindow){
        actualWindow.setVisible(false);
        newWindow.setVisible(true);
        newWindow.setLocationRelativeTo(null);
        actualWindow.dispose();
    }
    
    public void openWindow(JDialog actualWindow, JFrame newWindow){
        actualWindow.setVisible(false);
        newWindow.setVisible(true);
        newWindow.setLocationRelativeTo(null);
        actualWindow.dispose();
    }
    
    public void openDialog(Frame actualWindow, JDialog newDialog){
        newDialog.setVisible(true);
        newDialog.setLocationRelativeTo(null);
    }
    
    public void openDialog(JDialog actualWindow, JDialog newDialog){
        newDialog.setVisible(true);
        newDialog.setLocationRelativeTo(null);
    }
    
    public List<ViewWindow> getViews(){
        return this.views;
    }
    
    public List<ViewDialog> getReportsViews(){
        return this.reports;
    }
    
    public void cleanTable(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
            
        int count = model.getRowCount();
        for(int i = 0; i < count; i++){
            model.removeRow(0);
        }
    }
}
