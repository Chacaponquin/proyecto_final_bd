/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.coach;

/**
 *
 * @author Jose
 */
public class ReadACoachDTO
{
    private String team_member_ID;

    public ReadACoachDTO(String team_member_ID)
    {
        this.team_member_ID = team_member_ID;
    }

    public String getTeam_member_ID()
    {
        return team_member_ID;
    }

    public void setTeam_member_ID(String team_member_ID)
    {
        if (team_member_ID != null)
        {
            this.team_member_ID = team_member_ID;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}
