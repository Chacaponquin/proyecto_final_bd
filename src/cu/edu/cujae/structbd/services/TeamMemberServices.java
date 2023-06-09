package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.team.FindTeamDTO;
import cu.edu.cujae.structbd.dto.team.ReadTeamDTO;
import cu.edu.cujae.structbd.dto.team_member.DeleteTeamMemberDTO;
import cu.edu.cujae.structbd.dto.team_member.ReadATeamMemberDTO;
import cu.edu.cujae.structbd.dto.team_member.ReadTeamMemberDTO;
import cu.edu.cujae.structbd.dto.team_member.UpdateTeamMemberDTO;
import cu.edu.cujae.structbd.exceptions.team_member.DuplicateMemberNumberException;
import cu.edu.cujae.structbd.exceptions.team_member.EmptyMemberNameException;
import cu.edu.cujae.structbd.exceptions.team_member.WrongMemberNumberException;
import cu.edu.cujae.structbd.utils.Connector;
import cu.edu.cujae.structbd.utils.TEAM_LIMITS;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;

public class TeamMemberServices {
    
    public ReadTeamMemberDTO readTeamMember(ReadATeamMemberDTO readATeamMemberDTO) throws SQLException, ClassNotFoundException{
        ReadTeamMemberDTO readTeamMemberDTO = null;
        
        String function = "{?= call team_member_load_by_id(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readATeamMemberDTO.getId());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        resultSet.next();
        readTeamMemberDTO = new ReadTeamMemberDTO(resultSet.getString(1), resultSet.getInt(2), 
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(5));
        resultSet.close();
        preparedFunction.close();

        return readTeamMemberDTO;
        
    }
    
    public List<ReadTeamMemberDTO> readAllTeamMembers() throws SQLException, ClassNotFoundException{
        LinkedList<ReadTeamMemberDTO> teamMembersList = new LinkedList<>();
        String function = "{?= call team_member_load_all()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            teamMembersList.add(new ReadTeamMemberDTO(resultSet.getString(1), resultSet.getInt(2), 
                    resultSet.getInt(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(5)));
        }
        resultSet.close();
        preparedFunction.close();

        return teamMembersList;
    }
    
    public void updateTeamMember(UpdateTeamMemberDTO updateTeamMemberDTO) throws SQLException, ClassNotFoundException{
        String function = "{call team_member_update(?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, updateTeamMemberDTO.getName());
        preparedFunction.setInt(2, updateTeamMemberDTO.getNumber());
        preparedFunction.setInt(3, updateTeamMemberDTO.getYearsInTeam());
        preparedFunction.setInt(4, updateTeamMemberDTO.getId());
        preparedFunction.setInt(5, updateTeamMemberDTO.getTeam_id());
        preparedFunction.execute();
        preparedFunction.close();
    }
    
    public void deleteTeamMember(DeleteTeamMemberDTO deleteTeamMemberDTO) throws SQLException, ClassNotFoundException{
        String function = "{call team_member_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, deleteTeamMemberDTO.getId());
        preparedFunction.execute();
        preparedFunction.close();
    }
    
    public ReadTeamMemberDTO findMemberWithNumber(int number, int teamID) throws SQLException, ClassNotFoundException{
        ReadTeamDTO foundTeam = ServicesLocator.TeamServices.findTeamByID(new FindTeamDTO(teamID));
        List<ReadTeamMemberDTO> members = ServicesLocator.TeamServices.readMembersFromTeam(foundTeam);
        
        ReadTeamMemberDTO existsNumber = null;
        for(int i = 0; i < members.size() && existsNumber == null; i++){
            if(members.get(i).getNumber() == number){
                existsNumber = members.get(i);
            }
        }
        
        return existsNumber;
    }
    
    public void validateMemberNumber(int number, int teamID) throws WrongMemberNumberException, SQLException, ClassNotFoundException, DuplicateMemberNumberException{
        if(number < TEAM_LIMITS.MEMBER_NUMBER.getMinimun() || number > TEAM_LIMITS.MEMBER_NUMBER.getMaximun()){
            throw new WrongMemberNumberException();
        }
        
        ReadTeamMemberDTO existsNumber = this.findMemberWithNumber(number, teamID);
        
        if(existsNumber != null){
            throw new DuplicateMemberNumberException();
        }
    }
    
    public void validateMemberName(String name) throws EmptyMemberNameException{
        if(name == null || name.trim().equals("")){
            throw new EmptyMemberNameException();
        }
    }
}
