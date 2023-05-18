package cu.edu.cujae.structbd.dto.team_member;

public class UpdateTeamMemberDTO {
    private String name;
    private int number;
    private int yearsInTeam;
    private int id;
    private int team_id;

    public UpdateTeamMemberDTO(String name, int number, int yearsInTeam, int id, int team_id) {
        this.name = name;
        this.number = number;
        this.yearsInTeam = yearsInTeam;
        this.id = id;
        this.team_id = team_id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }
}
