package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.batter.ReadBatterDTO;
import cu.edu.cujae.structbd.dto.coach.ReadCoachDTO;
import cu.edu.cujae.structbd.dto.pitcher.ReadPitcherDTO;
import cu.edu.cujae.structbd.dto.player.ReadPlayerDTO;
import cu.edu.cujae.structbd.dto.team.FindTeamDTO;
import cu.edu.cujae.structbd.dto.team.ReadTeamDTO;
import cu.edu.cujae.structbd.dto.team_member.ReadTeamMemberDTO;
import cu.edu.cujae.structbd.utils.Connector;
import cu.edu.cujae.structbd.utils.TEAM_LIMITS;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class TeamServices {
    public ArrayList<ReadTeamDTO> readTeams() throws SQLException, ClassNotFoundException{
        ArrayList<ReadTeamDTO> teams = new ArrayList<>();
        
        String function = "{?= call team_read()}";
        java.sql.Connection connection = Connector.getConnection();
        
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        
        while (resultSet.next())
        {
            int team_id = resultSet.getInt("team_id");
            String team_name = resultSet.getString("team_name");
            int played_championships = resultSet.getInt("played_championships");
            int won_championships = resultSet.getInt("won_championships");
            String color = resultSet.getString("color");
            String province = resultSet.getString("province_name");
            String pet = resultSet.getString("pet");
            String stadium = resultSet.getString("stadium_name");
            
            teams.add(new ReadTeamDTO(team_id, team_name, played_championships,won_championships, color, province, pet, stadium));
        }
        
        resultSet.close();
        preparedFunction.close();
        
        return teams;
        
    }
    
    public List<ReadTeamMemberDTO> readMembersFromTeam(ReadTeamDTO team) throws SQLException, ClassNotFoundException{
        LinkedList<ReadTeamMemberDTO> members = new LinkedList<>();
        
        String function = "{?= call members_by_team(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, team.getTeam_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        
        while (resultSet.next())
        {
            String name = resultSet.getString("member_name");
            int number = resultSet.getInt("member_number");
            int yearsInTeam = resultSet.getInt("years_in_team");
            int id = resultSet.getInt("member_id");
            String team_name = resultSet.getString("team_name");
            String type = resultSet.getString("member_type");
            
            members.add(new ReadTeamMemberDTO(name, number, yearsInTeam, id, team_name, type));
        }
        
        resultSet.close();
        preparedFunction.close();
        
        return members;
    }
    
    public List<ReadPlayerDTO> readPlayerFromTeam(ReadTeamDTO team) throws SQLException, ClassNotFoundException{
        LinkedList<ReadPlayerDTO> players_list = new LinkedList<>();
        
        String function = "{?= call players_by_team(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, team.getTeam_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            int team_member_ID = resultSet.getInt("member_id");
            String team_member_name = resultSet.getString("member_name");
            int member_number = resultSet.getInt("member_number");
            String team_name = team.getTeam_name();
            String position_name = resultSet.getString("position_name");
            int years_in_team = resultSet.getInt("years_in_team");
            
            players_list.add(new ReadPlayerDTO(team_member_ID, team_member_name,member_number, team_name, position_name, years_in_team));
        }
        resultSet.close();
        preparedFunction.close();
        
        return players_list;
    }
    
    public List<ReadCoachDTO> readCoachsFromTeam(ReadTeamDTO team) throws SQLException, ClassNotFoundException{
        LinkedList<ReadCoachDTO> players_list = new LinkedList<>();
        
        String function = "{?= call coachs_by_team(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, team.getTeam_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            int team_member_ID = resultSet.getInt("member_id");
            String team_member_name = resultSet.getString("member_name");
            int member_number = resultSet.getInt("member_number");
            String team_name = team.getTeam_name();
            int experience_years = resultSet.getInt("experience_year");
            int years_in_team = resultSet.getInt("years_in_team");
            
            players_list.add(new ReadCoachDTO(team_member_ID, team_member_name, member_number, team_name, experience_years, years_in_team));
        }
        resultSet.close();
        preparedFunction.close();
        
        return players_list;
    }
    
    public List<ReadPitcherDTO> readPitchersFromTeam(ReadTeamDTO team) throws SQLException, ClassNotFoundException{
        LinkedList<ReadPitcherDTO> players_list = new LinkedList<>();
        
        String function = "{?= call pitchers_by_team(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, team.getTeam_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {
            int team_member_ID = resultSet.getInt("member_id");
            String team_member_name = resultSet.getString("member_name");
            int member_number = resultSet.getInt("member_number");
            String team_name = team.getTeam_name();
            int years_in_team = resultSet.getInt("years_in_team");
            int inningsPitched = resultSet.getInt("innings_pitched");
            int runsAllowed = resultSet.getInt("runs_allowed");
            int teamID = resultSet.getInt("team_id");
            
            players_list.add(new ReadPitcherDTO(team_member_ID, team_member_name, member_number, team_name, years_in_team, inningsPitched, runsAllowed, teamID));
        }
        resultSet.close();
        preparedFunction.close();
        
        return players_list;
    }
    
    public List<ReadBatterDTO> readBatterFromTeam(ReadTeamDTO team) throws SQLException, ClassNotFoundException{
        LinkedList<ReadBatterDTO> players_list = new LinkedList<>();
        
        String function = "{?= call batters_by_team(?)}";
        java.sql.Connection connection = Connector.getConnection();
        connection.setAutoCommit(false);
        CallableStatement preparedFunction = connection.prepareCall(function);
        preparedFunction.registerOutParameter(1, java.sql.Types.REF_CURSOR);
        preparedFunction.setInt(2, team.getTeam_id());
        preparedFunction.execute();
        ResultSet resultSet = (ResultSet) preparedFunction.getObject(1);
        while (resultSet.next())
        {   
            int member_id = resultSet.getInt("member_id");
            String name = resultSet.getString("member_name");
            String team_name = team.getTeam_name();
            int yearsInTeam = resultSet.getInt("years_in_team");
            int member_number = resultSet.getInt("member_number");
            String position = resultSet.getString("position_name");
            int atBats = resultSet.getInt("at_bats");
            int totalHits = resultSet.getInt("total_hits");
            
            players_list.add(new ReadBatterDTO(member_id, name, team_name, yearsInTeam, member_number, position, atBats, totalHits));
        }
        resultSet.close();
        preparedFunction.close();
        
        return players_list;
    }
    
    public List<ReadTeamDTO> getTeamsForInsertPitcher() throws SQLException, ClassNotFoundException{
        List<ReadTeamDTO> allTeams = this.readTeams();
        List<ReadPitcherDTO> allPichers = ServicesLocator.PitcherServices.readAllPitchers();
        
        List<ReadTeamDTO> returnTeams = new LinkedList<>();
        for(ReadTeamDTO t: allTeams){
            int contPitchers = 0;
            
            for(ReadPitcherDTO p: allPichers){
                if(p.getTeam().equals(t.getTeam_name())){
                    contPitchers++;
                }
            }
            
            if(contPitchers < TEAM_LIMITS.PLAYER.getMaximun()){
                returnTeams.add(t);
            }
        }
        
        return returnTeams;
    }
    
    public ReadTeamDTO findTeamByID(FindTeamDTO team) throws SQLException, ClassNotFoundException{
        ReadTeamDTO foundTeam = null;
        List<ReadTeamDTO> allTeams = this.readTeams();
        
        for(int i = 0; i < allTeams.size() && foundTeam == null; i++){
            if(allTeams.get(i).getTeam_id() == team.getTeam_id()){
                foundTeam = allTeams.get(i);
            }
        }
        
        return foundTeam;
    }
}
