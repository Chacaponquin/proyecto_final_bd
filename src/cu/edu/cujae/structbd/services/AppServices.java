/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.province.ReadProvinceDTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_4DTO;
import cu.edu.cujae.structbd.dto.reports.ReadReport_5DTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
