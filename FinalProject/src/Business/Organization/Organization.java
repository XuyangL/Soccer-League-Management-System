/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Personnel.PersonnelDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author lixuy
 */

    public abstract class Organization {

    private int organizationID;
    private String name;
    private PersonnelDirectory personnelDirectory;
    private UserAccountDirectory userAccountDirectory;
   
    public static int count = 0;
    
    public enum Type{
        SoccerAssociation("Soccer Association"),RefereeOrganization("Referee Organization"), ClubManagerOrganization("Club Manager Organization"), 
        CoachOrganization("Coach Organization"), PlayerOrganization("Soccer Player Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        
        personnelDirectory = new PersonnelDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = ++count;
    }

    /**
     *
     * @return
     */
    public abstract Role getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public PersonnelDirectory getPersonnelDirectory() {
        return personnelDirectory;
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
