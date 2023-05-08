package cu.edu.cujae.structbd.dto.game;

import java.time.LocalDate;
import java.util.Date;

public class ReadGameDTO {
    private String id;
    private String hcTeamID;
    private String visTeamID;
    private String phaseID;
    private Date date;
    private String winner;
    private int audience;

    public ReadGameDTO(String id, String hcTeamID, String visTeamID, String phaseID, Date date, String winner, int audience) {
        this.id = id;
        this.hcTeamID = hcTeamID;
        this.visTeamID = visTeamID;
        this.phaseID = phaseID;
        this.date = date;
        this.winner = winner;
        this.audience = audience;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id != null){
            this.id = id;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getHcTeamID() {
        return hcTeamID;
    }

    public void setHcTeamID(String hcTeamID) {
        if(hcTeamID != null) {
            this.hcTeamID = hcTeamID;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getVisTeamID() {
        return visTeamID;
    }

    public void setVisTeamID(String visTeamID) {
        if(visTeamID != null){
            this.visTeamID = visTeamID;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getPhaseID() {
        return phaseID;
    }

    public void setPhaseID(String phaseID) {
        if(phaseID != null) {
            this.phaseID = phaseID;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if(date != null){
            this.date = date;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        if(winner != null){
            this.winner = winner;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int getAudience() {
        return audience;
    }

    public void setAudience(int audience) {
        if(audience > 0) {
            this.audience = audience;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
