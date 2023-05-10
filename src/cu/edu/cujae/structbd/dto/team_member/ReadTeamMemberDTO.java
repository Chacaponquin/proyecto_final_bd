package cu.edu.cujae.structbd.dto.team_member;

public class ReadTeamMemberDTO {
    private String name;
    private int number;
    private int yearsInTeam;
    private String id;
    private String team_name;

    public ReadTeamMemberDTO(String name, int number, int yearsInTeam, String id, String team_name) {
        this.name = name;
        this.number = number;
        this.yearsInTeam = yearsInTeam;
        this.id = id;
        this.team_name = team_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null){
            this.name = name;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if(number > 0){
            this.number = number;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id != null){
            this.id = id;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        if(team_name != null){
            this.team_name = team_name;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
