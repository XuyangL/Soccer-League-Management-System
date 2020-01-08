/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Club.Club;
import Business.EcoSystem;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.PlayerRole.PlayerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author lixuy
 */
public class PlayerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel container, UserAccount account, Organization organization, Club club, EcoSystem system) {
        return new PlayerWorkAreaJPanel(container, club, account, system);
    }
    
}
