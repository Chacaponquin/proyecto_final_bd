/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.services;


import cu.edu.cujae.structbd.dto.user.ActualUserDTO;
import cu.edu.cujae.structbd.dto.user.CreateUserDTO;
import cu.edu.cujae.structbd.dto.user.DeleteUserDTO;
import cu.edu.cujae.structbd.dto.user.LoginUserDTO;
import cu.edu.cujae.structbd.dto.user.ReadUserDTO;
import cu.edu.cujae.structbd.dto.user.UpdateUserDTO;
import cu.edu.cujae.structbd.exceptions.app.EmptyFieldFormException;
import cu.edu.cujae.structbd.exceptions.user.DifferentPasswordsException;
import cu.edu.cujae.structbd.exceptions.user.DuplicateUserException;
import cu.edu.cujae.structbd.exceptions.user.IncorrectLoginException;
import cu.edu.cujae.structbd.exceptions.user.ShortUsernameException;
import cu.edu.cujae.structbd.utils.Connector;
import cu.edu.cujae.structbd.utils.USER_ROLE;
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
    
    private List<ReadUserDTO> readUsers() throws SQLException, ClassNotFoundException{
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
            int id = resultSet.getInt("user_id");
            String username = resultSet.getString("username");
            String role = resultSet.getString("role_name");
            String password = resultSet.getString("password");
            
            users.add(new ReadUserDTO(id, username, role, password));
        }
        
        resultSet.close();
        preparedFunction.close();
        
        return users;
    }
    
    public List<ReadUserDTO> readUsersForAdmin() throws SQLException, ClassNotFoundException{
        List<ReadUserDTO> allUsers = this.readUsers();
        
        List<ReadUserDTO> returnUsers = new LinkedList<>();
        for(ReadUserDTO r: allUsers){
            if(r.getUserID() != this.actualUser.getID()){
                returnUsers.add(r);
            }
        }
        
        return returnUsers;
    }
    
    private void validateUsername(String username) throws EmptyFieldFormException, SQLException, ClassNotFoundException, ShortUsernameException{
        if(username.equals("")){
            throw new EmptyFieldFormException("nombre de usuario");
        }
        else if(username.length() < 5){
            throw new ShortUsernameException();
        }
        else if(username.equals("")){
            throw new EmptyFieldFormException("contraseña");
        }
    }
    
    public void createUser(CreateUserDTO newUser) throws DifferentPasswordsException, SQLException, ClassNotFoundException, EmptyFieldFormException, ShortUsernameException, DuplicateUserException{
        this.validateUsername(newUser.getUsername());
        
        if(this.foundDuplicateUsername(newUser.getUsername()) != null){
            throw new DuplicateUserException();
        }
        
        
        if(!(newUser.getComfirmPassword().equals(newUser.getPassword()))){
            throw new DifferentPasswordsException();
        }
        
        
        String function = "{call user_insert(?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, newUser.getUsername());
        preparedFunction.setString(2, this.hashPassword(newUser.getPassword()));
        preparedFunction.setInt(3, newUser.getUserRoleID());
        preparedFunction.execute();
        preparedFunction.close();
        
        connection.commit();
    }
    
    public void loginUser(LoginUserDTO user) throws SQLException, ClassNotFoundException, IncorrectLoginException{
        List<ReadUserDTO> users = this.readUsers();
        
        ReadUserDTO foundUser = null;
        for(int i = 0; i < users.size() && foundUser == null; i++){
            ReadUserDTO u = users.get(i);
            
            if(u.getUsername().equals(user.getUsername())){
                if(this.verifyPassword(user.getPassword(), u.getPassword())){
                    foundUser = u;
                }
            }
        }
        
        if(foundUser == null){
            throw new IncorrectLoginException();
        }else {
            this.setActualUser(new ActualUserDTO(foundUser.getUserID(),foundUser.getUsername(), foundUser.getRole()));
        }
    }
    
    public void deleteUser(DeleteUserDTO user) throws SQLException, ClassNotFoundException{
        List<ReadUserDTO> allUsers = this.readUsers();
        
        ReadUserDTO userFound = null;
        for(int i =0; i < allUsers.size() && userFound == null; i++){
            if(allUsers.get(i).getUserID() == user.getUserID()){
                userFound = allUsers.get(i);
            }
        }
        
        if(userFound != null){
            this.deleteUserQuery(user);
        }
    }
    
    private void deleteUserQuery(DeleteUserDTO user) throws SQLException, ClassNotFoundException{
        String function = "{call user_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, user.getUserID());
        preparedFunction.execute();
        preparedFunction.close();
        
        connection.commit();
    }
    
    private ReadUserDTO foundDuplicateUsername(String username) throws SQLException, ClassNotFoundException{
        ReadUserDTO found = null;
        List<ReadUserDTO> users = this.readUsers();
        
        for(int i = 0; i < users.size() && found == null; i++){
            if(users.get(i).getUsername().equals(username)){
                found = users.get(i);
            }
        }
        
        
        return found;
    }
    
    public void updateUser(UpdateUserDTO updateUser) throws SQLException, ClassNotFoundException, EmptyFieldFormException, EmptyFieldFormException, DuplicateUserException, ShortUsernameException{
        this.validateUsername(updateUser.getNewUsername());
        
        ReadUserDTO foundDuplicate = this.foundDuplicateUsername(updateUser.getNewUsername());
        if(foundDuplicate != null && foundDuplicate.getUserID() != updateUser.getUserID()){
            throw new DuplicateUserException();
        }
        
        String function = "{call user_update(?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, updateUser.getUserID());
        preparedFunction.setString(2, updateUser.getNewUsername());
        
        preparedFunction.close();
        connection.commit();
    }
    
    
    private String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }
    
    private boolean verifyPassword(String loginPassword, String hashPassword){
        return BCrypt.checkpw(loginPassword, hashPassword);
    }
    
    public void signOutUser(){
        this.actualUser = null;
    }
    
    public boolean actualUserIsAdmin(){
        if(actualUser == null) return false;
        
        return this.actualUser.getRole().equals(USER_ROLE.ADMIN.getRoleName());
    }
    
}
