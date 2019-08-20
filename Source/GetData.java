import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
public class GetData 
{
JFrame f;
JScrollPane jsp;
JLabel l1,l2,l3,l4,l5,l6,l7,hd,ft,h1,h2;
JButton b1,b2,b3,b4,b5,b6,b7;
JPanel p;
GetData() {
f = new JFrame("Get Data");
hd = new JLabel("Get Data From Government of India");
hd.setBounds(120,15,350,30);
hd.setForeground(Color.red);
hd.setFont(new Font("Serif",Font.BOLD,20));
f.add(hd);
ft = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
ft.setBounds(5,47,600,20);
f.add(ft);
f.setSize(600,600);

l1 = new JLabel("1. State/UT-Wise Details Of Road Accident Deaths By Mode Of Transport 2017");
l1.setBounds(20,80,500,30);
f.add(l1);

b1 = new JButton("Get");
b1.setBackground(Color.YELLOW);
b1.setBounds(30,115,70,20);
f.add(b1);
//t2
l2 = new JLabel("2. All India level Road Accident Deaths in Type of Vehicle during 2000");
l2.setBounds(20,140,500,30);
f.add(l2);

b2 = new JButton("Get");
b2.setBackground(Color.YELLOW);
b2.setBounds(30,170,70,20);
f.add(b2);
//t3

l3 = new JLabel("3. State/UT/City and Place of Occurrence-wise Road Accident Deaths during 2015");
l3.setBounds(20,190,500,30);
f.add(l3);

b3 = new JButton("Get");
b3.setBackground(Color.YELLOW);
b3.setBounds(30,220,70,20);
f.add(b3);
//t4
l4 = new JLabel("4. Accident prone black spots on national highways from 2011 to 2014 (From: Ministry of Road Transport and Highways)");
l4.setBounds(20,240,500,30);
f.add(l4);

b4 = new JButton("Get");
b4.setBackground(Color.YELLOW);
b4.setBounds(30,270,70,20);
f.add(b4);

//t5
l5 = new JLabel("5. State/UT-wise Accidents Classified according to Type of Traffic Violations during 2017");
l5.setBounds(20,290,500,30);
f.add(l5);

b5 = new JButton("Get");
b5.setBackground(Color.YELLOW);
b5.setBounds(30,320,70,20);
f.add(b5);


Icon icon1 = new ImageIcon("icon2.png");
JLabel label1 = new JLabel(icon1);
label1.setBounds(290,480,300,90);
Configure();
display();
f.add(label1);   
f.setLayout(null);
f.setResizable(false);
f.getContentPane().setBackground(Color.ORANGE);
f.setVisible(true);
}
public void Configure()
{
b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
GetJson1 obj  = new GetJson1();

}
}
);
b2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{

GetJson2 obj  = new GetJson2();

}
}
);
b3.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
GetJson3 obj  = new GetJson3();

}
}
);
b4.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
GetJson4 obj  = new GetJson4();

}
}
);
b5.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
GetJson5 obj  = new GetJson5();

}
}
);

}
public void display()
{
Icon icon = new ImageIcon("loader1.gif");
JLabel label = new JLabel(icon);
label.setBounds(140,350,160,130);
f.add(label);  
}
}