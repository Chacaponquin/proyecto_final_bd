/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.phase;

/**
 *
 * @author Jose
 */
public class ReadAPhaseDTO
{
    private String phase_id;

    public ReadAPhaseDTO(String phase_id)
    {
        this.phase_id = phase_id;
    }

    public String getPhase_id()
    {
        return phase_id;
    }

    public void setPhase_id(String phase_id)
    {
        if (phase_id != null)
        {
            this.phase_id = phase_id;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}
