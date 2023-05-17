package cu.edu.cujae.structbd.dto.pitcher;

public class CreatePitcherDTO {
    private String teamMemberName;
    private int memberNumber;
    private int teamID;
    private int yearsInTeam;
    private int inningsPitched;
    private int runsAllowed;
    private int positionID;

    public CreatePitcherDTO(String teamMemberName, 
            int memberNumber, int teamID, int yearsInTeam, int inningsPitched, int runsAllowed) {
        this.teamMemberName = teamMemberName;
        this.memberNumber = memberNumber;
        this.teamID = teamID;
        this.yearsInTeam = yearsInTeam;
        this.inningsPitched = inningsPitched;
        this.runsAllowed = runsAllowed;
    }

    public String getTeamMemberName() {
            return teamMemberName;
    }

    public void setTeamMemberName(String teamMemberName) {
        if(teamMemberName != null){
            this.teamMemberName = teamMemberName;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        if(memberNumber > 0){
            this.memberNumber = memberNumber;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getYearsInTeam() {
        return yearsInTeam;
    }

    public void setYearsInTeam(int yearsInTeam) {
        if(yearsInTeam >= 0){
            this.yearsInTeam = yearsInTeam;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int getInningsPitched() {
        return inningsPitched;
    }

    public void setInningsPitched(int inningsPitched) {
        if(inningsPitched >= 0){
            this.inningsPitched = inningsPitched;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int getRunsAllowed() {
        return runsAllowed;
    }

    public void setRunsAllowed(int runsAllowed) {
        if(runsAllowed > 0){
            this.runsAllowed = runsAllowed;
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
