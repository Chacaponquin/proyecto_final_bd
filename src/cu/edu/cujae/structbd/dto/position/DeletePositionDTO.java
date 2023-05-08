package cu.edu.cujae.structbd.dto.position;

public class DeletePositionDTO {
    private String positionID;

    public DeletePositionDTO(String positionID) {
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
