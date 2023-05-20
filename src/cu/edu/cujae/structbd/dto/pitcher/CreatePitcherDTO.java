package cu.edu.cujae.structbd.dto.pitcher;

public class CreatePitcherDTO {
    private final String teamMemberName;
    private final int memberNumber;
    private final int teamID;

    public CreatePitcherDTO(String teamMemberName, int memberNumber, int teamID) {
        this.teamMemberName = teamMemberName.trim();
        this.memberNumber = memberNumber;
        this.teamID = teamID;
    }

    public String getTeamMemberName() {
        return teamMemberName;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public int getTeamID() {
        return teamID;
    }
}
