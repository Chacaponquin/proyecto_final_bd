package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.phase.CreatePhaseDTO;
import cu.edu.cujae.structbd.dto.phase.DeletePhaseDTO;
import cu.edu.cujae.structbd.dto.phase.ReadAPhaseDTO;
import cu.edu.cujae.structbd.dto.phase.ReadPhaseDTO;
import cu.edu.cujae.structbd.dto.phase.UpdatePhaseDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhaseServices
{

    public void createPhase(CreatePhaseDTO createPhaseDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call phase_insert(?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, createPhaseDTO.getPhase_id());
        preparedFunction.setString(2, createPhaseDTO.getPhase_name());
        preparedFunction.setDate(3, java.sql.Date.valueOf(createPhaseDTO.getStart_date()));
        preparedFunction.setDate(4, java.sql.Date.valueOf(createPhaseDTO.getFinish_date()));
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
        preparedFunction.setDate(3, java.sql.Date.valueOf(updatePhaseDTO.getStart_date()));
        preparedFunction.setDate(4, java.sql.Date.valueOf(updatePhaseDTO.getFinish_date()));
        preparedFunction.setInt(5, updatePhaseDTO.getTeams_amount());
        preparedFunction.execute();
        preparedFunction.close();
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
            phase_list.add(new ReadPhaseDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3).
                                            toLocalDate(),
                                            resultSet.
                                                getDate(4).toLocalDate(), resultSet.getInt(5)));
        }
        resultSet.close();
        preparedFunction.close();
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
        readPhaseDTO = new ReadPhaseDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3).
                                        toLocalDate(),
                                        resultSet.getDate(4).toLocalDate(), resultSet.getInt(5));
        
        resultSet.close();
        preparedFunction.close();
        return readPhaseDTO;
    }

    public void deletePhase(DeletePhaseDTO deletePhaseDTO) throws SQLException, ClassNotFoundException
    {
        System.out.println(deletePhaseDTO.getPhase_id());
        String function = "{call phase_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, deletePhaseDTO.getPhase_id());
        preparedFunction.execute();
        preparedFunction.close();
    }

    public static void main(String args[])
    {
        DeletePhaseDTO df = new DeletePhaseDTO("3da4016e-1603-1603-bc49-ae82ea8cd7c5");
        PhaseServices ps = new PhaseServices();
        try
        {
            ps.deletePhase(df);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(PhaseServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(PhaseServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
