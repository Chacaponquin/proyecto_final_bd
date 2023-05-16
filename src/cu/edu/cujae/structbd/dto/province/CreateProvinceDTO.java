package cu.edu.cujae.structbd.dto.province;

public class CreateProvinceDTO
{
    private String name;

    public CreateProvinceDTO(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
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
