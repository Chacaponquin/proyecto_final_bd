/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.province;

/**
 *
 * @author Jose
 */
public class UpdateProvinceDTO
{
    private String ID;
    private String name;

    public UpdateProvinceDTO(String ID, String name)
    {
        this.ID = ID;
        this.name = name;
    }

    public String getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
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

    public void setName(String name)
    {
        if (name != null)
        {
            this.name = name;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}
