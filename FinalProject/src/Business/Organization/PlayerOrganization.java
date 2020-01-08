/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PlayerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author lixuy
 */
public class PlayerOrganization extends  Organization{

    
    public PlayerOrganization(String name) {
        super(name);
    }

    @Override
    public Role getSupportedRole() {
        return new PlayerRole();
    }


    
}
