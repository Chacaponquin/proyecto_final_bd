/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.team;

/**
 *
 * @author Jose
 */
public class ReadATeamDTO
{
    private int team_id;

    public ReadATeamDTO(int team_id)
    {
        this.team_id = team_id;
    }

    public int getTeam_id()
    {
        return team_id;
    }

    public void setTeam_id(int team_id)
    {
        this.team_id = team_id;
    }

}
