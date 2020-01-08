/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SoccerAssociationRole;

import Business.Club.Club;
import Business.Club.ClubDirectory;
import Business.Match.MatchDay;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author lixuy
 */
public class CreateMatchJPanel extends javax.swing.JPanel {

    private JPanel container;
    private MatchDay matchDay;
    private ClubDirectory clubDirectory;
    /**
     * Creates new form CreateMatchJPanel
     */

    public CreateMatchJPanel(JPanel container, MatchDay matchDay, ClubDirectory clubDirectory) {
        initComponents();
        this.container = container;
        this.matchDay = matchDay;
        this.clubDirectory = clubDirectory;
        
        initComboBox();
    }

    private void initComboBox() {
      club1jComboBox.removeAllItems();
      club2jComboBox.removeAllItems();
      for(Club club: clubDirectory.getClubList())
      {
       club1jComboBox.addItem(club.getClubName()); 
      }
      
      for(Club club: clubDirectory.getClubList())
      {
       club2jComboBox.addItem(club.getClubName()); 
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
        jLabel3 = new javax.swing.JLabel();
        club1jComboBox = new javax.swing.JComboBox<>();
        club2jComboBox = new javax.swing.JComboBox<>();
        datejTextField = new javax.swing.JTextField();
        timejTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        createBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Create a New Match");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Club1 (Home) :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Club2 (Away) :");

        club1jComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        club2jComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        datejTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        timejTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Date :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Time :");

        createBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(createBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(club1jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(timejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(club2jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(club1jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(club2jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(datejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(timejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(createBtn)
                .addGap(28, 28, 28)
                .addComponent(backBtn)
                .addContainerGap(245, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        // TODO add your handling code here:
        
        Club club1 = null;
        Club club2 = null;
        String club1Name = (String)club1jComboBox.getSelectedItem();
        String club2Name = (String)club2jComboBox.getSelectedItem();
        
        for(Club club: clubDirectory.getClubList())
        {
         if(club.getClubName().equals(club1Name))
             club1 = club;
         
         if(club.getClubName().equals(club2Name))
             club2 = club;
        
        }
        
        String startDate = datejTextField.getText();
        String preferredTime = timejTextField.getText();     
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        try 
        {
            Date unifiedTime = sdf.parse(startDate + " " + preferredTime);
            matchDay.addMatch(club1, club2, unifiedTime);
            JOptionPane.showMessageDialog(null, "Match Successfully added!", "Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null,"Wrong time format! Please enter as yyyy-MM-dd HH:mm!",null, JOptionPane.WARNING_MESSAGE);
        }
       
    }//GEN-LAST:event_createBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageMatchJPanel panel = (ManageMatchJPanel) component;
        panel.initComboBox();
        
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> club1jComboBox;
    private javax.swing.JComboBox<String> club2jComboBox;
    private javax.swing.JButton createBtn;
    private javax.swing.JTextField datejTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField timejTextField;
    // End of variables declaration//GEN-END:variables

}