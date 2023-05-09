/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

import java.util.UUID;

/**
 *
 * @author Hector Angel Gomez
 */
public class IdUtils {
    public String generateUniqueID(){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        
        return uuidAsString;
    }
    
}
