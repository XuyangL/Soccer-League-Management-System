/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.League.League;
import Business.League.LeagueDirectory;
import Business.Personnel.Personnel;
import UserInterface.RefereeRole.ManageMatchReportJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lixuy
 */
public class ViewStatisticJPanel extends javax.swing.JPanel {

    private JPanel container;
    private LeagueDirectory leagueDirectory;
    /**
     * Creates new form ViewStatisticJPanel
     */
    public ViewStatisticJPanel(JPanel container, LeagueDirectory leagueDirectory) {
        initComponents();
        this.container = container;
        this.leagueDirectory = leagueDirectory;    
        jComboBox.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e) 
            {
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                 String comboString = (String) jComboBox.getSelectedItem();
                 populateStandingsTable(comboString);
                 populateStrikerTable(comboString);
                 populateAssisterTable(comboString);
                }
            } 
        });
        
        initjComboBox();
        if(leagueDirectory.getLeagueList().size()!= 0)
            jComboBox.setSelectedIndex(0);
    }

    
    private void initjComboBox() {
       for(League league: leagueDirectory.getLeagueList())
       {
         jComboBox.addItem(league.getLeagueName());   
       }
    }
    
    private void populateStandingsTable(String comboString) {
        
        League league = null;
        for(League l: leagueDirectory.getLeagueList())
        {
         if(l.getLeagueName().equals(comboString))
         {
           league = l;
           break;
         }  
        }
        
        DefaultTableModel dtm = (DefaultTableModel)standingsjTable.getModel();
        dtm.setRowCount(0);
        int no = 1;
        for(String s: league.getLeagueStatistics().getClubStatistics()) 
        {
             
             String[] log = s.split(" ");
             Object[] row = new Object[9];
             row[0] = String.valueOf(no++);
             row[1] = log[0];
             row[2] = log[1];
             row[3] = log[2];
             row[4] = log[3];
             row[5] = log[4];
             row[6] = log[5];
             row[7] = log[6];
             row[8] = log[7];                    
             dtm.addRow(row);                                 
         }               
    }
     private void populateStrikerTable(String comboString) {
      League league = null;
        for(League l: leagueDirectory.getLeagueList())
        {
         if(l.getLeagueName().equals(comboString))
         {
           league = l;
           break;
         }  
        }
        
        DefaultTableModel dtm = (DefaultTableModel)strikerjTable.getModel();
        dtm.setRowCount(0);
          
        
        HashMap<Personnel,Integer> scoreStatistics = league.getLeagueStatistics().getScoreStatistics();
        ArrayList<String> scores = new ArrayList<>() ;
        
        for(Personnel p : scoreStatistics.keySet())
        {
         int score = scoreStatistics.get(p);
         String log = p.getName() + " " + String.valueOf(score);    
         scores.add(log);
        }
        
        Collections.sort(scores, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String number1 = s1.split(" ")[1];
                String number2 = s2.split(" ")[1];
                return Integer.parseInt(number2) - Integer.parseInt(number1);
            }
        });
        
        for(int no = 1; no <= 5 && no <= scores.size(); no++) 
        {
             
             String[] log = scores.get(no - 1).split(" ");
             Object[] row = new Object[3];
             row[0] = String.valueOf(no);
             row[1] = log[0];
             row[2] = log[1];                   
             dtm.addRow(row);                                 
        }                            
    }

        private void populateAssisterTable(String comboString) {
        League league = null;
        for(League l: leagueDirectory.getLeagueList())
        {
         if(l.getLeagueName().equals(comboString))
         {
           league = l;
           break;
         }  
        }
        
        DefaultTableModel dtm = (DefaultTableModel)assisterjTable.getModel();
        dtm.setRowCount(0);
        
        HashMap<Personnel,Integer> assistStatistics = league.getLeagueStatistics().getAssistStatistics();
        ArrayList<String> assists = new ArrayList<>() ;
        
        for(Personnel p : assistStatistics.keySet())
        {
         int assist = assistStatistics.get(p);
         String log = p.getName() + " " + String.valueOf(assist);    
         assists.add(log);
        }
        
        Collections.sort(assists, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String number1 = s1.split(" ")[1];
                String number2 = s2.split(" ")[1];
                return Integer.parseInt(number2) - Integer.parseInt(number1);
            }
        });
        
        for(int no = 1; no <= 5 && no <= assists.size(); no++) 
        {
             
             String[] log = assists.get(no - 1).split(" ");
             Object[] row = new Object[3];
             row[0] = String.valueOf(no);
             row[1] = log[0];
             row[2] = log[1];                   
             dtm.addRow(row);                                 
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
        jComboBox = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        standingsjTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        strikerjTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        assisterjTable = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("League :");

        jComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        backBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Standings :");

        standingsjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Club Name", "MP", "W", "D", "L", "GF", "GA", "Points"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(standingsjTable);
        if (standingsjTable.getColumnModel().getColumnCount() > 0) {
            standingsjTable.getColumnModel().getColumn(0).setResizable(false);
            standingsjTable.getColumnModel().getColumn(1).setResizable(false);
            standingsjTable.getColumnModel().getColumn(2).setResizable(false);
            standingsjTable.getColumnModel().getColumn(3).setResizable(false);
            standingsjTable.getColumnModel().getColumn(3).setHeaderValue("W");
            standingsjTable.getColumnModel().getColumn(4).setResizable(false);
            standingsjTable.getColumnModel().getColumn(4).setHeaderValue("D");
            standingsjTable.getColumnModel().getColumn(5).setResizable(false);
            standingsjTable.getColumnModel().getColumn(5).setHeaderValue("L");
            standingsjTable.getColumnModel().getColumn(6).setResizable(false);
            standingsjTable.getColumnModel().getColumn(6).setHeaderValue("GF");
            standingsjTable.getColumnModel().getColumn(7).setResizable(false);
            standingsjTable.getColumnModel().getColumn(7).setHeaderValue("GA");
            standingsjTable.getColumnModel().getColumn(8).setResizable(false);
            standingsjTable.getColumnModel().getColumn(8).setHeaderValue("Points");
        }

        strikerjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Player", "Goals"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(strikerjTable);
        if (strikerjTable.getColumnModel().getColumnCount() > 0) {
            strikerjTable.getColumnModel().getColumn(0).setResizable(false);
            strikerjTable.getColumnModel().getColumn(1).setResizable(false);
            strikerjTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Top Strikers :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Top Assister:");

        assisterjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Player", "Assist"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(assisterjTable);
        if (assisterjTable.getColumnModel().getColumnCount() > 0) {
            assisterjTable.getColumnModel().getColumn(0).setResizable(false);
            assisterjTable.getColumnModel().getColumn(1).setResizable(false);
            assisterjTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        
        Component[] componentArray = container.getComponents();
        Component component1 = componentArray[componentArray.length - 1];
        
        container.remove(component1);               
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assisterjTable;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable standingsjTable;
    private javax.swing.JTable strikerjTable;
    // End of variables declaration//GEN-END:variables

}
