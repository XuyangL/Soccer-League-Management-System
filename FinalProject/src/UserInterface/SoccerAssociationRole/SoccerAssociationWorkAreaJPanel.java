/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SoccerAssociationRole;

import Business.EcoSystem;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.ViewStatisticJPanel;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author lixuy
 */
public class SoccerAssociationWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel container;
    private UserAccount userAccount;
    private EcoSystem system;
    private Icon wallpaper;

    /**
     * Creates new form SoccerAssociationWorkAreaJPanel
     */
    public SoccerAssociationWorkAreaJPanel(JPanel container, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.container = container;
        this.userAccount = userAccount;
        this.system = system;
        this.setBackground(new ImageIcon("bg/bg4.jpg"));
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (null != wallpaper) {
            processBackground(g);
        }
    }

    private void setBackground(Icon wallpaper) {
        this.wallpaper = wallpaper;
        this.repaint();
    }

    private void processBackground(Graphics g) {
        ImageIcon icon = (ImageIcon) wallpaper;
        Image image = icon.getImage();
        int cw = getWidth();
        int ch = getHeight();
        int iw = image.getWidth(this);
        int ih = image.getHeight(this);
        int x = 0;
        int y = 0;
        while (y <= ch) {
            g.drawImage(image, x, y, this);
            x += iw;
            if (x >= cw) {
                x = 0;
                y += ih;
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

        manageLeagueAndMatchBtn = new javax.swing.JButton();
        manageClubBtn = new javax.swing.JButton();
        manageRefereeBtn = new javax.swing.JButton();
        messageCenterBtn = new javax.swing.JButton();
        viewStatisticBtn = new javax.swing.JButton();
        manageAccountsBtn = new javax.swing.JButton();

        manageLeagueAndMatchBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        manageLeagueAndMatchBtn.setText("Manage Leagues & Matches");
        manageLeagueAndMatchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageLeagueAndMatchBtnActionPerformed(evt);
            }
        });

        manageClubBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        manageClubBtn.setText("Manage Clubs");
        manageClubBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageClubBtnActionPerformed(evt);
            }
        });

        manageRefereeBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        manageRefereeBtn.setText("Manage Referees");
        manageRefereeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRefereeBtnActionPerformed(evt);
            }
        });

        messageCenterBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        messageCenterBtn.setText("Message Center");
        messageCenterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageCenterBtnActionPerformed(evt);
            }
        });

        viewStatisticBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        viewStatisticBtn.setText("View Statistic");
        viewStatisticBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStatisticBtnActionPerformed(evt);
            }
        });

        manageAccountsBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        manageAccountsBtn.setText("Manage Accounts");
        manageAccountsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAccountsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageLeagueAndMatchBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(messageCenterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, Short.MAX_VALUE)
                        .addComponent(viewStatisticBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(manageClubBtn)
                        .addGap(87, 87, 87)
                        .addComponent(manageRefereeBtn))
                    .addComponent(manageAccountsBtn))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageLeagueAndMatchBtn)
                    .addComponent(manageClubBtn)
                    .addComponent(manageRefereeBtn))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageCenterBtn)
                    .addComponent(manageAccountsBtn))
                .addGap(66, 66, 66)
                .addComponent(viewStatisticBtn)
                .addContainerGap(251, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void messageCenterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageCenterBtnActionPerformed
        // TODO add your handling code here:
        MessageCenterAssociationJPanel panel = new MessageCenterAssociationJPanel(container, userAccount, system);
        container.add("MessageCenterJPanel", panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_messageCenterBtnActionPerformed

    private void viewStatisticBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStatisticBtnActionPerformed
        // TODO add your handling code here:
        
        ViewStatisticJPanel panel = new ViewStatisticJPanel(container,system.getLeagueDirectory());
        JScrollPane jscrollPane1 =new JScrollPane(panel);
        
        container.add("ViewStatisticJPanel", jscrollPane1);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_viewStatisticBtnActionPerformed

    private void manageRefereeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRefereeBtnActionPerformed
        // TODO add your handling code here:
        for (Organization organization : system.getOrganizationDirectory().getOrganizationList()) {
            if (organization.getName().equals("Referee Organization")) {

                ManageRefereeJPanel panel = new ManageRefereeJPanel(container, system, organization);
                container.add("ManageRefereeJPanel", panel);
                CardLayout layout = (CardLayout) container.getLayout();
                layout.next(container);
                break;
            }
        }
    }//GEN-LAST:event_manageRefereeBtnActionPerformed

    private void manageLeagueAndMatchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageLeagueAndMatchBtnActionPerformed
        // TODO add your handling code here:
        ManageLeagueAndMatchJPanel panel = new ManageLeagueAndMatchJPanel(container, system);
        container.add("ManageLeagueAndMatchJPanel", panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_manageLeagueAndMatchBtnActionPerformed

    private void manageClubBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageClubBtnActionPerformed
        // TODO add your handling code here:
        ManageClubJPanel panel = new ManageClubJPanel(container, system, system.getClubDirectory());
        container.add("ManageClubJPanel", panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_manageClubBtnActionPerformed

    private void manageAccountsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountsBtnActionPerformed
        // TODO add your handling code here:
        ManageAccoutsJPanel panel = new ManageAccoutsJPanel(container, system);
        container.add("ManageAccoutsJPanel", panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_manageAccountsBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton manageAccountsBtn;
    private javax.swing.JButton manageClubBtn;
    private javax.swing.JButton manageLeagueAndMatchBtn;
    private javax.swing.JButton manageRefereeBtn;
    private javax.swing.JButton messageCenterBtn;
    private javax.swing.JButton viewStatisticBtn;
    // End of variables declaration//GEN-END:variables
}
