/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Match;

import Business.Organization.Organization;
import Business.Organization.PlayerOrganization;
import Business.Personnel.Personnel;
import Business.Personnel.PersonnelDirectory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author lixuy
 */
public class LeagueStatistics {
    
    private ArrayList<String> clubStatistics;
    private HashMap<Personnel,Integer> scoreStatistics;
    private HashMap<Personnel,Integer> ownGoalStatistics;
    private HashMap<Personnel,Integer> assistStatistics;
    private HashMap<Personnel,Integer> yellowStatistics;
    private HashMap<Personnel,Integer> redStatistics;
    
    private PersonnelDirectory problemPlayer;

    public LeagueStatistics() {
        clubStatistics = new ArrayList<>();
        scoreStatistics = new HashMap();
        ownGoalStatistics = new HashMap();
        assistStatistics = new HashMap();
        yellowStatistics = new HashMap();
        redStatistics = new HashMap();
        problemPlayer = new PersonnelDirectory();      
    }
    
    public void addToStatistics(Match match){
        
        //clear the problem players for both clubs of the match
        for(Personnel p1 : problemPlayer.getPersonnelList())
        {
         int flag = 0;
         for(Organization o1:match.getClub1().getOrganizationDirectory().getOrganizationList())
         {
          if(o1 instanceof PlayerOrganization)
          {
           for(Personnel p2:o1.getPersonnelDirectory().getPersonnelList())
           {
             if(p1 == p2)
             {
               problemPlayer.getPersonnelList().remove(p1);
               flag = 1;
               break;
             }
           }
           
           if(flag == 1)
              break;
          }
         }
        
         if(flag == 0)
         {
             for(Organization o2:match.getClub2().getOrganizationDirectory().getOrganizationList())
             {
               if(o2 instanceof PlayerOrganization)
               {
                for(Personnel p3:o2.getPersonnelDirectory().getPersonnelList())
                {
                 if(p1 == p3)
                 {
                 problemPlayer.getPersonnelList().remove(p1);
                 flag = 1;
                 break;
                 }
                }
                 if(flag == 1)
                   break;
               }     
             }    
         }    
       }
        
        String club1String = null;
        String club2String = null;
        
        String club1Final = null;
        String club2Final = null;
        
        for(String s:clubStatistics)
        {
         if(s.contains(match.getClub1().getClubName()))
              club1String = s;
         if(s.contains(match.getClub2().getClubName()))
              club2String = s;
        }
        
        clubStatistics.remove(club1String);
        clubStatistics.remove(club2String);
        
        String[] club1log = club1String.split(" ");
        String[] club2log = club2String.split(" ");
        
        club1Final = club1log[0] + " ";
        club2Final = club2log[0] + " ";
        
        club1Final += String.valueOf(Integer.parseInt(club1log[1]) +  1) + " ";
        club2Final += String.valueOf(Integer.parseInt(club2log[1]) +  1) + " ";
        
        if(match.getMatchReport().getWinner().equals("Draw"))
        {
         club1Final += club1log[2] + " " + String.valueOf(Integer.valueOf(club1log[3]) +  1) + " " + club1log[4] + " ";
         club2Final += club2log[2] + " " + String.valueOf(Integer.valueOf(club2log[3]) +  1) + " " + club2log[4] + " ";
        }
        else
        {
            if(match.getMatchReport().getWinner().equals(match.getClub1().getClubName()))
            {
             club1Final += String.valueOf(Integer.valueOf(club1log[2]) +  1) + " " + club1log[3] + " " + club1log[4] + " ";
             club2Final += club2log[2] + " " + club2log[3] + " " + String.valueOf(Integer.valueOf(club2log[4]) +  1) + " ";
            }
            else
            {
             club1Final += club1log[2] + " " + club1log[3] + " " + String.valueOf(Integer.valueOf(club1log[4]) +  1) + " ";    
             club2Final += String.valueOf(Integer.valueOf(club2log[2]) +  1) + " " + club2log[3] + " " + club2log[4] + " ";          
            }     
        }  
        
        club1Final += String.valueOf(Integer.valueOf(club1log[5]) + match.getMatchReport().getClub1Score()) + " ";
        club1Final += String.valueOf(Integer.valueOf(club1log[6]) + match.getMatchReport().getClub2Score()) + " ";
        
        club2Final += String.valueOf(Integer.valueOf(club2log[5]) + match.getMatchReport().getClub2Score()) + " ";
        club2Final += String.valueOf(Integer.valueOf(club2log[6]) + match.getMatchReport().getClub1Score()) + " ";
        
        String[] temp1 = club1Final.split(" ");
        String[] temp2 = club2Final.split(" ");
        
        club1Final += String.valueOf(Integer.valueOf(temp1[2]) * 3 + Integer.valueOf(temp1[3]));
        club2Final += String.valueOf(Integer.valueOf(temp2[2]) * 3 + Integer.valueOf(temp2[3]));
        
        clubStatistics.add(club1Final);
        clubStatistics.add(club2Final);
        clubStatisticsSort();
        
        
        for(MatchEvent matchEvent:match.getMatchReport().getScoreEvent())
        {
         if(matchEvent.getType().equals("Goal")|| matchEvent.getType().equals("Penalty"))
         {
           int scores = 0;
           if(scoreStatistics.containsKey(matchEvent.getPlayer1()))
             scores = scoreStatistics.get(matchEvent.getPlayer1());
           scores++;
           scoreStatistics.put(matchEvent.getPlayer1(), scores);
         }
         
         if(matchEvent.getType().equals("Owngoal"))
         {
          int scores = 0;
           if(ownGoalStatistics.containsKey(matchEvent.getPlayer1()))
             scores = ownGoalStatistics.get(matchEvent.getPlayer1());
           scores++;
           ownGoalStatistics.put(matchEvent.getPlayer1(), scores);
         
         }
         if(matchEvent.getPlayer2()!= null)
         {
             int assist = 0;
             if(assistStatistics.containsKey(matchEvent.getPlayer2()))
                 assist = assistStatistics.get(matchEvent.getPlayer2());
             assist++;
             assistStatistics.put(matchEvent.getPlayer2(), assist); 
         }
        }
        
        for(MatchEvent matchEvent:match.getMatchReport().getYellowEvent())
        {
         int yellow = 0;
         if(yellowStatistics.containsKey(matchEvent.getPlayer1()))
             yellow = yellowStatistics.get(matchEvent.getPlayer1());
         yellow++;
         yellowStatistics.put(matchEvent.getPlayer1(),yellow);
         
        }
        
        for(MatchEvent matchEvent:match.getMatchReport().getRedEvent())
        {
         int red = 0;
         if(redStatistics.containsKey(matchEvent.getPlayer1()))
             red = redStatistics.get(matchEvent.getPlayer1());
         red++;
         redStatistics.put(matchEvent.getPlayer1(),red);
         problemPlayer.getPersonnelList().add(matchEvent.getPlayer1());      //*****
        }
    }
    
