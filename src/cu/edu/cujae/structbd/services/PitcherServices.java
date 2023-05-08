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
        String function = "{call pitcher_insert(?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, createPitcherDTO.getTeamMemberID());
        preparedFunction.setInt(2, createPitcherDTO.getInningsPitched());
        preparedFunction.setInt(3, createPitcherDTO.getRunsAllowed());
        preparedFunction.setString(4, createPitcherDTO.getPositionID());
        preparedFunction.setString(5, createPitcherDTO.getTeamMemberName());
        preparedFunction.setInt(6, createPitcherDTO.getMemberNumber());
        preparedFunction.setString(7, createPitcherDTO.getTeamID());
        preparedFunction.setInt(8, createPitcherDTO.getYearsInTeam());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
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
            pitchers_list.add(new ReadPitcherDTO(resultSet.getString(1), resultSet.getInt(2), 
                    resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5),
                    resultSet.getInt(6), resultSet.getString(7), resultSet.getInt(8)));
        }
        resultSet.close();
        preparedFunction.close();
        connection.close();
        return pitchers_list;
    }
    
    public ReadPitcherDTO readPitcher(ReadAPitcherDTO readAPitcherDTO) throws SQLException, ClassNotFoundException{
        ReadPitcherDTO readPitcherDTO = null;
        String function = "{?= call pitcher_load_by_id(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setString(2, readAPitcherDTO.getTeamMemberID());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        resultSet.next();
        readPitcherDTO = new ReadPitcherDTO(resultSet.getString(1), resultSet.getInt(2), 
                    resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5),
                    resultSet.getInt(6), resultSet.getString(7), resultSet.getInt(8));
        resultSet.close();
        preparedFunction.close();
        connection.close();
        return readPitcherDTO;
    }
    
    public void updatePitcher(UpdatePitcherDTO updatePitcherDTO) throws SQLException, ClassNotFoundException{
        String function = "{call pitcher_update(?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, updatePitcherDTO.getTeamMemberID());
        preparedFunction.setInt(2, updatePitcherDTO.getInningsPitched());
        preparedFunction.setInt(3, updatePitcherDTO.getRunsAllowed());
        preparedFunction.setString(4, updatePitcherDTO.getPositionID());
        preparedFunction.setString(5, updatePitcherDTO.getTeamMemberName());
        preparedFunction.setInt(6, updatePitcherDTO.getMemberNumber());
        preparedFunction.setString(7, updatePitcherDTO.getTeamID());
        preparedFunction.setInt(8, updatePitcherDTO.getYearsInTeam());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    
    public void deletePitcher(DeletePitcherDTO deletePitcherDTO) throws SQLException, ClassNotFoundException{
        String function = "{call pitcher_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, deletePitcherDTO.getTeamMemberID());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
}
