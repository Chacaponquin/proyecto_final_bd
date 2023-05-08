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
    private String stadiumName;
    private int capacity;
    
    public ReadStadiumDTO(String stadiumName, int capacity){
        this.capacity = capacity;
        this.stadiumName = stadiumName;
    }
    
}
