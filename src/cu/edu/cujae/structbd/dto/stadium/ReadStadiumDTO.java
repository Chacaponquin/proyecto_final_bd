/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.stadium;

/**
 *
 * @author Hector Angel Gomez
 */
public class ReadStadiumDTO {
    private final int stadiumID;
    private final String stadiumName;
    private final int capacity;
    private final String province;

    public ReadStadiumDTO(int stadiumID, String stadiumName, int capacity, String province) {
        this.stadiumID = stadiumID;
        this.stadiumName = stadiumName;
        this.capacity = capacity;
        this.province = province;
    }

    public int getStadiumID() {
        return stadiumID;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getProvince() {
        return province;
    }
}
