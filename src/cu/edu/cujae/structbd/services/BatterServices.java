package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.batter.ReadBatterDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BatterServices {
    public ArrayList<ReadBatterDTO> readBatters() throws SQLException, ClassNotFoundException{
        ArrayList<ReadBatterDTO> batters = new ArrayList<>();
        
        String query = "SELECT * FROM batter JOIN player ON player.member_id = batter.member_id JOIN teammember ON teammember.member_id = batter.member_id JOIN position ON player.position_id = position.position_id JOIN team ON team.team_id = teammember.team_id";
        
        java.sql.Connection connection = Connector.getConnection();

	ResultSet result = connection.createStatement().executeQuery(query);
        
        
        while (result.next())
        {
            int id = result.getInt("member_id");
            String name = result.getString("member_name");
            String equipo = result.getString("team_name");
            int yearsInTeam = result.getInt("years_in_team");
            int number = result.getInt("member_number");
            String position = result.getString("position_name");
            int atBats = result.getInt("at_bats");
            int totalHits = result.getInt("total_hits");
            
            ReadBatterDTO newDTO = new ReadBatterDTO(id, name, equipo, yearsInTeam, number, position, atBats, totalHits);            
            batters.add(newDTO);
        }
        
        result.close();
        
        return batters;
    }
}
