package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.position.CreatePositionDTO;
import cu.edu.cujae.structbd.dto.position.DeletePositionDTO;
import cu.edu.cujae.structbd.dto.position.FindPositionDTO;
import cu.edu.cujae.structbd.dto.position.ReadAPositionDTO;
import cu.edu.cujae.structbd.dto.position.ReadPositionDTO;
import cu.edu.cujae.structbd.dto.position.UpdatePositionDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;


public class PositionServices {
    
    public void createPosition(CreatePositionDTO createPositionDTO) throws SQLException, ClassNotFoundException{
        String function = "{call position_insert(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, createPositionDTO.getPositionName());
        preparedFunction.execute();
        preparedFunction.close();
    }
    
    public void deletePosition(DeletePositionDTO deletePositionDTO) throws SQLException, ClassNotFoundException{
        String function = "{call position_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, deletePositionDTO.getPositionID());
        preparedFunction.execute();
        preparedFunction.close();
    }
    
    public void updatePosition(UpdatePositionDTO updatePositionDTO) throws SQLException, ClassNotFoundException{
        String function = "{call position_update(?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, updatePositionDTO.getPositionID());
        preparedFunction.setString(2, updatePositionDTO.getPositionName());
        preparedFunction.execute();
        preparedFunction.close();
    }
    
    public ReadPositionDTO readPosition(ReadAPositionDTO readAPositionDTO) throws SQLException, ClassNotFoundException{
        ReadPositionDTO readPositionDTO = null;
        String function = "{?= call position_load_by_id(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readAPositionDTO.getPositionID());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        resultSet.next();
        readPositionDTO = new ReadPositionDTO(resultSet.getInt(1), resultSet.getString(2));
        resultSet.close();
        preparedFunction.close();

        return readPositionDTO;
        
    }
    
    public List<ReadPositionDTO> readAllPositions() throws SQLException, ClassNotFoundException{
        LinkedList<ReadPositionDTO> positions_list = new LinkedList<>();
        String function = "{?= call position_load_all()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            positions_list.add(new ReadPositionDTO(resultSet.getInt("position_id"), resultSet.getString("position_name")));
        }
        resultSet.close();
        preparedFunction.close();

        return positions_list;
    }
    
    public int getPitcherPositionID() throws SQLException, ClassNotFoundException{
        List<ReadPositionDTO> allPositions = this.readAllPositions();
        
        ReadPositionDTO pitcherPos = null;
        for(int i=0; i < allPositions.size() && pitcherPos == null; i++){
            if(allPositions.get(i).getPositionName().equals("P")){
                pitcherPos = allPositions.get(i);
            }
        }
        
        return pitcherPos.getPositionID();
    }
    
    public List<ReadPositionDTO> readBatterPositions() throws SQLException, ClassNotFoundException{
        LinkedList<ReadPositionDTO> positions_list = new LinkedList<>();
        
        String function = "{?= call position_read_batter_positions()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            positions_list.add(new ReadPositionDTO(resultSet.getInt("position_id"), resultSet.getString("position_name")));
        }
        resultSet.close();
        preparedFunction.close();

        return positions_list;
    }
    
    public ReadPositionDTO findPosition(FindPositionDTO position) throws SQLException, ClassNotFoundException{
        List<ReadPositionDTO> allPositions = this.readAllPositions();
        ReadPositionDTO foundPosition = null;
        
        for(int i = 0; i < allPositions.size() && foundPosition == null; i++){
            if(allPositions.get(i).getPositionID() == position.getPositionID()){
                foundPosition = allPositions.get(i);
            }
        }
        
        return foundPosition;
    }
}
