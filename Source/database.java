import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
public class database {
database()
{
 try
    {
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost/accident_prediction";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM ambulance WHERE Time = '8'";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
       
      // iterate through the java resultset
      while (rs.next())
      {
        //String ID = rs.getString("ID");
        int Ambulance  = rs.getInt("Bidholi");
        //String lastName = rs.getString("last_name");
        //Date dateCreated = rs.getDate("date_created");
        //boolean isAdmin = rs.getBoolean("is_admin");
        //int numPoints = rs.getInt("num_points");
        
        // print the results
        System.out.println("2.Number of Ambulances in area:- \t ");
        System.out.format("%s%s", Ambulance);
        
      }
     
      st.close();
    }
    catch (SQLException e)
    {
      System.out.println("Got an exception! ");
     // System.err.println(e.getMessage());
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Got an exception! ");
     // System.err.println(e.getMessage());
    }
    catch (Exception e)
    {
      System.out.println(" Ambulance ");
     // System.err.println(e.getMessage());
    }
}
}