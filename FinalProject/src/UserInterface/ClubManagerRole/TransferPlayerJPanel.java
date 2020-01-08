/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ClubManagerRole;

import Business.Club.Club;
import Business.EcoSystem;
import Business.Organization.Organization;
import Business.Personnel.Personnel;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lixuy
 */
public class TransferPlayerJPanel extends javax.swing.JPanel {

    private JPanel container;
    private Club club;
    private EcoSystem system;
    /**
     * Creates new form TransferPlayerJPanel
     */
    public TransferPlayerJPanel(JPanel container, Club club, EcoSystem system) {
        initComponents();
        this.container = container;
        this.club = club;
        this.system = system;
        populateTable();
    }
    
    private void populateTable() {
        
        DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
        dtm.setRowCount(0);
      
        for(UserAccount userAccount: system.getFreePlayerPool().getUserAccountList()) 
        {
             Object[] row = new Object[3];
             row[0] = userAccount.getPersonnel().getId();
             row[1] = userAccount;    
             row[2] = userAccount.getPersonnel().getName();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        signBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Free Player under the Soccer Association :");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "UserAccount Name", "Player Name"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        backBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        signBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        signBtn.setText("Sign");
        signBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signBtnActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(signBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signBtn)
                .addGap(9, 9, 9)
                .addComponent(backBtn)
                .addContainerGap(201, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed

    private void signBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = jTable.getSelectedRow();
        if(selectedrow >= 0)
        {
          UserAccount userAccount = (UserAccount) jTable.getValueAt(selectedrow,1);
          for(Organization organization: club.getOrganizationDirectory().getOrganizationList())
          {
           if(organization.getName().equals("First Team"))
           {
            organization.getPersonnelDirectory().getPersonnelList().add(userAccount.getPersonnel());
            organization.getUserAccountDirectory().getUserAccountList().add(userAccount);
            system.getFreePlayerPool().getUserAccountList().remove(userAccount);
            populateTable();
            break;
           }
          }
        }
        
        else
        {
            JOptionPane.showMessageDialog(null,"Please select a player from the table first!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_signBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton signBtn;
    // End of variables declaration//GEN-END:variables

}