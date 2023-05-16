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
    private int phase_id;

    public ReadAPhaseDTO(int phase_id)
    {
        this.phase_id = phase_id;
    }

    public int getPhase_id()
    {
        return phase_id;
    }

    public void setPhase_id(int phase_id)
    {
        this.phase_id = phase_id;
    }
}
