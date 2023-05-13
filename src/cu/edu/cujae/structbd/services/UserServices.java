/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.services;


import cu.edu.cujae.structbd.dto.user.ActualUserDTO;
import cu.edu.cujae.structbd.dto.user.CreateUserDTO;
import cu.edu.cujae.structbd.dto.user.ReadUserDTO;
import cu.edu.cujae.structbd.exceptions.app.EmptyFieldFormException;
import cu.edu.cujae.structbd.exceptions.user.DifferentPasswordsException;
import cu.edu.cujae.structbd.exceptions.user.DuplicateUserException;
import cu.edu.cujae.structbd.exceptions.user.ShortUsernameException;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
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
    
    public List<ReadUserDTO> readUsers() throws SQLException, ClassNotFoundException{
        LinkedList<ReadUserDTO> users = new LinkedList<>();
        
        String function = "{?= call user_load()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            String username = resultSet.getString("username");
            String role = resultSet.getString("role_name");
            String password = resultSet.getString("password");
            
            users.add(new ReadUserDTO(username, role, password));
        }
        resultSet.close();
        preparedFunction.close();
        
        return users;
    }
    
    public void createUser(CreateUserDTO newUser) throws DifferentPasswordsException, SQLException, ClassNotFoundException, EmptyFieldFormException, ShortUsernameException, DuplicateUserException{
        if(newUser.getPassword().equals("")){
            throw new EmptyFieldFormException("nombre de usuario");
        }
        else if(newUser.getUsername().equals("")){
            throw new EmptyFieldFormException("contraseña");
        }
        else if(newUser.getUsername().length() < 5){
            throw new ShortUsernameException();
        }
        else if(!(newUser.getComfirmPassword().equals(newUser.getPassword()))){
            throw new DifferentPasswordsException();
        }else if(!this.validateNotExistsDuplicateUsername(newUser.getUsername())){
            throw new DuplicateUserException();
        }
        
        String function = "{call user_insert(?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, newUser.getID());
        preparedFunction.setString(2, newUser.getUsername());
        preparedFunction.setString(3, this.hashPassword(newUser.getPassword()));
        preparedFunction.setString(4, newUser.getUserRoleID());
        preparedFunction.execute();
        preparedFunction.close();
        
        connection.commit();
    }
    
    private boolean validateNotExistsDuplicateUsername(String username) throws SQLException, ClassNotFoundException{
        boolean validate = true;
        
        List<ReadUserDTO> users = this.readUsers();
        
        for(int i = 0; i < users.size() && validate; i++){
            if(users.get(i).getUsername().equals(username)){
                validate = false;
            }
        }
        
        
        return validate;
    }
    
    private String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }
    
}
