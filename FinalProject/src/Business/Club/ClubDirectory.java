/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Club;

import java.util.ArrayList;

/**
 *
 * @author lixuy
 */
public class ClubDirectory {
    
    private ArrayList<Club> clubList;

    public ClubDirectory() {
        
        clubList = new ArrayList<>();
    }

    public ArrayList<Club> getClubList() {
        return clubList;
    }

    public void setClubList(ArrayList<Club> clubList) {
        this.clubList = clubList;
    }

    public void addClub(String clubName, String clubAddress, String clubManagerName, String clubManagerAccountName, String clubManagerPassword) {
        Club club = new Club(clubName,clubAddress,clubManagerName, clubManagerAccountName, clubManagerPassword);
        clubList.add(club);
    }
    
}
