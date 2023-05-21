package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.coach.CreateCoachDTO;
import cu.edu.cujae.structbd.dto.coach.DeleteCoachDTO;
import cu.edu.cujae.structbd.dto.coach.ReadACoachDTO;
import cu.edu.cujae.structbd.dto.coach.ReadCoachDTO;
import cu.edu.cujae.structbd.dto.coach.UpdateCoachDTO;
import cu.edu.cujae.structbd.dto.team.ReadTeamDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CoachServices
{

    public void createCoach(CreateCoachDTO createCoachDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call coach_insert(?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, createCoachDTO.getTeam_member_name());
        preparedFunction.setInt(2, createCoachDTO.getMember_number());
        preparedFunction.setInt(3, createCoachDTO.getTeam_ID());
        preparedFunction.setInt(4, createCoachDTO.getExperience_years());
        preparedFunction.execute();
        preparedFunction.close();
        connection.commit();
    }

    public void updateCoach(UpdateCoachDTO updateCoachDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call coach_update(?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, updateCoachDTO.getTeam_member_ID());
        preparedFunction.setString(2, updateCoachDTO.getTeam_member_name());
        preparedFunction.setInt(3, updateCoachDTO.getTeam_id());
        preparedFunction.setInt(4, updateCoachDTO.getMember_number());
        preparedFunction.setInt(5, updateCoachDTO.getExperience_years());
        preparedFunction.setInt(6, updateCoachDTO.getYears_in_team());
        preparedFunction.execute();
        preparedFunction.close();
        connection.commit();
    }

    public void deleteCoach(DeleteCoachDTO deleteCoachDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call coach_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, deleteCoachDTO.getTeam_member_ID());
        preparedFunction.execute();
        preparedFunction.close();
        connection.commit();
    }

    public List<ReadCoachDTO> readAllCoaches() throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadCoachDTO> coaches_list = new LinkedList<>();
        String function = "{?= call coach_load()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            coaches_list.add(new ReadCoachDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(4),
                                              resultSet.getString(3), resultSet.getInt(5), resultSet.getInt(6)));
        }
        resultSet.close();
        preparedFunction.close();
        
        return coaches_list;
    }

    public ReadCoachDTO readACoach(ReadACoachDTO readACoachDTO) throws SQLException, ClassNotFoundException
    {
        ReadCoachDTO readCoachDTO = null;
        String function = "{?= call coach_load_by_id(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readACoachDTO.getTeam_member_ID());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        resultSet.next();
        readCoachDTO = new ReadCoachDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(4),
                                        resultSet.getString(3), resultSet.getInt(5), resultSet.getInt(6));
        preparedFunction.close();
        return readCoachDTO;
    }

    public List<ReadTeamDTO> getPosiblesTeamsToInsert() throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadTeamDTO> list = new LinkedList<>();
        String function = "{?= call load_teams_to_insert_coach()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            list.add(new ReadTeamDTO(resultSet.getInt(1), resultSet.getString(2), 0, 0, null, null, null, null));
        }
        resultSet.close();
        preparedFunction.close();
        return list;
    }
}
