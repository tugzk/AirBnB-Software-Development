/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airbnb;
import java.sql.Connection;        
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author w1546834
 */
public class JDBC {

    
    public static void main(String[] args) {
        System.out.println("-------- Simple MySQL Application ------------");
        System.out.println("MySQL JDBC Driver Registered.");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection connection = null;

        try 
        {
            //connection = DriverManager.getConnection(
            //     "jdbc:mysql://elephant.ecs.westminster.ac.uk:3306/w1709330_0",
            //     "w1709330", "Bq699RYSULwd");
            // this is for running on the University network, to elephant:3306; use a localhost tunnel if outside



            connection = DriverManager.getConnection("jdbc:mysql://localhost:2222/w1709330_0", "w1709330", "Bq699RYSULwd");
            
            //If using Mac, open Terminal and type command below.
            //ssh -L 2222:elephant.ecs.westminster.ac.uk:3306 w1709330@compute0.westminster.ac.uk
            
        } catch (SQLException e) // check for connection error
        {
            System.out.println("ERROR: MySQL Connection Failed!");
            e.printStackTrace();
            return;
        }

        Statement stmt = null;
        try // create a Statement for the SQL query
        {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR: Failed to create Statement.");
            e.printStackTrace();
            return;
        }

        ResultSet queryRes = null;   // variable to contain the query result
        try // try to run an SQL query
        {
            queryRes = stmt.executeQuery("SELECT * from Users");
            int n = 0;    // a counter for the output

            while (queryRes.next()) // while there's still some more results of the query...
            {
                int numColumns = queryRes.getMetaData().getColumnCount();  
                n++;
                System.out.print("" + n);
                for (int i = 1; i <= numColumns; i++) 
                {                                               
                    System.out.print("  " + queryRes.getObject(i));
                }
                System.out.println("");   
            }
        } catch (SQLException e) // check for a query error
        {
            System.out.println("ERROR: Cannot execute query.");
            e.printStackTrace();
            return;
        }
        try 
        {
            connection.close();
        } catch (SQLException e) {
            System.out.println("WARNING: Failed to close database!");
            e.printStackTrace();
            return;
        }
        System.out.println("Database closed.");
    }
    
    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(       // connect through a local tunnel
                     "jdbc:mysql://localhost:2222/w1709330_0",
                      "w1709330", "Bq699RYSULwd");
            System.out.println("Connection successful");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}
