/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MessageQueue;

import java.util.ArrayList;

/**
 *
 * @author lixuy
 */
public class MessageQueue {
    private ArrayList<Message> messageList;

    public MessageQueue() {
        messageList = new ArrayList<>();
    }
    
    

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }
}
