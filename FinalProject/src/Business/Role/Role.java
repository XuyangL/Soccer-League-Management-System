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
import javax.swing.JPanel;

/**
 *
 * @author lixuy
 */
public abstract class Role {
    
    public enum RoleType{
        SoccerAssociation("Soccer Association"),
        Referee("Referee"),
        ClubManager("Club Manager"),
        Coach("Coach"),
        Player("Soccer Player");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel container, 
            UserAccount account, 
            Organization organization, 
            Club club, 
            EcoSystem system);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
}
