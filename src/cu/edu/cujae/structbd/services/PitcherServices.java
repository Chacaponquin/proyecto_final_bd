package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.pitcher.CreatePitcherDTO;
import cu.edu.cujae.structbd.dto.pitcher.DeletePitcherDTO;
import cu.edu.cujae.structbd.dto.pitcher.ReadAPitcherDTO;
import cu.edu.cujae.structbd.dto.pitcher.ReadPitcherDTO;
import cu.edu.cujae.structbd.dto.pitcher.UpdatePitcherDTO;
import cu.edu.cujae.structbd.dto.team_member.ReadTeamMemberDTO;
import cu.edu.cujae.structbd.exceptions.team_member.EmptyMemberNameException;
import cu.edu.cujae.structbd.exceptions.team_member.DuplicateMemberNumberException;
import cu.edu.cujae.structbd.exceptions.team_member.WrongMemberNumberException;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;

public class PitcherServices {
    
    public void createPitcher(CreatePitcherDTO createPitcherDTO) throws SQLException, ClassNotFoundException, EmptyMemberNameException, WrongMemberNumberException, DuplicateMemberNumberException{
        ServicesLocator.TeamMemberServices.validateMemberName(createPitcherDTO.getTeamMemberName());
        ServicesLocator.TeamMemberServices.validateMemberNumber(createPitcherDTO.getMemberNumber(), createPitcherDTO.getTeamID());

        int pitcherPos = ServicesLocator.PositionServices.getPitcherPositionID();
        
        String function = "{call pitcher_insert(?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, 0);
        preparedFunction.setInt(2, 0);
        preparedFunction.setInt(3, pitcherPos);
        preparedFunction.setString(4, createPitcherDTO.getTeamMemberName());
        preparedFunction.setInt(5, createPitcherDTO.getMemberNumber());
        preparedFunction.setInt(6, createPitcherDTO.getTeamID());
        preparedFunction.setInt(7, 0);
        preparedFunction.execute();
        preparedFunction.close();
        
        connection.commit();
    }
    
    public List<ReadPitcherDTO> readAllPitchers() throws SQLException, ClassNotFoundException{
        LinkedList<ReadPitcherDTO> pitchers_list = new LinkedList<>();
        String function = "{?= call pitcher_load_all()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        
        while (resultSet.next())
        {
            int team_member_ID = resultSet.getInt("member_id");
            String team_member_name = resultSet.getString("member_name");
            int member_number = resultSet.getInt("member_number");
            String team_name = resultSet.getString("team_name");
            int years_in_team = resultSet.getInt("years_in_team");
            int inningsPitched = resultSet.getInt("innings_pitched");
            int runsAllowed = resultSet.getInt("runs_allowed");
            int teamID = resultSet.getInt("team_id");
            
            pitchers_list.add(new ReadPitcherDTO(team_member_ID, team_member_name, member_number, team_name, years_in_team, inningsPitched, runsAllowed, teamID));
        }
        
        resultSet.close();
        preparedFunction.close();
        
        return pitchers_list;
    }
    
    public ReadPitcherDTO readPitcher(ReadAPitcherDTO readAPitcherDTO) throws SQLException, ClassNotFoundException{        
        String function = "{?= call pitcher_load_by_id(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readAPitcherDTO.getTeamMemberID());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        resultSet.next();
        
        int team_member_ID = resultSet.getInt("member_id");
        String team_member_name = resultSet.getString("member_name");
        int member_number = resultSet.getInt("member_number");
        String team_name = resultSet.getString("team_name");
        int years_in_team = resultSet.getInt("years_in_team");
        int inningsPitched = resultSet.getInt("innings_pitched");
        int runsAllowed = resultSet.getInt("runs_allowed");
        int teamID = resultSet.getInt("team_id");
            
        ReadPitcherDTO pitcher =  new ReadPitcherDTO(team_member_ID, team_member_name, member_number, team_name, years_in_team, inningsPitched, runsAllowed, teamID);
        resultSet.close();
        preparedFunction.close();
        
        return pitcher;
    }
    
    public void updatePitcher(UpdatePitcherDTO updatePitcherDTO) throws SQLException, ClassNotFoundException, WrongMemberNumberException, DuplicateMemberNumberException, EmptyMemberNameException{
        ServicesLocator.TeamMemberServices.validateMemberName(updatePitcherDTO.getTeamMemberName());
        
        ReadTeamMemberDTO foundMemberWithNumber = ServicesLocator.TeamMemberServices.findMemberWithNumber(updatePitcherDTO.getMemberNumber(), updatePitcherDTO.getTeamID());
        if(foundMemberWithNumber != null && foundMemberWithNumber.getId() != updatePitcherDTO.getTeamMemberID()){
            throw new DuplicateMemberNumberException();
        }
        
        String function = "{call pitcher_update(?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, updatePitcherDTO.getTeamMemberID());
        preparedFunction.setString(2, updatePitcherDTO.getTeamMemberName());
        preparedFunction.setInt(3, updatePitcherDTO.getMemberNumber());
        preparedFunction.setInt(4, updatePitcherDTO.getYearsInTeam());
        preparedFunction.setInt(5, updatePitcherDTO.getTeamID());
        preparedFunction.setInt(6, updatePitcherDTO.getInningsPitched());
        preparedFunction.setInt(7, updatePitcherDTO.getRunsAllowed());
        preparedFunction.execute();
        preparedFunction.close();
        
        connection.commit();
    }
    
    public void deletePitcher(DeletePitcherDTO deletePitcherDTO) throws SQLException, ClassNotFoundException{
        String function = "{call pitcher_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, deletePitcherDTO.getTeamMemberID());
        preparedFunction.execute();
        preparedFunction.close();
    }
}
