package cu.edu.cujae.structbd.dto.reports;

public class ReadReport_7DTO {
    private String positionName;
    private String teamMemberName;
    private String teamName;
    private float average;

    public ReadReport_7DTO(String positionName, String teamMemberName, String teamName, float average) {
        this.positionName = positionName;
        this.teamMemberName = teamMemberName;
        this.teamName = teamName;
        this.average = average;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        if(positionName != null){
            this.positionName = positionName;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        if(teamName != null){
            this.teamName = teamName;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        if(average >= 0){
            this.average = average;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
    
    
}
