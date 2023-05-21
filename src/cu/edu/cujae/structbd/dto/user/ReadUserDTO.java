/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.user;

import cu.edu.cujae.structbd.utils.USER_ROLE;

/**
 *
 * @author Hector Angel Gomez
 */
public class ReadUserDTO {
    private final int userID;
    private final String username;
    private final String role;
    private final String password;
    private final int roleID;

    public ReadUserDTO(int userID, String username, String role, String password, int roleID) {
        this.username = username;
        this.role = role;
        this.password = password;
        this.userID = userID;
        this.roleID = roleID;
    }

    public String getUsername() {
        return username;
    }
    
    public int getRoleID(){
        return this.roleID;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public int getUserID() {
        return userID;
    }
    
    public boolean isAdmin(){
        return this.getRole().equals(USER_ROLE.ADMIN.getRoleName());
    } 
}
