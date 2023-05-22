package cu.edu.cujae.structbd.dto.game;

import java.time.LocalDate;

public class ReadGameDTO {
    private int id;
    private String hcTeamName;
    private String visTeamName;
    private String phaseName;
    private LocalDate date;
    private String winner;
    private int audience;
    private int runs_home_club;
    private int runs_visitant;

    public ReadGameDTO(int id, String hcTeamName, String visTeamName, String phaseName, LocalDate date, String winner,
                       int audience, int runs_home_club, int runs_visitant)
    {
        this.id = id;
        this.hcTeamName = hcTeamName;
        this.visTeamName = visTeamName;
        this.phaseName = phaseName;
        this.date = date;
        this.winner = winner;
        this.audience = audience;
        this.runs_home_club = runs_home_club;
        this.runs_visitant = runs_visitant;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getResult(){
        return this.runs_home_club + "-" + this.runs_visitant; 
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

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
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


    public int getRuns_home_club()
    {
        return runs_home_club;
    }

    public void setRuns_home_club(int runs_home_club)
    {
        if (audience > 0)
        {
            this.runs_home_club = runs_home_club;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public int getRuns_visitant()
    {
        return runs_visitant;
    }

    public void setRuns_visitant(int runs_visitant)
    {
        if (audience > 0)
        {
            this.runs_visitant = runs_visitant;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}
