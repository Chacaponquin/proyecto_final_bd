package cu.edu.cujae.structbd.dto.game;

import java.time.LocalDate;
import java.util.Date;

public class UpdateGameDTO {
    private int id;
    private int hcTeamID;
    private int visTeamID;
    private int phaseID;
    private LocalDate date;
    private int winner;
    private int audience;
    private int runs_home_club;
    private int runs_visitant;

    public UpdateGameDTO(int id, int hcTeamID, int visTeamID, int phaseID, LocalDate date, int winner,
                         int audience, int runs_home_club, int runs_visitant)
    {
        this.id = id;
        this.hcTeamID = hcTeamID;
        this.visTeamID = visTeamID;
        this.phaseID = phaseID;
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

    public int getHcTeamID()
    {
        return hcTeamID;
    }

    public void setHcTeamID(int hcTeamID)
    {
            this.hcTeamID = hcTeamID;

    }

    public int getVisTeamID()
    {
        return visTeamID;
    }

    public void setVisTeamID(int visTeamID)
    {

        this.visTeamID = visTeamID;
    }

    public int getPhaseID()
    {
        return phaseID;
    }

    public void setPhaseID(int phaseID)
    {

            this.phaseID = phaseID;

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

    public int getWinner()
    {
        return winner;
    }

    public void setWinner(int winner)
    {

            this.winner = winner;

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
