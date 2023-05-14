/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.user;

/**
 *
 * @author Hector Angel Gomez
 */
public class ReadUserDTO {
    private final String userID;
    private final String username;
    private final String role;
    private final String password;

    public ReadUserDTO(String userID, String username, String role, String password) {
        this.username = username;
        this.role = role;
        this.password = password;
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getUserID() {
        return userID;
    }
    
    

    
}
