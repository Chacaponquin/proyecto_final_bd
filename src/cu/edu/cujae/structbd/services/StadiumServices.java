package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.stadium.ReadStadiumDTO;
import cu.edu.cujae.structbd.dto.team.FindTeamDTO;
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
        if (resultSet.next())
        {
            int stadiumID = resultSet.getInt("stadium_id");
            String stadiumName = resultSet.getString("stadium_name");
            int capacity = resultSet.getInt("capacity");
        readStadiumDTO = new ReadStadiumDTO(stadiumID, stadiumName, capacity, null);
        }
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return readStadiumDTO;
    }
}
