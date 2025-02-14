/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_assignment;

import commom.TagReader;
import commom.TagValue;
import commom.TagWriter;
import commom.Tags;
import commom.User;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javafx.scene.control.TableColumn;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Meep
 */
public class SearchForm extends javax.swing.JFrame {

    static Socket conn;
    private TagReader reader;
    private TagWriter writer;
    JTable table = new JTable();
    public static List<User> AlreadyFriends;
    private String[] UserInformation;
    private String AccountName; //the login variable
    private int AccountID;
    private static String info;

    /**
     * Creates new form SearchForm
     */
    public SearchForm(String userInfor, List<User> Friends) {
        initComponents();
        setIcon();
        if (userInfor != null) {
            if (!userInfor.isEmpty()) {
                userInfor = userInfor.substring(1, userInfor.length() - 1);
                UserInformation = userInfor.split(" ");
                AccountName = UserInformation[1];
                AccountID = Integer.valueOf(UserInformation[0]);

            }
        }
        if (Friends != null) {
            if (!Friends.isEmpty()) {
                AlreadyFriends = Friends;
            } else {
                AlreadyFriends = null;
            }
        }

        setTitle("Search Friends");
        setIcon();
        noRes.setVisible(false);

        jPanel1.setLayout(new FlowLayout());
        jPanel1.setPreferredSize(new Dimension(620, 550));

        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(620, 550));
        jPanel1.add(scroll);
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
        txtSearchinput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        noRes = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Search");

        txtSearchinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchinputActionPerformed(evt);
            }
        });
        txtSearchinput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchinputKeyPressed(evt);
            }
        });

        jButton1.setText("Check");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        noRes.setForeground(new java.awt.Color(255, 51, 0));
        noRes.setText("No Result Found");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchinput, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(noRes)))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(txtSearchinput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noRes))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchinputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchinputActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String Seachinput = txtSearchinput.getText();

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SearchforFriends();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtSearchinputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchinputKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SearchforFriends();
        }
    }//GEN-LAST:event_txtSearchinputKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SearchforFriends();
        }
    }//GEN-LAST:event_jButton1KeyPressed

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
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchForm(info, AlreadyFriends).setVisible(true);
            }
        });
    }

    private void setIcon() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/chat_assignment/res/iconfinder_flower_1055057.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel noRes;
    private javax.swing.JTextField txtSearchinput;
    // End of variables declaration//GEN-END:variables

    private void SearchFriend() {
        // Addtopanel();
//    String input = txtSearchinput.getText();
//    DefaultTableModel model = (DefaultTableModel) tblSearchoutput.getModel();
////    model.setDataVector(new Object[][]{}, new Object[]{});
//    model.setRowCount(0);
////    model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
//       
//        try {
//            tblSearchoutput= new JTable(model);
//                 
//            conn = new Socket(InetAddress.getLocalHost(), 9000);
//            reader = new TagReader(conn.getInputStream());  
//            writer = new TagWriter(conn.getOutputStream()); 
//            String[] request = {Tags.SEARCH, "<"+input+">"};
//            TagValue tv = new TagValue(request[0], request[1].getBytes());
//            writer.writeTag(tv);
//            writer.flush();
//            tv = reader.getTagValue();            
//            if(tv.getTag().equals(Tags.SUCCESS)){
//                noRes.setVisible(false);
//                List<User> users= getContent(tv.getContent());
//                for(int i=0;i<users.size();i++){
//                    
//                    String name= users.get(i).getUser_name();
//                    String IP=users.get(i).getIP_addr();
//                    int status= users.get(i).getStatus();
//                    
//                    
//                    
////                    JButton btn= new JButton("JButton_"+i);  
////                    model.setDataVector(new Object[][]{{name,IP,status}}, new Object[]{"Name","Button"});
//                    model.addRow(new Object[]{name,IP,status});                     
//                    tblSearchoutput.getColumn("Button").setCellRenderer(new ButtonRenderer());
//                    tblSearchoutput.getColumn("Button").setCellEditor( new ButtonEditor(new JCheckBox()));
//                }
//                txtSearchinput.setText("");
//            }
//            else
//            {
//                noRes.setVisible(true);
//            }            
//            
//        } catch (Exception e) {
//            System.err.println("Network error");
//        }
    }

    private List<User> getContent(byte[] content) {
        String s = new String(content);
        s = s.replace("<", "");
        s = s.replace(">", "");

        String[] arrString = s.split("\\|");
        List<User> users = new ArrayList<>();

        for (String str : arrString) {
            String[] arrAttr = str.split(" ");
            users.add(new User(Integer.parseInt(arrAttr[0]), arrAttr[1], arrAttr[2], Integer.parseInt(arrAttr[3])));
        }

        return users;
    }

    private void SearchforFriends() {
        DefaultTableModel dm = new DefaultTableModel();
        dm.setRowCount(0);
        dm.setDataVector(new Object[][]{{"button 1", "foo"},
        {"button 2", "bar"}}, new Object[]{"Add_Friends", "String"});

        Object[] tblHeader = {"Name", "IP_Adress", "Status", "Add_Friends"};

        String input = txtSearchinput.getText();
        try {
//            tblSearchoutput= new JTable(dm);

            conn = new Socket(InetAddress.getLocalHost(), 9000);
            reader = new TagReader(conn.getInputStream());
            writer = new TagWriter(conn.getOutputStream());
            String[] request = {Tags.SEARCH, "<" + input + ">"};
            TagValue tv = new TagValue(request[0], request[1].getBytes());
            writer.writeTag(tv);
            writer.flush();
            tv = reader.getTagValue();
            if (tv.getTag().equals(Tags.SUCCESS)) {
                noRes.setVisible(false);
                List<User> users = getContent(tv.getContent());

                Object[][] tblData = new Object[users.size()][4];
                
                for (int i = 0; i < users.size(); i++) {

                    String name = users.get(i).getUser_name();
                    String IP = users.get(i).getIP_addr();
                    int status = users.get(i).getStatus();
                    int userID = users.get(i).getID();

                    //model.addRow(new Object[]{name,IP,status});
                    
                        tblData[i][0] = name;
                        tblData[i][1] = IP;
                        if (status == 0) {
                            tblData[i][2] = "Offline";
                        } else {
                            tblData[i][2] = "Online";
                        }
                        tblData[i][3] = AccountID + "_" + AccountName + " " + userID + "_" + name;
                       
                    
                    
                }

                dm.setDataVector(tblData, tblHeader);
                txtSearchinput.setText("");

                table.setModel(dm);
                ButtonRenderer needbtn = new ButtonRenderer();
                needbtn.setText("Suprise");
                table.getColumn("Add_Friends").setCellRenderer(needbtn);
                table.getColumn("Add_Friends").setCellEditor(new ButtonEditor(new JCheckBox()));
//                JTable table = new JTable(dm);               
//                table.getColumn("Add_Friends").setCellRenderer(new ButtonRenderer());
//                table.getColumn("Add_Friends").setCellEditor(new ButtonEditor(new JCheckBox()));
//                JScrollPane scroll = new JScrollPane(table);
//                jPanel1.add(scroll);
            } else {
                noRes.setVisible(true);
            }

        } catch (Exception e) {
            System.err.println("Network error");
        }

        ////////////////////////////////////////////////////////////////////////////////////
//    JTable table = new JTable(dm);
//    table.getColumn("Add_Friends").setCellRenderer(new ButtonRenderer());
//    table.getColumn("Add_Friends").setCellEditor(new ButtonEditor(new JCheckBox()));
//    JScrollPane scroll = new JScrollPane(table);
//    jPanel1.add(scroll);
    }

}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }

