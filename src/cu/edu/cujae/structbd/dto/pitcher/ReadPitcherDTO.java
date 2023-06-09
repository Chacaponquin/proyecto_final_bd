package cu.edu.cujae.structbd.dto.pitcher;

public class ReadPitcherDTO {
    private int teamMemberID;
    private String teamMemberName;
    private int memberNumber;
    private String team;
    private int yearsInTeam;
    private int inningsPitched;
    private int runsAllowed;
    private final int teamID;

    public ReadPitcherDTO(int teamMemberID, String teamMemberName, int memberNumber, String team, int yearsInTeam, int inningsPitched, int runsAllowed, int teamID) {
        this.teamMemberID = teamMemberID;
        this.teamMemberName = teamMemberName;
        this.memberNumber = memberNumber;
        this.team = team;
        this.yearsInTeam = yearsInTeam;
        this.inningsPitched = inningsPitched;
        this.runsAllowed = runsAllowed;
        this.teamID = teamID;
    }

    public int getTeamMemberID() {
        return teamMemberID;
    }

    public int getTeamID() {
        return teamID;
    }
    
    public float getPCL(){
        if(this.runsAllowed == 0)
            return 0;
        
        return (float) this.inningsPitched / this.runsAllowed;
    }

    public void setTeamMemberID(int teamMemberID) {
        this.teamMemberID = teamMemberID;
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        if(team != null){
            this.team = team;
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
}
