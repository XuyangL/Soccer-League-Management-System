/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Match;

import java.util.ArrayList;

/**
 *
 * @author lixuy
 */
public class MatchDayDirectory {
    private ArrayList<MatchDay> matchDayList;

    public MatchDayDirectory() {
        matchDayList = new ArrayList<>();
    }

    public ArrayList<MatchDay> getMatchDayList() {
        return matchDayList;
    }

    public void setMatchDayList(ArrayList<MatchDay> matchDayList) {
        this.matchDayList = matchDayList;
    }
    
    public MatchDay addMatchDay()
    {
      MatchDay matchDay = new MatchDay();
      matchDayList.add(matchDay);
      return matchDay;  
    }
}
