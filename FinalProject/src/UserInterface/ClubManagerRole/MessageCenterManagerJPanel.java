/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClubManagerRole;

import Business.Club.Club;
import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import UserInterface.MessageInboxJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author lixuy
 */
public class MessageCenterManagerJPanel extends javax.swing.JPanel {

    private JPanel container;
    private UserAccount userAccount;
    private Club club;
    private EcoSystem system;
    
    /**
     * Creates new form MessageCenterManagerJPanel
     */
    public MessageCenterManagerJPanel(JPanel container, UserAccount userAccount, Club club, EcoSystem system) {
        initComponents();
        
        this.container = container;
        this.userAccount = userAccount;
        this.club = club;
        this.system = system;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        composeBtn = new javax.swing.JButton();
        unreadBtn = new javax.swing.JButton();
        readBtn = new javax.swing.JButton();
        sentBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jSplitPane.setDividerLocation(130);

        composeBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        composeBtn.setText("Compose");
        composeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                composeBtnActionPerformed(evt);
            }
        });

        unreadBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        unreadBtn.setText("Unread");
        unreadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unreadBtnActionPerformed(evt);
            }
        });

        readBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        readBtn.setText("Read");
        readBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readBtnActionPerformed(evt);
            }
        });

        sentBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        sentBtn.setText("Sent");
        sentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sentBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(composeBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unreadBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(readBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(composeBtn)
                .addGap(47, 47, 47)
                .addComponent(unreadBtn)
                .addGap(47, 47, 47)
                .addComponent(readBtn)
                .addGap(47, 47, 47)
                .addComponent(sentBtn)
                .addGap(47, 47, 47)
                .addComponent(backBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane.setLeftComponent(jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 744, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        jSplitPane.setRightComponent(jPanel2);

        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void composeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_composeBtnActionPerformed
        // TODO add your handling code here:

        ComposeMessageManagerJPanel panel = new ComposeMessageManagerJPanel(userAccount,club,system);
        jSplitPane.setRightComponent(panel);
    }//GEN-LAST:event_composeBtnActionPerformed

    private void unreadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unreadBtnActionPerformed
        // TODO add your handling code here:
        MessageInboxJPanel panel = new MessageInboxJPanel(userAccount,jSplitPane,"unread");
        jSplitPane.setRightComponent(panel);
    }//GEN-LAST:event_unreadBtnActionPerformed

    private void readBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readBtnActionPerformed
        // TODO add your handling code here:
        MessageInboxJPanel panel = new MessageInboxJPanel(userAccount,jSplitPane,"read");
        jSplitPane.setRightComponent(panel);
    }//GEN-LAST:event_readBtnActionPerformed

    private void sentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sentBtnActionPerformed
        // TODO add your handling code here:
        MessageInboxJPanel panel = new MessageInboxJPanel(userAccount,jSplitPane,"sent");
        jSplitPane.setRightComponent(panel);
    }//GEN-LAST:event_sentBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton composeBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JButton readBtn;
    private javax.swing.JButton sentBtn;
    private javax.swing.JButton unreadBtn;
    // End of variables declaration//GEN-END:variables
}
