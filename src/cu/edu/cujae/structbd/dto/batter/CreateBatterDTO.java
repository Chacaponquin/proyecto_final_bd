package cu.edu.cujae.structbd.dto.batter;

public class CreateBatterDTO {
    private String name;
    private String equipo;
    private int yearsInTeam;
    private int number;
    private String position;
    private int atBats;
    private int totalHits;

    public CreateBatterDTO(String name, String equipo, int yearsInTeam, int number, String position, int atBats, int totalHits) {
        this.name = name;
        this.equipo = equipo;
        this.yearsInTeam = yearsInTeam;
        this.number = number;
        this.position = position;
        this.atBats = atBats;
        this.totalHits = totalHits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setYearsInTeam(int yearsInTeam) {
        this.yearsInTeam = yearsInTeam;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAtBats(int atBats) {
        this.atBats = atBats;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public String getName() {
        return name;
    }

    public String getEquipo() {
        return equipo;
    }

    public int getYearsInTeam() {
        return yearsInTeam;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public int getAtBats() {
        return atBats;
    }

    public int getTotalHits() {
        return totalHits;
    }
    
    
    
}
