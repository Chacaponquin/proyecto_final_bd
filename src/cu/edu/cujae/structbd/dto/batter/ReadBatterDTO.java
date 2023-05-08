/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.batter;

/**
 *
 * @author Hector Angel Gomez
 */
public class ReadBatterDTO {
    private String name;
    private String equipo;
    private int yearsInTeam;
    private int number;
    private String position;
    private int atBats;
    private int totalHits;

    public ReadBatterDTO(String name, String equipo, int yearsInTeam, int number, String position, int atBats, int totalHits) {
        this.name = name;
        this.equipo = equipo;
        this.yearsInTeam = yearsInTeam;
        this.number = number;
        this.position = position;
        this.atBats = atBats;
        this.totalHits = totalHits;
    }
    
    public Object[] getArrayValues(){
        return new Object[]{name, equipo, yearsInTeam,number, position, atBats, totalHits, this.getAverage()};
    }
    
    public int getAverage(){
        float value = (float)totalHits / atBats * 1000;
        return (int) value;
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
}
