import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JTabbedPane;
import java.awt.EventQueue;
import java.lang.String;
public class Administrator
{
int i=0,num=0;
JFrame f;
JLabel l;
JButton b,b1,b2;
JProgressBar pb;
JTabbedPane jtb;
JPanel p1,p2,p3,p4;
Administrator()
{
initialize();
f.setResizable(false);
f.setLayout(null);
//f.getContentPane().setBackground(Color.PINK);
//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);
f.add(pb);
iterate();
Configure();

}
public void initialize()
{
f = new JFrame("Administrator");
f.setSize(700,650);
pb = new JProgressBar(0,200);
pb.setBounds(260,10,160,30);
pb.setValue(0);
pb.setStringPainted(true);
//cli
// Icon icon = new ImageIcon("iconb.png");
 b = new JButton("CLI");
 b.setBounds(550,50,130,130);
f.add(b);
//Jlabel
l = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
l.setBounds(2,25,700,32);
f.add(l);
//tabbedpane
jtb = new JTabbedPane();
jtb.setBounds(10,50,530,530);
jtb.addTab("Programs",p1);
jtb.addTab("Algorithms",p2);
jtb.addTab("Classifier",p3);
jtb.addTab("Cluster",p4);
f.add(jtb);
//b1
b1= new JButton("GET GRAPH");
b1.setBounds(550,200,130,130);
f.add(b1);
b2= new JButton("SEND SMS");
b2.setBounds(550,350,130,130);
f.add(b2);
//Panels in Tabs
p1 = new JPanel();
p2 = new JPanel();
p3 = new JPanel();
p4 = new JPanel();
} 
void Configure()
{
b.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
CLI obj = new CLI();
}
}
);
b2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{

SMS obj = new SMS();
}
}
);
}
public void iterate(){  
while(i<=200){    
  pb.setValue(i);    
  i=i+20;    
  try{Thread.sleep(100);}catch(Exception e){}    
}    
}
}
