package cu.edu.cujae.structbd.dto.position;

public class ReadAPositionDTO {
    private String positionID;

    public ReadAPositionDTO(String positionID) {
        this.positionID = positionID;
    }

    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        if(positionID != null){
            this.positionID = positionID;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
