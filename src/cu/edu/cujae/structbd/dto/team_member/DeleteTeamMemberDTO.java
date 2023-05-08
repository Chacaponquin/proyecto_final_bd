package cu.edu.cujae.structbd.dto.team_member;

public class DeleteTeamMemberDTO {
    private String id;

    public DeleteTeamMemberDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id != null){
            this.id = id;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
