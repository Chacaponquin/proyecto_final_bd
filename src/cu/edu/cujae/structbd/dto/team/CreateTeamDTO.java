package cu.edu.cujae.structbd.dto.team;

public class CreateTeamDTO {
    private String team_id;
    private String team_name;
    private int played_championships;
    private int won_championships;
    private String color;
    private String province;
    private String pet;
    private String stadium;

    public CreateTeamDTO(String team_id, String team_name, int played_championships, int won_championships, String color, String province, String pet, String stadium) {
        this.team_id = team_id;
        this.team_name = team_name;
        this.played_championships = played_championships;
        this.won_championships = won_championships;
        this.color = color;
        this.province = province;
        this.pet = pet;
        this.stadium = stadium;
    }

    public String getTeam_id() {
        return team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public int getPlayed_championships() {
        return played_championships;
    }

    public int getWon_championships() {
        return won_championships;
    }

    public String getColor() {
        return color;
    }

    public String getProvince() {
        return province;
    }

    public String getPet() {
        return pet;
    }

    public String getStadium() {
        return stadium;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public void setPlayed_championships(int played_championships) {
        this.played_championships = played_championships;
    }

    public void setWon_championships(int won_championships) {
        this.won_championships = won_championships;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }
    
}
