/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Club;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Personnel.Personnel;
import Business.Role.ClubManagerRole;

/**
 *
 * @author lixuy
 */
public class Club {   
    
    private int clubID;
    private String clubName;
    private String address;
    public static int count = 0;
    
    private OrganizationDirectory organizationDirectory;

    public Club(String clubName, String address, String clubManagerName, String clubManagerAccountName, String clubManagerPassword) {
        this.clubName = clubName;
        this.address = address;
        clubID = ++count;
        
        organizationDirectory = new OrganizationDirectory();
        organizationDirectory.createOrganization(Organization.Type.ClubManagerOrganization,null);
        organizationDirectory.createOrganization(Organization.Type.CoachOrganization,null);
        organizationDirectory.createOrganization(Organization.Type.PlayerOrganization,"First Team");
        
        for(Organization origanization: organizationDirectory.getOrganizationList())
        {
         if (origanization.getName().equals("Club Manager Organization"))
         {
           Personnel personnel = origanization.getPersonnelDirectory().createPersonel(clubManagerName);
           origanization.getUserAccountDirectory().createUserAccount(clubManagerAccountName, clubManagerPassword, personnel, new ClubManagerRole());
         }
        }
    }

    public int getClubID() {
        return clubID;
    }

    public void setClubID(int clubID) {
        this.clubID = clubID;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    } 
    
    @Override
    public String toString()
    {
     return clubName;
    
    }
}
