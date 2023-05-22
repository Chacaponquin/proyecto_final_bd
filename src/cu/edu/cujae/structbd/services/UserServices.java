/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.services;


import cu.edu.cujae.structbd.dto.user.ActualUserDTO;
import cu.edu.cujae.structbd.dto.user.CreateUserDTO;
import cu.edu.cujae.structbd.dto.user.DeleteUserDTO;
import cu.edu.cujae.structbd.dto.user.FindUserDTO;
import cu.edu.cujae.structbd.dto.user.LoginUserDTO;
import cu.edu.cujae.structbd.dto.user.ReadUserDTO;
import cu.edu.cujae.structbd.dto.user.UpdatePasswordDTO;
import cu.edu.cujae.structbd.dto.user.UpdateUserDTO;
import cu.edu.cujae.structbd.exceptions.app.EmptyFieldFormException;
import cu.edu.cujae.structbd.exceptions.user.AdminNotDeleteAdminException;
import cu.edu.cujae.structbd.exceptions.user.AtLeastOneAdminException;
import cu.edu.cujae.structbd.exceptions.user.DifferentPasswordsException;
import cu.edu.cujae.structbd.exceptions.user.DuplicateUserException;
import cu.edu.cujae.structbd.exceptions.user.EmptyNewPasswordException;
import cu.edu.cujae.structbd.exceptions.user.IncorrectLoginException;
import cu.edu.cujae.structbd.exceptions.user.NotEqualOldPassword;
import cu.edu.cujae.structbd.exceptions.user.ShortPasswordException;
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
            int roleID = resultSet.getInt("user_role_id");
            
            users.add(new ReadUserDTO(id, username, role, password, roleID));
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
    
    public void createUser(CreateUserDTO newUser) throws DifferentPasswordsException, SQLException, ClassNotFoundException, EmptyFieldFormException, ShortUsernameException, DuplicateUserException, EmptyNewPasswordException, ShortPasswordException{
        this.validateUsername(newUser.getUsername());
        
        if(this.foundDuplicateUsername(newUser.getUsername()) != null){
            throw new DuplicateUserException();
        }
        
        this.validateUserPassword(newUser.getPassword(), newUser.getComfirmPassword());
        
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
            this.setActualUser(new ActualUserDTO(foundUser.getUserID(),foundUser.getUsername(), foundUser.getRole(), foundUser.getRoleID()));
        }
    }
    
    public void deleteUser(DeleteUserDTO user) throws SQLException, ClassNotFoundException, AdminNotDeleteAdminException, AtLeastOneAdminException{
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
    
    public ReadUserDTO findUser(FindUserDTO user) throws SQLException, ClassNotFoundException{
        List<ReadUserDTO> allUsers = this.readUsers();
        ReadUserDTO found = null;
        
        for(int i = 0; i < allUsers.size() && found == null; i++){
            if(allUsers.get(i).getUserID() == user.getUserID()){
                found = allUsers.get(i);
            }
        }
        
        return found;
    }
    
    private void deleteUserQuery(DeleteUserDTO user) throws SQLException, ClassNotFoundException, AdminNotDeleteAdminException, AtLeastOneAdminException, AtLeastOneAdminException{
        this.validateActualUserCanDelete(user);
        
        String function = "{call user_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, user.getUserID());
        preparedFunction.execute();
        preparedFunction.close();
        
        connection.commit();
    }
    
    private int countAdminUsers() throws SQLException, ClassNotFoundException{
        List<ReadUserDTO> allUsers = this.readUsers();
        int cont = 0;
        
        for(int i = 0; i < allUsers.size(); i++){
            if(USER_ROLE.ADMIN.equal(allUsers.get(i).getRole())){
                cont++;
            }
        }
        
        return cont;
        
    }
    
    private void validateActualUserCanDelete(DeleteUserDTO userToDelete) throws SQLException, ClassNotFoundException, AdminNotDeleteAdminException, AtLeastOneAdminException{
        ReadUserDTO foundUserDelete = this.findUser(new FindUserDTO(userToDelete.getUserID()));
        
        if(USER_ROLE.ADMIN.equal(foundUserDelete.getRole()) && USER_ROLE.ADMIN.equal(this.actualUser.getRole())){
            throw new AdminNotDeleteAdminException();
        }
        
        if(this.actualUserIsSuperAdmin()){
            int contAdmin = this.countAdminUsers();
            
            if(contAdmin == 1){
                throw new AtLeastOneAdminException();
            }
        }
    }
    
    private boolean actualUserIsSuperAdmin() {
        return USER_ROLE.SUPER_ADMIN.equal(this.actualUser.getRole());
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
    
    private void validateUserPassword(String password, String comfirmPassword) throws EmptyNewPasswordException, ShortPasswordException, DifferentPasswordsException{
        if(password.equals("")){
            throw new EmptyNewPasswordException();
        }
        
        if(password.length() < 5){
            throw new ShortPasswordException();
        }
        
        if(!(comfirmPassword.equals(password))){
            throw new DifferentPasswordsException();
        }
    }
    
    public void updateUserPassword(UpdatePasswordDTO newPassword) throws SQLException, ClassNotFoundException, NotEqualOldPassword, EmptyNewPasswordException, DifferentPasswordsException, ShortPasswordException{
        ReadUserDTO foundUser = this.findUser(new FindUserDTO(newPassword.getUserID()));
        
        if(!this.verifyPassword(newPassword.getOldPassword(), foundUser.getPassword())){
            throw new NotEqualOldPassword();
        }
        
        this.validateUserPassword(newPassword.getNewPassword(), newPassword.getComfirmPassword());
        
        String function = "{call user_update(?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, newPassword.getUserID());
        preparedFunction.setString(2, foundUser.getUsername());
        preparedFunction.setString(3, this.hashPassword(newPassword.getNewPassword()));
        preparedFunction.setInt(4, foundUser.getRoleID());
        
        preparedFunction.execute();
        preparedFunction.close();
        connection.commit();
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
        preparedFunction.setString(3, updateUser.getNewPassword());
        preparedFunction.setInt(4, updateUser.getRoleID());
        
        preparedFunction.execute();
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
        
        return USER_ROLE.SUPER_ADMIN.equal(this.actualUser.getRole()) || USER_ROLE.ADMIN.equal(this.actualUser.getRole());
    }
    
    public boolean actualUserIsInvited(){
        return USER_ROLE.INVITED.equal(this.actualUser.getRole());
    }
    
}
