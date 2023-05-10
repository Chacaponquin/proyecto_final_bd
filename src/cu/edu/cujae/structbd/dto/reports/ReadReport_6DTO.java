package cu.edu.cujae.structbd.dto.reports;

public class ReadReport_6DTO {
    private String phaseName;
    private int played;
    private int won;
    private int lost;
    private int wonAsHC;
    private int lostAsHC;
    private int wonAsVis;
    private int lostAsVis;

    public ReadReport_6DTO(String phaseName, int played, int won, int lost, int wonAsHC, 
            int lostAsHC, int wonAsVis, int lostAsVis) {
        this.played = played;
        this.phaseName = phaseName;
        this.won = won;
        this.lost = lost;
        this.wonAsHC = wonAsHC;
        this.lostAsHC = lostAsHC;
        this.wonAsVis = wonAsVis;
        this.lostAsVis = lostAsVis;
    }

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }
    
    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getWonAsHC() {
        return wonAsHC;
    }

    public void setWonAsHC(int wonAsHC) {
        this.wonAsHC = wonAsHC;
    }

    public int getLostAsHC() {
        return lostAsHC;
    }

    public void setLostAsHC(int lostAsHC) {
        this.lostAsHC = lostAsHC;
    }

    public int getWonAsVis() {
        return wonAsVis;
    }

    public void setWonAsVis(int wonAsVis) {
        this.wonAsVis = wonAsVis;
    }

    public int getLostAsVis() {
        return lostAsVis;
    }

    public void setLostAsVis(int lostAsVis) {
        this.lostAsVis = lostAsVis;
    }
}
