
package bank.management.system;

import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Login extends JFrame implements ActionListener {
    JButton clear_b,sign_b,submit_b,exit_app;
    JTextField uid_f;
    JPasswordField pin_f;
    Login(){
        
        setLayout(null);        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setTitle("BANK OF PRAJWAL");
        
        ImageIcon logo=new ImageIcon(ClassLoader.getSystemResource("icons/bank_logo.jpg"));
        Image logo_Sc=logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon finalLogo=new ImageIcon(logo_Sc);
        
        JLabel label=new JLabel(finalLogo);
        label.setBounds(250,0,100,100);
        add(label);
        
        JLabel wel_txt=new JLabel("BANK OF PRAJWAL");
        wel_txt.setFont(new Font("Osward",Font.BOLD,18));
        
        wel_txt.setBounds(215,110,200,40);
        add(wel_txt);
        
        JLabel uid_l=new JLabel("ENTER ID : ");
        uid_l.setBounds(150,160,200,40);
        add(uid_l);
        
         uid_f=new JTextField();
        uid_f.setBounds(275,160,250,40);
        add(uid_f);
        
        
        JLabel pin_l=new JLabel("ENTER PIN : ");
        pin_l.setBounds(150,210,200,40);
        add(pin_l);
        
        pin_f=new JPasswordField();
        pin_f.setBounds(275,210,250,40);
        add(pin_f);
        
        submit_b=new JButton("SUBMIT");
        submit_b.setBounds(295, 260, 120, 40);
        submit_b.setBackground(Color.blue);
        submit_b.setForeground(Color.white);
        add(submit_b);
        
        submit_b.addActionListener(this);
        
        clear_b=new JButton("CLEAR");
        clear_b.setBounds(425, 260, 80, 40);
        clear_b.setBackground(Color.green);
        clear_b.setForeground(Color.black);
        add(clear_b);
        
        clear_b.addActionListener(this);
        
        sign_b=new JButton("SIGN UP");
        sign_b.setBounds(295, 310, 120, 40);
        sign_b.setBackground(Color.black);
        sign_b.setForeground(Color.white);
        add(sign_b);
        
        sign_b.addActionListener(this);
        
        exit_app=new JButton("EXIT");
        exit_app.setBounds(425, 310, 80, 40);
        exit_app.setBackground(Color.RED);
        exit_app.setForeground(Color.WHITE);
        add(exit_app);
        
        exit_app.addActionListener(this);
        
        
        setSize(600,400);
        setVisible(true);
        setLocation(150,150);
        
       
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submit_b){
            
            String uid=uid_f.getText();
            String upin=String.valueOf(pin_f.getPassword());
            boolean res;
            res=false;
            
            
            
//            System.out.println(" [ "+ uid +" :" +upin+" ]");
            
            if("".equals(uid)){
                 JOptionPane.showMessageDialog(rootPane, "please fill user id ");
                 
             }
            else if("".equals(upin) || upin.length()!=4){
                 JOptionPane.showMessageDialog(rootPane, "please fill valid pin ");
                 
             }
           
            else{
                
            try {
                Conn obj=new Conn();
                ResultSet result = null ;
                try {
                    String query=" select * from accountsigned where uid='" + uid + "' and upin='" +upin+"';";
                    System.out.println(query);
                    result = obj.s.executeQuery(query);
                } catch (SQLException ex) {
                    System.out.println("[ error logging in ]");
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(!result.isBeforeFirst()){
                    res=false;
                }
                else{
                     res=true;
                }
                
                
                
                
            } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(res==false){
                
                JOptionPane.showMessageDialog(rootPane, "User dont exist /CHECK credentials ");
            }else{
                
                JOptionPane.showMessageDialog(rootPane, "USer exist ");
                setVisible(false);
                new AccountPage(uid);
            }
                
                
            }
            
            
            
            
        }else if(ae.getSource()==sign_b){
            setVisible(false);
            new SignUp();
            
            
        }else if (ae.getSource()==clear_b){
            
            uid_f.setText("");
            pin_f.setText("");
        }else if(ae.getSource()==exit_app){
          System.exit(0);
            
            
        }
        
        
        
    }

    
    public static void main(String [] args){
        
         new Login();
         
    }

    
}
