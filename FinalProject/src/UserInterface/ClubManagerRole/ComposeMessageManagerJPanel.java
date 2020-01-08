/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClubManagerRole;

import Business.Club.Club;
import Business.EcoSystem;
import Business.MessageQueue.Message;
import Business.Organization.ClubManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author lixuy
 */
public class ComposeMessageManagerJPanel extends javax.swing.JPanel {

    private UserAccount userAccount;
    private Club club;
    private EcoSystem system;
    /**
     * Creates new form ComposeMessageManagerJPanel
     */
    public ComposeMessageManagerJPanel(UserAccount userAccount, Club club, EcoSystem system) {
        initComponents();
        this.userAccount = userAccount;
        this.club = club;
        this.system = system;
        
        clubjComboBox.addItemListener(new ItemListener()
         {
            @Override
            public void itemStateChanged(ItemEvent e) 
            {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                 String clubName = (String) clubjComboBox.getSelectedItem();
                 initOrganizationjComboBox(clubName);
                }
            }

          
        });
       
       organizationjComboBox.addItemListener(new ItemListener()
         {
            @Override
            public void itemStateChanged(ItemEvent e) 
            {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                 String clubName = (String) clubjComboBox.getSelectedItem();
                 String organizationName = (String) organizationjComboBox.getSelectedItem();
                 initPersonneljComboBox(clubName,organizationName);
                }
            }     
        });
       
       
       
       
       
       initClubjComboBox();
    }
    
    private void initClubjComboBox() {
        
        clubjComboBox.removeAllItems();
        for(Club club:system.getClubDirectory().getClubList())
        {
         clubjComboBox.addItem(club.getClubName());
        
        }
        
        clubjComboBox.addItem("N/A");
        
    }
    
     private void initOrganizationjComboBox(String clubName) {
         
         organizationjComboBox.removeAllItems();
         if(!clubName.equals("N/A"))
         {
             Club club = null;
             for(Club c: system.getClubDirectory().getClubList())
             {
              if(c.getClubName().equals(clubName))
              {
               club = c;
               break;           
              }       
             }
         
             if(club != null)
             {
                 if(club.getClubName().equals(this.club.getClubName()))
                 {
                     for(Organization organization: club.getOrganizationDirectory().getOrganizationList())
                    {
                      organizationjComboBox.addItem(organization.getName());      
                    }
                 }
                 
                 else{
                 
                     for(Organization organization: club.getOrganizationDirectory().getOrganizationList())
                     {
                      if(organization instanceof ClubManagerOrganization)
                         organizationjComboBox.addItem(organization.getName());      
                     }
                 
                 }
             }
         }
         
         if(clubName.equals("N/A"))
         {   
           organizationjComboBox.addItem("Soccer Association");  
         }
          
               
    }
    
    private void initPersonneljComboBox(String clubName,String organizationName) {
        
        personneljComboBox.removeAllItems();
        
         if(!clubName.equals("N/A"))
         {
             Club club = null;
             for(Club c: system.getClubDirectory().getClubList())
             {
              if(c.getClubName().equals(clubName))
              {
               club = c;
               break;           
              }       
             }
             Organization organization = null;
             for(Organization o: club.getOrganizationDirectory().getOrganizationList())
             {
               if(o.getName().equals(organizationName))
               {
                organization = o;
                break;        
               }
             }
             
             for(UserAccount u: organization.getUserAccountDirectory().getUserAccountList())
             {
               personneljComboBox.addItem(u.getUsername());    
             }
         }
         
         else{
                  
         if(organizationName.equals("Soccer Association"))
         {
             Organization organization = null;
             for(Organization o: system.getOrganizationDirectory().getOrganizationList())
             {
               if(o.getName().equals("Soccer Association"))
               {
                organization = o;
                break;        
               }
             }
             
             for(UserAccount u: organization.getUserAccountDirectory().getUserAccountList())
             {
               personneljComboBox.addItem(u.getUsername());    
             }
         
         }
              
         }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titlejTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        clubjComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        organizationjComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        personneljComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        sendBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Compose New Message");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Title : ");

        titlejTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Receiver :");

        clubjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        clubjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clubjComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Organization :");

        organizationjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Personnel :");

        personneljComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        sendBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Club :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(titlejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sendBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clubjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(organizationjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(personneljComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(titlejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(clubjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(organizationjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(personneljComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sendBtn)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clubjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clubjComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clubjComboBoxActionPerformed

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
        String title = titlejTextField.getText();
        String content = jTextArea.getText();

        String userName = (String)personneljComboBox.getSelectedItem();

        UserAccount userAccount = null;
        for(Organization o: system.getOrganizationDirectory().getOrganizationList())
        {
            for(UserAccount u:o.getUserAccountDirectory().getUserAccountList())
            {
                if(u.getUsername().equals(userName))
                {
                    userAccount = u;
                    break;
                }
            }
        }

        if(userAccount == null)
        {
            for(Club c: system.getClubDirectory().getClubList())
            {
                for(Organization o: c.getOrganizationDirectory().getOrganizationList())
                {
                    for(UserAccount u:o.getUserAccountDirectory().getUserAccountList())
                    {
                        if(u.getUsername().equals(userName))
                        {
                            userAccount = u;
                            break;
                        }
                    }
                }
            }

        }

        if(userAccount != null)
        {
            Message messageSent = new Message();
            Message messageReceive = new Message();

            messageSent.setTitle(title);
            messageSent.setMessage(content);
            messageSent.setSender(this.userAccount);
            messageSent.setReceiver(userAccount);
            messageSent.setStatus("sent");
            messageSent.setSendDate(new Date());

            messageReceive.setTitle(title);
            messageReceive.setMessage(content);
            messageReceive.setSender(this.userAccount);
            messageReceive.setReceiver(userAccount);
            messageReceive.setStatus("unread");
            messageReceive.setSendDate(new Date());

            this.userAccount.getMessageQueue().getMessageList().add(messageSent);
            userAccount.getMessageQueue().getMessageList().add(messageReceive);

            titlejTextField.setText("");
            jTextArea.setText("");
        }

        else
        {
            JOptionPane.showMessageDialog(null,"Invalid Sender","Warning", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_sendBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> clubjComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JComboBox<String> organizationjComboBox;
    private javax.swing.JComboBox<String> personneljComboBox;
    private javax.swing.JButton sendBtn;
    private javax.swing.JTextField titlejTextField;
    // End of variables declaration//GEN-END:variables
}
