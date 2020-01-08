/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SoccerAssociationRole;

import Business.Club.Club;
import Business.Organization.Organization;
import Business.Personnel.Personnel;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lixuy
 */
public class ViewClubJPanel extends javax.swing.JPanel {

    private JPanel container;
    private Club club;
    /**
     * Creates new form ViewClubJPanel
     */
    ViewClubJPanel(JPanel container, Club club) {
        initComponents();
        this.container = container;
        this.club = club;
        populateClubManagerTable();
        populateCoachManagerTable();
        populatePlayerTable();
    }

    public void populateClubManagerTable() {
        DefaultTableModel dtm = (DefaultTableModel) clubManagerjTable.getModel();
        dtm.setRowCount(0);
      
        for(Organization origanization: club.getOrganizationDirectory().getOrganizationList())
        {
         if (origanization.getName().equals("Club Manager Organization"))
         {
           for(Personnel personnel: origanization.getPersonnelDirectory().getPersonnelList()) 
           {
             Object[] row = new Object[2];
             row[0] = personnel.getId();
             row[1] = personnel;             
             dtm.addRow(row);      
           }
         }
        }
    }

    public void populateCoachManagerTable() {
        DefaultTableModel dtm = (DefaultTableModel)coachjTable.getModel();
        dtm.setRowCount(0);
      
        for(Organization origanization: club.getOrganizationDirectory().getOrganizationList())
        {
         if (origanization.getName().equals("Coach Organization"))
         {
           for(Personnel personnel: origanization.getPersonnelDirectory().getPersonnelList()) 
           {
             Object[] row = new Object[2];
             row[0] = personnel.getId();
             row[1] = personnel;             
             dtm.addRow(row);      
           }
         }
        }
        
    }

    public void populatePlayerTable() {
        DefaultTableModel dtm = (DefaultTableModel)soccerPlayerjTable.getModel();
        dtm.setRowCount(0);
      
        for(Organization origanization: club.getOrganizationDirectory().getOrganizationList())
        {
         if (!(origanization.getName().equals("Coach Organization") || origanization.getName().equals("Club Manager Organization")))
         {
           for(Personnel personnel: origanization.getPersonnelDirectory().getPersonnelList()) 
           {
             Object[] row = new Object[2];
             row[0] = personnel.getId();
             row[1] = personnel;             
             dtm.addRow(row);      
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clubManagerjTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        coachjTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        soccerPlayerjTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Club: ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Club Manager :");

        clubManagerjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Manager Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(clubManagerjTable);
        if (clubManagerjTable.getColumnModel().getColumnCount() > 0) {
            clubManagerjTable.getColumnModel().getColumn(0).setResizable(false);
            clubManagerjTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Soccer Player :");

        coachjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Coach Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(coachjTable);
        if (coachjTable.getColumnModel().getColumnCount() > 0) {
            coachjTable.getColumnModel().getColumn(0).setResizable(false);
            coachjTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Coach :");

        soccerPlayerjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Plager Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(soccerPlayerjTable);
        if (soccerPlayerjTable.getColumnModel().getColumnCount() > 0) {
            soccerPlayerjTable.getColumnModel().getColumn(0).setResizable(false);
            soccerPlayerjTable.getColumnModel().getColumn(1).setResizable(false);
        }

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
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backBtn)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageClubJPanel panel = (ManageClubJPanel) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTable clubManagerjTable;
    private javax.swing.JTable coachjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable soccerPlayerjTable;
    // End of variables declaration//GEN-END:variables

}