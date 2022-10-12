
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
import javax.swing.SwingConstants;


public class TransCheckBalance extends JFrame implements ActionListener{
    
    
    String totalB;
    JButton goBackB;
    String userid;
    TransCheckBalance(String userid){
                  // --------------------------------------------------------
        setLayout(null);       
        getContentPane().setBackground(Color.BLACK);
        setTitle("BANK OF PRAJWAL");
        
        //-------------------------------------------------------------
        this.userid=userid;
        
         Conn obj=new Conn();
        ResultSet result = null ;
        try {
            String query=" select * from bank_balance where uid='" + userid + "';";
            System.out.println(query);
            result = obj.s.executeQuery(query);
            
            while(result.next()) {
                
                totalB=result.getString("totalB");
        
             }
             System.out.println("balance "+totalB);

        } catch (SQLException ex) {
            System.out.println("[ error logging in ]");
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
       
          //----------------------------------------------------------
          
        ImageIcon bg1=new ImageIcon(ClassLoader.getSystemResource("icons/transact_img.jpg"));
        Image bg_sc=bg1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon finalbg1=new ImageIcon(bg_sc);
        JLabel fbg1=new JLabel(finalbg1);
        fbg1.setBounds(0,0,600 ,500);
        add(fbg1);
        
        JLabel showbal=new JLabel( totalB +"$",SwingConstants.CENTER);
        showbal.setBounds(240,200,150 ,60);
        showbal.setForeground(Color.BLACK);
        showbal.setBackground(Color.WHITE);
        showbal.setOpaque(true);
        fbg1.add(showbal);
        
        
        goBackB=new JButton(" back ");
        goBackB.setBounds(530, 200, 140, 40);
        goBackB.setBackground(Color.YELLOW);
        goBackB.setForeground(Color.BLUE);
        add(goBackB);
        goBackB.addActionListener(this);
        //----------------------

        setSize(800,550);
        setVisible(true);
        setLocation(50,50);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==goBackB){
            System.out.println("go back pressed");
            setVisible(false);
          
           new AccountPage(userid);
            
            
        }
    }
    
    public static void main(String [] args){
        
//        new TransCheckBalance("S1234a");
    }
    
}
