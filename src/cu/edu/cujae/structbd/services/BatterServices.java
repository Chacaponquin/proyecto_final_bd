package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.batter.CreateBatterDTO;
import cu.edu.cujae.structbd.dto.batter.DeleteBatterDTO;
import cu.edu.cujae.structbd.dto.batter.ReadBatterDTO;
import cu.edu.cujae.structbd.dto.batter.UpdateBatterDTO;
import cu.edu.cujae.structbd.dto.team_member.ReadTeamMemberDTO;
import cu.edu.cujae.structbd.exceptions.team_member.DuplicateMemberNumberException;
import cu.edu.cujae.structbd.exceptions.team_member.EmptyMemberNameException;
import cu.edu.cujae.structbd.exceptions.team_member.WrongMemberNumberException;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BatterServices {
    public List<ReadBatterDTO> readBatters() throws SQLException, ClassNotFoundException{
        ArrayList<ReadBatterDTO> batters = new ArrayList<>();
        
        String query = "SELECT * FROM batter JOIN player ON player.member_id = batter.member_id JOIN teammember ON teammember.member_id = batter.member_id JOIN position ON player.position_id = position.position_id JOIN team ON team.team_id = teammember.team_id";
        
        java.sql.Connection connection = Connector.getConnection();

	ResultSet result = connection.createStatement().executeQuery(query);
        
        
        while (result.next())
        {
            int id = result.getInt("member_id");
            String name = result.getString("member_name");
            String equipo = result.getString("team_name");
            int yearsInTeam = result.getInt("years_in_team");
            int number = result.getInt("member_number");
            String position = result.getString("position_name");
            int atBats = result.getInt("at_bats");
            int totalHits = result.getInt("total_hits");
            int teamID = result.getInt("team_id");
            int positionID = result.getInt("position_id");
            
            ReadBatterDTO newDTO = new ReadBatterDTO(id, name, equipo, yearsInTeam, number, position, atBats, totalHits, teamID, positionID);            
            batters.add(newDTO);
        }
        
        result.close();
        
        return batters;
    }
    
    public void createBatter(CreateBatterDTO newBatter) throws EmptyMemberNameException, WrongMemberNumberException, SQLException, ClassNotFoundException, DuplicateMemberNumberException{
        ServicesLocator.TeamMemberServices.validateMemberName(newBatter.getName());
        ServicesLocator.TeamMemberServices.validateMemberNumber(newBatter.getMemberNumber(), newBatter.getTeamID());
        
        String function = "{call batter_insert(?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setString(1, newBatter.getName());
        preparedFunction.setInt(2, newBatter.getMemberNumber());
        preparedFunction.setInt(3, newBatter.getTeamID());
        preparedFunction.setInt(4,0);
        preparedFunction.setInt(5, newBatter.getPositionID());
        preparedFunction.setInt(6, 0);
        preparedFunction.setInt(7, 0);
        preparedFunction.execute();
        preparedFunction.close();
        
        connection.commit();
    }
    
    public void deleteBatter(DeleteBatterDTO deletePitcherDTO) throws SQLException, ClassNotFoundException{
        String function = "{call batter_delete(?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, deletePitcherDTO.getBatterID());
        preparedFunction.execute();
        preparedFunction.close();
    }
    
    public void updateBatter(UpdateBatterDTO newBatter) throws EmptyMemberNameException, SQLException, ClassNotFoundException, DuplicateMemberNumberException{
        ServicesLocator.TeamMemberServices.validateMemberName(newBatter.getBatterName());
        
        ReadTeamMemberDTO foundMemberWithNumber = ServicesLocator.TeamMemberServices.findMemberWithNumber(newBatter.getNumber(), newBatter.getTeamID());
        if(foundMemberWithNumber != null && foundMemberWithNumber.getId() != newBatter.getMember_id()){
            throw new DuplicateMemberNumberException();
        }
        
        String function = "{call batter_update(?,?,?,?,?,?,?,?)}";
        java.sql.Connection connection = Connector.getConnection();
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.setInt(1, newBatter.getMember_id());
        preparedFunction.setString(2, newBatter.getBatterName());
        preparedFunction.setInt(3, newBatter.getNumber());
        preparedFunction.setInt(4, newBatter.getYearsInTeam());
        preparedFunction.setInt(5, newBatter.getTeamID());
        preparedFunction.setInt(6, newBatter.getPositionID());
        preparedFunction.setInt(7, newBatter.getAtBats());
        preparedFunction.setInt(8, newBatter.getTotalHits());
        preparedFunction.execute();
        preparedFunction.close();
        
        connection.commit();
    }
}
