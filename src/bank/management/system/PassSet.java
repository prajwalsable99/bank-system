package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import bank.management.system.Conn;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PassSet extends JFrame implements ActionListener{
    
    JTextField pass_1;
    JPasswordField pass_2;
    JLabel p1,p2;
    JButton setpassbutton;
        String userid;
    PassSet(String x){
        System.out.println(x);
        this.userid=x;
          // --------------------------------------------------------
        setLayout(null);       
        getContentPane().setBackground(Color.white);
        setTitle("BANK OF PRAJWAL");
        
        //-------------------------------------------------------------
        
        
        p1=new JLabel("set password ");
        p1.setBounds(50,160,200,20);
        add(p1);
        
         pass_1=new JTextField();
        pass_1.setBounds(205,160,200,20);
        add(pass_1);
        
        
        p2=new JLabel("confrim password : ");
        p2.setBounds(50,210,200,20);
        add(p2);
        
        pass_2=new JPasswordField();
        pass_2.setBounds(205,210,200,20);
        add(pass_2);
        
         setpassbutton=new JButton("SET PASSWORD");
        setpassbutton.setBounds(150, 250, 200, 40);
        setpassbutton.setBackground(Color.black);
        setpassbutton.setForeground(Color.white);
        add(setpassbutton);
        
        setpassbutton.addActionListener(this);
        
       
          //----------------------------------------------------------

        setSize(500,600);
        setVisible(true);
        setLocation(150,150);
        
        
    }
    
   
    @Override
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==setpassbutton){
             String t1=pass_1.getText();
             String t2=String.valueOf(pass_2.getPassword());
             
              if("".equals(t1) || t1.length()!=4){
                 JOptionPane.showMessageDialog(rootPane, "please fill first entry (len must be 4)");
                 
             }
             else if("".equals(t2) || t2.length()!=4){
                 JOptionPane.showMessageDialog(rootPane, "please fill second entry (len must be 4)");
                 
             }
             else if (!t1.equals(t2)){
                 JOptionPane.showMessageDialog(rootPane, "both entries dont match");
             }
             else{
                 System.out.println("[matched ! setting pin] ==>" +t1);
             System.out.println(t1);
             
             JOptionPane.showMessageDialog(rootPane, "[ Setting pin ....]");
             
               Conn obj=new Conn();
              String query="update accountsigned set upin='"+t1+"' where uid='"+userid+"';";
              System.out.println(query);
//              
            try {
                obj.s.executeUpdate(query);
            } catch (SQLException ex) {
                System.out.println("[ error setting up pin ]");
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(rootPane, "[ Successfully account creation  ....]");
            
            System.out.println("[ YES ! ACCOUNT CREATED ]");
            setVisible(false);
            new AccountPage(userid);
//             
             }
             
         
         }
    }
     public static void main(String [] args){
        
//         new PassSet("A8529t");
        
    }
    
    
    
}
