/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author DELL
 */
public class TransDep extends JFrame implements ActionListener{
    String userid;
    int itotalB;
    String stotalB;
    JTextField depAmountF;
    JButton goBackB,depButt;
    TransDep(String userid){
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
        
        
        JLabel depAL=new JLabel("Enter  Amount to deposit ");
        depAL.setBounds(200,200,200,40);
        depAL.setForeground(Color.BLACK);
        depAL.setBackground(Color.WHITE);
        depAL.setOpaque(true);
        add(depAL);
        
        depAmountF=new JTextField();
        depAmountF.setBounds(200,250,200,40);
        add(depAmountF);
        
        goBackB=new JButton(" back ");
        goBackB.setBounds(560, 200, 140, 40);
        goBackB.setBackground(Color.YELLOW);
        goBackB.setForeground(Color.BLUE);
        add(goBackB);
        goBackB.addActionListener(this);
        
        depButt=new JButton(" deposit ");
        depButt.setBounds(220, 300, 140, 40);
        depButt.setBackground(Color.YELLOW);
        depButt.setForeground(Color.BLUE);
        add(depButt);
        depButt.addActionListener(this);

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
         if(ae.getSource()==depButt){
            System.out.println("deposit  pressed");
            
            int finalb=0;
            finalb=Integer.parseInt(depAmountF.getText());
            
            if(finalb<=0){
                JOptionPane.showMessageDialog(rootPane, "enter valid amount");
            }else{
                finalb= finalb + itotalB;
            Conn obj=new Conn();
                ResultSet result = null ;
                try {
                    JOptionPane.showMessageDialog(rootPane, "[ depositing money....wait]");
                    String query="  update bank_balance set totalB= "+ finalb +" where uid='" + userid + "';";
                    System.out.println(query);
                    obj.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(rootPane, "[ Money deposited successfully]");

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
//       new TransDep("S1234a");
    }
    
}
