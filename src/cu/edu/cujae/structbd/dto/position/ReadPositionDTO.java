package cu.edu.cujae.structbd.dto.position;

public class ReadPositionDTO {
    private int positionID;
    private String positionName;

    public ReadPositionDTO(int positionID, String positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
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
