package cu.edu.cujae.structbd.dto.game;

import java.time.LocalDate;

public class ReadAGameDTO {
    private int id;

    public ReadAGameDTO(int id, String hcTeamID, String visTeamID, String phaseID, LocalDate date, String winner,
                        int audience)
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
