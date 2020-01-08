/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Match;

import Business.Personnel.Personnel;

/**
 *
 * @author lixuy
 */
public class MatchEvent {
    
    private Personnel player1;
    private Personnel player2;
    private int time;
    private String type;

    public MatchEvent(Personnel player1, Personnel player2, int time, String type) {
        this.player1 = player1;
        this.player2 = player2;
        this.time = time;
        this.type = type;
    }
    
    
    public Personnel getPlayer1() {
        return player1;
    }

    public void setPlayer1(Personnel player1) {
        this.player1 = player1;
    }

    public Personnel getPlayer2() {
        return player2;
    }

    public void setPlayer2(Personnel player2) {
        this.player2 = player2;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }   
}
