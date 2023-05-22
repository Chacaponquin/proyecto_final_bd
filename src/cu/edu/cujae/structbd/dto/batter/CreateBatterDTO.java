package cu.edu.cujae.structbd.dto.batter;

public class CreateBatterDTO {
    private final String name;
    private final int teamID;
    private final int memberNumber;
    private final int positionID;

    public CreateBatterDTO(String name, int teamID, int memberNumber, int positionID) {
        this.name = name.trim();
        this.teamID = teamID;
        this.memberNumber = memberNumber;
        this.positionID = positionID;
    }

    public String getName() {
        return name;
    }

    public int getTeamID() {
        return teamID;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public int getPositionID() {
        return positionID;
    }   
}
