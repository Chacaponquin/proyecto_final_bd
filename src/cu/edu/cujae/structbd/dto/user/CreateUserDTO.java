/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.user;

/**
 *
 * @author Hector Angel Gomez
 */
public class CreateUserDTO {;
    private String username;
    private String password;
    private int userRoleID;
    private String comfirmPassword;

    public CreateUserDTO(String username, String password, String comfirmPassword, int userRoleID) {
        this.username = username.trim();
        this.password = password.trim();
        this.comfirmPassword = comfirmPassword.trim();
        this.userRoleID = userRoleID;
    }

    public int getUserRoleID() {
        return userRoleID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getComfirmPassword() {
        return comfirmPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }

    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
    }
}
