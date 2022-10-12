
package bank.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.SQLException;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("hellllo");
             c = null;
          
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_system", "root", "prajwal");
            s=c.createStatement();
            System.out.println(c +"[ Connection is established ... ]");
        
     
        
        
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
            
            
        }
            
            
       
    
    
     }
    
    public static void main (String []args) throws SQLException{
        
    }
}
