/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.League;

import Business.Club.Club;
import Business.Club.ClubDirectory;
import Business.Match.LeagueStatistics;
import Business.Match.MatchDayDirectory;
import java.util.ArrayList;

/**
 *
 * @author lixuy
 */
public class League {
    private int leagueID;
    private String leagueName;
    private String rank;
    private ClubDirectory clubDirectory;
    private MatchDayDirectory matchDayDirectory;
    private LeagueStatistics leagueStatistics;
    
    public static int count = 0;

    public League(String leagueName, String rank) {
        this.leagueID = ++count;
        this.leagueName = leagueName;
        this.rank = rank;
        clubDirectory = new ClubDirectory();
        matchDayDirectory = new MatchDayDirectory();
        leagueStatistics = new LeagueStatistics();
    }
    
    public void initLeagueStatistics()
    {
      ArrayList<String> clubStatistics = leagueStatistics.getClubStatistics();
      for(Club club:clubDirectory.getClubList())
      {
       String log = club.getClubName() + " 0 0 0 0 0 0 0";
       clubStatistics.add(log);
      }
    }

    public int getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(int leagueID) {
        this.leagueID = leagueID;
    }
    
    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public ClubDirectory getClubDirectory() {
        return clubDirectory;
    }

    public void setClubDirectory(ClubDirectory clubDirectory) {
        this.clubDirectory = clubDirectory;
    }

    public MatchDayDirectory getMatchDayDirectory() {
        return matchDayDirectory;
    }

    public void setMatchDayDirectory(MatchDayDirectory matchDayDirectory) {
        this.matchDayDirectory = matchDayDirectory;
    }

    public LeagueStatistics getLeagueStatistics() {
        return leagueStatistics;
    }

    public void setLeagueStatistics(LeagueStatistics leagueStatistics) {
        this.leagueStatistics = leagueStatistics;
    }
    
    @Override
    public String toString()
    {
        return leagueName;
    }
}
