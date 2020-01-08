/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author lixuy
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Organization.Type type, String name){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.ClubManagerOrganization.getValue()))
        {
            organization = new ClubManagerOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Organization.Type.CoachOrganization.getValue()))
        {
            organization = new CoachOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Organization.Type.PlayerOrganization.getValue()))
        {
            organization = new PlayerOrganization(name);
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Organization.Type.SoccerAssociation.getValue()))
        {
            organization = new SoccerAssociationOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Organization.Type.RefereeOrganization.getValue()))
        {
            organization = new RefereeOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
}
