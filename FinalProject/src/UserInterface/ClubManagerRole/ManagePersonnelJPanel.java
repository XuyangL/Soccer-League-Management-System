/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClubManagerRole;

import Business.Club.Club;
import Business.EcoSystem;
import Business.League.League;
import Business.Match.Match;
import Business.Match.MatchDay;
import Business.Organization.Organization;
import Business.Organization.PlayerOrganization;
import Business.Personnel.Personnel;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lixuy
 */
public class ManagePersonnelJPanel extends javax.swing.JPanel {

    private JPanel container;
    private Club club;
    private EcoSystem system;

    /**
     * Creates new form ManagePersonnelJPanel
     */
    public ManagePersonnelJPanel(JPanel container, EcoSystem system, Club club) {

        initComponents();
        this.container = container;
        this.club = club;
        this.system = system;
        organizationjComboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String comboString = (String) organizationjComboBox.getSelectedItem();
                    for (Organization organization : club.getOrganizationDirectory().getOrganizationList()) {
                        if (comboString.equals(organization.getName())) {
                            populateTable(organization);
                            break;
                        }
                    }

                }
            }
        });

        initComboBox();
        initComboBox2();

    }

    public void initComboBox() {
        organizationjComboBox.removeAllItems();
        for (Organization organization : club.getOrganizationDirectory().getOrganizationList()) {
            organizationjComboBox.addItem(organization.getName());
        }

        if (club.getOrganizationDirectory().getOrganizationList().size() != 0) {
            organizationjComboBox.setSelectedIndex(0);
        }
    }

    public void initComboBox2() {

        targetOrganizationjComboBox.removeAllItems();
        for (Organization organization : club.getOrganizationDirectory().getOrganizationList()) {
            if (!(organization.getName().equals("Coach Organization") || organization.getName().equals("Club Manager Organization"))) {
                targetOrganizationjComboBox.addItem(organization.getName());
            }
        }
    }

    private void populateTable(Organization organization) {

        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        dtm.setRowCount(0);

        for (Personnel personnel : organization.getPersonnelDirectory().getPersonnelList()) {
            Object[] row = new Object[2];
            row[0] = personnel.getId();
            row[1] = personnel;
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

        organizationjComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        addPlayerTeamBtn = new javax.swing.JButton();
        playerTeamNamejTextField = new javax.swing.JTextField();
        addPersonnelBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        targetOrganizationjComboBox = new javax.swing.JComboBox<>();
        changeTeamBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        transferBtn = new javax.swing.JButton();

        organizationjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Organization");

        addPlayerTeamBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addPlayerTeamBtn.setText("Add New Player Team");
        addPlayerTeamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlayerTeamBtnActionPerformed(evt);
            }
        });

        playerTeamNamejTextField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        addPersonnelBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addPersonnelBtn.setText("Add Personnel to Organization");
        addPersonnelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPersonnelBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Name of the Player Team :");

        targetOrganizationjComboBox.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        changeTeamBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        changeTeamBtn.setText("Change Player Team");
        changeTeamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTeamBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        transferBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        transferBtn.setText("Transfer Player");
        transferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(organizationjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addPersonnelBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(targetOrganizationjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(changeTeamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(transferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addPlayerTeamBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(playerTeamNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(organizationjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addPersonnelBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(changeTeamBtn)
                        .addComponent(transferBtn))
                    .addComponent(targetOrganizationjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerTeamNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(addPlayerTeamBtn))
                .addGap(49, 49, 49)
                .addComponent(backBtn)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changeTeamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeTeamBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = jTable.getSelectedRow();
        if (selectedrow >= 0) {
            Personnel personnel = (Personnel) jTable.getValueAt(selectedrow, 1);
            String beforeOrganizationName = (String) organizationjComboBox.getSelectedItem();
            String targetOrganizationName = (String) targetOrganizationjComboBox.getSelectedItem();
            UserAccount targetUserAccount = null;
            for (Organization organization : club.getOrganizationDirectory().getOrganizationList()) {
                int flag = 0;
                if (beforeOrganizationName.equals(organization.getName())) {
                    if(organization instanceof PlayerOrganization)
                    {
                     for (Personnel p : organization.getPersonnelDirectory().getPersonnelList()) {
                        if (personnel == p) {
                            organization.getPersonnelDirectory().getPersonnelList().remove(p);
                            for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                                if (userAccount.getPersonnel() == p) {
                                    organization.getUserAccountDirectory().getUserAccountList().remove(userAccount);
                                    targetUserAccount = userAccount;
                                    break;
                                }
                            }
                            flag = 1;
                            break;
                        }
                    }
                  }
                    
                else {
                        JOptionPane.showMessageDialog(null, "Please select a player from the table!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
            }
            for (Organization organization : club.getOrganizationDirectory().getOrganizationList()) {
                if (targetOrganizationName.equals(organization.getName())) {
                    organization.getPersonnelDirectory().getPersonnelList().add(targetUserAccount.getPersonnel());
                    organization.getUserAccountDirectory().getUserAccountList().add(targetUserAccount);
                    break;
                }
            }
            initComboBox();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a personnel from the table first!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_changeTeamBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed

    private void addPlayerTeamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerTeamBtnActionPerformed
        // TODO add your handling code here:
        String teamName = playerTeamNamejTextField.getText();
        if (teamName.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in all blanks!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        for (Organization o : club.getOrganizationDirectory().getOrganizationList()) {
            if (o.getName().equals(teamName)) {
                JOptionPane.showMessageDialog(null, "Duplicated name! Please try another one!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        club.getOrganizationDirectory().createOrganization(Organization.Type.PlayerOrganization, teamName);
        JOptionPane.showMessageDialog(null, teamName + " successfully added!", "Successful", JOptionPane.INFORMATION_MESSAGE);

        initComboBox();
        initComboBox2();
    }//GEN-LAST:event_addPlayerTeamBtnActionPerformed

    private void addPersonnelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonnelBtnActionPerformed
        // TODO add your handling code here:
        String organizationName = (String) organizationjComboBox.getSelectedItem();
        for (Organization organization : club.getOrganizationDirectory().getOrganizationList()) {
            if (organizationName.equals(organization.getName())) {
                CreatePersonnelJPanel panel = new CreatePersonnelJPanel(container, system, organization);
                container.add("CreatePersonnelJPanel", panel);
                CardLayout layout = (CardLayout) container.getLayout();
                layout.next(container);
                break;
            }
        }
    }//GEN-LAST:event_addPersonnelBtnActionPerformed

    private void transferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = jTable.getSelectedRow();
        if (selectedrow >= 0) {
            Personnel personnel = (Personnel) jTable.getValueAt(selectedrow, 1);
            String beforeOrganizationName = (String) organizationjComboBox.getSelectedItem();

            for (Organization organization : club.getOrganizationDirectory().getOrganizationList()) {
                int flag = 0;
                if (beforeOrganizationName.equals(organization.getName())) {
                    if(organization instanceof PlayerOrganization)
                    {
                    for(League league : system.getLeagueDirectory().getLeagueList())
                    {    for(MatchDay matchDay: league.getMatchDayDirectory().getMatchDayList())
                         {    for(Match match: matchDay.getMatchList())
                                 {
                                  if(!match.isMatchReportProvided())
                                  {
                                   JOptionPane.showMessageDialog(null, "League has begun, transfer market closed!", "Warning", JOptionPane.WARNING_MESSAGE);               
                                   return;
                                   }
                            }
                         }
                    }
                    
                    for (Personnel p : organization.getPersonnelDirectory().getPersonnelList()) {
                        if (personnel == p) {
                            organization.getPersonnelDirectory().getPersonnelList().remove(p);

                            for (UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountList()) {
                                if (userAccount.getPersonnel() == p) {
                                    organization.getUserAccountDirectory().getUserAccountList().remove(userAccount);
                                    system.getFreePlayerPool().getUserAccountList().add(userAccount);
                                    break;
                                }
                            }
                            flag = 1;
                            break;
                        }

                     }
                   }
                    else JOptionPane.showMessageDialog(null, "Please select a player from the table!", "Warning", JOptionPane.WARNING_MESSAGE);            

                }

                if (flag == 1) {
                    break;
                }

            }

            initComboBox();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a personnel from the table first!", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_transferBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPersonnelBtn;
    private javax.swing.JButton addPlayerTeamBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton changeTeamBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JComboBox<String> organizationjComboBox;
    private javax.swing.JTextField playerTeamNamejTextField;
    private javax.swing.JComboBox<String> targetOrganizationjComboBox;
    private javax.swing.JButton transferBtn;
    // End of variables declaration//GEN-END:variables

}
