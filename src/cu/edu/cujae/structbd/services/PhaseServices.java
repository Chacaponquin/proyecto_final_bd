package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.phase.CreatePhaseDTO;
import cu.edu.cujae.structbd.dto.phase.DeletePhaseDTO;
import cu.edu.cujae.structbd.dto.phase.ReadAPhaseDTO;
import cu.edu.cujae.structbd.dto.phase.ReadPhaseDTO;
import cu.edu.cujae.structbd.dto.phase.UpdatePhaseDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
public class PhaseServices
{

    public void createPhase(CreatePhaseDTO createPhaseDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call phase_insert(?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        System.out.println(createPhaseDTO.getPhase_name());
        preparedFunction.setString(1, createPhaseDTO.getPhase_name());
        preparedFunction.setDate(2, java.sql.Date.valueOf(createPhaseDTO.getStart_date()));
        preparedFunction.setDate(3, java.sql.Date.valueOf(createPhaseDTO.getFinish_date()));
        preparedFunction.setInt(4, createPhaseDTO.getTeams_amount());
        preparedFunction.execute();
        preparedFunction.close();
        connection.commit();
    }

    public void updatePhase(UpdatePhaseDTO updatePhaseDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call phase_update(?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, updatePhaseDTO.getPhase_id());
        preparedFunction.setString(2, updatePhaseDTO.getPhase_name());
        preparedFunction.setDate(3, java.sql.Date.valueOf(updatePhaseDTO.getStart_date()));
        preparedFunction.setDate(4, java.sql.Date.valueOf(updatePhaseDTO.getFinish_date()));
        preparedFunction.setInt(5, updatePhaseDTO.getTeams_amount());
        preparedFunction.setBoolean(6, updatePhaseDTO.getIs_active());
        preparedFunction.execute();
        preparedFunction.close();
        connection.commit();
    }

    public List<ReadPhaseDTO> readAllPhase() throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadPhaseDTO> phase_list = new LinkedList<>();
        String function = "{?= call phase_load()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            phase_list.add(new ReadPhaseDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3).
                                            toLocalDate(),
                                            resultSet.
                                                getDate(4).toLocalDate(), resultSet.getInt(5), resultSet.getBoolean(6)));
        }
        resultSet.close();
        preparedFunction.close();
        return phase_list;
    }

    public ReadPhaseDTO readAPhase(ReadAPhaseDTO readAPhaseDTO) throws SQLException, ClassNotFoundException
    {
        ReadPhaseDTO readPhaseDTO = null;
        String function = "{?= call phase_load_by_id(?)}";
        System.out.println(readAPhaseDTO.getPhase_id());
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, readAPhaseDTO.getPhase_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            readPhaseDTO = new ReadPhaseDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3).
                                            toLocalDate(),
                                        resultSet.getDate(4).toLocalDate(), resultSet.getInt(5), resultSet.getBoolean(6));
        }
        resultSet.close();
        preparedFunction.close();

        return readPhaseDTO;
    }

    public void deletePhase(DeletePhaseDTO deletePhaseDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call phase_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, deletePhaseDTO.getPhase_id());
        preparedFunction.execute();
        preparedFunction.close();
        connection.commit();
    }

    public List<ReadPhaseDTO> readActivePhase() throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadPhaseDTO> phase_list = new LinkedList<>();
        String function = "{?= call actives_phases()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            phase_list.add(new ReadPhaseDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3).
                                            toLocalDate(),
                                            resultSet.
                                                getDate(4).toLocalDate(), resultSet.getInt(5), resultSet.getBoolean(6)));
        }
        resultSet.close();
        preparedFunction.close();

        return phase_list;
    }

    public void closePhase(int phase_id) throws SQLException, ClassNotFoundException
    {
        String function = "{call close_phase(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, phase_id);
        preparedFunction.execute();
        preparedFunction.close();
        connection.commit();
    }
}
