package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.pitcher.CreatePitcherDTO;
import cu.edu.cujae.structbd.dto.pitcher.DeletePitcherDTO;
import cu.edu.cujae.structbd.dto.pitcher.ReadAPitcherDTO;
import cu.edu.cujae.structbd.dto.pitcher.ReadPitcherDTO;
import cu.edu.cujae.structbd.dto.pitcher.UpdatePitcherDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;

public class PitcherServices {
    
    public void createPitcher(CreatePitcherDTO createPitcherDTO) throws SQLException, ClassNotFoundException{
        String function = "{call pitcher_insert(?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(2, createPitcherDTO.getInningsPitched());
        preparedFunction.setInt(3, createPitcherDTO.getRunsAllowed());
        preparedFunction.setInt(4, createPitcherDTO.getPositionID());
        preparedFunction.setString(5, createPitcherDTO.getTeamMemberName());
        preparedFunction.setInt(6, createPitcherDTO.getMemberNumber());
        preparedFunction.setInt(7, createPitcherDTO.getTeamID());
        preparedFunction.setInt(8, createPitcherDTO.getYearsInTeam());
        preparedFunction.execute();
        preparedFunction.close();
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
            int teamMemberID = resultSet.getInt("member_id");
            String teamMemberName = resultSet.getString("member_name");
            int memberNumber = resultSet.getInt("member_number");
            String team = resultSet.getString("team_name");
            int yearsInTeam = resultSet.getInt("years_in_team");
            int inningsPitched = resultSet.getInt("innings_pitched");
            int runsAllowed = resultSet.getInt("runs_allowed");
            
            pitchers_list.add(new ReadPitcherDTO(teamMemberID, inningsPitched, runsAllowed, teamMemberName, memberNumber, team, 
            yearsInTeam));
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
        ReadPitcherDTO  readPitcherDTO = new ReadPitcherDTO(resultSet.getInt(1), resultSet.getInt(2), 
                    resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5), 
                    resultSet.getString(6), resultSet.getInt(7));
        resultSet.close();
        preparedFunction.close();
        
        return readPitcherDTO;
    }
    
    public void updatePitcher(UpdatePitcherDTO updatePitcherDTO) throws SQLException, ClassNotFoundException{
        String function = "{call pitcher_update(?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, updatePitcherDTO.getTeamMemberID());
        preparedFunction.setInt(2, updatePitcherDTO.getInningsPitched());
        preparedFunction.setInt(3, updatePitcherDTO.getRunsAllowed());
        preparedFunction.setString(4, updatePitcherDTO.getPositionID());
        preparedFunction.setString(5, updatePitcherDTO.getTeamMemberName());
        preparedFunction.setInt(6, updatePitcherDTO.getMemberNumber());
        preparedFunction.setString(7, updatePitcherDTO.getTeamID());
        preparedFunction.setInt(8, updatePitcherDTO.getYearsInTeam());
        preparedFunction.execute();
        preparedFunction.close();
    }
    
    public void deletePitcher(DeletePitcherDTO deletePitcherDTO) throws SQLException, ClassNotFoundException{
        String function = "{call pitcher_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, deletePitcherDTO.getTeamMemberID());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
}
