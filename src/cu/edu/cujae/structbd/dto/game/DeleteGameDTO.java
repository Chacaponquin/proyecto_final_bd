package cu.edu.cujae.structbd.dto.game;

import java.time.LocalDate;

public class DeleteGameDTO {
    private int id;

    public DeleteGameDTO(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
