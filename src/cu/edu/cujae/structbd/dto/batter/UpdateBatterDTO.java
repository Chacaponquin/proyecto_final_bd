/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.batter;

/**
 *
 * @author Hector Angel Gomez
 */
public class UpdateBatterDTO {
    private final int member_id;
    private final String batterName;
    private final int teamID;
    private final int yearsInTeam;
    private final int number;
    private final int positionID;
    private final int atBats;
    private final int totalHits;

    public UpdateBatterDTO(int member_id, String batterName, int teamID, int yearsInTeam, int number, int positionID, int atBats, int totalHits) {
        this.member_id = member_id;
        this.batterName = batterName;
        this.teamID = teamID;
        this.yearsInTeam = yearsInTeam;
        this.number = number;
        this.positionID = positionID;
        this.atBats = atBats;
        this.totalHits = totalHits;
    }

    public int getMember_id() {
        return member_id;
    }

    public String getBatterName() {
        return batterName;
    }

    public int getTeamID() {
        return teamID;
    }

    public int getYearsInTeam() {
        return yearsInTeam;
    }

    public int getNumber() {
        return number;
    }

    public int getPositionID() {
        return positionID;
    }

    public int getAtBats() {
        return atBats;
    }

    public int getTotalHits() {
        return totalHits;
    }
}
