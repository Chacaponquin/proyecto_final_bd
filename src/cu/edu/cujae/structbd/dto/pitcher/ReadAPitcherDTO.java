package cu.edu.cujae.structbd.dto.pitcher;

public class ReadAPitcherDTO {
    private String teamMemberID;

    public ReadAPitcherDTO(String teamMemberID) {
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
