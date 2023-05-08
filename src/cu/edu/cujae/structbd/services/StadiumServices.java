package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.stadium.ReadStadiumDTO;
import cu.edu.cujae.structbd.utils.Connector;
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
        
        result.close();
        connection.close();
        
        return stadiums;
    }
}
