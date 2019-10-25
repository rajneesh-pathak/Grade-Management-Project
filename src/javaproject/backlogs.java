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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class backlogs extends javax.swing.JFrame {

    /**
     * Creates new form backlogs
     */
    public backlogs() {
        initComponents();
        fillTable();
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
                JOptionPane.showMessageDialog(null,"MySql Connection Failed in project folder.....");
                return null;
            }
        }   
         public Connection MySqlConnectionBack(){
            Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/back","root" ,"");
                //JOptionPane.showMessageDialog(null, "MySql DB Connection Successful....");
                return conn;
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"MySql Connection Failed in back folder.....");
                return null;
            }
        }  
        //show or data to the table
        public ArrayList<backlogsBean> retrivedData(){
        ArrayList<backlogsBean> al=null;
        al=new ArrayList<backlogsBean>();
        Connection conn=null;
        try{
            conn= MySqlConnectionBack();
            String q = "select * from logs";
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(q);
            backlogsBean student;
            while(rs.next()){
                student = new backlogsBean(rs.getString("Reg_id"),rs.getString("Name"),
                        rs.getString("Roll"),rs.getString("MA401"),rs.getString("CS401"),rs.getString("CS402"),rs.getString("EC401"),
                        rs.getString("EC402"),rs.getString("CS411"),rs.getString("CS412"),rs.getString("CS413"));
                al.add(student);
                
            }
        }
        catch(Exception e){
            System.out.println("Error in retriveData method"+e);
        }
        return al;
    }
        
        public ArrayList<StudentBean> retriveData(){
        ArrayList<StudentBean> al=null;
        al=new ArrayList<StudentBean>();
        Connection conn=null;
        try{
            conn= MySqlConnection();
            String q = "select * from students";
            Statement st = conn.createStatement();
            ResultSet rs=st.executeQuery(q);
            StudentBean student;
            while(rs.next()){
                student = new StudentBean(rs.getString("Reg_id"),rs.getString("Name"),
                        rs.getString("Roll"),rs.getString("MA401"),rs.getString("CS401"),rs.getString("CS402"),rs.getString("EC401"),
                        rs.getString("EC402"),rs.getString("CS411"),rs.getString("CS412"),rs.getString("CS413"));
                al.add(student);
                
            }
        }
        catch(Exception e){
            System.out.println("Error in retriveData method"+e);
        }
        return al;
    }
        
    //FILL THE TABLE Or / SHOW THE DATA TO THE JTable
        public void fillTable(){
        ArrayList<backlogsBean> al=retrivedData();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        Object[] row=new Object[11];
        for(int i=0;i<al.size();i++){
            row[0]=al.get(i).getId();
            row[1]=al.get(i).getName();
            row[2]=al.get(i).getRoll();
            row[3]=al.get(i).getMA401();
            row[4]=al.get(i).getCS401();
            row[5]=al.get(i).getCS402();
            row[6]=al.get(i).getEC401();
            row[7]=al.get(i).getEC402();  
            row[8]=al.get(i).getCS411();
            row[9]=al.get(i).getCS412();
            row[10]=al.get(i).getCS413();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg_id", "Name", "Roll", "MA401", "CS401", "CS402", "EC401", "EC402", "CS411", "CS412", "CS413"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Previous Semester Backlogs");

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 255, 204));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 255, 204));
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(188, 188, 188)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i;
        int res = 0;
        String reg;
        String roll;
        String name;
        String ma401;
        String cs401;
        String cs402;
        String ec401;
        String ec402;
        String cs411;
        String cs412;
        String cs413;
        String x;
        
                ArrayList<StudentBean> al=retriveData();                
                ArrayList<backlogsBean> all=retrivedData();                
                int len = all.size();
                for( i=0;i<len;i=i+1){
                    //JOptionPane.showMessageDialog(null,"abhishek" + i);
                    String qry="delete from logs where Reg_id=?";
                    Connection con=MySqlConnectionBack();
                    x =retrivedData().get(0).getId();  
                    
                    try{
                        PreparedStatement ps = con.prepareStatement(qry);                    
                        ps.setString(1,x);
                        int re=ps.executeUpdate();
                        
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"abhishek");
                    }
                }
                
                for( i=0;i<al.size();i=i+1){ 
                    Connection con = MySqlConnectionBack(); 
                    
                                 reg = retriveData().get(i).getId();
                                 roll = retriveData().get(i).getRoll();
                                 name = retriveData().get(i).getName();
                                 if(retriveData().get(i).getMA401().equals("F") || retriveData().get(i).getMA401().equals("f"))
                                     ma401 = "F";
                                 else
                                     ma401 = "";
                                 
                                 if(retriveData().get(i).getCS401().equals("F") || retriveData().get(i).getCS401().equals("f"))
                                     cs401 = "F";
                                 else
                                     cs401 = "";
                                 
                                 if(retriveData().get(i).getCS402().equals("F") || retriveData().get(i).getCS402().equals("f"))
                                     cs402 = "F";
                                 else
                                     cs402 = "";
                                 
                                if(retriveData().get(i).getEC401().equals("F") || retriveData().get(i).getEC401().equals("f"))
                                     ec401 = "F";
                                 else
                                     ec401 = "";
                                
                                if(retriveData().get(i).getEC402().equals("F") || retriveData().get(i).getEC402().equals("f"))
                                     ec402 = "F";
                                 else
                                     ec402 = "";
                                
                                if(retriveData().get(i).getCS411().equals("F") || retriveData().get(i).getCS411().equals("f"))
                                     cs411 = "F";
                                 else
                                     cs411 = "";
                                
                                if(retriveData().get(i).getCS412().equals("F") || retriveData().get(i).getCS412().equals("f"))
                                     cs412 = "F";
                                 else
                                     cs412 = "";
                                 
                                if(retriveData().get(i).getCS413().equals("F") || retriveData().get(i).getCS413().equals("f"))
                                     cs413 = "F";
                                 else
                                     cs413 = "";
                                
                                try {                                            
                                            PreparedStatement ps = con.prepareStatement("insert into logs" + 
                                                    "(Reg_id,Name,Roll,MA401,CS401,CS402,EC401,EC402,CS411,CS412,CS413) values (?,?,?,?,?,?,?,?,?,?,?)");
                                            ps.setString(1,reg);
                                            ps.setString(2,name);
                                            ps.setString(3,roll);
                                            ps.setString(4,ma401);
                                            ps.setString(5,cs401);
                                            ps.setString(6,cs402);
                                            ps.setString(7,ec401);
                                            ps.setString(8,ec402);
                                            ps.setString(9,cs411);
                                            ps.setString(10,cs412);
                                            ps.setString(11,cs413);

                                            res = ps.executeUpdate(); 
                                }
                                catch(Exception e){
                                    JOptionPane.showMessageDialog(null,res+"Error in try and catch");
                                }
                                }                                        
                                fillTable();
                
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        StudentsForm s = new StudentsForm();
        s.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(backlogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(backlogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(backlogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(backlogs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new backlogs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}