/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.user.ActualUserDTO;
import cu.edu.cujae.structbd.dto.user_role.FindUserRoleDTO;
import cu.edu.cujae.structbd.dto.user_role.ReadUserRoleDTO;
import cu.edu.cujae.structbd.utils.Connector;
import cu.edu.cujae.structbd.utils.USER_ROLE;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Hector Angel Gomez
 */
public class UserRoleServices {
    private List<ReadUserRoleDTO> readUserRoles() throws SQLException, ClassNotFoundException{
        LinkedList<ReadUserRoleDTO> user_roles = new LinkedList<>();
        String function = "{?= call user_role_load()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            ReadUserRoleDTO o = new ReadUserRoleDTO(resultSet.getInt("user_role_id"), resultSet.getString("role_name"));
            user_roles.add(o);
        }
        resultSet.close();
        preparedFunction.close();
        
        return user_roles;
    }
    
    public List<ReadUserRoleDTO> readLoginRoles() throws SQLException, ClassNotFoundException{
        LinkedList<ReadUserRoleDTO> user_roles = new LinkedList<>();
        List<ReadUserRoleDTO> allRoles = this.readUserRoles();
        ActualUserDTO actualUser = ServicesLocator.UserServices.getActualUser();
        
        for(ReadUserRoleDTO r: allRoles){
            if(!USER_ROLE.SUPER_ADMIN.equal(r.getRoleName())){
                if(USER_ROLE.ADMIN.equal(r.getRoleName())){
                   if(USER_ROLE.SUPER_ADMIN.equal(actualUser.getRole())){
                       user_roles.add(r);
                    }
                }else{
                    user_roles.add(r);
                }      
            }
        }
        
        return user_roles;
    }
    
    public ReadUserRoleDTO findRole(FindUserRoleDTO role) throws SQLException, ClassNotFoundException{
        List<ReadUserRoleDTO> allRoles = this.readUserRoles();
        ReadUserRoleDTO found = null;
        
        for(int i = 0; i < allRoles.size() && found == null; i++){
            if(allRoles.get(i).getUserRoleID() == role.getRoleID()){
                found = allRoles.get(i);
            }
        }
        
        return found;
    }
    
}
