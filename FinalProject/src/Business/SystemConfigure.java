/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Organization.Organization;
import Business.Personnel.Personnel;
import Business.Role.SoccerAssociationRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author lixuy
 */
public class SystemConfigure {

    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();

        for (Organization organization : system.getOrganizationDirectory().getOrganizationList()) {
            if (organization.getName().equals("Soccer Association")) {
                Personnel personnel2 = organization.getPersonnelDirectory().createPersonel("keyboardman");
                organization.getUserAccountDirectory().createUserAccount("keyboardman", "keyboardman", personnel2, new SoccerAssociationRole());

                Personnel personnel = organization.getPersonnelDirectory().createPersonel("soccer association");
                organization.getUserAccountDirectory().createUserAccount("soc", "soc", personnel, new SoccerAssociationRole());
            }
        }
        return system;
    }

}
