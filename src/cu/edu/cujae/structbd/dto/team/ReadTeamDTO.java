/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.team;

/**
 *
 * @author Hector Angel Gomez
 */
public class ReadTeamDTO {
    private final int team_id;
    private final String team_name;
    private final int played_championships;
    private final int won_championships;
    private final String color;
    private final String province;
    private final String pet;
    private final String stadium;

    public ReadTeamDTO(int team_id, String team_name, int played_championships, int won_championships,String color, String province, String pet, String stadium) {
        this.team_id = team_id;
        this.team_name = team_name;
        this.played_championships = played_championships;
        this.color = color;
        this.province = province;
        this.pet = pet;
        this.stadium = stadium;
        this.won_championships = won_championships;
    }
    

    public int getTeam_id() {
        return team_id;
    }
    
    public int getWon_championships(){
        return this.won_championships;
    }

    public String getTeam_name() {
        return team_name;
    }

    public int getPlayed_championships() {
        return played_championships;
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
    
    
}
