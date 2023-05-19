/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

/**
 *
 * @author Hector Angel Gomez
 */
public enum USER_ROLE {
    ADMIN("Administrador");
    
    private String roleName;
    
    private USER_ROLE(String roleName){
        this.roleName = roleName;
    }
    
    public String getRoleName(){
        return this.roleName;
    }
    
}