    public ArrayList<String> getClubStatistics() {
        return clubStatistics;
    }

    public void setClubStatistics(ArrayList<String> clubStatistics) {
        this.clubStatistics = clubStatistics;
    }

    public HashMap<Personnel, Integer> getScoreStatistics() {
        return scoreStatistics;
    }

    public void setScoreStatistics(HashMap<Personnel, Integer> scoreStatistics) {
        this.scoreStatistics = scoreStatistics;
    }

    public HashMap<Personnel, Integer> getAssistStatistics() {
        return assistStatistics;
    }

    public void setAssistStatistics(HashMap<Personnel, Integer> assistStatistics) {
        this.assistStatistics = assistStatistics;
    }

    public HashMap<Personnel, Integer> getYellowStatistics() {
        return yellowStatistics;
    }

    public void setYellowStatistics(HashMap<Personnel, Integer> yellowStatistics) {
        this.yellowStatistics = yellowStatistics;
    }

    public HashMap<Personnel, Integer> getRedStatistics() {
        return redStatistics;
    }

    public void setRedStatistics(HashMap<Personnel, Integer> redStatistics) {
        this.redStatistics = redStatistics;
    }

    public PersonnelDirectory getProblemPlayer() {
        return problemPlayer;
    }

    public void setProblemPlayer(PersonnelDirectory problemPlayer) {
        this.problemPlayer = problemPlayer;
    }  

    public HashMap<Personnel, Integer> getOwnGoalStatistics() {
        return ownGoalStatistics;
    }

    public void setOwnGoalStatistics(HashMap<Personnel, Integer> ownGoalStatistics) {
        this.ownGoalStatistics = ownGoalStatistics;
    }

    private void clubStatisticsSort() {
        
         Collections.sort(clubStatistics, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int number1 = 0;
                int number2 = 0;
                String[] temp1 = s1.split(" ");
                String[] temp2 = s2.split(" ");
                
                number1 = Integer.valueOf(temp1[7])*1000 + Integer.valueOf(temp1[5]) + Integer.valueOf(temp1[6]);
                number2 = Integer.valueOf(temp2[7])*1000 + Integer.valueOf(temp2[5]) + Integer.valueOf(temp2[6]);
                return number2 - number1;
            }
        });
    }


}
