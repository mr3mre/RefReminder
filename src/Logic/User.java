package Logic;

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
    public String country;
    public String province;


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
        final String driver = "";
        final String url = "";
        final String username = "root";
        final String password = "root";

        try
        {
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection( url, username, password );


            Statement statement1 = ((java.sql.Connection) conn).createStatement();
            String sql1 = "SELECT country FROM user WHERE username = '" + name + "'";
            ResultSet resultset1 = statement1.executeQuery(sql1);

            while( resultset1.next() )
            {
                country = resultset1.getString("country");
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

            Statement statement4 = ((java.sql.Connection) conn).createStatement();
            String sql4 = "SELECT province FROM user WHERE username = '" + name + "'";
            ResultSet resultset4 = statement1.executeQuery(sql4);

            while( resultset4.next() )
            {
                province = resultset4.getString("province");
            }
        }

        catch(SQLException e ) { e.printStackTrace();} catch (ClassNotFoundException e) { e.printStackTrace(); }
    }

    // Getters and setters
    public String getUsername()
    {
        return this.name;
    }

    public String getPassword()
    {
        return this.userPassword;
    }


    public String getCountry()
    {
        return this.country;
    }

    public String getProvince()
    {
        return this.province;
    }

    public String getEmail()
    {
        return this.email;
    }

    /**
     * Get username from file
     *
     * @return Username
     * @throws FileNotFoundException
     */
    public static String textReader() throws FileNotFoundException
    {
        File file = new File("filename.txt");
        Scanner scan = new Scanner( file );
        String name = scan.next();
        scan.close();
        return name;
    }
}

