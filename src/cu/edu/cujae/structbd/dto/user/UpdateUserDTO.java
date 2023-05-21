/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.user;

/**
 *
 * @author Hector Angel Gomez
 */
public class UpdateUserDTO {
    private final int userID;
    private final String newUsername;
    private final String newPassword;
    private final String comfirmPassword;

    public UpdateUserDTO(int userID, String newUsername, String newPassword, String comfirmPassword) {
        this.userID = userID;
        this.newUsername = newUsername;
        this.newPassword = newPassword;
        this.comfirmPassword = comfirmPassword;
    }

    public int getUserID() {
        return userID;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getComfirmPassword() {
        return comfirmPassword;
    }
    
    
    
}
