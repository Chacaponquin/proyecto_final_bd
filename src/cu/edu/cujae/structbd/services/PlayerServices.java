package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.player.DeletePlayerDTO;
import cu.edu.cujae.structbd.dto.player.ReadAPlayerDTO;
import cu.edu.cujae.structbd.dto.player.ReadPlayerDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PlayerServices
{
    public void deletePlayer(DeletePlayerDTO deletePlayerDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call player_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, deletePlayerDTO.getID());
        preparedFunction.execute();
    }

    public List<ReadPlayerDTO> readAllPlayer() throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadPlayerDTO> players_list = new LinkedList<>();
        String function = "{?= call player_load()}";
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
            String position_name = resultSet.getString("position_name");
            int years_in_team = resultSet.getInt("years_in_team");
            
            players_list.add(new ReadPlayerDTO(team_member_ID, team_member_name,member_number, team_name, position_name, years_in_team));
        }
        resultSet.close();
        preparedFunction.close();
        return players_list;
    }

    public ReadPlayerDTO readAPlayer(ReadAPlayerDTO readAPlayerDTO) throws SQLException, ClassNotFoundException
    {
        ReadPlayerDTO readPlayerDTO = null;
        String function = "{?= call player_load_by_id(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readAPlayerDTO.getID());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        resultSet.next();
        readPlayerDTO = new ReadPlayerDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(4),
                                          resultSet.getString(3), resultSet.getString(5), resultSet.getInt(6));
        preparedFunction.close();
        return readPlayerDTO;
    }
}
