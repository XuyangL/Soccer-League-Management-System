/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.RefereeRole;

import Business.EcoSystem;
import Business.Organization.Organization;
import Business.Organization.SoccerAssociationOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author lixuy
 */
public class RefereeWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel container;
    private UserAccount userAccount;
    private EcoSystem system;
    private Icon wallpaper;

    /**
     * Creates new form RefereeWorkAreaJPanel
     */
    public RefereeWorkAreaJPanel(JPanel container, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.container = container;
        this.userAccount = userAccount;
        this.system = system;
        this.setBackground(new ImageIcon("bg/bg5.jpg"));
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
        messageCenterBtn1 = new javax.swing.JButton();
        manageAccountBtn = new javax.swing.JButton();

        messageCenterBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        messageCenterBtn.setText("Message Center");
        messageCenterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageCenterBtnActionPerformed(evt);
            }
        });

        messageCenterBtn1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        messageCenterBtn1.setText("Match Report");
        messageCenterBtn1.setToolTipText("");
        messageCenterBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageCenterBtn1ActionPerformed(evt);
            }
        });

        manageAccountBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        manageAccountBtn.setText("Manage Account");
        manageAccountBtn.setToolTipText("");
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
                    .addComponent(messageCenterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(messageCenterBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(505, 505, 505)
                .addComponent(manageAccountBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageCenterBtn1)
                    .addComponent(manageAccountBtn))
                .addGap(50, 50, 50)
                .addComponent(messageCenterBtn)
                .addContainerGap(282, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void messageCenterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageCenterBtnActionPerformed
        // TODO add your handling code here:
        for (Organization organization : system.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof SoccerAssociationOrganization) {
                MessageCenterRefereeJPanel panel = new MessageCenterRefereeJPanel(container, userAccount, organization);
                container.add("MessageCenterManagerJPanel", panel);
                CardLayout layout = (CardLayout) container.getLayout();
                layout.next(container);
            }
        }
    }//GEN-LAST:event_messageCenterBtnActionPerformed

    private void manageAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageAccountBtnActionPerformed
        // TODO add your handling code here:

        RefereeUpdateJPanel panel = new RefereeUpdateJPanel(container, system, userAccount);
        container.add("RefereeUpdateJPanel", panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_manageAccountBtnActionPerformed

    private void messageCenterBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageCenterBtn1ActionPerformed
        // TODO add your handling code here:
        ManageMatchReportJPanel panel = new ManageMatchReportJPanel(container, userAccount.getPersonnel(), system.getLeagueDirectory());
        container.add("MessageCenterManagerJPanel", panel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_messageCenterBtn1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton manageAccountBtn;
    private javax.swing.JButton messageCenterBtn;
    private javax.swing.JButton messageCenterBtn1;
    // End of variables declaration//GEN-END:variables

        }