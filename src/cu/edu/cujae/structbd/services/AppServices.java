/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.game.ReadGameDTO;
import cu.edu.cujae.structbd.dto.phase.ReadAPhaseDTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_1DTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_2DTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_4DTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_5DTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_6DTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_7DTO;
import cu.edu.cujae.structbd.dto.snb.TeamPositionDTO;
import cu.edu.cujae.structbd.dto.team.FindTeamDTO;
import cu.edu.cujae.structbd.dto.team.ReadTeamDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class AppServices

{

    /**
     * Retorna una lista con los 3 entrenadores de más experiencia de cada equipo, agrupados por equipos.
     *
     * @return List<>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<ReadReport_4DTO> getMore_experiences_coaches() throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadReport_4DTO> list = new LinkedList<>();
        String function = "{?= call more_experiences_coaches()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            list.add(new ReadReport_4DTO(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(4), resultSet.
                                         getInt(3)));
        }
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return list;
    }

    /**
     * La función getHighest_audience() permite obtener un listado con el promedio de las audiencias de cada estadio
     * ordenado de forma descendente.
     *
     * @return List<>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<ReadReport_5DTO> getHighest_audience() throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadReport_5DTO> list = new LinkedList<>();
        String function = "{?= call highest_audience()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            list.add(new ReadReport_5DTO(resultSet.getString(1), resultSet.getFloat(2)));
        }
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return list;
    }

    /**
     * La función getTeamStatus(int team_id) permite obtener el estado de un equipo dado su identificador, se mostrará
     * por cada fase la cantidad de juegos jugados en total, la cantidad de victorias y derrotas y estos datos también
     * para cuando ha sido local o visitante
     *
     * @param team_id
     * @return List<>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<ReadReport_6DTO> getTeamStatus(int team_id) throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadReport_6DTO> list = new LinkedList<>();
        String function = "{?= call report_team_status(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, team_id);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            list.add(new ReadReport_6DTO(resultSet.getString(1), resultSet.getInt(2),
                                         resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5),
                                         resultSet.getInt(6), resultSet.getInt(7), resultSet.getInt(8))
            );
        }
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return list;
    }

    /**
     * La función getAllStarTeam() permite obtener el equipo todos estrellas de la temporada. Se obtiene el mejor
     * jugador de cada posición, en el caso de los jugadores de posición son los de mayor average y en el caso de los
     * pitcher son los de menor promedio de carreras limpias.
     *
     * @return List<>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<ReadReport_7DTO> getAllStarTeam() throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadReport_7DTO> list = new LinkedList<>();
        String function = "{?= call report_all_star_team()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            list.add(new ReadReport_7DTO(resultSet.getString(1), resultSet.getString(2),
                                         resultSet.getString(3), resultSet.getFloat(4)));
        }
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return list;
    }

    /**
     * La función getPositionsTablebyPhase(ReadAPhaseDTO readAPhaseDTO) permite obtener la tabla de posiciones
     * actualizada de una fase en particular. Se muestra la cantidad de juegos jugados, la cantidad de juegos ganados y
     * perdidos y la cantidad de puntos de cada equipo. Los equipos se encuentran ordenados de forma descendente según
     * su puntuación.
     *
     * @param readAPhaseDTO
     * @return List<>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<TeamPositionDTO> getPositionsTablebyPhase(ReadAPhaseDTO readAPhaseDTO) throws SQLException,
                                                                                              ClassNotFoundException
    {
        LinkedList<TeamPositionDTO> list = new LinkedList<>();
        String function = "{?= call positions_table_by_phase(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readAPhaseDTO.getPhase_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            list.add(new TeamPositionDTO(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.
                                         getInt(4), resultSet.getInt(5)));
        }
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return list;
    }

    /**
     * La función getPositionTable() permite obtener la tabla de posiciones de la serie mostrando cada equipo, su
     * posición y la cantidad de puntos de cada uno, obtenidos por cada juego ganado. Los equipos se encuentran
     * ordenados de forma descendente según su puntuación.
     *
     * @return List<>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<ReadReport_1DTO> getPositionTable() throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadReport_1DTO> list = new LinkedList<>();
        String function = "{?= call report_position_table()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            list.add(new ReadReport_1DTO(resultSet.getString("team_name"), resultSet.getInt("points"), 0, 0));
        }
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return list;
    }

    /**
     * La función getGamesByTeams(int firstTeamID, int secondTeamID) permite obtener la información de todos los juegos
     * entre los equipos pasados por parámetro.
     *
     * @param firstTeamID
     * @param secondTeamID
     * @return List<>
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<ReadReport_2DTO> getGamesByTeams(int firstTeamID, Integer secondTeamID) throws SQLException,
                                                                                           ClassNotFoundException
    {
        LinkedList<ReadReport_2DTO> list = new LinkedList<>();

        if (firstTeamID != -1 && secondTeamID != -1)
        {
            String function = "{?= call report_games_by_teams(?,?)}";
            java.sql.Connection connection = Connector.getConnection();
            connection.setAutoCommit(false);
            CallableStatement preparedFunction = connection.prepareCall(function);
            preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);

            preparedFunction.setInt(2, firstTeamID);
            preparedFunction.setInt(3, secondTeamID);
            preparedFunction.execute();

            ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
            while (resultSet.next())
            {
                String phaseName = resultSet.getString("phase_name");
                LocalDate date = resultSet.getDate("game_date").toLocalDate();
                String winner = resultSet.getString("winner_name");
                int audience = resultSet.getInt("total_audience");
                int runs_home_club = resultSet.getInt("runs_home_club");
                int runs_visitant = resultSet.getInt("runs_visitant");
                String stadiumName = resultSet.getString("stadium_name");
                
                ReadReport_2DTO rep = new ReadReport_2DTO(phaseName, date, winner, audience, runs_home_club, runs_visitant, stadiumName);
                list.add(rep);
            }
            
            resultSet.close();
            preparedFunction.close();
            connection.commit();
        }
        
        return list;
    }
    
    public List<ReadGameDTO> getGamesByDateAndStadium(Date date, Integer stadiumID) throws SQLException, ClassNotFoundException{
        List<ReadGameDTO> games = new LinkedList<>();
        
        
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        
        CallableStatement preparedFunction;
        if(stadiumID != null){
            String function = "{?= call report_games_by_date_stadium(?,?)}";
            preparedFunction = connection.prepareCall(function);
            preparedFunction.setInt(2, stadiumID);
             preparedFunction.setDate(3, date);
        }else {
            String function = "{?= call report_games_by_date(?)}";
            preparedFunction = connection.prepareCall(function);
            preparedFunction.setDate(2, date);
        }
        
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();

        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            int id = resultSet.getInt("game_id");
            String hcTeamName = resultSet.getString("home_club_name");
            String visTeamName = resultSet.getString("visitant_name");
            String phaseName = resultSet.getString("phase_name");
            LocalDate game_date = resultSet.getDate("game_date").toLocalDate();
            String winner = resultSet.getString("winner_name");
            int audience = resultSet.getInt("total_audience");
            int runs_home_club = resultSet.getInt("runs_home_club");
            int runs_visitant = resultSet.getInt("runs_visitant");
            
            ReadGameDTO game = new ReadGameDTO(id, hcTeamName, visTeamName, phaseName, game_date, winner, audience, runs_home_club, runs_visitant);
            games.add(game);

        }

        resultSet.close();
        preparedFunction.close();
        connection.commit();
        
        return games;
    }

    /**
     * La función getTeamsInPhase(ReadAPhaseDTO readAPhaseDTO) permite obtener los equipos activos en una fase. Se
     * consideran equipos activos aquellos que clasificaron a dicha fase y que no hayan jugados todos sus
     * correspondientes a dicha fase
     *
     * @param readAPhaseDTO
     * @return List<>
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<ReadTeamDTO> getTeamsInPhase(ReadAPhaseDTO readAPhaseDTO) throws ClassNotFoundException, SQLException
    {
        LinkedList<ReadTeamDTO> list = new LinkedList<>();
        String function = "{?= call teams_in_phase(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readAPhaseDTO.getPhase_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            list.add(new ReadTeamDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), 0, null, null,
                                     null, null));
        }
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return list;
    }

    /**
     * La función getTeamsPosibleRivals(ReadAPhaseDTO readAPhaseDTO, FindTeamDTO readATeamDTO) permite obtener los
     * posibles rivales de un equipo en un juego de una fase. Se consideran posibles rivales, aquellos equipos
     * clasificados a dicha fase con los que aun no haya jugado. Se recibe como parámetros el equipo y la fase.
     *
     * @param readAPhaseDTO
     * @param readATeamDTO
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public List<ReadTeamDTO> getTeamsPosibleRivals(ReadAPhaseDTO readAPhaseDTO, FindTeamDTO readATeamDTO) throws
        ClassNotFoundException, SQLException
    {
        LinkedList<ReadTeamDTO> list = new LinkedList<>();
        String function = "{?= call teams_posible_rivals(?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readAPhaseDTO.getPhase_id());
        preparedFunction.setInt(3, readATeamDTO.getTeam_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            list.add(new ReadTeamDTO(resultSet.getInt(1), resultSet.getString(2), 0, 0, null, null, null, null));
        }
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return list;
    }

    /**
     * La función getWinner() permite obtener el equipo ganador de la serie. Es ganador aquel equipo que tiene más
     * puntos al finalizar la serie.
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ReadReport_1DTO getWinner() throws SQLException, ClassNotFoundException
    {
        ReadReport_1DTO readReport_1DTO = null;
        String function = "{?= call team_winner()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        if (resultSet.next())
        {
            readReport_1DTO = new ReadReport_1DTO(resultSet.getString(1), 0, 0, 0);
        }
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return readReport_1DTO;
    }

    public int getCountGamesInPhase(ReadAPhaseDTO readAPhaseDTO) throws SQLException, ClassNotFoundException
    {
        int result = -1;
        String function = "{?= call count_games_in_phase(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readAPhaseDTO.getPhase_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        if (resultSet.next())
        {
            result = resultSet.getInt(1);
        }
        resultSet.close();
        preparedFunction.close();
        connection.commit();
        return result;
    }
}
