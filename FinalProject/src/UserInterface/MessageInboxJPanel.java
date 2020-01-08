/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.MessageQueue.Message;
import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lixuy
 */
public class MessageInboxJPanel extends javax.swing.JPanel {

    private UserAccount userAccount;
    private JSplitPane jSplitPane;
    private String type;
    /**
     * Creates new form MessageInboxJPanel
     */

    public MessageInboxJPanel(UserAccount userAccount,JSplitPane jSplitPane,String type) {
        initComponents();
        this.jSplitPane = jSplitPane;
        this.userAccount = userAccount;
        this.type = type;
        populateTable(type);
    }

     private void populateTable(String type) {
         
        DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
        dtm.setRowCount(0);
        
        if(type.equals("unread"))
        {    
           for(Message message:userAccount.getMessageQueue().getMessageList()) 
           {
             if(message.getStatus().equals("unread"))
             {
                 Object[] row = new Object[3];
             
                 row[0] = message.getSender().getUsername();
                 row[1] = message;
             
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                 row[2] = sdf.format(message.getSendDate());
             
                 dtm.addRow(row);  
             }
           
         }
        }
        
        if(type.equals("read"))
        {    
           for(Message message:userAccount.getMessageQueue().getMessageList()) 
           {
             if(message.getStatus().equals("read"))
             {
                 Object[] row = new Object[3];
             
                 row[0] = message.getSender().getUsername();
                 row[1] = message;
             
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                 row[2] = sdf.format(message.getSendDate());
             
                 dtm.addRow(row);  
             }
           
         }
        }
        
        if(type.equals("sent"))
        {    
           for(Message message:userAccount.getMessageQueue().getMessageList()) 
           {
             if(message.getStatus().equals("sent"))
             {
                 Object[] row = new Object[3];
             
                 row[0] = message.getSender().getUsername();
                 row[1] = message;
             
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                 row[2] = sdf.format(message.getSendDate());
             
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        viewBtn = new javax.swing.JButton();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Title ", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(2).setResizable(false);
        }

        viewBtn.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        viewBtn.setText("View");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewBtn)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        int selectedrow = jTable.getSelectedRow();
        if(selectedrow >= 0)
        {
            Message message = (Message) jTable.getValueAt(selectedrow,1);
            
            if(message.getStatus().equals("unread"))
               message.setStatus("read");
            
            ViewMessageJPanel panel =  new ViewMessageJPanel(message);
            jSplitPane.setRightComponent(panel);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Please select a message from the table first!","Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_viewBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables

}