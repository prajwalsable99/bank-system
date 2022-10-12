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
//jdbc




public class SignUp extends JFrame implements ActionListener {
    JButton signup_button1;
    JTextField uname,uadharid,uemail,umob,uadd,udob;
    JRadioButton u_isml,u_isfl;
    ButtonGroup ugen;
    SignUp(){
        
        // 
        setLayout(null);       
        getContentPane().setBackground(Color.white);
        setTitle("BANK OF PRAJWAL");
        //----------------------------------------------------
        // Form 8008600
        
        JLabel u_name=new JLabel("ENTER NAME : ");
        u_name.setBounds(100,50,200,25);
        add(u_name);
        
        uname=new JTextField();
        uname.setBounds(270,50,200,25);
        add(uname);
        
        JLabel u_gender=new JLabel("ENTER Gender : ");
        u_gender.setBounds(100,100,200,25);
        add(u_gender);
        
        u_isml=new JRadioButton("MALE");
        u_isml.setBounds(270,100,60,30);
        add(u_isml);
        
        u_isfl=new JRadioButton("FEMALE");
        u_isfl.setBounds(340,100,77,30);
        add(u_isfl);
        
        ugen=new ButtonGroup();
        ugen.add(u_isml);
        ugen.add(u_isfl);
        
        JLabel u_dob=new JLabel("DOB (DD/MM/YYYY) : ");
        u_dob.setBounds(100,150,200,25);
        add(u_dob);
        
        udob=new JTextField();
        udob.setBounds(270,150,200,25);
        add(udob);
        
        JLabel u_adharid=new JLabel("ENTER Adhar number : ");
        u_adharid.setBounds(100,200,200,25);
        add(u_adharid);
        
        uadharid=new JTextField();
        uadharid.setBounds(270,200,200,25);
        add(uadharid);
        
        JLabel u_email=new JLabel("ENTER Email-id ");
        u_email.setBounds(100,250,200,25);
        add(u_email);
        
        uemail=new JTextField();
        uemail.setBounds(270,250,200,25);
        add(uemail);
        
        JLabel u_mob=new JLabel("ENTER Phone number ");
        u_mob.setBounds(100,300,200,25);
        add(u_mob);
        
        umob=new JTextField();
        umob.setBounds(270,300,200,25);
        add(umob);
        
        JLabel u_address=new JLabel("ENTER Address ");
        u_address.setBounds(100,350,200,25);
        add(u_address);
        
        uadd=new JTextField();
        uadd.setBounds(270,350,200,25);
        add(uadd);
        
        
        signup_button1=new JButton("proceed");
        signup_button1.setBounds(180, 400, 120, 40);
        signup_button1.setBackground(Color.black);
        signup_button1.setForeground(Color.white);
        add(signup_button1);
        
        signup_button1.addActionListener(this);
        
        
        
        
        
        //----------------------------------------------------------

        setSize(800,600);
        setVisible(true);
        setLocation(150,150);
        
       
        
        
        
        
       
    }
    @Override
    public void actionPerformed(ActionEvent ae){
//        uname,uadharid,uemail,umob,uadd,udob;
        if(ae.getSource()==signup_button1){
            
            System.out.println("proceed clicked");
              String u_name=uname.getText();
              String u_adharid=uadharid.getText();
              String u_email=uemail.getText();
             String u_mob=umob.getText();
              String u_add=uadd.getText();
             String u_dob= udob.getText();
             
             String u_gender=null;
             if(u_isml.isSelected()){
                 u_gender="male";
             }else{
                 u_gender="female";
             }
             
             
             
             if("".equals(u_name)){
                 JOptionPane.showMessageDialog(rootPane, "enter name please");
                 
             }
             else if("".equals(u_dob)){
                 JOptionPane.showMessageDialog(rootPane, "enter DOB please");
                 
             }
             else if("".equals(u_adharid)){
                 JOptionPane.showMessageDialog(rootPane, "enter Adharid please");
                 
             }
             else if("".equals(u_email)){
                 JOptionPane.showMessageDialog(rootPane, "enter email please");
                 
             }
             else if("".equals(u_mob) || u_mob.length()<10){
                 JOptionPane.showMessageDialog(rootPane, "enter mobile number please");
                 
             }
             else if("".equals(u_add)){
                 JOptionPane.showMessageDialog(rootPane, "enter address please");
                 
             }else{
                 
             
            
             JOptionPane.showMessageDialog(rootPane, "[ Signing Up ....]");
             // id will be  Uppercase  first letter of name + first 4 digit of phone number + lowercase second letter of name 
             String u_id=  Character.toUpperCase(u_name.charAt(0)) +
                     (u_mob.substring(0, 4)) +
                     Character.toLowerCase(u_name.charAt(1))
                     ;
             
             System.out.println(u_id);
             
                     
                    
             String u_pin="****";
            String query= "insert into accountsigned values ( '" +u_id+"','"+u_pin +"','"+ u_name +"','"+ u_adharid +"','" + u_email +"','"+ u_mob +"','"+ u_add +"','"+ u_dob +"','"+ u_gender +"')";
            System.out.println(query);
            String query2="insert into bank_balance values ('"+u_id+"',0);";
            
          Conn obj=new Conn();
          
            try {
                obj.s.executeUpdate(query);
                obj.s.executeUpdate(query2);
            } catch (SQLException ex) {
                System.out.println("[ error sgning up]");
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(rootPane, "[ Successfully signed up ....]");
            
            System.out.println("[ signed up ]");
            
            setVisible(false);
            
            new PassSet(u_id);
            
         
             
             
        
        }
    }

    } 
    public static void main(String [] args){
        
//        SignUp signUp = new SignUp();
    }

    
}
