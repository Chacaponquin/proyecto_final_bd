package cu.edu.cujae.structbd.dto.position;

public class CreatePositionDTO {
    private String positionName;

    public CreatePositionDTO(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        if(positionName != null){
            this.positionName = positionName;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
