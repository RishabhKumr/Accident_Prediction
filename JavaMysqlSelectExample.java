import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
public class JavaMysqlSelectExample
{
JFrame jf;
JButton jl;
JLabel l;
BufferedImage ob;
Resizer rz;
int Prediction;
JavaMysqlSelectExample()
{
jf=new JFrame("Prediction:-");
rz=new Resizer();
jf.getContentPane().setBackground(Color.PINK);
jf.setSize(600,600);
jf.setLayout(null);
jf.setVisible(true);
initalize();
try
    {
      String myDriver = "com.mysql.cj.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost/accident_prediction";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
      // our SQL SELECT query. 
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM prediction WHERE Time = '10'";

      // create the java statement
      Statement st = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
       
      // iterate through the java resultset
      while (rs.next())
      {
        //String ID = rs.getString("");
         Prediction = rs.getInt("Bidholi");
        //String lastName = rs.getString("last_name");
        //Date dateCreated = rs.getDate("date_created");
        //boolean isAdmin = rs.getBoolean("is_admin");
        //int numPoints = rs.getInt("num_points");
        
        // print the results
         System.out.print("++++++++++++++++++++++++++++\n");
        System.out.format("%s%s\n",Prediction,"%");
       
      
      }
    
      st.close();
    }
    catch (SQLException e)
    {
      System.out.println("Got sql exception! ");
     // System.err.println(e.getMessage());
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Got class exception! ");
     // System.err.println(e.getMessage());
    }
    catch (Exception e)
    {
      System.out.println("Got an exception! ");
     // System.err.println(e.getMessage());
    }
  
   Condition();
}
public void initalize()
{
imageonoff();
l = new JLabel("Prediction:-");
l.setBounds(10,50,180,30);
jf.add(l);
/*
Icon icon = new ImageIcon("green.gif");
  JLabel label = new JLabel(icon);
   label.setBounds(150,300,230,230);
   jf.add(label);
   */
}
void delay(int a)
{
try
{
Thread.sleep(a);
}
catch (InterruptedException e)
{
System.out.println(e);
}
}
void imageonoff()
{
int i;
prepare(225,225);
for(i=1;i<5;i++)
{
delay(1000);
set();
delay(1000);
reset();
}
}
void prepare(int a,int b)
{
if(jl!=null)
{
reset();
}
try
{
ob=ImageIO.read(new File("red.png"));
}
catch(IOException e)
{
System.out.println("FILE NOT FOUND !!!");
return;
}
ob=(BufferedImage)(rz.ScaledImage(ob,a,b));
jl=new JButton(new ImageIcon(ob));
//jl=new JButton("Testing !!!");
jl.setBounds(150,300,230,230);

}
void set()
{
jf.add(jl);
jf.revalidate();
jf.repaint();
}
void reset()
{
jf.remove(jl);
jf.revalidate();
jf.repaint();
} 

void Condition()
{
if(Prediction >= 84)
{
System.out.println("----------------------------------");
System.out.println("\n1.Chances of Accident is 'High'");
High2();
}
else if(Prediction > 50  && Prediction < 84 )
{

System.out.println("----------------------------------");
System.out.println("\n1.Chances of Accident is 'Moderate'");
High1();
}
else
{
System.out.println("----------------------------------");
System.out.println("\n1.Chances Of Accident is Low");
High();
}
}
public void High()
{
JLabel l1 = new JLabel();
l1.setText(String.valueOf(Prediction));
l1.setBounds(100,50,180,30);
jf.add(l1);

JLabel l = new JLabel("Chances of Accident is Low");
l.setBounds(150,240,200,30);
jf.add(l);
Icon icon = new ImageIcon("green.gif");
JLabel label = new JLabel(icon);
label.setBounds(150,300,230,230);
jf.add(label);
jf.revalidate();
jf.repaint();
}
public void High1()
{
JLabel l1 = new JLabel();
l1.setText(String.valueOf(Prediction));
l1.setBounds(100,50,180,30);
jf.add(l1);
JLabel l = new JLabel("Chances of Accident is Moderate");
l.setBounds(160,270,200,30);
jf.add(l);
Icon icon1 = new ImageIcon("yellow.gif");
JLabel label1 = new JLabel(icon1);
label1.setBounds(150,300,230,230);
jf.add(label1);
jf.revalidate();
jf.repaint();
}
public void High2()
{
JLabel l1 = new JLabel();
l1.setText(String.valueOf(Prediction));
l1.setBounds(100,50,180,30);
jf.add(l1);
JLabel l = new JLabel("Chances of Accident is High");
l.setBounds(150,240,200,30);
jf.add(l);
Icon icon2 = new ImageIcon("red.gif");
JLabel label2 = new JLabel(icon2);
label2.setBounds(150,300,230,230);
jf.add(label2);
jf.revalidate();
jf.repaint();
}
}