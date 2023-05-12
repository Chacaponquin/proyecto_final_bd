/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.user.ActualUserDTO;
import cu.edu.cujae.structbd.dto.user.CreateUserDTO;
import cu.edu.cujae.structbd.exceptions.user.DifferentPasswordsException;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

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
    
    public void createUser(CreateUserDTO newUser) throws DifferentPasswordsException, SQLException, ClassNotFoundException{
        if(newUser.getComfirmPassword() != newUser.getPassword()){
            throw new DifferentPasswordsException();
        }
        
        String function = "{call user_insert(?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, newUser.getID());
        preparedFunction.setString(1, newUser.getUsername());
        preparedFunction.setString(2, newUser.getPassword());
        preparedFunction.execute();
        preparedFunction.close();
    }
    
    private String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }
    
}
