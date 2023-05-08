/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.reports;

/**
 *
 * @author Jose
 */
public class ReadReport_5DTO
{

    private String stadium_name;
    private float audience_avg;

    public ReadReport_5DTO(String stadium_name, float audience_avg)
    {
        this.stadium_name = stadium_name;
        this.audience_avg = audience_avg;
    }

    public String getStadium_name()
    {
        return stadium_name;
    }

    public void setStadium_name(String stadium_name)
    {
        if (stadium_name != null)
        {
            this.stadium_name = stadium_name;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public float getAudience_avg()
    {
        return audience_avg;
    }

    public void setAudience_avg(float audience_avg)
    {
        if (audience_avg > 0)
        {
            this.audience_avg = audience_avg;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

}
