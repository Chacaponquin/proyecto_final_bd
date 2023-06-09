/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.phase;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Jose
 */
public class UpdatePhaseDTO
{
    private int phase_id;
    private String phase_name;
    private LocalDate start_date;
    private LocalDate finish_date;
    private int teams_amount;
    private boolean is_active;

    public UpdatePhaseDTO(int phase_id, String phase_name, LocalDate start_date, LocalDate finish_date,
                          int teams_amount, boolean is_active)
    {
        this.phase_id = phase_id;
        this.phase_name = phase_name;
        this.start_date = start_date;
        this.finish_date = finish_date;
        this.teams_amount = teams_amount;
        this.is_active = is_active;
    }

    public int getPhase_id()
    {
        return phase_id;
    }

    public void setPhase_id(int phase_id)
    {
        this.phase_id = phase_id;
    }

    public String getPhase_name()
    {
        return phase_name;
    }

    public void setPhase_name(String phase_name)
    {
        if (phase_name != null)
        {
            this.phase_name = phase_name;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public LocalDate getStart_date()
    {
        return start_date;
    }

    public void setStart_date(LocalDate start_date)
    {
        if (start_date != null)
        {
            this.start_date = start_date;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public LocalDate getFinish_date()
    {
        return finish_date;
    }

    public void setFinish_date(LocalDate finish_date)
    {
        if (finish_date != null)
        {
            this.finish_date = finish_date;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public int getTeams_amount()
    {
        return teams_amount;
    }

    public void setTeams_amount(int teams_amount)
    {
        if (teams_amount > 0)
        {
            this.teams_amount = teams_amount;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public boolean getIs_active()
    {
        return is_active;
    }

    public void setIs_active(boolean is_active)
    {
        this.is_active = is_active;
    }

}
