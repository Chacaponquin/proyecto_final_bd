package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.team.ReadTeamDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class TeamServices {
    public ArrayList<ReadTeamDTO> readTeams() throws SQLException, ClassNotFoundException{
        ArrayList<ReadTeamDTO> teams = new ArrayList<>();
        
        String function = "{?= call team_read()}";
        java.sql.Connection connection = Connector.getConnection();
        
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        
        while (resultSet.next())
        {
            int team_id = resultSet.getInt("team_id");
            String team_name = resultSet.getString("team_name");
            int played_championships = resultSet.getInt("played_championships");
            int won_championships = resultSet.getInt("won_championships");
            String color = resultSet.getString("color");
            String province = resultSet.getString("province_name");
            String pet = resultSet.getString("pet");
            String stadium = resultSet.getString("stadium_name");
            
            teams.add(new ReadTeamDTO(team_id, team_name, played_championships,won_championships, color, province, pet, stadium));
        }
        
        resultSet.close();
        preparedFunction.close();
        
        return teams;
        
    }
}
