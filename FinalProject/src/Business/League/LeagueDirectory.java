/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.League;

import java.util.ArrayList;

/**
 *
 * @author lixuy
 */
public class LeagueDirectory {
    private ArrayList<League> leagueList;

    public LeagueDirectory() {
        
        leagueList = new ArrayList<>();
    }

    
    public ArrayList<League> getLeagueList() {
        return leagueList;
    }

    public void setLeagueList(ArrayList<League> leagueList) {
        this.leagueList = leagueList;
    }
    
    public void addLeague(String leagueName, String rank)
    {
     League league = new League(leagueName,rank);
     leagueList.add(league);
    }
    
}
