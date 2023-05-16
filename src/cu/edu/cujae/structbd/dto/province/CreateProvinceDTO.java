package cu.edu.cujae.structbd.dto.province;

public class CreateProvinceDTO
{

    private int ID;
    private String name;

    public CreateProvinceDTO(int ID, String name)
    {
        this.ID = ID;
        this.name = name;
    }

    public int getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public void setID(int id)
    {
        this.ID = id;
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
