package cu.edu.cujae.structbd.dto.position;

public class ReadAPositionDTO {
    private int positionID;

    public ReadAPositionDTO(int positionID) {
        this.positionID = positionID;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }
}
