/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.user;

/**
 *
 * @author Hector Angel Gomez
 */
public class FindUserDTO {
    private final int userID;

    public FindUserDTO(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
    
    
}
