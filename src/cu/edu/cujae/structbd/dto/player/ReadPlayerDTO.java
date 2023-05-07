/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.player;

/**
 *
 * @author Jose
 */
public class ReadPlayerDTO
{
    private String team_member_ID;
    private String team_member_name;
    private int member_number;
    private String team_name;
    private String position_name;

    public ReadPlayerDTO(String team_member_ID, String team_member_name, int member_number, String team_name,
                         String position_name)
    {
        this.team_member_ID = team_member_ID;
        this.team_member_name = team_member_name;
        this.member_number = member_number;
        this.team_name = team_name;
        this.position_name = position_name;
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

    public String getTeam_member_name()
    {
        return team_member_name;
    }

    public void setTeam_member_name(String team_member_name)
    {
        if (team_member_name != null)
        {
            this.team_member_name = team_member_name;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public int getMember_number()
    {
        return member_number;
    }

    public void setMember_number(int member_number)
    {
        if (member_number > 0 && member_number < 100)
        {
            this.member_number = member_number;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public String getTeam_name()
    {
        return team_name;
    }

    public void setTeam_name(String team_name)
    {
        if (team_name != null)
        {
            this.team_name = team_name;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public String getPosition_name()
    {
        return position_name;
    }

    public void setPosition_name(String position_name)
    {
        if (position_name != null)
        {
            this.position_name = position_name;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

}
