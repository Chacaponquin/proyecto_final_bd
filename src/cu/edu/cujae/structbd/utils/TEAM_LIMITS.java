/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cu.edu.cujae.structbd.utils;

/**
 *
 * @author Hector Angel Gomez
 */
public enum TEAM_LIMITS {
    BATTER(18, 20),
    PITCHER(10, 12),
    PLAYER(28, 32),
    COACH(5, 6),
    MEMBER(33, 38);
    
    private final int minimun;
    private final int maximun;
    
    private TEAM_LIMITS(int minimun, int maximun){
        this.minimun = minimun;
        this.maximun = maximun;
    }

    public int getMinimun() {
        return minimun;
    }

    public int getMaximun() {
        return maximun;
    }
}
