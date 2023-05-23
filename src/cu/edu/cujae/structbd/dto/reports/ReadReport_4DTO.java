/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.reports;

/**
 *
 * @author Jose
 */
public class ReadReport_4DTO
{

    private String team_name;
    private String coach_name;
    private int experience_years;
    private int member_number;

    public ReadReport_4DTO(String team_name, String coach_name, int experience_years, int member_number)
    {
        this.team_name = team_name;
        this.coach_name = coach_name;
        this.experience_years = experience_years;
        this.member_number = member_number;
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

    public String getCoach_name()
    {
        return coach_name;
    }

    public void setCoach_name(String coach_name)
    {
        if (coach_name != null)
        {
            this.coach_name = coach_name;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public int getExperience_years()
    {
        return experience_years;
    }

    public void setExperience_years(int experience_years)
    {
        if (experience_years > 0)
        {
            this.experience_years = experience_years;
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
        this.member_number = member_number;
    }


}
