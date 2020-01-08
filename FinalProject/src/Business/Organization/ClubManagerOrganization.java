/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ClubManagerRole;
import Business.Role.Role;

/**
 *
 * @author lixuy
 */
public class ClubManagerOrganization extends Organization{

    ClubManagerOrganization() {
        super("Club Manager Organization");
       
    }
    @Override
    public Role getSupportedRole() {
        return new ClubManagerRole();
    }

}
