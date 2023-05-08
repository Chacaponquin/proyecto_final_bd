package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.game.CreateGameDTO;
import cu.edu.cujae.structbd.dto.game.DeleteGameDTO;
import cu.edu.cujae.structbd.dto.game.ReadAGameDTO;
import cu.edu.cujae.structbd.dto.game.ReadGameDTO;
import cu.edu.cujae.structbd.dto.game.UpdateGameDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;

public class GameServices {
    
    public void createGame(CreateGameDTO createGameDTO) throws SQLException, ClassNotFoundException{
        String function = "{call game_insert(?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, createGameDTO.getId());
        preparedFunction.setString(2, createGameDTO.getHcTeamID());
        preparedFunction.setString(3, createGameDTO.getVisTeamID());
        preparedFunction.setString(4, createGameDTO.getPhaseID());
        preparedFunction.setDate(5, (Date) createGameDTO.getDate());
        preparedFunction.setString(6, createGameDTO.getWinner());
        preparedFunction.setInt(7, createGameDTO.getAudience());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    
    public List<ReadGameDTO> readAllGames() throws SQLException, ClassNotFoundException{
        LinkedList<ReadGameDTO> games_list = new LinkedList<>();
        String function = "{?= call game_load_all()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            games_list.add(new ReadGameDTO(resultSet.getString(1), resultSet.getString(2), 
                    resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), 
                    resultSet.getString(6), resultSet.getInt(7)));
        }
        resultSet.close();
        preparedFunction.close();
        connection.close();
        return games_list;
    }
    
    public ReadGameDTO readGame(ReadAGameDTO readAGameDTO) throws SQLException, ClassNotFoundException{
        ReadGameDTO readGameDTO = null;
        String function = "{?= call game_load_by_id(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setString(2, readAGameDTO.getId());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        resultSet.next();
        readGameDTO = new ReadGameDTO(resultSet.getString(1), resultSet.getString(2), 
                    resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), 
                    resultSet.getString(6), resultSet.getInt(7));
        resultSet.close();
        preparedFunction.close();
        connection.close();
        return readGameDTO;
    }
    
    public void updateGame(UpdateGameDTO updateGameDTO) throws SQLException, ClassNotFoundException{
        String function = "{call game_update(?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, updateGameDTO.getId());
        preparedFunction.setString(2, updateGameDTO.getHcTeamID());
        preparedFunction.setString(3, updateGameDTO.getVisTeamID());
        preparedFunction.setString(4, updateGameDTO.getPhaseID());
        preparedFunction.setDate(5, (Date) updateGameDTO.getDate());
        preparedFunction.setString(6, updateGameDTO.getWinner());
        preparedFunction.setInt(7, updateGameDTO.getAudience());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
    
    public void deleteGame(DeleteGameDTO deleteGameDTO) throws SQLException, ClassNotFoundException{
        String function = "{call game_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, deleteGameDTO.getId());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }
}

