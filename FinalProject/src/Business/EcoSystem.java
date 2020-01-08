/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Club.Club;
import Business.Club.ClubDirectory;
import Business.League.LeagueDirectory;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Personnel.Personnel;
import Business.Role.SoccerAssociationRole;
import Business.UserAccount.UserAccountDirectory;

/**
 *
 * @author lixuy
 */
public class EcoSystem {

    private static EcoSystem business;
    private ClubDirectory clubDirectory;
    private LeagueDirectory leagueDirectory;
    private OrganizationDirectory organizationDirectory;
    private IDGenerator idg;
    private UserAccountDirectory freePlayerPool;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        leagueDirectory = new LeagueDirectory();
        clubDirectory = new ClubDirectory();
        organizationDirectory = new OrganizationDirectory();
        freePlayerPool = new UserAccountDirectory();
        organizationDirectory.createOrganization(Organization.Type.SoccerAssociation, null);
        organizationDirectory.createOrganization(Organization.Type.RefereeOrganization, null);
        idg = new IDGenerator();
//delete below when run database
        for (Organization organization : organizationDirectory.getOrganizationList()) {
            if (organization.getName().equals("Soccer Association")) {
                Personnel personnel2 = organization.getPersonnelDirectory().createPersonel("keyboardman");
                organization.getUserAccountDirectory().createUserAccount("keyboardman", "keyboardman", personnel2, new SoccerAssociationRole());

                Personnel personnel = organization.getPersonnelDirectory().createPersonel("soccer association");
                organization.getUserAccountDirectory().createUserAccount("soc", "soc", personnel, new SoccerAssociationRole());

            }
        }
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public ClubDirectory getClubDirectory() {
        return clubDirectory;
    }

    public void setClubDirectory(ClubDirectory clubDirectory) {
        this.clubDirectory = clubDirectory;
    }

    public LeagueDirectory getLeagueDirectory() {
        return leagueDirectory;
    }

    public void setLeagueDirectory(LeagueDirectory leagueDirectory) {
        this.leagueDirectory = leagueDirectory;
    }

    public boolean isFeasible(String newUserName) {
        //Step1: Check in the soccer assocication and Referee
        for (Organization organization : organizationDirectory.getOrganizationList()) {
            if (!organization.getUserAccountDirectory().checkIfUsernameIsUnique(newUserName)) {
                return false;
            }
        }
        //Step 2: Go inside each club and check each organization
        for (Club club : clubDirectory.getClubList()) {
            for (Organization organization : club.getOrganizationDirectory().getOrganizationList()) {
                if (!organization.getUserAccountDirectory().checkIfUsernameIsUnique(newUserName)) {
                    return false;
                }
            }
        }
        return true;
    }

    public UserAccountDirectory getFreePlayerPool() {
        return freePlayerPool;
    }

    public void setFreePlayerPool(UserAccountDirectory freePlayerPool) {
        this.freePlayerPool = freePlayerPool;
    }

    public IDGenerator getIdg() {
        return idg;
    }

    public void setIdg(IDGenerator idg) {
        this.idg = idg;
    }
    
    
}
