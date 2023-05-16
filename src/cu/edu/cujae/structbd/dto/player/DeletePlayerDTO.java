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
    private int ID;

    public DeletePlayerDTO(int ID)
    {
        this.ID = ID;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int id)
    {
        this.ID = id;
    }

}
