package cu.edu.cujae.structbd.services;

import cu.edu.cujae.structbd.dto.position.CreatePositionDTO;
import cu.edu.cujae.structbd.dto.position.DeletePositionDTO;
import cu.edu.cujae.structbd.dto.position.ReadPositionDTO;
import cu.edu.cujae.structbd.dto.position.UpdatePositionDTO;
import cu.edu.cujae.structbd.utils.Connector;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.List;


public class PositionServices {
    
    public void createPosition(CreatePositionDTO createPositionDTO) throws SQLException, ClassNotFoundException{
        String function = "{?= call public.position_insert(?, ?)}";
        CallableStatement pf = Connector.getConnection().prepareCall(function);
        pf.setString(2, createPositionDTO.getPositionName());
        pf.execute();
    }
    
    public void deletePosition(DeletePositionDTO deletePositionDTO){
        
    }
    
    public void updatePosition(UpdatePositionDTO updatePositionDTO){
        
    }
    
    public ReadPositionDTO readPosition(DeletePositionDTO deletePositionDTO){
        
        return null;
    }
    
    public List<ReadPositionDTO> readAllPositions(){
        
        return null;
    }
            
}
