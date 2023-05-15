/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.snb;

/**
 *
 * @author Jose
 */
public class TeamPositionDTO
{
    private String team_name;
    private int played_games;
    private int won_playes;
    private int lost_playes;
    private int points;

    public TeamPositionDTO(String team_name, int played_games, int won_playes, int lost_playes, int points)
    {
        this.team_name = team_name;
        this.played_games = played_games;
        this.won_playes = won_playes;
        this.lost_playes = lost_playes;
        this.points = points;
    }

    public String getTeam_name()
    {
        return team_name;
    }

    public void setTeam_name(String team_name)
    {
        this.team_name = team_name;
    }

    public int getPlayed_games()
    {
        return played_games;
    }

    public void setPlayed_games(int played_games)
    {
        this.played_games = played_games;
    }

    public int getWon_playes()
    {
        return won_playes;
    }

    public void setWon_playes(int won_playes)
    {
        this.won_playes = won_playes;
    }

    public int getLost_playes()
    {
        return lost_playes;
    }

    public void setLost_playes(int lost_playes)
    {
        this.lost_playes = lost_playes;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

}
