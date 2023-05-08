package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.player.CreatePlayerDTO;
import cu.edu.cujae.structbd.dto.player.DeletePlayerDTO;
import cu.edu.cujae.structbd.dto.player.ReadAPlayerDTO;
import cu.edu.cujae.structbd.dto.player.ReadPlayerDTO;
import cu.edu.cujae.structbd.dto.player.UpdatePlayerDTO;
import cu.edu.cujae.structbd.dto.province.ReadProvinceDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayerServices
{
    public void createPlayer(CreatePlayerDTO createPlayerDTO)
    {

    }

    public void updatePlayer(UpdatePlayerDTO updatePlayerDTO)
    {

    }

    public void deletePlayer(DeletePlayerDTO deletePlayerDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call player_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, deletePlayerDTO.getID());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
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
            players_list.add(new ReadPlayerDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(4),
                                               resultSet.getString(3), resultSet.getString(5), resultSet.getInt(6)));
        }
        resultSet.close();
        preparedFunction.close();
        connection.close();
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
        preparedFunction.setString(2, readAPlayerDTO.getID());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        resultSet.next();
        readPlayerDTO = new ReadPlayerDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(4),
                                          resultSet.getString(3), resultSet.getString(5), resultSet.getInt(6));
        return readPlayerDTO;
    }
}
