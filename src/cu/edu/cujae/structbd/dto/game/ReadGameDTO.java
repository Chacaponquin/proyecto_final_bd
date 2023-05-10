package cu.edu.cujae.structbd.dto.game;

import java.util.Date;

public class ReadGameDTO {
    private String id;
    private String hcTeamName;
    private String visTeamName;
    private String phaseName;
    private Date date;
    private String winner;
    private int audience;

    public ReadGameDTO(String id, String hcTeamName, String visTeamName, String phaseName, Date date, String winner, int audience) {
        this.id = id;
        this.hcTeamName = hcTeamName;
        this.visTeamName = visTeamName;
        this.phaseName = phaseName;
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

    public String getHcTeamName() {
        return hcTeamName;
    }

    public void setHcTeamName(String hcTeamName) {
        if(hcTeamName != null) {
            this.hcTeamName = hcTeamName;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getVisTeamName() {
        return visTeamName;
    }

    public void setVisTeamName(String visTeamName) {
        if(visTeamName != null){
            this.visTeamName = visTeamName;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        if(phaseName != null) {
            this.phaseName = phaseName;
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
