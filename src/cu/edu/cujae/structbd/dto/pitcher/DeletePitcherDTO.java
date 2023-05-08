package cu.edu.cujae.structbd.dto.pitcher;

public class DeletePitcherDTO {
    private String teamMemberID;

    public DeletePitcherDTO(String teamMemberID) {
        this.teamMemberID = teamMemberID;
    }

    public String getTeamMemberID() {
        return teamMemberID;
    }

    public void setTeamMemberID(String teamMemberID) {
        if(teamMemberID != null){
            this.teamMemberID = teamMemberID;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
