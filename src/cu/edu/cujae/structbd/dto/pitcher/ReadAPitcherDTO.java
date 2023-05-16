package cu.edu.cujae.structbd.dto.pitcher;

public class ReadAPitcherDTO {
    private int teamMemberID;

    public ReadAPitcherDTO(int teamMemberID) {
        this.teamMemberID = teamMemberID;
    }

    public int getTeamMemberID() {
        return teamMemberID;
    }

    public void setTeamMemberID(int teamMemberID) {
        this.teamMemberID = teamMemberID;
    }
}
