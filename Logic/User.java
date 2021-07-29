import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

/**
 * @author Goksu
 */

public class User {
    // properties
    public String name;
    public String userPassword;
    public String email;
    public String address;
    
    
    
    // constructor for login user
    public User( String n )
    {
        try
        {
            name = textReader();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("1");
        }
         
        
        //name = n;
        
        //connection constants
        final String driver = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://34.141.44.144:3306/user";
        final String username = "root";
        final String password = "root";
        
        try
        {
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection( url, username, password );
            
            
            Statement statement1 = ((java.sql.Connection) conn).createStatement(); 
            String sql1 = "SELECT address FROM user WHERE username = '" + name + "'";
            ResultSet resultset1 = statement1.executeQuery(sql1);
            
            while( resultset1.next() )
            {
                address = resultset1.getString("address");
            }
            
            Statement statement2 = ((java.sql.Connection) conn).createStatement(); 
            String sql2 = "SELECT password FROM user WHERE username = '" +  name + "'";
            ResultSet resultset2 = statement2.executeQuery(sql2);
            
            while(  resultset2.next() )
            {
                userPassword = resultset2.getString("password");
            }
            
            Statement statement3 = ((java.sql.Connection) conn).createStatement(); 
            String sql3 = "SELECT email FROM user WHERE username = '" +  name + "'";
            ResultSet resultset3 = statement3.executeQuery(sql3);
            
            while(  resultset3.next() )
            {
                email = resultset3.getString("email");
            }
        }
        
        catch(SQLException e ) { e.printStackTrace();} catch (ClassNotFoundException e) { e.printStackTrace(); }
    }


    public String getUsername()
    {
        return this.name;
    }
    
    public String getPassword()
    {
        return this.userPassword;
    }
    
    
    public String getAddress()
    {
        return this.address;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public static String textReader() throws FileNotFoundException
    {
        File file = new File( "filename.txt" );
        Scanner scan = new Scanner( file );
        String name = scan.next();
        scan.close();
        return name;
    } 
}
