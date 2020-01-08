/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClubManagerRole;

import Business.League.League;
import Business.Match.Match;
import Business.Organization.Organization;
import Business.Personnel.Personnel;
import Business.Personnel.PersonnelDirectory;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lixuy
 */
public class ProvideSquadListJPanel extends javax.swing.JPanel {

    private JPanel container; 
    private Organization organization;
    private Match match;
    private String clubBelong;
    private League league;
    private PersonnelDirectory susPlayers;
    private PersonnelDirectory tempSquadList;
    /**
     * Creates new form SquadListJPanel
     */

    public ProvideSquadListJPanel(JPanel container, Organization organization, Match match, String clubBelong, League league) {
        initComponents();
        this.container = container;
        this.organization = organization;
        this.match = match;
        this.clubBelong = clubBelong;
        this.league = league;
        
        susPlayers = new PersonnelDirectory();
        tempSquadList = new PersonnelDirectory();
        
        matchInfojLabel.setText("Match Information: " + match.getClub1().getClubName() + " VS " + match.getClub2().getClubName());
        populateSquadTable();
        populatePlayerTable();
        populateSusTable();
    }

    
    private void populateSquadTable() {
        DefaultTableModel dtm = (DefaultTableModel)squadjTable.getModel();
        dtm.setRowCount(0);
        
        for(Personnel personnel: tempSquadList.getPersonnelList()) 
          {
             Object[] row = new Object[2];
             row[0] = personnel.getId();
             row[1] = personnel;           
             dtm.addRow(row);
          }
        playerNumberjLabel.setText("Number of Player in the Squad List: " + Integer.toString(tempSquadList.getPersonnelList().size()));
                
}

    private void populatePlayerTable() {
        
        DefaultTableModel dtm = (DefaultTableModel)playerjTable.getModel();
        dtm.setRowCount(0);
        
        for(Personnel personnel1: organization.getPersonnelDirectory().getPersonnelList()) 
        {
           int flag = 0;
           for(Personnel personnel2: tempSquadList.getPersonnelList())
           { 
              if(personnel1 == personnel2)
               {
                 flag = 1;
                 break;
               }
            }
              
           if(flag == 0)
              {
               Object[] row = new Object[2];
               row[0] = personnel1.getId();
               row[1] = personnel1;           
               dtm.addRow(row);      
              
              }
        }
        
    }
    
    public void populateSusTable() {
       DefaultTableModel dtm = (DefaultTableModel)susjTable.getModel();
       dtm.setRowCount(0);
       for(Personnel p1 :organization.getPersonnelDirectory().getPersonnelList()) 
       { 
           for(Personnel p2: league.getLeagueStatistics().getProblemPlayer().getPersonnelList())
           {
           
               if(p1 == p2)
               {
                Object[] row = new Object[2];
                row[0] = p1.getId();
                row[1] = p1;           
                dtm.addRow(row);
                susPlayers.getPersonnelList().add(p1);
                
                break;          
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

        matchInfojLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        squadjTable = new javax.swing.JTable();
        playerNumberjLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        playerjTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        susjTable = new javax.swing.JTable();
        confirmBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        matchInfojLabel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        matchInfojLabel.setText("Match Information:");

        squadjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(squadjTable);
        if (squadjTable.getColumnModel().getColumnCount() > 0) {
            squadjTable.getColumnModel().getColumn(0).setResizable(false);
            squadjTable.getColumnModel().getColumn(1).setResizable(false);
        }

        playerNumberjLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        playerNumberjLabel.setText("Number of Player in the Squad List :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Squad List of the Match :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Player List of the First Team :");

        playerjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(playerjTable);
        if (playerjTable.getColumnModel().getColumnCount() > 0) {
            playerjTable.getColumnModel().getColumn(0).setResizable(false);
            playerjTable.getColumnModel().getColumn(1).setResizable(false);
        }

        addBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        removeBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Player under Suspension :");
        jLabel4.setToolTipText("");

        susjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(susjTable);
        if (susjTable.getColumnModel().getColumnCount() > 0) {
            susjTable.getColumnModel().getColumn(0).setResizable(false);
            susjTable.getColumnModel().getColumn(1).setResizable(false);
        }

        confirmBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        confirmBtn.setText("Confirm");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playerNumberjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(matchInfojLabel)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(matchInfojLabel)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(playerNumberjLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn)
                    .addComponent(backBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = playerjTable.getSelectedRow();
        if(selectedrow >= 0)
        {
            Personnel selectedPlayer = (Personnel) playerjTable.getValueAt(selectedrow,1);
            
            for(Personnel player: susPlayers.getPersonnelList())
            {
                if(selectedPlayer == player)
                {
                    JOptionPane.showMessageDialog(null,"This player is under suspension!","Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }          
            }
            
            tempSquadList.getPersonnelList().add(selectedPlayer);

            populateSquadTable();
            populatePlayerTable();
           
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select a player from the table first!","Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        // TODO add your handling code here:
         if(clubBelong.equals("club1"))
         {
          if(tempSquadList.getPersonnelList().size()!= 15) //may change to 15 later
            JOptionPane.showMessageDialog(null,"Number of Player must be 15!","Warning", JOptionPane.WARNING_MESSAGE);
          else
          {
           int dialogButton = JOptionPane.YES_NO_OPTION;
           int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to add these players into squad list? (You cannot add new players when you exit.)","Warning",dialogButton);
           if(dialogResult == JOptionPane.YES_OPTION)   
           {   
           match.getMatchReport().setClub1BigPlayerDirectory(tempSquadList);
           match.setClub1PlayerBigListProvided(true);    
           JOptionPane.showMessageDialog(null,"Players are successfully added to thr squad list!","Warning", JOptionPane.WARNING_MESSAGE);  
           }
          }      
         }
         
         else
         {
          if(tempSquadList.getPersonnelList().size()!= 15) //may change to 15 later
            JOptionPane.showMessageDialog(null,"Number of Player must be 15!","Warning", JOptionPane.WARNING_MESSAGE);
          else
          {
           int dialogButton = JOptionPane.YES_NO_OPTION;
           int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to add these players into squad list? (You cannot add new players when you exit.)","Warning",dialogButton);
           if(dialogResult == JOptionPane.YES_OPTION)   
           {   
           match.getMatchReport().setClub2BigPlayerDirectory(tempSquadList);    
           match.setClub2PlayerBigListProvided(true);
           JOptionPane.showMessageDialog(null,"Players are successfully added to thr squad list!","Warning", JOptionPane.WARNING_MESSAGE);  
           }
          }        
         }      
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = squadjTable.getSelectedRow();
        if(selectedrow >= 0)
        {
            Personnel personnel = (Personnel) squadjTable.getValueAt(selectedrow,1);
            tempSquadList.getPersonnelList().remove(personnel);               
            populateSquadTable();
            populatePlayerTable();
           
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select a player from the table first!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_removeBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);   
        Component[] componentArray = container.getComponents();
        Component component1 = componentArray[componentArray.length - 1];
        Component component2 = componentArray[componentArray.length - 2];
        
        container.remove(component1);       
        ManageSquadListJPanel panel = (ManageSquadListJPanel) component2;
        
        panel.populateTable();
        
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container); 
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel matchInfojLabel;
    private javax.swing.JLabel playerNumberjLabel;
    private javax.swing.JTable playerjTable;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTable squadjTable;
    private javax.swing.JTable susjTable;
    // End of variables declaration//GEN-END:variables

}
