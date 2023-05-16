package cu.edu.cujae.structbd.dto.position;

public class CreatePositionDTO {
    private int positionID;
    private String positionName;

    public CreatePositionDTO(String positionName, int positionID) {
        this.positionID = positionID;
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

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }
    
    
    
}
