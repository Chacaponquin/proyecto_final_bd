/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.reports;

/**
 *
 * @author Hector Angel Gomez
 */
public class ReadReport_1DTO {
    private final String teamName;
    private final int points;
    private final int runsMaked;
    private final int runsAllowed;

    public ReadReport_1DTO(String teamName, int points, int runsMaked, int runsAllowed) {
        this.teamName = teamName;
        this.points = points;
        this.runsMaked = runsMaked;
        this.runsAllowed = runsAllowed;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPoints() {
        return points;
    }

    public int getRunsMaked() {
        return runsMaked;
    }

    public int getRunsAllowed() {
        return runsAllowed;
    }
    
    
    
    
}
