package cu.edu.cujae.structbd.dto.pitcher;

public class UpdatePitcherDTO {
    private String teamMemberID;
    private String teamMemberName;
    private int memberNumber;
    private String teamID;
    private int yearsInTeam;
    private int inningsPitched;
    private int runsAllowed;
    private String positionID;

    public UpdatePitcherDTO(String teamMemberID, String positionID, String teamMemberName, int memberNumber, String teamID, int yearsInTeam, int inningsPitched, int runsAllowed) {
        this.teamMemberID = teamMemberID;
        this.teamMemberName = teamMemberName;
        this.memberNumber = memberNumber;
        this.teamID = teamID;
        this.yearsInTeam = yearsInTeam;
        this.inningsPitched = inningsPitched;
        this.runsAllowed = runsAllowed;
        this.positionID = positionID;
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

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        if(teamID != null){
            this.teamID = teamID;
        }
        else{
            throw new IllegalArgumentException();
        }
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
    
    
}
