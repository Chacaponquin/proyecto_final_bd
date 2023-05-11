/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

import cu.edu.cujae.structbd.visual.batter.BatterUI;

import cu.edu.cujae.structbd.visual.coach.Coach_UI;
import cu.edu.cujae.structbd.visual.game.GameUI;
import cu.edu.cujae.structbd.visual.main.MainUI;
import cu.edu.cujae.structbd.visual.phase.PhaseUI;

import cu.edu.cujae.structbd.visual.pitcher.PitcherUI;

import cu.edu.cujae.structbd.visual.player.Player_UI;
import cu.edu.cujae.structbd.visual.position.PositionUI;
import cu.edu.cujae.structbd.visual.reports.Report_1UI;
import cu.edu.cujae.structbd.visual.reports.Report_2UI;
import cu.edu.cujae.structbd.visual.reports.Report_3UI;
import cu.edu.cujae.structbd.visual.reports.Report_4UI;
import cu.edu.cujae.structbd.visual.reports.Report_5UI;
import cu.edu.cujae.structbd.visual.reports.Report_6UI;
import cu.edu.cujae.structbd.visual.reports.Report_7UI;
import cu.edu.cujae.structbd.visual.stadium.StadiumUI;
import cu.edu.cujae.structbd.visual.team.TeamUI;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Hector Angel Gomez
 */
public class ViewUtils {
    private final HashMap<String, JFrame> views = new HashMap<>();
    private final HashMap<String, JDialog> reports = new HashMap<>();
    
    public ViewUtils()
    {
        
        try{
            this.views.put("Estadios", new StadiumUI());
            this.views.put("Posiciones", new PositionUI());
            this.views.put("Pitchers", new PitcherUI());
            this.views.put("Fases", new PhaseUI());
            this.views.put("Juegos", new GameUI());
            this.views.put("Entrenadores", new Coach_UI());
            this.views.put("Equipos", new TeamUI());
            this.views.put("Bateadores", new BatterUI());
            this.views.put("Jugadores", new Player_UI());
            
            this.reports.put("Tabla de posiciones", new Report_1UI(null, false));
            this.reports.put("Partidos por equipos", new Report_2UI(null, false));
            this.reports.put("Partidos jugados por fecha", new Report_3UI(null, false));
            this.reports.put("Entrenadores de más experiencia", new Report_4UI(null, false));
            this.reports.put("Estadios con mayor audiencia", new Report_5UI(null, false));
            this.reports.put("Estado de un equipo", new Report_6UI(null, false));
            this.reports.put("Equipo todos estrellas", new Report_7UI(null, false));
            
        }
        catch(SQLException | ClassNotFoundException ex){
            System.out.println(ex);
            System.out.println("Error por falta de Backup");
        }catch (Exception ex){
            System.out.println(ex);
            System.out.println("Error por falta de Backup");
        }
    }
    
    public void getBackHome(JFrame actualWindow){
        actualWindow.setVisible(false);
        actualWindow.dispose();
    }
    
    public void openWindow(JFrame actualWindow, JFrame newWindow){
        actualWindow.setVisible(false);
        newWindow.setVisible(true);
        newWindow.setLocationRelativeTo(null);
        actualWindow.dispose();
    }
    
    public HashMap<String, JFrame> getViews(){
        return this.views;
    }
    
    public HashMap<String, JDialog> getReportsViews(){
        return this.reports;
    }
}
