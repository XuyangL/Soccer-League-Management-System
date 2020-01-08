/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClubManagerRole;

import Business.Match.Match;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author lixuy
 */
public class ViewSquadListJPanel extends javax.swing.JPanel {

    private JPanel container; 
    private Match match;
    private String clubBelong;
    /**
     * Creates new form ViewSquadListJPanel
     */
    public ViewSquadListJPanel(JPanel container, Match match, String clubBelong) {
        initComponents();
        this.container = container;
        this.match = match;
        this.clubBelong = clubBelong;
        matchInfojLabel.setText("Match Information: " + match.getClub1().getClubName() + " VS " + match.getClub2().getClubName());
        initPlayer();
    }

    private void initPlayer() {
        
        if(clubBelong.equals("club1"))
        {
         jLabel1.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(0).getName());
         jLabel2.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(1).getName());
         jLabel3.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(2).getName());
         jLabel4.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(3).getName());
         jLabel5.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(4).getName());
         jLabel6.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(5).getName());
         jLabel7.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(6).getName());
         jLabel8.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(7).getName());
         jLabel9.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(8).getName());
         jLabel10.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(9).getName());
         jLabel11.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(10).getName());
         jLabel12.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(11).getName());
         jLabel13.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(12).getName());
         jLabel14.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(13).getName());
         jLabel15.setText("Player :" + match.getMatchReport().getClub1BigPlayerDirectory().getPersonnelList().get(14).getName());
        }
        else
        {
         jLabel1.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(0).getName());
         jLabel2.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(1).getName());
         jLabel3.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(2).getName());
         jLabel4.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(3).getName());
         jLabel5.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(4).getName());
         jLabel6.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(5).getName());
         jLabel7.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(6).getName());
         jLabel8.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(7).getName());
         jLabel9.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(8).getName());
         jLabel10.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(9).getName());
         jLabel11.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(10).getName());
         jLabel12.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(11).getName());
         jLabel13.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(12).getName());
         jLabel14.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(13).getName());
         jLabel15.setText("Player :" + match.getMatchReport().getClub2BigPlayerDirectory().getPersonnelList().get(14).getName());
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

        matchInfojLabel = new javax.swing.JLabel();
        titlejLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        matchInfojLabel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        matchInfojLabel.setText("Match Information:");

        titlejLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        titlejLabel.setText("Squad List of the Match :");

        backBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Player :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Player :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Player :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Player :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Player :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Player :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Player :");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Player :");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Player :");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Player :");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Player :");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Player :");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Player :");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Player :");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Player :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matchInfojLabel)
                    .addComponent(titlejLabel)
                    .addComponent(backBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(236, 236, 236)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))))
                .addContainerGap(522, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(matchInfojLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titlejLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)))
                .addGap(50, 50, 50)
                .addComponent(backBtn)
                .addContainerGap(108, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel matchInfojLabel;
    private javax.swing.JLabel titlejLabel;
    // End of variables declaration//GEN-END:variables

}
