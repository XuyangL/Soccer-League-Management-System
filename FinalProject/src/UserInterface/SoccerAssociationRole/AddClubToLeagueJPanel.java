/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SoccerAssociationRole;

import Business.Club.Club;
import Business.Club.ClubDirectory;
import Business.League.League;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lixuy
 */
public class AddClubToLeagueJPanel extends javax.swing.JPanel {

    private JPanel container;
    private ClubDirectory systemClubDirectory;
    private ClubDirectory tempClubDirectory;
    private League league;
    /**
     * Creates new form viewLeagueJPanel
     */
 

    AddClubToLeagueJPanel(JPanel container, ClubDirectory systemClubDirectory,League league) {
        initComponents();
        this.container = container;
        this.systemClubDirectory = systemClubDirectory;
        this.league = league;
        
        tempClubDirectory = new ClubDirectory();
        
        populateLeagueTable();
        populateLeagueOutTable();
    }
    public void populateLeagueTable() {
        
        DefaultTableModel dtm = (DefaultTableModel)leagueClubjTable.getModel();
        dtm.setRowCount(0);
        
           for( Club club: tempClubDirectory.getClubList()) 
           {
             Object[] row = new Object[3];
             row[0] = club.getClubID();
             row[1] = club;
             row[2] = club.getAddress();             
             dtm.addRow(row);      
           
         }      
    }
    
     public void populateLeagueOutTable() {
         
        DefaultTableModel dtm = (DefaultTableModel)leagueOutClubjTable.getModel();
        dtm.setRowCount(0);

       // System.out.println(leagueDirectory);
        
           for( Club systemClub: systemClubDirectory.getClubList()) 
           {
             int flag = 0;
             for(Club leagueClub: tempClubDirectory.getClubList())
             {
               if(systemClub == leagueClub)
               {
                flag = 1;
                break;
               }            
             }
             
             if(flag == 0)
             {
              Object[] row = new Object[3];
              row[0] = systemClub.getClubID();
              row[1] = systemClub;
              row[2] = systemClub.getAddress();             
              dtm.addRow(row);    
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

        jScrollPane1 = new javax.swing.JScrollPane();
        leagueClubjTable = new javax.swing.JTable();
        AddClubBtn = new javax.swing.JButton();
        backClubBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        leagueOutClubjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        removeBtn = new javax.swing.JButton();

        leagueClubjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ClubID", "Club Name", "Club Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        leagueClubjTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(leagueClubjTable);
        if (leagueClubjTable.getColumnModel().getColumnCount() > 0) {
            leagueClubjTable.getColumnModel().getColumn(0).setResizable(false);
            leagueClubjTable.getColumnModel().getColumn(1).setResizable(false);
            leagueClubjTable.getColumnModel().getColumn(2).setResizable(false);
        }

        AddClubBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        AddClubBtn.setText("Add New Club");
        AddClubBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClubBtnActionPerformed(evt);
            }
        });

        backClubBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backClubBtn.setText("Confirm and Back");
        backClubBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backClubBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Clubs out of this League:");

        leagueOutClubjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ClubID", "Club Name", "Club Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        leagueOutClubjTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(leagueOutClubjTable);
        if (leagueOutClubjTable.getColumnModel().getColumnCount() > 0) {
            leagueOutClubjTable.getColumnModel().getColumn(0).setResizable(false);
            leagueOutClubjTable.getColumnModel().getColumn(1).setResizable(false);
            leagueOutClubjTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Clubs in this League:");

        removeBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        removeBtn.setText("Remove Club");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(backClubBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddClubBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddClubBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backClubBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddClubBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClubBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = leagueOutClubjTable.getSelectedRow();
        if(selectedrow >= 0)
        {
            Club Club = (Club) leagueOutClubjTable.getValueAt(selectedrow,1);
            tempClubDirectory.getClubList().add(Club);
            populateLeagueTable();
            populateLeagueOutTable();
           
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select a club from the table first!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_AddClubBtnActionPerformed

    private void backClubBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backClubBtnActionPerformed
        // TODO add your handling code here:
        if(tempClubDirectory.getClubList().size()<2)
        {
         JOptionPane.showMessageDialog(null,"Please add more than two clubs into the league!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
           int dialogButton = JOptionPane.YES_NO_OPTION;
           int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to add these clubs into league? (You cannot add new clubs in this league later.)","Warning",dialogButton);
           if(dialogResult == JOptionPane.YES_OPTION)   
           {
            league.setClubDirectory(tempClubDirectory);
            league.initLeagueStatistics();
        
            container.remove(this);
            Component[] componentArray = container.getComponents();
            Component component = componentArray[componentArray.length - 1];
            ManageLeagueAndMatchJPanel panel = (ManageLeagueAndMatchJPanel) component;
            panel.populateTable();
            CardLayout layout = (CardLayout) container.getLayout();
            layout.previous(container);
           }
        }
        
    }//GEN-LAST:event_backClubBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = leagueClubjTable.getSelectedRow();
        if(selectedrow >= 0)
        {
            Club Club = (Club) leagueClubjTable.getValueAt(selectedrow,1);
            tempClubDirectory.getClubList().remove(Club);
            populateLeagueTable();
            populateLeagueOutTable();
           
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select a club from the table first!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_removeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddClubBtn;
    private javax.swing.JButton backClubBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable leagueClubjTable;
    private javax.swing.JTable leagueOutClubjTable;
    private javax.swing.JButton removeBtn;
    // End of variables declaration//GEN-END:variables

}
