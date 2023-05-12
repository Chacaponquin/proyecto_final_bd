/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.user.ActualUserDTO;

/**
 *
 * @author Hector Angel Gomez
 */
public class UserServices {
    private ActualUserDTO actualUser = null;
    
    public ActualUserDTO getActualUser(){
        return this.actualUser;
    } 
    
    public void setActualUser(ActualUserDTO user){
        this.actualUser = user;
    }
    
}
