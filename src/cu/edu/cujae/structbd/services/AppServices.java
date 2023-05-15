/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.services;

<<<<<<< HEAD
import cu.edu.cujae.structbd.dto.phase.ReadAPhaseDTO;
import cu.edu.cujae.structbd.dto.province.ReadProvinceDTO;
=======
import cu.edu.cujae.structbd.dto.reports.ReadReport_1DTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_2DTO;
>>>>>>> 56d321e75e2835f3a9e797bcec56038f96e2d062
import cu.edu.cujae.structbd.dto.reports.ReadReport_4DTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_5DTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_6DTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_7DTO;
import cu.edu.cujae.structbd.dto.snb.TeamPositionDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jose
 */
public class AppServices
{
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
            list.add(new ReadReport_4DTO(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
        }
        resultSet.close();
        preparedFunction.close();

        return list;
    }

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
        
        return list;
    }
    
    public List<ReadReport_6DTO> getTeamStatus(String team_id) throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadReport_6DTO> list = new LinkedList<>();
        String function = "{?= call report_team_status(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setString(2, team_id);
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
        return list;
    }
    
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
        return list;
    }
<<<<<<< HEAD

    //Obtener la tabla de posiciones de una fase
    public List<TeamPositionDTO> getPositionsTablebyPhase(ReadAPhaseDTO readAPhaseDTO) throws SQLException,
                                                                                              ClassNotFoundException
    {
        LinkedList<TeamPositionDTO> list = new LinkedList<>();
        String function = "{?= call positions_table_by_phase(?)}";
=======
    
    public List<ReadReport_1DTO> getPositionTable() throws SQLException, ClassNotFoundException{
        LinkedList<ReadReport_1DTO> list = new LinkedList<>();
        
        String function = "{?= call report_position_table()}";
>>>>>>> 56d321e75e2835f3a9e797bcec56038f96e2d062
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
<<<<<<< HEAD
        preparedFunction.setString(2, readAPhaseDTO.getPhase_id());
=======
>>>>>>> 56d321e75e2835f3a9e797bcec56038f96e2d062
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
<<<<<<< HEAD
            list.add(new TeamPositionDTO(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.
                                         getInt(4), resultSet.getInt(5)));
        }
        resultSet.close();
        preparedFunction.close();
=======
            list.add(new ReadReport_1DTO(resultSet.getString("team_name"), resultSet.getInt("points"), 0, 0));
        }
        resultSet.close();
        preparedFunction.close();
        
        return list;
    }
    
    public List<ReadReport_2DTO> getGamesByTeams(String firstTeamID, String secondTeamID) throws SQLException, ClassNotFoundException{
        LinkedList<ReadReport_2DTO> list = new LinkedList<>();
        
        if(firstTeamID != null && secondTeamID != null){
            String function = "{?= call report_games_by_teams(?,?)}";
            java.sql.Connection connection = Connector.getConnection();
            connection.setAutoCommit(false);
            CallableStatement preparedFunction = connection.prepareCall(function);
            preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
            
            preparedFunction.setString(2, firstTeamID);
            preparedFunction.setString(3, secondTeamID);
            preparedFunction.execute();
            
            ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
            while (resultSet.next())
            {
                String phaseName = resultSet.getString("phase_name");
                LocalDate date = resultSet.getDate("game_date").toLocalDate();
                String winner = resultSet.getString("team_winner_name");
                int audience = resultSet.getInt("total_audience");
                int runs_home_club = resultSet.getInt("runs_home_club");
                int runs_visitant = resultSet.getInt("runs_visitant");
                String stadiumName = resultSet.getString("stadium_name");
                
                list.add(new ReadReport_2DTO(phaseName, date, winner, audience, runs_home_club, runs_visitant, stadiumName));
            }
            resultSet.close();
            preparedFunction.close();
        }
        
>>>>>>> 56d321e75e2835f3a9e797bcec56038f96e2d062
        return list;
    }
}
