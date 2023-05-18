package cu.edu.cujae.structbd.dto.coach;

public class CreateCoachDTO
{
    private String team_member_name;
    private int member_number;
    private int team_ID;
    private int experience_years;

    public CreateCoachDTO(String team_member_name, int member_number, int team_ID,
                          int experience_years)
    {
        this.team_member_name = team_member_name;
        this.member_number = member_number;
        this.team_ID = team_ID;
        this.experience_years = experience_years;
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

    public int getTeam_ID()
    {
        return team_ID;
    }

    public void setTeam_ID(int team_ID)
    {
        this.team_ID = team_ID;
    }

    public int getExperience_years()
    {
        return experience_years;
    }

    public void setExperience_years(int experience_years)
    {
        if (experience_years >= 0)
        {
            this.experience_years = experience_years;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

}
