package cu.edu.cujae.structbd.dto.game;

import java.time.LocalDate;

public class ReadAGameDTO {
     private String id;

    public ReadAGameDTO(String id, String hcTeamID, String visTeamID, String phaseID, LocalDate date, String winner, int audience) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id != null){
            this.id = id;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
