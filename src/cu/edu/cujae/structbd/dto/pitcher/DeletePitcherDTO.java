package cu.edu.cujae.structbd.dto.pitcher;

public class DeletePitcherDTO {
    private final int teamMemberID;

    public DeletePitcherDTO(int teamMemberID) {
        this.teamMemberID = teamMemberID;
    }

    public int getTeamMemberID() {
        return teamMemberID;
    }
}
