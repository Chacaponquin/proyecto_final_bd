/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.dto.user_role;

/**
 *
 * @author Hector Angel Gomez
 */
public class ReadUserRoleDTO {
    private final String userRoleID;
    private final String roleName;

    public ReadUserRoleDTO(String userRoleID, String roleName) {
        this.userRoleID = userRoleID;
        this.roleName = roleName;
    }

    public String getUserRoleID() {
        return userRoleID;
    }

    public String getRoleName() {
        return roleName;
    }
    
    
    
}
