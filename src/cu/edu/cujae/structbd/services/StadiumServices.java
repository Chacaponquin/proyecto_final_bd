package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.stadium.ReadStadiumDTO;
import cu.edu.cujae.structbd.dto.stadium.UpdateStadiumDTO;
import cu.edu.cujae.structbd.dto.team.FindTeamDTO;
import cu.edu.cujae.structbd.exceptions.stadium.EmptyStadiumNameException;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StadiumServices {
    public List<ReadStadiumDTO> getStadiums() throws SQLException, ClassNotFoundException{
        List<ReadStadiumDTO> stadiums = new ArrayList<>();
        
        String function = "{?= call stadium_read()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            int stadiumID = resultSet.getInt("stadium_id");
            String stadiumName = resultSet.getString("stadium_name");
            int capacity = resultSet.getInt("capacity");
            String province = resultSet.getString("province_name");
            
            stadiums.add(new ReadStadiumDTO(stadiumID, stadiumName, capacity, province));
        }
        resultSet.close();
        preparedFunction.close();
        
        return stadiums;
    }
    
    public void validateStadiumName(String name) throws EmptyStadiumNameException{
        if(name.equals("")){
            throw new EmptyStadiumNameException();
        }
    }
    
    
    
    public void updateStadium(UpdateStadiumDTO stadium) throws SQLException, ClassNotFoundException, EmptyStadiumNameException{
        this.validateStadiumName(stadium.getStadiumName());
        
        String function = "{call stadium_update(?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(3, stadium.getCapacity());
        preparedFunction.setString(2, stadium.getStadiumName());
        preparedFunction.setInt(1, stadium.getStadiumID());
        
        preparedFunction.execute();
        preparedFunction.close();
        connection.commit();
    }

    public ReadStadiumDTO getStadiumByTeam(FindTeamDTO readATeamDTO) throws SQLException, ClassNotFoundException
    {
        ReadStadiumDTO readStadiumDTO = null;
        String function = "{?= call load_stadium_by_team_id(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readATeamDTO.getTeam_id());
        preparedFunction.execute();
        
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
<<<<<<< HEAD
=======

>>>>>>> 75770589af48dd0d984136ae4133c42cc47d1318
        if (resultSet.next())
        {
            int stadiumID = resultSet.getInt("stadium_id");
            String stadiumName = resultSet.getString("stadium_name");
            int capacity = resultSet.getInt("capacity");
        readStadiumDTO = new ReadStadiumDTO(stadiumID, stadiumName, capacity, null);
        }
<<<<<<< HEAD
=======
        
>>>>>>> 75770589af48dd0d984136ae4133c42cc47d1318
        resultSet.next();
        int stadiumID = resultSet.getInt("stadium_id");
        String stadiumName = resultSet.getString("stadium_name");
        int capacity = resultSet.getInt("capacity");
        String province = resultSet.getString("province_name");
        
        readStadiumDTO = new ReadStadiumDTO(stadiumID, stadiumName, capacity, province);
<<<<<<< HEAD
=======

>>>>>>> 75770589af48dd0d984136ae4133c42cc47d1318
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return readStadiumDTO;
    }
}
