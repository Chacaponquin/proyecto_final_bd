/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.user;

/**
 *
 * @author Hector Angel Gomez
 */
public class UpdatePasswordDTO {
    private final int userID;
    private final String oldPassword;
    private final String newPassword;
    private final String comfirmPassword;

    public UpdatePasswordDTO(int userID, String oldPassword, String newPassword, String comfirmPassword) {
        this.userID = userID;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.comfirmPassword = comfirmPassword;
    }

    public int getUserID() {
        return userID;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getComfirmPassword() {
        return comfirmPassword;
    }
    
    
}
