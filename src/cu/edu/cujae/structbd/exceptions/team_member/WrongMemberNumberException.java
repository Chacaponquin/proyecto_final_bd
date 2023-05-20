/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.exceptions.team_member;

import cu.edu.cujae.structbd.utils.TEAM_LIMITS;

/**
 *
 * @author Hector Angel Gomez
 */
public class WrongMemberNumberException extends Exception{
    private String message;
    
    public WrongMemberNumberException(){      
        String min = String.valueOf(TEAM_LIMITS.MEMBER_NUMBER.getMinimun());
        String max = String.valueOf(TEAM_LIMITS.MEMBER_NUMBER.getMaximun());
        
        this.message = "El dorsal debe estar entre " + min + " y " + max + ".";
    }
    
    @Override
    public String getMessage(){
        return this.message;
    }
}
