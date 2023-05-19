/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.batter;

/**
 *
 * @author Hector Angel Gomez
 */
public class ReadBatterDTO {
    private final int member_id;
    private final String name;
    private final String team;
    private final int yearsInTeam;
    private final int number;
    private final String position;
    private final int atBats;
    private final int totalHits;

    public ReadBatterDTO(int member_id, String name, String team, int yearsInTeam, int number, String position, int atBats, int totalHits) {
        this.member_id = member_id;
        this.name = name;
        this.team = team;
        this.yearsInTeam = yearsInTeam;
        this.number = number;
        this.position = position;
        this.atBats = atBats;
        this.totalHits = totalHits;
    }

    public int getMember_id() {
        return member_id;
    }

    public int getTotalHits() {
        return totalHits;
    }
    
    public int getAverage(){
        float value = (float)totalHits / atBats * 1000;
        return (int) value;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getYearsInTeam() {
        return yearsInTeam;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public int getAtBats() {
        return atBats;
    }
}
