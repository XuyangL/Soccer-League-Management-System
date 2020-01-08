/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CoachRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author lixuy
 */
public class CoachOrganization extends Organization{

    public CoachOrganization() {
        super("Coach Organization");
    }

    @Override
    public Role getSupportedRole() {
        return new CoachRole();
    }

    
}
