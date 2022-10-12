package bank.management.system;
import bank.management.system.Conn;
import bank.management.system.SignUp;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class AccountPage extends JFrame implements ActionListener{
    
        String uid,uname,uadhar,udob,uemail,umob,uadd,ugender;
        JButton depositB,withdrawB,CheckBalanceB,exitB;
        AccountPage(String userid){
            
            uid=userid;
   
            
  
          // --------------------------------------------------------
        setLayout(null);       
        getContentPane().setBackground(Color.darkGray);
        setTitle("BANK OF PRAJWAL");
        
        //-------------------------------------------------------------
         Conn obj=new Conn();
        ResultSet result = null ;
        try {
            String query=" select * from accountsigned where uid='" + userid + "';";
            System.out.println(query);
            result = obj.s.executeQuery(query);
            
            while(result.next()) {
                
                uid=result.getString("uid");
                uname=result.getString("uname");
                uadhar=result.getString("uadhar");
                uemail=result.getString("uemail");
                umob=result.getString("umob");
                uadd=result.getString("uadd");
                udob=result.getString("udob");
                ugender=result.getString("ugender");
                
 
         
             }

        } catch (SQLException ex) {
            System.out.println("[ error logging in ]");
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        System.out.println(uid);
//        System.out.println(uname);
//        System.out.println(ugender);
//        System.out.println(udob);
//        System.out.println(uadhar);
//        System.out.println(uemail);
//        System.out.println(umob);
//        System.out.println(uadd);

        JLabel bn=new JLabel("BANK OF PRAJWAL" ,SwingConstants.CENTER);
        bn.setBounds(50,10,850,30);
        bn.setForeground(Color.WHITE);
        bn.setBackground(Color.blue);
        bn.setOpaque(true);
        add(bn);
        
        JLabel lid=new JLabel("   [ ACCOUNT ID ] : "+uid.toUpperCase());
        lid.setBounds(50,50,200,30);
        lid.setForeground(Color.blue);
        lid.setBackground(Color.lightGray);
        lid.setOpaque(true);

        add(lid);
        
        JLabel lname=new JLabel("  [ ACCOUNT-HOLDER ] : "+uname.toUpperCase());
        lname.setBounds(300,50,350,30);
        add(lname);
        lname.setForeground(Color.blue);
        lname.setBackground(Color.lightGray);
        lname.setOpaque(true);
        
        JLabel lgender=new JLabel("  [ GENDER ] : "+ugender.toUpperCase());
        lgender.setBounds(700,50,200,30);
        lgender.setForeground(Color.blue);
        lgender.setBackground(Color.lightGray);
        lgender.setOpaque(true);
        add(lgender);
        
        
        ImageIcon ad=new ImageIcon(ClassLoader.getSystemResource("icons/myad.jpg"));
        Image ad_sc=ad.getImage().getScaledInstance(300, 550, Image.SCALE_DEFAULT);
        ImageIcon finalad=new ImageIcon(ad_sc);
        
        JLabel fad=new JLabel(finalad);
        fad.setBounds(925,50,300 ,550);
        add(fad);
//        
        JLabel lemail=new JLabel("  [ EMAIL ] : "+uemail);
        lemail.setBounds(50,100,200,30);
        lemail.setForeground(Color.blue);
        lemail.setBackground(Color.lightGray);
        lemail.setOpaque(true);
        add(lemail);
        
        JLabel lmob=new JLabel(" [ MOBILE ] : "+umob.toUpperCase());
        lmob.setBounds(300,100,150,30);
        lmob.setForeground(Color.blue);
        lmob.setBackground(Color.lightGray);
        lmob.setOpaque(true);
        add(lmob);
        
        
        
        JLabel ldob=new JLabel(" [ DOB ] : "+udob.toUpperCase());
        ldob.setBounds(470,100,180,30);
        ldob.setForeground(Color.blue);
        ldob.setBackground(Color.lightGray);
        ldob.setOpaque(true);
        add(ldob);
        
        JLabel ladhar=new JLabel(" [ ADHAR ID ] : "+uadhar.toUpperCase());
        ladhar.setBounds(700,100,200,30);
        ladhar.setForeground(Color.blue);
        ladhar.setBackground(Color.lightGray);
        ladhar.setOpaque(true);
        add(ladhar);
//        
        //-----------------------------------------------------
        
        CheckBalanceB=new JButton("Check Balance");
        CheckBalanceB.setBounds(300, 300, 180, 40);
        CheckBalanceB.setBackground(Color.black);
        CheckBalanceB.setForeground(Color.white);
        add(CheckBalanceB);
        
        CheckBalanceB.addActionListener(this);
        
        
        depositB=new JButton(" Deposit ");
        depositB.setBounds(300, 350, 180, 40);
        depositB.setBackground(Color.black);
        depositB.setForeground(Color.white);
        add(depositB);
        
        depositB.addActionListener(this);
        
        withdrawB=new JButton("Withdraw");
        withdrawB.setBounds(300, 400, 180, 40);
        withdrawB.setBackground(Color.black);
        withdrawB.setForeground(Color.white);
        add(withdrawB);
        
        withdrawB.addActionListener(this);
       
        exitB=new JButton("exit");
        exitB.setBounds(300, 450, 180, 40);
        exitB.setBackground(Color.black);
        exitB.setForeground(Color.white);
        add(exitB);
        
        exitB.addActionListener(this);
          //----------------------------------------------------------

        setSize(1250,700);
        setVisible(true);
        setLocation(50,50);
        
        
    }
    
   
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==CheckBalanceB){
            
            setVisible(false);
            System.out.println("check balnace");
           new TransCheckBalance(uid);
            
            
        }
        if(ae.getSource()==depositB){
            System.out.println("deposit");
            setVisible(false);
             new TransDep(uid);
            
        }
        if(ae.getSource()== withdrawB){
            
            System.out.println("withdraw");
            setVisible(false);
             new TransWithdraw(uid);
            
            
        }
         if(ae.getSource()== exitB){
            
            System.out.println("exit");
            setVisible(false);
             new Login();
            
            
        }
       
    }
     public static void main(String [] args){
        
//         new AccountPage("S1234a");
        
    }
    
}
