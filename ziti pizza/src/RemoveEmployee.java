import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RemoveEmployee extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public static String uname;
    public RemoveEmployee() {
        initComponents();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/zitipizza?zeroDateTimeBehavior=CONVERT_TO_NULL",Login.Username,Login.Password);
            String sql="Select Emp_id , name , phone_no from Employee;";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1050, 600));

        jPanel1.setBackground(new java.awt.Color(64, 68, 67));
        jPanel1.setMaximumSize(new java.awt.Dimension(1050, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(1050, 600));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 600));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Employee ID:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(180, 240, 200, 22);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setMaximumSize(new java.awt.Dimension(5, 600));
        jSeparator2.setMinimumSize(new java.awt.Dimension(5, 600));
        jSeparator2.setPreferredSize(new java.awt.Dimension(5, 600));
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(525, 0, 5, 600);

        jTextField1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(173, 280, 180, 30);

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(565, 80, 452, 430);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BACK");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jLabel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 560, 50, 22);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("REMOVE");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jLabel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(925, 560, 90, 22);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Remove Employee");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 45, 230, 28);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>                        

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        // BACK
        dispose();
        AdminPage adminPage=new AdminPage();
        adminPage.setVisible(true);

    }

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
        // REMOVE
        try
        {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/zitipizza?zeroDateTimeBehavior=CONVERT_TO_NULL",Login.Username,Login.Password);
                String sql1="select * from employee where emp_id='"+jTextField1.getText()+"';";
                PreparedStatement ps1=conn.prepareStatement(sql1);
                ResultSet rs1=ps1.executeQuery();
                if(rs1.next())
                {
                    String sql="Delete from Login where username='"+rs1.getString("Username")+"';";
                    System.out.println(sql);

                    PreparedStatement ps=conn.prepareStatement(sql);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Employee Removed Successfully!!");
                    dispose();
                    AdminPage adminPage=new AdminPage();
                    adminPage.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Enter valid Employee id");
                }



        }

        catch (Exception e)
        {
            System.out.println(e);
        }
    }



    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}