//        setText((value == null) ? "" : value.toString());
        setText("Add");
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {

    private Socket conn;
    private TagReader reader;
    private TagWriter writer;
    private String[] request;

    protected JButton button;

    private String label;

    private boolean isPushed;

    private String AccountName;
    private int AccountID;
    private String FoundName;
    private int FoundID;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "hello" : value.toString();
//        button.setText(label);
        button.setText("Add");
        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {

            String[] nameAid = label.split(" ", 2); // Format( 'loginID' '_' 'loginName' "(space)" 'FoundID' '_' 'FoundName')           
            String[] Account = nameAid[0].split("_", 2);
            String[] Found = nameAid[1].split("_", 2);

            AccountName = Account[1];
            AccountID = Integer.valueOf(Account[0]);
            FoundName = Found[1];
            FoundID = Integer.valueOf(Found[0]);
            if(AccountID!=FoundID)
            {if (checkifFriend()) {
                JOptionPane.showMessageDialog(button, "You 2 have already been friends");
            } else {
                if (RequestFriend()) {
                    JOptionPane.showMessageDialog(button, "Request Friends sent");
                } else {
                    JOptionPane.showMessageDialog(button, "Request has already sent to " + FoundName);
                }
            }
            }
            else{JOptionPane.showMessageDialog(button, "Why Request to yourself...???");}
//            JOptionPane.showMessageDialog(button, label + ": Ouch!");

        }
        isPushed = false;
        return new String(label);
    }

    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }

    private boolean checkifFriend() {
        List<User> Friends = ImportListFriends(AccountName);
        if(Friends!=null)
            for (int i = 0; i < Friends.size(); i++) {
                if (FoundID == Friends.get(i).getID()) {
                    return true;
                }
            }
        return false;
    }

    private java.util.List<User> ImportListFriends(String username) {
        String[] askF = {Tags.FIND_FRIEND, "<" + username + ">"};
        List<User> users = null;
        try {
            conn = new Socket(InetAddress.getLocalHost(), 9000);
            reader = new TagReader(conn.getInputStream());
            writer = new TagWriter(conn.getOutputStream());
            TagValue tv2 = new TagValue(askF[0], askF[1].getBytes());
            writer.writeTag(tv2);
            writer.flush();
            tv2 = reader.getTagValue();
//                System.out.println("ask: "+ tv2.getTag());
            if (tv2.getTag().equals(Tags.SUCCESS)) {
                users = getUsers(tv2.getContent());
                for (User usr : users) {
//                        System.out.println("get this: "+usr.getUser_name());
                }
            }

        } catch (Exception e) {
            System.err.println("Network error");
        }
        return users;
    }

    private java.util.List<User> getUsers(byte[] content) {
        String string = new String(content);
        string = string.replace("<", "");
        string = string.replace(">", "");

        String[] arrString = string.split("\\|");
        java.util.List<User> users = new ArrayList<>();

        for (String str : arrString) {
            String[] arrAttr = str.split(" ");
            users.add(new User(Integer.parseInt(arrAttr[0]), arrAttr[1], arrAttr[2], Integer.parseInt(arrAttr[3])));
        }
        return users;
    }

    private boolean RequestFriend() {
        String[] askF = {Tags.REQUEST, "<" + AccountName + " " + FoundName + ">"};
        List<User> users = null;
        try {
            conn = new Socket(InetAddress.getLocalHost(), 9000);
            reader = new TagReader(conn.getInputStream());
            writer = new TagWriter(conn.getOutputStream());
            TagValue tv2 = new TagValue(askF[0], askF[1].getBytes());
            writer.writeTag(tv2);
            writer.flush();
            tv2 = reader.getTagValue();
//                System.out.println("ask: "+ tv2.getTag());
            if (tv2.getTag().equals(Tags.SUCCESS)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.err.println("Network error");
        }
        return false;
    }
}
