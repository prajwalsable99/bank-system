
package bank.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TransWithdraw extends JFrame implements ActionListener {
    String userid;
    int itotalB;
    String stotalB;
    JTextField withdrawAF;
    JButton goBackB,withdrawButt;
    TransWithdraw (String userid){
        this.userid=userid;
    
    
    
     setLayout(null);       
        getContentPane().setBackground(Color.BLACK);
        setTitle("BANK OF PRAJWAL");
        
        //-------------------------------------------------------------
        
        
         Conn obj=new Conn();
        ResultSet result = null ;
        try {
            String query=" select * from bank_balance where uid='" + userid + "';";
            System.out.println(query);
            result = obj.s.executeQuery(query);
            
            while(result.next()) {
                
                stotalB=result.getString("totalB");
                itotalB=Integer.parseInt(stotalB);
                
        
             }
             System.out.println("balance "+ itotalB);

        } catch (SQLException ex) {
            System.out.println("[ error logging in ]");
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        ////////////////////////////////////////////////////////////////////////////////
        
        
        JLabel wdAL=new JLabel("Enter  Amount to withdraw ");
        wdAL.setBounds(200,200,200,40);
        wdAL.setForeground(Color.BLACK);
        wdAL.setBackground(Color.WHITE);
        wdAL.setOpaque(true);
        add(wdAL);
        
        withdrawAF=new JTextField();
        withdrawAF.setBounds(200,250,200,40);
        add(withdrawAF);
        
        goBackB=new JButton(" back ");
        goBackB.setBounds(560, 200, 140, 40);
        goBackB.setBackground(Color.YELLOW);
        goBackB.setForeground(Color.BLUE);
        add(goBackB);
        goBackB.addActionListener(this);
        
        withdrawButt=new JButton(" withdraw ");
        withdrawButt.setBounds(220, 300, 140, 40);
        withdrawButt.setBackground(Color.YELLOW);
        withdrawButt.setForeground(Color.BLUE);
        add(withdrawButt);
        withdrawButt.addActionListener(this);

        setSize(800,550);
        setVisible(true);
        setLocation(50,50);
        
    
    
    
    
    
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==goBackB){
            System.out.println("go back pressed");
            JOptionPane.showMessageDialog(rootPane, "[ end of session...]");
            setVisible(false);
            
           new AccountPage(userid);
            
            
        }
         if(ae.getSource()==withdrawButt){
            
             
             int atw= Integer.parseInt(withdrawAF.getText());
             if(atw <1){
                 JOptionPane.showMessageDialog(rootPane, "enter valid amount to withdraw");
             }
             else if(atw> itotalB){
                 JOptionPane.showMessageDialog(rootPane, "not sufficient balance");
             }
             else{
                    Conn obj=new Conn();
                 JOptionPane.showMessageDialog(rootPane, "withdrawing");
                 int finalb=itotalB-atw;
                 try {
            
                String query="  update bank_balance set totalB= "+ finalb +" where uid='" + userid + "';";
                System.out.println(query);
                obj.s.executeUpdate(query);

                JOptionPane.showMessageDialog(rootPane, "[ Money withdrawn successfully]");

                } catch (Exception ex) {
                    System.out.println("[ error doing transaction]");
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
                  setVisible(false);
            
                new AccountPage(userid); 
                 
             }
            
        }
    }
    public static void main(String [] args){
//       new TransWithdraw("S1234a");
    }
}
