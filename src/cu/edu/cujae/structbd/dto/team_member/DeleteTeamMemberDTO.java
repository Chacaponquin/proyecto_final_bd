package cu.edu.cujae.structbd.dto.team_member;

public class DeleteTeamMemberDTO {
    private int id;

    public DeleteTeamMemberDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
       this.id = id;
    }
}
