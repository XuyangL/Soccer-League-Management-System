/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CoachRole;

import Business.Club.Club;
import Business.League.League;
import Business.League.LeagueDirectory;
import Business.Match.Match;
import Business.Match.MatchDay;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lixuy
 */
public class ManagePlayerListJPanel extends javax.swing.JPanel {

    private JPanel container;
    private Club club;
    private LeagueDirectory leagueDirectory;
    /**
     * Creates new form ManagePlayerListJPanel
     */
    public ManagePlayerListJPanel(JPanel container, Club club, LeagueDirectory leagueDirectory) {
        initComponents();
        this.container = container;
        this.club = club; 
        this.leagueDirectory = leagueDirectory;
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
        dtm.setRowCount(0);
      
        for(League league:leagueDirectory.getLeagueList())
        {    
            for( MatchDay matchDay: league.getMatchDayDirectory().getMatchDayList()) 
            {
                for(Match match:matchDay.getMatchList())
                {
                   if((match.getClub1() == club || match.getClub2() == club) && match.isRefereeAssigned())
                   {
                       String clubBelong = "";
                       if(match.getClub1() == club)
                          clubBelong = "club1";
                       else clubBelong = "club2";
                       
                       
                       if(clubBelong.equals("club1"))
                       {
                           if(match.isClub1PlayerBigListProvided())
                           {
                               Object[] row = new Object[6];
                               row[0] = league;
                               row[1] = match;
                               row[2] = match.getClub1().getClubName() + " VS " + match.getClub2().getClubName();
                               row[3] = match.getClub1().getAddress();
             
                               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                               row[4] = sdf.format(match.getTime());
             
                               if(match.isClub1PlayerMatchListProvided())
                                  row[5] = "Yes";
                               else row[5] = "No";
                               dtm.addRow(row); 
                           }
                       }
                       else
                       {
                           if(match.isClub2PlayerBigListProvided())
                           {
                              Object[] row = new Object[6];
                              row[0] = league;
                              row[1] = match;
                              row[2] = match.getClub1().getClubName() + " VS " + match.getClub2().getClubName();
                              row[3] = match.getClub1().getAddress();
             
                              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                              row[4] = sdf.format(match.getTime());
                              if(match.isClub2PlayerMatchListProvided())
                                 row[5] = "Yes";
                              else row[5] = "No";
                              dtm.addRow(row); 
                           }
                       }
                       
                            
                   }
               
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        viewBtn = new javax.swing.JButton();
        provideBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("All Matches of the Club :");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "League", "MatchID", "Match Info", "Location", "Time", "Match List Finished"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(4).setResizable(false);
            jTable.getColumnModel().getColumn(5).setResizable(false);
        }

        viewBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        viewBtn.setText("View");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        provideBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        provideBtn.setText("Provide Squad List");
        provideBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provideBtnActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(provideBtn))
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(provideBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = jTable.getSelectedRow();
        if(selectedrow >= 0)
        {
            Match match = (Match) jTable.getValueAt(selectedrow,1);

            String clubBelong = "";

            if(match.getClub1() == club)
            clubBelong = "club1";
            else clubBelong = "club2";
            
            if(clubBelong.equals("club1"))
            {
              if(match.isClub1PlayerMatchListProvided())
              {
                ViewMatchListJPanel panel = new ViewMatchListJPanel(container, match, clubBelong);
                container.add("ViewMatchListJPanel",panel);
                CardLayout layout = (CardLayout) container.getLayout();
                layout.next(container);
              }
              else
              {
               JOptionPane.showMessageDialog(null,"Match List doesn't exist!","Warning", JOptionPane.WARNING_MESSAGE);
              }
            }
            
            if(clubBelong.equals("club2"))
            {
              if(match.isClub2PlayerMatchListProvided())
              {
                ViewMatchListJPanel panel = new ViewMatchListJPanel(container, match, clubBelong);
                container.add("ViewMatchListJPanel",panel);
                CardLayout layout = (CardLayout) container.getLayout();
                layout.next(container);
              }
              else
              {
               JOptionPane.showMessageDialog(null,"Match List doesn't exist!","Warning", JOptionPane.WARNING_MESSAGE);
              }
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select a match from the table first!","Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_viewBtnActionPerformed

    private void provideBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provideBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = jTable.getSelectedRow();
        if(selectedrow >= 0)
        {
            

            Match match = (Match) jTable.getValueAt(selectedrow,1);

            String clubBelong = "";

            if(match.getClub1() == club)
            clubBelong = "club1";
            else clubBelong = "club2";
            String judge = (String) jTable.getValueAt(selectedrow,5);
            
            if(judge.equals("No"))
            {
                ProvideMatchListJPanel panel = new ProvideMatchListJPanel(container, match, clubBelong);          
                container.add("ProvideMatchListJPanel",panel);
                CardLayout layout = (CardLayout) container.getLayout();
                layout.next(container);
            }
            else JOptionPane.showMessageDialog(null,"You have already provided the match list!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select a match from the table first!","Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_provideBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton provideBtn;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}
