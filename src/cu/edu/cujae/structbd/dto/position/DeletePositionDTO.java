package cu.edu.cujae.structbd.dto.position;

public class DeletePositionDTO {
    private int positionID;

    public DeletePositionDTO(int positionID) {
        this.positionID = positionID;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }
}
