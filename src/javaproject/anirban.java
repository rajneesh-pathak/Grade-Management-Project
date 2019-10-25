/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class anirban extends javax.swing.JFrame {

    /**
     * Creates new form 
     */
    public anirban() {
        initComponents();
        fillTable();
    }
    
    public ArrayList<anirbanBean> retriveData(){
        ArrayList<anirbanBean> al=null;
        al=new ArrayList<anirbanBean>();
        Connection conn=null;
        try{
            conn= MySqlConnection();
            String q = "select Reg_id,Name,Roll,MA401,CS413 from students";
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(q);
            anirbanBean student;
            while(rs.next()){
                student = new anirbanBean(rs.getString("Reg_id"),rs.getString("Name"),rs.getString("Roll"),rs.getString("MA401"),rs.getString("CS413"));
                al.add(student);
                
            }
        }
        catch(Exception e){
            System.out.println("Error in retriveData method"+e);
        }
        return al;
    }
    
    public Connection MySqlConnection(){
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root" ,"");
                //JOptionPane.showMessageDialog(null, "MySql DB Connection Successful....");
                return conn;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySql Connection Failed.....");
                return null;
            }
        }
    //FILL THE TABLE Or / SHOW THE DATA TO THE JTable
        public void fillTable(){
        ArrayList<anirbanBean> al=retriveData();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        Object[] row=new Object[5];
        for(int i=0;i<al.size();i++){
            row[0]=al.get(i).getId();
            row[1]=al.get(i).getName();
            row[2]=al.get(i).getRoll();
            row[3]=al.get(i).getMA401();
            row[4]=al.get(i).getCS413();
            model.addRow(row);
        }        
    }

         public void showItemToFields(int index){        
        jTextField_id.setText(retriveData().get(index).getId());
        jTextField_name.setText(retriveData().get(index).getName());                
        jTextField_roll.setText(retriveData().get(index).getRoll());
        jTextField_MA401.setText(retriveData().get(index).getMA401());
        jTextField_CS413.setText(retriveData().get(index).getCS413());
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_roll = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        jTextField_MA401 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField_CS413 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton_new = new javax.swing.JButton();
        jButton_save = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setForeground(new java.awt.Color(102, 255, 51));

        jLabel1.setBackground(new java.awt.Color(51, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Dr. Anirban Login");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anir.jpg"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Reg NO.");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("ROLL NO");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("NAME");

        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("MA-401");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setText("CS-413");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("NUMERICAL METHODS");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("SCILAB");

        jButton_new.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton_new.setForeground(new java.awt.Color(0, 51, 204));
        jButton_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pic.jpg"))); // NOI18N
        jButton_new.setText("CLEAR");
        jButton_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_newActionPerformed(evt);
            }
        });

        jButton_save.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton_save.setForeground(new java.awt.Color(0, 51, 204));
        jButton_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/insert.jpg"))); // NOI18N
        jButton_save.setText("INSERT");
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jButton_update.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton_update.setForeground(new java.awt.Color(0, 51, 204));
        jButton_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/up.jpg"))); // NOI18N
        jButton_update.setText("UPDATE");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jButton_delete.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton_delete.setForeground(new java.awt.Color(0, 51, 204));
        jButton_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.jpg"))); // NOI18N
        jButton_delete.setText("DELETE");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("Search Student By Name");

        jTextField_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_searchActionPerformed(evt);
            }
        });
        jTextField_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_searchKeyReleased(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg_id", "Name", "Roll No", "MA401", "CS413"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/out2.jpg"))); // NOI18N
        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(478, 478, 478)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2)
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_roll, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_MA401))
                                    .addComponent(jLabel3))
                                .addGap(185, 185, 185)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField_CS413, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_new))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_new, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_save, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextField_roll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(jTextField_CS413, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(17, 17, 17)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(jTextField_MA401, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nameActionPerformed

    private void jButton_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_newActionPerformed
        jTextField_id.setText("");
        jTextField_name.setText("");
        jTextField_roll.setText("");
        jTextField_MA401.setText("");
        jTextField_CS413.setText("");

    }//GEN-LAST:event_jButton_newActionPerformed

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        if(jTextField_id.getText()!=null || jTextField_name.getText()!=null || jTextField_roll.getText()!=null || 
                jTextField_MA401.getText()!=null || jTextField_CS413.getText()!=null){

            try{
                Connection conn = MySqlConnection();                
                PreparedStatement ps = conn.prepareStatement("insert into students" +
                    "(Reg_id,Name,Roll,MA401,CS413) values (?,?,?,?,?)");
                ps.setString(1,jTextField_id.getText());
                ps.setString(2,jTextField_name.getText());
                ps.setString(3,jTextField_roll.getText());
                ps.setString(4,jTextField_MA401.getText());
                ps.setString(5,jTextField_CS413.getText());

                int res = ps.executeUpdate();
                fillTable();
                if(res>=1)
                {
                    JOptionPane.showMessageDialog(null,res+"Number of Student" + "inserted into DB");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Students insertion Fialed");
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            jTextField_id.setText("");
            jTextField_name.setText("");
            jTextField_roll.setText("");
            jTextField_MA401.setText("");
            jTextField_CS413.setText("");

        }
        else{
            JOptionPane.showMessageDialog(null, "All Fields are mandatory....");
        }
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        if(jTextField_id!=null || jTextField_name!=null || jTextField_roll!=null || jTextField_MA401!=null || jTextField_CS413!=null){

            String qry=null;
            PreparedStatement ps = null;
            Connection conn = MySqlConnection();

            try{
                qry="update students set Name=?,Roll=?,MA401=?,CS413=? where Reg_id=?";
                ps=conn.prepareStatement(qry);

                //ps.setString(1,jTextField_id.getText());
                ps.setString(1,jTextField_name.getText());
                ps.setString(2,jTextField_roll.getText());
                ps.setString(3,jTextField_MA401.getText());
                ps.setString(4,jTextField_CS413.getText());
                ps.setString(5,jTextField_id.getText());

                int res = ps.executeUpdate();
                fillTable();
                if(res>=1)
                {
                    JOptionPane.showMessageDialog(null,res+"Number of Student" + "Updated into DB....");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Students Updation Fialed...");
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            jTextField_id.setText("");
            jTextField_name.setText("");
            jTextField_roll.setText("");
            jTextField_MA401.setText("");
            jTextField_CS413.setText("");

        }
        else{
            JOptionPane.showMessageDialog(null, "All Fields are mandatory....");
        }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        if(jTextField_id.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the Students Registration id");
        }
        else{
            try{
                String qry="delete from students where Reg_id=?";
                Connection conn=MySqlConnection();
                PreparedStatement ps=conn.prepareStatement(qry);
                ps.setString(1, jTextField_id.getText());
                int res=ps.executeUpdate();
                fillTable();
                if(res>=1){
                    JOptionPane.showMessageDialog(null,"Patients deleted Successfully....");
                }
                else
                JOptionPane.showMessageDialog(null,"Patients deletion Failed....");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
        jTextField_id.setText("");
        jTextField_name.setText("");
        jTextField_roll.setText("");
        jTextField_MA401.setText("");
        jTextField_CS413.setText("");

    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jTextField_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_searchActionPerformed

    private void jTextField_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_searchKeyReleased
        ArrayList<anirbanBean> al=null;
        al=new ArrayList<anirbanBean>();
        String val=jTextField_search.getText().toString();
        try{
            Connection conn=MySqlConnection();
            String qry ="select Reg_id,Name,Roll,MA401,CS413 from students where name like '%"+val+"%'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            anirbanBean student;
            while(rs.next()){
                student = new anirbanBean(rs.getString("Reg_id"),rs.getString("Name"),rs.getString("Roll"),rs.getString("MA401"),rs.getString("CS413"));
                al.add(student);
            }
            DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);

            Object[] row=new Object[5];
            for(int i=0;i<al.size();i++){
                row[0]=al.get(i).getId();
                row[1]=al.get(i).getName();
                row[2]=al.get(i).getRoll();
                row[3]=al.get(i).getMA401();
                row[4]=al.get(i).getCS413();
                model.addRow(row);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jTextField_searchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int ind=jTable1.getSelectedRow();
        showItemToFields(ind);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login s = new login();
        s.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(anirban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(anirban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(anirban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(anirban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new anirban().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_new;
    private javax.swing.JButton jButton_save;
    private javax.swing.JButton jButton_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_CS413;
    private javax.swing.JTextField jTextField_MA401;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_roll;
    private javax.swing.JTextField jTextField_search;
    // End of variables declaration//GEN-END:variables
}
