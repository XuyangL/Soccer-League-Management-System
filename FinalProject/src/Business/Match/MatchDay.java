/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Match;

import Business.Club.Club;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lixuy
 */
public class MatchDay {
    
    private ArrayList<Match> matchList;

    public MatchDay() {
        matchList = new ArrayList<>();
    }

    public ArrayList<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(ArrayList<Match> matchList) {
        this.matchList = matchList;
    }  
    
    public void addMatch(Club club1, Club club2,Date time)
    {
     Match match = new Match(club1,club2,time);
     matchList.add(match);    
    }
}
