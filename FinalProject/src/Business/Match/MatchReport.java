/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Match;

import Business.Club.Club;
import Business.Personnel.Personnel;
import Business.Personnel.PersonnelDirectory;
import java.util.ArrayList;

/**
 *
 * @author lixuy
 */
public class MatchReport {
    
    private PersonnelDirectory club1BigPlayerDirectory;
    private PersonnelDirectory club2BigPlayerDirectory;
    
    private PersonnelDirectory club1PlayerMatchDirectory;
    private PersonnelDirectory club2PlayerMatchDirectory;   
    
    private Personnel club1Captain;
    private Personnel club2Captain;
    private Personnel club1Goalkeeper;
    private Personnel club2GoalKeeper;
    
    private String club1Formation;
    private String club2Formation;
    
    private String winner;
    private int club1Score;
    private int club2Score;
    
    private ArrayList<MatchEvent> scoreEvent;
    private ArrayList<MatchEvent> subEvent;
    private ArrayList<MatchEvent> yellowEvent;
    private ArrayList<MatchEvent> redEvent;
    
    
    
   // private int club1Goal;

    public MatchReport() {
        
        club1BigPlayerDirectory = new PersonnelDirectory();
        club2BigPlayerDirectory = new PersonnelDirectory();
        
        club1PlayerMatchDirectory = new PersonnelDirectory();
        club2PlayerMatchDirectory = new PersonnelDirectory(); 
        
        club1Captain = null;
        club2Captain = null;
        club1Goalkeeper = null;
        club2GoalKeeper = null;
        
        club1Formation="";
        club2Formation="";
        
        winner = null;
        club1Score = 0;
        club2Score = 0;
             
        scoreEvent = new ArrayList<>();
        subEvent = new ArrayList<>();
        yellowEvent = new ArrayList<>();
        redEvent = new ArrayList<>();
        
    }

    public PersonnelDirectory getClub1BigPlayerDirectory() {
        return club1BigPlayerDirectory;
    }

    public void setClub1BigPlayerDirectory(PersonnelDirectory club1BigPlayerDirectory) {
        this.club1BigPlayerDirectory = club1BigPlayerDirectory;
    }

    public PersonnelDirectory getClub2BigPlayerDirectory() {
        return club2BigPlayerDirectory;
    }

    public void setClub2BigPlayerDirectory(PersonnelDirectory club2BigPlayerDirectory) {
        this.club2BigPlayerDirectory = club2BigPlayerDirectory;
    }

    public PersonnelDirectory getClub1PlayerMatchDirectory() {
        return club1PlayerMatchDirectory;
    }

    public void setClub1PlayerMatchDirectory(PersonnelDirectory club1PlayerMatchDirectory) {
        this.club1PlayerMatchDirectory = club1PlayerMatchDirectory;
    }

    public PersonnelDirectory getClub2PlayerMatchDirectory() {
        return club2PlayerMatchDirectory;
    }

    public void setClub2PlayerMatchDirectory(PersonnelDirectory club2PlayerMatchDirectory) {
        this.club2PlayerMatchDirectory = club2PlayerMatchDirectory;
    }

    public Personnel getClub1Captain() {
        return club1Captain;
    }

    public void setClub1Captain(Personnel club1Captain) {
        this.club1Captain = club1Captain;
    }

    public Personnel getClub2Captain() {
        return club2Captain;
    }

    public void setClub2Captain(Personnel club2Captain) {
        this.club2Captain = club2Captain;
    }

    public Personnel getClub1Goalkeeper() {
        return club1Goalkeeper;
    }

    public void setClub1Goalkeeper(Personnel club1Goalkeeper) {
        this.club1Goalkeeper = club1Goalkeeper;
    }

    public Personnel getClub2GoalKeeper() {
        return club2GoalKeeper;
    }

    public void setClub2GoalKeeper(Personnel club2GoalKeeper) {
        this.club2GoalKeeper = club2GoalKeeper;
    }

    public String getClub1Formation() {
        return club1Formation;
    }

    public void setClub1Formation(String club1Formation) {
        this.club1Formation = club1Formation;
    }

    public String getClub2Formation() {
        return club2Formation;
    }

    public void setClub2Formation(String club2Formation) {
        this.club2Formation = club2Formation;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getClub1Score() {
        return club1Score;
    }

    public void setClub1Score(int club1Score) {
        this.club1Score = club1Score;
    }

    public int getClub2Score() {
        return club2Score;
    }

    public void setClub2Score(int club2Score) {
        this.club2Score = club2Score;
    }

    public ArrayList<MatchEvent> getScoreEvent() {
        return scoreEvent;
    }

    public void setScoreEvent(ArrayList<MatchEvent> scoreEvent) {
        this.scoreEvent = scoreEvent;
    }

    public ArrayList<MatchEvent> getSubEvent() {
        return subEvent;
    }

    public void setSubEvent(ArrayList<MatchEvent> subEvent) {
        this.subEvent = subEvent;
    }

    public ArrayList<MatchEvent> getYellowEvent() {
        return yellowEvent;
    }

    public void setYellowEvent(ArrayList<MatchEvent> yellowEvent) {
        this.yellowEvent = yellowEvent;
    }

    public ArrayList<MatchEvent> getRedEvent() {
        return redEvent;
    }

    public void setRedEvent(ArrayList<MatchEvent> redEvent) {
        this.redEvent = redEvent;
    }
    
}
