package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.phase.CreatePhaseDTO;
import cu.edu.cujae.structbd.dto.phase.ReadAPhaseDTO;
import cu.edu.cujae.structbd.dto.phase.ReadPhaseDTO;
import cu.edu.cujae.structbd.dto.phase.UpdatePhaseDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PhaseServices
{

    public void createPhase(CreatePhaseDTO createPhaseDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call phase_insert(?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, createPhaseDTO.getPhase_id());
        preparedFunction.setString(2, createPhaseDTO.getPhase_name());
        preparedFunction.setDate(3, (Date) createPhaseDTO.getStart_date());
        preparedFunction.setDate(4, (Date) createPhaseDTO.getFinish_date());
        preparedFunction.setInt(5, createPhaseDTO.getTeams_amount());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }

    public void updatePhase(UpdatePhaseDTO updatePhaseDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call phase_update(?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, updatePhaseDTO.getPhase_id());
        preparedFunction.setString(2, updatePhaseDTO.getPhase_name());
        preparedFunction.setDate(3, (Date) updatePhaseDTO.getStart_date());
        preparedFunction.setDate(4, (Date) updatePhaseDTO.getFinish_date());
        preparedFunction.setInt(5, updatePhaseDTO.getTeams_amount());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
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
            phase_list.add(new ReadPhaseDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3),
                                            resultSet.
                                                getDate(4), resultSet.getInt(5)));
        }
        resultSet.close();
        preparedFunction.close();
        connection.close();
        return phase_list;
    }

    public ReadPhaseDTO readAPhase(ReadAPhaseDTO readAPhaseDTO) throws SQLException, ClassNotFoundException
    {
        ReadPhaseDTO readPhaseDTO = null;
        String function = "{?= call phase_load_by_id(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setString(2, readAPhaseDTO.getPhase_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        resultSet.next();
        readPhaseDTO = new ReadPhaseDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3),
                                        resultSet.getDate(4), resultSet.getInt(5));
        
        resultSet.close();
        preparedFunction.close();
        connection.close();
        return readPhaseDTO;
    }
}
