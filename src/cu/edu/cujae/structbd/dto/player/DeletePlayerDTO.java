/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.player;

/**
 *
 * @author Jose
 */
public class DeletePlayerDTO
{
    private String ID;

    public DeletePlayerDTO(String ID)
    {
        this.ID = ID;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        if (ID != null)
        {
            this.ID = ID;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

}
