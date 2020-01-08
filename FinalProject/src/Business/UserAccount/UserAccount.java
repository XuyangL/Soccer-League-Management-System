/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.MessageQueue.MessageQueue;
import Business.Personnel.Personnel;
import Business.Role.Role;

/**
 *
 * @author lixuy
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Personnel personnel;
    private Role role;
    private MessageQueue messageQueue;

    public UserAccount() {
        messageQueue = new MessageQueue();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public MessageQueue getMessageQueue() {
        return messageQueue;
    }

    public void setMessageQueue(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }
    
    @Override
    public String toString() {
        return username;
    }
}
