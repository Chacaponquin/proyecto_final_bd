package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.reports.ReadReport_1DTO;
import cu.edu.cujae.structbd.dto.stadium.ReadStadiumDTO;
import cu.edu.cujae.structbd.dto.team.ReadATeamDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StadiumServices {
    public ArrayList<ReadStadiumDTO> getStadiums() throws SQLException, ClassNotFoundException{
        ArrayList<ReadStadiumDTO> stadiums = new ArrayList<>();
        
        String query = "SELECT * FROM stadium";
        
        java.sql.Connection connection = Connector.getConnection();

	ResultSet result = connection.createStatement().executeQuery(query);
        
        
        while (result.next())
        {
            ReadStadiumDTO newDTO = new ReadStadiumDTO(result.getString(1), Integer.parseInt(result.getString(2)));            
            stadiums.add(newDTO);
        }
        
        return stadiums;
    }

    public ReadStadiumDTO getStadiumByTeam(ReadATeamDTO readATeamDTO) throws SQLException, ClassNotFoundException
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
        resultSet.next();
        readStadiumDTO = new ReadStadiumDTO(resultSet.getString(2), resultSet.getInt(3));

        resultSet.close();
        preparedFunction.close();
        return readStadiumDTO;
    }
}
