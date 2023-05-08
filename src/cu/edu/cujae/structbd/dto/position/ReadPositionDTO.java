package cu.edu.cujae.structbd.dto.position;

public class ReadPositionDTO {
    private String positionID;
    private String positionName;

    public ReadPositionDTO(String positionID, String positionName) {
        this.positionID = positionID;
        this.positionName = positionName;
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
