package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.province.CreateProvinceDTO;
import cu.edu.cujae.structbd.dto.province.DeleteProvinceDTO;
import cu.edu.cujae.structbd.dto.province.ReadAProvinceDTO;
import cu.edu.cujae.structbd.dto.province.ReadProvinceDTO;
import cu.edu.cujae.structbd.dto.province.UpdateProvinceDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProvinceServices
{

    public void createProvince(CreateProvinceDTO createProvinceDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call province_insert(?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, createProvinceDTO.getID());
        preparedFunction.setString(2, createProvinceDTO.getName());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();

    }

    public void updateProvince(UpdateProvinceDTO updateProvinceDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call province_update(?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, updateProvinceDTO.getID());
        preparedFunction.setString(2, updateProvinceDTO.getName());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }

    public void deleteProvince(DeleteProvinceDTO deleteProvinceDTO) throws SQLException, ClassNotFoundException
    {
        String function = "{call province_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, deleteProvinceDTO.getID());
        preparedFunction.execute();
        preparedFunction.close();
        connection.close();
    }

    public List<ReadProvinceDTO> readAllProvince() throws SQLException, ClassNotFoundException
    {
        LinkedList<ReadProvinceDTO> provinces_list = new LinkedList<>();
        String function = "{?= call province_load()}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            provinces_list.add(new ReadProvinceDTO(resultSet.getString(1), resultSet.getString(2)));
        }
        resultSet.close();
        preparedFunction.close();
        connection.close();
        return provinces_list;
    }

    public ReadProvinceDTO readAProvince(ReadAProvinceDTO readAProvinceDTO) throws SQLException, ClassNotFoundException
    {        
        ReadProvinceDTO readProvinceDTO = null;
        String function = "{?= call province_load_by_id(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setString(2, readAProvinceDTO.getID());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        resultSet.next();
        readProvinceDTO = new ReadProvinceDTO(resultSet.getString(1), resultSet.getString(2));
        resultSet.close();
        preparedFunction.close();
        connection.close();
        return readProvinceDTO;
    }
}
