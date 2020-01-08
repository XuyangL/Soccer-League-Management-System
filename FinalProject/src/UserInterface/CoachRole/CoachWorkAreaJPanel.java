/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CoachRole;

import Business.Club.Club;
import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
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
public class CoachWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel container;
    private EcoSystem system;
    private Club club;
    private UserAccount userAccount;
    private Icon wallpaper;

    /**
     * Creates new form CoachWorkAreaPanel
     */
    public CoachWorkAreaJPanel(JPanel container, Club club, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.container = container;
        this.club = club;
        this.system = system;
        this.userAccount = userAccount;
        this.setBackground(new ImageIcon("bg/bg6.jpg"));


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

        messageCenterBtn = new javax.swing.JButton();
        playerBtn = new javax.swing.JButton();
        viewStatisticBtn = new javax.swing.JButton();
        manageAccountBtn = new javax.swing.JButton();

        messageCenterBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        messageCenterBtn.setText("Message Center");
        messageCenterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageCenterBtnActionPerformed(evt);
            }
        });

        playerBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        playerBtn.setText("Match Player List");
        playerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerBtnActionPerformed(evt);
            }
        });

        viewStatisticBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        viewStatisticBtn.setText("View Statistic");
        viewStatisticBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStatisticBtnActionPerformed(evt);
            }
        });

        manageAccountBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        manageAccountBtn.setText("Manage Account");
        manageAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageAccountBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewStatisticBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(messageCenterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 458, Short.MAX_VALUE)
                .addComponent(manageAccountBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerBtn)
                    .addComponent(manageAccountBtn))
                .addGap(58, 58, 58)
                .addComponent(messageCenterBtn)
                .addGap(57, 57, 57)
                .addComponent(viewStatisticBtn)
                .addContainerGap(216, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void messageCenterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageCenterBtnActionPerformed
        // TODO add your handling code here:
        MessageCenterCoachPlayerJPanel panel = new MessageCenterCoachPlayerJPanel(container,userAccount,club,system);
        container.add("MessageCenterCoachPlayerJPanel",panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);

    }//GEN-LAST:event_messageCenterBtnActionPerformed

    private void playerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerBtnActionPerformed
        // TODO add your handling code here:
        ManagePlayerListJPanel panel = new ManagePlayerListJPanel(container, club, system.getLeagueDirectory());
        container.add("ManagePlayerListJPanel", panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);


    }//GEN-LAST:event_playerBtnActionPerformed
                                     
    private void viewStatisticBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStatisticBtnActionPerformed
        // TODO add your handling code here:
        ViewStatisticJPanel panel = new ViewStatisticJPanel(container,system.getLeagueDirectory());
        JScrollPane jscrollPane1 =new JScrollPane(panel);
        
        container.add("ViewStatisticJPanel", jscrollPane1);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_viewStatisticBtnActionPerformed

    private void manageAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountBtnActionPerformed
        // TODO add your handling code here:
        CoachUpdateJPanel panel = new CoachUpdateJPanel(container, system, userAccount);
        container.add("CoachUpdateJPanel", panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_manageAccountBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton manageAccountBtn;
    private javax.swing.JButton messageCenterBtn;
    private javax.swing.JButton playerBtn;
    private javax.swing.JButton viewStatisticBtn;
    // End of variables declaration//GEN-END:variables
}
