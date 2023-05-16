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
    private int team_member_ID;

    public ReadACoachDTO(int team_member_ID)
    {
        this.team_member_ID = team_member_ID;
    }

    public int getTeam_member_ID()
    {
        return team_member_ID;
    }

    public void setTeam_member_ID(int team_member_ID)
    {
            this.team_member_ID = team_member_ID;

    }
}
