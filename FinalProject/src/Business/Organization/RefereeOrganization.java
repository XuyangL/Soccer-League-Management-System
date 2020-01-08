/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author lixuy
 */
public class RefereeOrganization extends Organization{

    public RefereeOrganization() {
        super("Referee Organization");
    }

    @Override
    public Role getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
