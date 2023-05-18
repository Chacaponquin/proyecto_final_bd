package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.game.CreateGameDTO;
import cu.edu.cujae.structbd.dto.game.DeleteGameDTO;
import cu.edu.cujae.structbd.dto.game.ReadAGameDTO;
import cu.edu.cujae.structbd.dto.game.ReadGameDTO;
import cu.edu.cujae.structbd.dto.game.UpdateGameDTO;
import cu.edu.cujae.structbd.dto.phase.ReadAPhaseDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;
import java.time.LocalDate;

public class GameServices {
    
    public void createGame(CreateGameDTO createGameDTO) throws SQLException, ClassNotFoundException{
        String function = "{call game_insert(?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, createGameDTO.getHcTeamID());
        preparedFunction.setInt(2, createGameDTO.getVisTeamID());
        preparedFunction.setInt(3, createGameDTO.getPhaseID());
        preparedFunction.setDate(4, java.sql.Date.valueOf(createGameDTO.getDate()));
        preparedFunction.setInt(5, createGameDTO.getRuns_home_club());
        preparedFunction.setInt(6, createGameDTO.getRuns_visitant());
        preparedFunction.setInt(7, createGameDTO.getWinner());
        preparedFunction.setInt(8, createGameDTO.getAudience());
        preparedFunction.execute();
        preparedFunction.close();
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
            games_list.add(new ReadGameDTO(resultSet.getInt(1), resultSet.getString(2),
                                           resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5).
                                           toLocalDate(), resultSet.getString(6), resultSet.getInt(7), resultSet.
                                           getInt(8), resultSet.
                                           getInt(9)));
        }
        resultSet.close();
        preparedFunction.close();

        return games_list;
    }
    
    public ReadGameDTO readGame(ReadAGameDTO readAGameDTO) throws SQLException, ClassNotFoundException{
        ReadGameDTO readGameDTO = null;
        String function = "{?= call game_load_by_id(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readAGameDTO.getId());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        resultSet.next();
        readGameDTO = new ReadGameDTO(resultSet.getInt(1), resultSet.getString(2),
                                      resultSet.getString(3), resultSet.getString(4), resultSet.getDate(1).toLocalDate(),
                                      resultSet.getString(6), resultSet.getInt(7), resultSet.
                                      getInt(8), resultSet.getInt(9));

        resultSet.close();
        preparedFunction.close();

        return readGameDTO;
    }
    
    public void updateGame(UpdateGameDTO updateGameDTO) throws SQLException, ClassNotFoundException{
        String function = "{call game_update(?,?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, updateGameDTO.getId());
        preparedFunction.setInt(2, updateGameDTO.getHcTeamID());
        preparedFunction.setInt(3, updateGameDTO.getVisTeamID());
        preparedFunction.setInt(4, updateGameDTO.getPhaseID());
        preparedFunction.setDate(5, java.sql.Date.valueOf(updateGameDTO.getDate())
        );
        preparedFunction.setInt(6, updateGameDTO.getRuns_home_club());
        preparedFunction.setInt(7, updateGameDTO.getRuns_visitant());
        preparedFunction.setInt(8, updateGameDTO.getWinner());
        preparedFunction.setInt(9, updateGameDTO.getAudience());
        preparedFunction.execute();
        preparedFunction.close();
    }
    
    public void deleteGame(DeleteGameDTO deleteGameDTO) throws SQLException, ClassNotFoundException{
        String function = "{call game_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, deleteGameDTO.getId());
        preparedFunction.execute();
        preparedFunction.close();
    }

    public List<ReadGameDTO> readAllGamesByPhase(ReadAPhaseDTO readAPhaseDTO) throws SQLException,
                                                                                     ClassNotFoundException
    {
        LinkedList<ReadGameDTO> games_list = new LinkedList<>();
        String function = "{?= call load_game_by_phase(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readAPhaseDTO.getPhase_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            //El null es porque no me hace falta la fase
            games_list.add(new ReadGameDTO(resultSet.getInt(1), resultSet.getString(2),
                                           resultSet.getString(3), null, resultSet.getDate(4).
                                           toLocalDate(), resultSet.getString(5), resultSet.getInt(6), resultSet.
                                           getInt(7), resultSet.
                                           getInt(8)));
        }
        resultSet.close();
        preparedFunction.close();
        return games_list;
    }
}

