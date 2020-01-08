/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.RefereeRole;

import Business.League.League;
import Business.Match.Match;
import Business.Match.MatchEvent;
import Business.Personnel.Personnel;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lixuy
 */
public class ProvideMatchReportJPanel extends javax.swing.JPanel {

    private JPanel container;
    private Match match;
    private League league;
    /**
     * Creates new form ProvideMatchReportJPanel
     */

    public ProvideMatchReportJPanel(JPanel container, Match match, League league) {
        initComponents();
        this.container = container;
        this.match = match;
        this.league = league;
        
        matchInfojLabel.setText("Match Information: " + match.getClub1().getClubName() + " VS " + match.getClub2().getClubName());
        initjComboBox();
        populateScoreTable();
        populateSubTable();
        populateYellowTable();
        populateRedTable();
                
    }

    private void initjComboBox() {
        winnerjComboBox.removeAllItems();
        winnerjComboBox.addItem(match.getClub1().getClubName());
        winnerjComboBox.addItem(match.getClub2().getClubName());
        winnerjComboBox.addItem("Draw");
        
        scoreNamejComboBox.removeAllItems();
        for(Personnel personnel: match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
        {
         scoreNamejComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        }       
        for(Personnel personnel: match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
        {
         scoreNamejComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        }  
        
        assistNamejComboBox.removeAllItems();
        for(Personnel personnel: match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
        {
         assistNamejComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        }         
        for(Personnel personnel: match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
        {
         assistNamejComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        }  
        assistNamejComboBox.addItem("N/A");
        
        scoreTypejComboBox.removeAllItems();
        scoreTypejComboBox.addItem("Goal");
        scoreTypejComboBox.addItem("Owngoal");
        scoreTypejComboBox.addItem("Penalty");
        
        subPlayerjComboBox.removeAllItems();
        for(Personnel personnel: match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
        {
         subPlayerjComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        }   
        
        for(Personnel personnel: match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
        {
         subPlayerjComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        }  
        
        
        subjComboBox.removeAllItems();
        for(Personnel personnel: match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
        {
         subjComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        }   
        
        for(Personnel personnel: match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
        {
         subjComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        } 
        
        yellowjComboBox.removeAllItems();
        for(Personnel personnel: match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
        {
         yellowjComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        }   
        
        for(Personnel personnel: match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
        {
         yellowjComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        } 
        
        redjComboBox.removeAllItems();
        for(Personnel personnel: match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
        {
         redjComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        }   
        
        for(Personnel personnel: match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
        {
         redjComboBox.addItem("ID: " + personnel.getId() + " " + personnel.getName());    
        }       
    }
    
    private void populateScoreTable() {
        DefaultTableModel dtm = (DefaultTableModel)scorejTable.getModel();
        dtm.setRowCount(0);
        
        for(MatchEvent matchEvent: match.getMatchReport().getScoreEvent())
        {
          Object[] row = new Object[4];
          row[0] = "ID: " + matchEvent.getPlayer1().getId() + " " + matchEvent.getPlayer1().getName();
          if(matchEvent.getPlayer2()==null)
              row[1] = "N/A";
          else row[1] = "ID: " + matchEvent.getPlayer2().getId() + " " + matchEvent.getPlayer2().getName();
          
          row[2] = String.valueOf(matchEvent.getTime());
          row[3] = matchEvent.getType();                                  
          dtm.addRow(row);      
        }
        
        
    }

    private void populateSubTable() {
        DefaultTableModel dtm = (DefaultTableModel)substitutionjTable.getModel();
        dtm.setRowCount(0);
        
        for(MatchEvent matchEvent: match.getMatchReport().getSubEvent())
        {
          Object[] row = new Object[3];
          row[0] = "ID: " + matchEvent.getPlayer1().getId() + " " + matchEvent.getPlayer1().getName();
          row[1] = "ID: " + matchEvent.getPlayer2().getId() + " "+ matchEvent.getPlayer2().getName();       
          row[2] = String.valueOf(matchEvent.getTime());
                   
          dtm.addRow(row);      
        }
    }

    private void populateYellowTable() {
        DefaultTableModel dtm = (DefaultTableModel)yellowjTable.getModel();
        dtm.setRowCount(0);
        for(MatchEvent matchEvent: match.getMatchReport().getYellowEvent())
        {
          Object[] row = new Object[2];
          row[0] = "ID: " + matchEvent.getPlayer1().getId()+" "+ matchEvent.getPlayer1().getName();  
          row[1] = String.valueOf(matchEvent.getTime());
                   
          dtm.addRow(row);      
        }
    }

    private void populateRedTable() {
        DefaultTableModel dtm = (DefaultTableModel)redjTable.getModel();
        dtm.setRowCount(0);
        
        for(MatchEvent matchEvent: match.getMatchReport().getRedEvent())
        {
          Object[] row = new Object[2];
          row[0] = "ID: " + matchEvent.getPlayer1().getId()+" "+ matchEvent.getPlayer1().getName();  
          row[1] = String.valueOf(matchEvent.getTime());
                   
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

        matchInfojLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        winnerjComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        club1ScorejTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        club2ScorejTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scorejTable = new javax.swing.JTable();
        matchInfojLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        substitutionjTable = new javax.swing.JTable();
        matchInfojLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        yellowjTable = new javax.swing.JTable();
        matchInfojLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        redjTable = new javax.swing.JTable();
        scoreNamejComboBox = new javax.swing.JComboBox<>();
        assistNamejComboBox = new javax.swing.JComboBox<>();
        scoreTypejComboBox = new javax.swing.JComboBox<>();
        subPlayerjComboBox = new javax.swing.JComboBox<>();
        subjComboBox = new javax.swing.JComboBox<>();
        yellowjComboBox = new javax.swing.JComboBox<>();
        redjComboBox = new javax.swing.JComboBox<>();
        timeScorejTextField = new javax.swing.JTextField();
        timeSubjTextField = new javax.swing.JTextField();
        timeYellowjTextField = new javax.swing.JTextField();
        timeRedjTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        addScoreBtn = new javax.swing.JButton();
        addSubBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        addYellowBtn = new javax.swing.JButton();
        addRedBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        matchInfojLabel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        matchInfojLabel.setText("Match Information:");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Winner :");

        winnerjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Scores :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Club1 :");

        club1ScorejTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Club2 :");

        club2ScorejTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("VS");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Score Information :");

        scorejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Score Player", "Assist Player", "Time", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(scorejTable);
        if (scorejTable.getColumnModel().getColumnCount() > 0) {
            scorejTable.getColumnModel().getColumn(0).setResizable(false);
            scorejTable.getColumnModel().getColumn(1).setResizable(false);
            scorejTable.getColumnModel().getColumn(2).setResizable(false);
            scorejTable.getColumnModel().getColumn(3).setResizable(false);
        }

        matchInfojLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        matchInfojLabel7.setText("Substitution Information :");

        substitutionjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Substitute", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(substitutionjTable);
        if (substitutionjTable.getColumnModel().getColumnCount() > 0) {
            substitutionjTable.getColumnModel().getColumn(0).setResizable(false);
            substitutionjTable.getColumnModel().getColumn(1).setResizable(false);
            substitutionjTable.getColumnModel().getColumn(2).setResizable(false);
        }

        matchInfojLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        matchInfojLabel8.setText("Yellow Card Information :");

        yellowjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(yellowjTable);
        if (yellowjTable.getColumnModel().getColumnCount() > 0) {
            yellowjTable.getColumnModel().getColumn(0).setResizable(false);
            yellowjTable.getColumnModel().getColumn(1).setResizable(false);
        }

        matchInfojLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        matchInfojLabel9.setText("Red Card Information :");

        redjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(redjTable);
        if (redjTable.getColumnModel().getColumnCount() > 0) {
            redjTable.getColumnModel().getColumn(0).setResizable(false);
            redjTable.getColumnModel().getColumn(1).setResizable(false);
        }

        scoreNamejComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        assistNamejComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        scoreTypejComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        subPlayerjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        subjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        yellowjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        redjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        timeScorejTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        timeSubjTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        timeYellowjTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        timeRedjTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Score Player Name :");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Assist Player Name :");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Time :");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Type :");

        addScoreBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addScoreBtn.setText("Add");
        addScoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addScoreBtnActionPerformed(evt);
            }
        });

        addSubBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addSubBtn.setText("Add");
        addSubBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSubBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backBtn.setText("Confirm & Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        addYellowBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addYellowBtn.setText("Add");
        addYellowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addYellowBtnActionPerformed(evt);
            }
        });

        addRedBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addRedBtn.setText("Add");
        addRedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRedBtnActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Player Name :");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Substitute Name :");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Time :");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Player Name :");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Time :");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Player Name :");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Time :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subPlayerjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timeSubjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(addSubBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yellowjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(timeYellowjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(addYellowBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(redjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(timeRedjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(addRedBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(matchInfojLabel7)
                        .addComponent(matchInfojLabel8)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(matchInfojLabel9)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scoreNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(assistNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(timeScorejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scoreTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(addScoreBtn))
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2)
                        .addComponent(matchInfojLabel)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(winnerjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(48, 48, 48)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(club1ScorejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jLabel5)
                            .addGap(32, 32, 32)
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(club2ScorejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(backBtn))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(matchInfojLabel)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(winnerjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(club1ScorejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(club2ScorejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(backBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(scoreNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(assistNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(timeScorejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(scoreTypejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addScoreBtn))
                .addGap(18, 18, 18)
                .addComponent(matchInfojLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(subPlayerjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(subjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(timeSubjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addSubBtn))
                .addGap(18, 18, 18)
                .addComponent(matchInfojLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(yellowjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(timeYellowjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addYellowBtn))
                .addGap(18, 18, 18)
                .addComponent(matchInfojLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(redjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(timeRedjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRedBtn))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addScoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addScoreBtnActionPerformed
        // TODO add your handling code here:
        int scoreId = Integer.valueOf(((String)scoreNamejComboBox.getSelectedItem()).split(" ")[1]);
        String assistItem = (String)assistNamejComboBox.getSelectedItem();
        int assistId = Integer.MAX_VALUE;
        if(!assistItem.equals("N/A"))
           assistId = Integer.valueOf(((String)assistNamejComboBox.getSelectedItem()).split(" ")[1]);
        
        int time = 0;
        try{
            time = Integer.valueOf(timeScorejTextField.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please give right format time for score information!",null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String type = (String) scoreTypejComboBox.getSelectedItem();
        
        Personnel scorePlayer = null;
        for(Personnel p:match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
        {
          if(p.getId()==scoreId)
          {
           scorePlayer = p;
           break;
          }
        
        }
        
        if(scorePlayer == null)
        {
          for(Personnel p:match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
          {
           if(p.getId()==scoreId)
           {
            scorePlayer = p;
            break;
           }    
           }   
        }
        
        Personnel assistPlayer = null;
        if(!assistItem.equals("N/A"))
        {
            for(Personnel p:match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
            {
             if(p.getId()==assistId)
             {
              assistPlayer = p;
              break;
            }
        
           }       
        if(assistPlayer == null)
        {
          for(Personnel p:match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
          {
           if(p.getId()== assistId)
           {
            scorePlayer = p;
            break;
           }    
          }   
        }
       }       
        
       match.getMatchReport().getScoreEvent().add(new MatchEvent(scorePlayer,assistPlayer,time,type));
       populateScoreTable();
        
    }//GEN-LAST:event_addScoreBtnActionPerformed

    private void addSubBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSubBtnActionPerformed
        // TODO add your handling code here:
        int subPlayerId = Integer.valueOf(((String)subPlayerjComboBox.getSelectedItem()).split(" ")[1]);
        int subId = Integer.valueOf(((String)subjComboBox.getSelectedItem()).split(" ")[1]);
        
        int time = 0;
        
        try{
            time = Integer.valueOf(timeSubjTextField.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please give right format time for substitution information!",null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        Personnel subPlayer = null;
        for(Personnel p:match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
        {
          if(p.getId() == subPlayerId)
          {
           subPlayer = p;
           break;
          }
        
        }
        
        if(subPlayer == null)
        {
          for(Personnel p:match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
          {
           if(p.getId() == subPlayerId)
           {
            subPlayer = p;
            break;
           }    
          }   
        }
        
        Personnel sub = null;
        for(Personnel p:match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
           {
             if(p.getId()==subId)
             {
              sub = p;
              break;
            }
        
           }       
        if(sub == null)
        {
          for(Personnel p:match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
          {
           if(p.getId()== subId)
           {
            sub = p;
            break;
           }    
          }   
        }      
       match.getMatchReport().getSubEvent().add(new MatchEvent(subPlayer,sub,time,"sub"));
       populateSubTable();
    }//GEN-LAST:event_addSubBtnActionPerformed

    private void addYellowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addYellowBtnActionPerformed
        // TODO add your handling code here:
        int playerId = Integer.valueOf(((String)yellowjComboBox.getSelectedItem()).split(" ")[1]);
        int time = 0;
        
        try{
            time = Integer.valueOf(timeYellowjTextField.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please give right format time for yellow card information!",null, JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        
        Personnel player = null;
        for(Personnel p:match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
        {
          if(p.getId()==playerId)
          {
           player = p;
           break;
          }
        
        }
        
        if(player == null)
        {
          for(Personnel p:match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
          {
           if(p.getId()==playerId)
           {
            player = p;
            break;
           }    
          }   
        }       
        match.getMatchReport().getYellowEvent().add(new MatchEvent(player,null,time,"yellow"));  
        populateYellowTable();
    }//GEN-LAST:event_addYellowBtnActionPerformed

    private void addRedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRedBtnActionPerformed
        // TODO add your handling code here:
        
        int playerId = Integer.valueOf(((String)redjComboBox.getSelectedItem()).split(" ")[1]);     
        int time = 0;
        
        try{
            time = Integer.valueOf(timeRedjTextField.getText());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please give right format time for red card information!",null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        Personnel player = null;
        for(Personnel p:match.getMatchReport().getClub1PlayerMatchDirectory().getPersonnelList())
        {
          if(p.getId()==playerId)
          {
           player = p;
           break;
          }
        
        }
        
        if(player == null)
        {
          for(Personnel p:match.getMatchReport().getClub2PlayerMatchDirectory().getPersonnelList())
          {
           if(p.getId()==playerId)
           {
            player = p;
            break;
           }    
          }   
        }       
        match.getMatchReport().getRedEvent().add(new MatchEvent(player,null,time,"red"));  
        populateRedTable();
    }//GEN-LAST:event_addRedBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        try{
            match.getMatchReport().setClub1Score(Integer.valueOf(club1ScorejTextField.getText()));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please give right format goal information for club1!",null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try{
            match.getMatchReport().setClub2Score(Integer.valueOf(club2ScorejTextField.getText()));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please give right format goal information for club2!",null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to provide this match report? (You cannot change this report when you exit.)", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
        match.getMatchReport().setWinner((String)winnerjComboBox.getSelectedItem());
        match.setMatchReportProvided(true);
        
        league.getLeagueStatistics().addToStatistics(match);
        
        container.remove(this);
        
        Component[] componentArray = container.getComponents();
        Component component1 = componentArray[componentArray.length - 1];
        Component component2 = componentArray[componentArray.length - 2];
        
        container.remove(component1);       
        ManageMatchReportJPanel panel = (ManageMatchReportJPanel) component2;
        
        panel.populateTable();
        
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
        }
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRedBtn;
    private javax.swing.JButton addScoreBtn;
    private javax.swing.JButton addSubBtn;
    private javax.swing.JButton addYellowBtn;
    private javax.swing.JComboBox<String> assistNamejComboBox;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField club1ScorejTextField;
    private javax.swing.JTextField club2ScorejTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel matchInfojLabel;
    private javax.swing.JLabel matchInfojLabel7;
    private javax.swing.JLabel matchInfojLabel8;
    private javax.swing.JLabel matchInfojLabel9;
    private javax.swing.JComboBox<String> redjComboBox;
    private javax.swing.JTable redjTable;
    private javax.swing.JComboBox<String> scoreNamejComboBox;
    private javax.swing.JComboBox<String> scoreTypejComboBox;
    private javax.swing.JTable scorejTable;
    private javax.swing.JComboBox<String> subPlayerjComboBox;
    private javax.swing.JComboBox<String> subjComboBox;
    private javax.swing.JTable substitutionjTable;
    private javax.swing.JTextField timeRedjTextField;
    private javax.swing.JTextField timeScorejTextField;
    private javax.swing.JTextField timeSubjTextField;
    private javax.swing.JTextField timeYellowjTextField;
    private javax.swing.JComboBox<String> winnerjComboBox;
    private javax.swing.JComboBox<String> yellowjComboBox;
    private javax.swing.JTable yellowjTable;
    // End of variables declaration//GEN-END:variables

}
