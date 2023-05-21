/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.user;

/**
 *
 * @author Hector Angel Gomez
 */
public class ActualUserDTO {
    private final String username;
    private final String role;
    private final int id;
    private final int roleID;

    public ActualUserDTO(int id, String username, String role, int roleID) {
        this.username = username;
        this.role = role;
        this.id = id;
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
    
    public int getID(){
        return id;
    }
}
