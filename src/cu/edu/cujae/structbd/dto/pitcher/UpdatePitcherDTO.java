package cu.edu.cujae.structbd.dto.pitcher;

public class UpdatePitcherDTO {
    private final int teamMemberID;
    private final String teamMemberName;
    private final int memberNumber;
    private final int teamID;
    private final int yearsInTeam;
    private final int inningsPitched;
    private final int runsAllowed;

    public UpdatePitcherDTO(int teamMemberID, String teamMemberName, int memberNumber, int teamID, int yearsInTeam, int inningsPitched, int runsAllowed) {
        this.teamMemberID = teamMemberID;
        this.teamMemberName = teamMemberName.trim();
        this.memberNumber = memberNumber;
        this.teamID = teamID;
        this.yearsInTeam = yearsInTeam;
        this.inningsPitched = inningsPitched;
        this.runsAllowed = runsAllowed;
    }

    

    public int getTeamMemberID() {
        return teamMemberID;
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


    public int getYearsInTeam() {
        return yearsInTeam;
    }



    public int getInningsPitched() {
        return inningsPitched;
    }


    public int getRunsAllowed() {
        return runsAllowed;
    }


    
}
