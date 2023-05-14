/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.reports;

import java.time.LocalDate;

/**
 *
 * @author Hector Angel Gomez
 */
public class ReadReport_2DTO {
    private final String phaseName;
    private final LocalDate date;
    private final String winner;
    private final int audience;
    private final int runs_home_club;
    private final int runs_visitant;
    private final String stadiumName;

    public ReadReport_2DTO(String phaseName, LocalDate date, String winner, int audience, int runs_home_club, int runs_visitant, String stadiumName) {
        this.phaseName = phaseName;
        this.date = date;
        this.winner = winner;
        this.audience = audience;
        this.runs_home_club = runs_home_club;
        this.runs_visitant = runs_visitant;
        this.stadiumName = stadiumName;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getWinner() {
        return winner;
    }

    public int getAudience() {
        return audience;
    }

    public int getRuns_home_club() {
        return runs_home_club;
    }

    public int getRuns_visitant() {
        return runs_visitant;
    }
    
    public String getGameResult(){
        return String.valueOf(this.runs_home_club) + " - " + String.valueOf(this.runs_visitant) ;
    }
}
