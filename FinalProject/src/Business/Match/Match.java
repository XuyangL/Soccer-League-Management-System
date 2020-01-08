/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Match;

import Business.Club.Club;
import Business.Personnel.Personnel;
import java.util.Date;

/**
 *
 * @author lixuy
 */
public class Match {
    
    private int matchID;
    private Club club1;
    private Club club2;
    private Date time;
    private Personnel referee;
    
    private MatchReport matchReport;
    
    private boolean refereeAssigned;
    private boolean club1PlayerBigListProvided;
    private boolean club2PlayerBigListProvided;
    private boolean club1PlayerMatchListProvided;
    private boolean club2PlayerMatchListProvided;
    private boolean matchReportProvided;

    public static int count = 0;

    public Match(Club club1, Club club2,Date time) {
        
        matchID = ++count;
        this.club1 = club1;
        this.club2 = club2;
        this.time = time;
        referee = null;  
        
        matchReport = new MatchReport();
        
        refereeAssigned = false;
        club1PlayerBigListProvided = false;
        club2PlayerBigListProvided = false;
        club1PlayerMatchListProvided = false;
        club2PlayerMatchListProvided = false;
        matchReportProvided = false;
        
    }

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public Club getClub1() {
        return club1;
    }

    public void setClub1(Club club1) {
        this.club1 = club1;
    }

    public Club getClub2() {
        return club2;
    }

    public void setClub2(Club club2) {
        this.club2 = club2;
    }

    public Personnel getReferee() {
        return referee;
    }

    public void setReferee(Personnel referee) {
        this.referee = referee;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public MatchReport getMatchReport() {
        return matchReport;
    }

    public void setMatchReport(MatchReport matchReport) {
        this.matchReport = matchReport;
    }

    public boolean isRefereeAssigned() {
        return refereeAssigned;
    }

    public void setRefereeAssigned(boolean refereeAssigned) {
        this.refereeAssigned = refereeAssigned;
    }

    public boolean isClub1PlayerBigListProvided() {
        return club1PlayerBigListProvided;
    }

    public void setClub1PlayerBigListProvided(boolean club1PlayerBigListProvided) {
        this.club1PlayerBigListProvided = club1PlayerBigListProvided;
    }

    public boolean isClub2PlayerBigListProvided() {
        return club2PlayerBigListProvided;
    }

    public void setClub2PlayerBigListProvided(boolean club2PlayerBigListProvided) {
        this.club2PlayerBigListProvided = club2PlayerBigListProvided;
    }

    public boolean isClub1PlayerMatchListProvided() {
        return club1PlayerMatchListProvided;
    }

    public void setClub1PlayerMatchListProvided(boolean club1PlayerMatchListProvided) {
        this.club1PlayerMatchListProvided = club1PlayerMatchListProvided;
    }

    public boolean isClub2PlayerMatchListProvided() {
        return club2PlayerMatchListProvided;
    }

    public void setClub2PlayerMatchListProvided(boolean club2PlayerMatchListProvided) {
        this.club2PlayerMatchListProvided = club2PlayerMatchListProvided;
    }

    public boolean isMatchReportProvided() {
        return matchReportProvided;
    }

    public void setMatchReportProvided(boolean matchReportProvided) {
        this.matchReportProvided = matchReportProvided;
    }
    
    @Override
    public String toString(){  
        return Integer.toString(matchID);
    }  
}
