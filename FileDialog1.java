import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class FileDialog1
{
JLabel lb,pic4,pic5,pic6,pic7,img1,img2,t;
JButton b1,b2,b3,b4;
JFileChooser jfc;
String loc[]={"Bidholi", "Premnagar", "ISBT", "Vikasnagar", "Delhi"};
String head[]; //Storing columns from file
String rows[][]; //Storing data from file
String cloc;
LinkedList<String> data;
JButton Rd,fs,g;
JFrame f;
JComboBox jcb;
JScrollPane jsp;
JTable jt;
JTextField at;
boolean fst;
int r,c;
BufferedImage img;
FileDialog1()
{
//Instantiation Area
initializ();
//Configuration Area
configure();
//Other Actionlistener configurations
configureActions();
//setimage(530,50,350,350);
//fileInput(200,200);
cloc=loc[0];
fst=false;
//Framing Area
f.setResizable(false);
//f.getContentPane().setBackground(Color.);
f.setLayout(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setVisible(true);
}
void initializ()
{
f=new JFrame("Read Data");
f.setSize(900,1100);

b1=new JButton("Read Data");
b1.setBounds(180,500,130,30);
f.add(b1);
g=new JButton("Get Data");
g.setBackground(Color.green);
g.setBounds(330,500,130,30);
f.add(g);
lb=new JLabel("<html><u>Road Accident Data</u></html>");
lb.setBounds(10,10,180,30);
f.add(lb);

jcb=new JComboBox<String>(loc);
jcb.setBounds(10,500,130,30);
f.add(jcb);

fs=new JButton("Open File");
fs.setBounds(10,550,130,30);
f.add(fs);

//Text field
at = new JTextField();
at.setBounds(10,600,310,30);
f.add(at);
//Analysis Button
b2 = new JButton("Analysis");
b2.setBounds(10,650,130,30);
b2.setBackground(Color.red);
f.add(b2);
//Admin
b3 = new JButton("Admin");
b3.setBounds(160,650,130,30);
f.add(b3);
//presenation
b4 = new JButton("Presentation");
b4.setBounds(310,650,130,30);
f.add(b4);

loadImage("imag.png",340,340);
img1=new JLabel(new ImageIcon(img));
img1.setBounds(543,70,325,325);
f.add(img1);

  Icon icon = new ImageIcon("plot1.gif");
  JLabel label = new JLabel(icon);
   label.setBounds(530,370,350,350);
   f.add(label);     
/*
loadImage("plot2.gif",350,350);
img2=new JLabel(new ImageIcon(img));
img2.setBounds(530,370,350,350);
f.add(img2);*/
}
void loadImage(String a,int w,int h)
{
try
{
img=ImageIO.read(new File(a));
}
catch(Exception e)
{
}
img = scaledImage(img,w,h);
}
void configure()
{
lb.setForeground(Color.blue);
lb.setFont(new Font("Serif",Font.BOLD,20));
}
void configureActions()
{
b1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
display();
}
}
);

g.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
GetData obj  = new GetData();
}
}
);
//Button for Admin
b3.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
Administrator ob = new Administrator();
//ob.setVisible(true);
}
}
);
//Button 4 presenttion
b4.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
TestPPT ob = new TestPPT();
//ob.setVisible(true);
}
}
);
//Button for Aanalysis
b2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
JavaMysqlSelectExample obj = new JavaMysqlSelectExample();
database ob = new database();
}
}
);
jcb.addItemListener(new ItemListener()
{
public void itemStateChanged(ItemEvent e)
{
cloc=e.getItem().toString();
}
}
);
fs.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
//file
jfc = new JFileChooser();
if(jfc.showOpenDialog(null)== JFileChooser.APPROVE_OPTION)
{
at.setText(jfc.getSelectedFile().getAbsoluteFile().toString());
}
else
{
at.setText("");
}
}
}
);
}
BufferedImage scaledImage(Image a,int w,int h)
{
BufferedImage b;
Graphics2D g2;
b=new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
g2=b.createGraphics();
g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
g2.drawImage(a,0,0,w,h,null);
g2.dispose();
return b;
}
LinkedList<String> fileToList(String dir)
{
LinkedList<String> link = new LinkedList<String>();
File chk;
String str;
BufferedReader br;
try
{
chk = new File(dir);
if(!(chk.exists()&&chk.isFile()))
{
return null;
}
br=new BufferedReader(new FileReader(dir));
while((str=br.readLine())!=null)
{
link.add(str);
}
br.close();
}
catch(IOException e)
{
System.out.println("ERROR !!!");
return null;
}
return link;
}
void prepareTable()
{
boolean first=true;
StringTokenizer st;
int i,j;
j=0;
data=fileToList(System.getProperty("user.dir").toString()+"\\Docs\\"+cloc+".csv");
if(data==null)
{
System.out.println("error");
return;
}
r=data.size()-1;
for(String trav : data)
{
i=0;
st=new StringTokenizer(trav,",");
if(first)
{
c=st.countTokens();
head=new String[c];
rows=new String[r][c];
while(st.hasMoreTokens())
{
head[i++]=st.nextToken();
}
first=false;
}
else
{
while(st.hasMoreTokens())
{
rows[j][i++]=st.nextToken();
}
j++;
}
}
}
void display()
{
prepareTable();
if(fst)
{
f.remove(jsp);
f.revalidate();
f.repaint();

}
else
{
fst=true;
}
jt=new JTable(rows,head);
jsp=new JScrollPane(jt);
jsp.setBounds(20,50,500,400);
t = new JLabel("Trained Model");
t.setBounds(660,25,100,30);
//graph image 
loadImage((System.getProperty("user.dir").toString()+"\\Docs\\"+cloc+".png"),330,330);
img1.setIcon(new ImageIcon(img));
f.add(t);
f.add(jsp);
f.revalidate();
f.repaint();
}
void viewTable() //Testing module (not included)
{
int i,j;
System.out.println("header");
for(i=0;i<c;i++)
{
System.out.println(head[i]);
}
System.out.println("table");
for(i=0;i<r;i++)
{
for(j=0;j<c;j++)
{
System.out.print(rows[i][j]+"\t");
}
System.out.println();
}
System.out.println();
}/*
//image inserting 
void setimage(int x,int y,int w,int h)
{
try
{
BufferedImage bf4 = ImageIO.read(new File("Round.jpeg"));
BufferedImage bf5 = ImageIO.read(new File("imag.png"));
//BufferedImage bf6 = ImageIO.read(new File("ml.png"));
//BufferedImage bf7 = ImageIO.read(new File("download.png"));
bf4=ScaledImage(bf4,w,h);
bf5=ScaledImage(bf5,w,h);
//bf6=ScaledImage(bf6,w,h);
//bf7=ScaledImage(bf7,w,h);
pic4=new JLabel(new ImageIcon(bf4));
pic5=new JLabel(new ImageIcon(bf5));
//pic6=new JLabel(new ImageIcon(bf6));
//pic7=new JLabel(new ImageIcon(bf7));
pic4.setBounds(x,y,w,h);
//pic5.setBounds(530,370,350,350);
//pic6.setBounds(550,100,390,250);
//pic7.setBounds(550,370,390,250);
f.add(pic4);
f.add(pic5);
//f.add(pic6);
//f.add(pic7);
f.revalidate();
f.repaint();
}
catch(Exception e)
{
}
}
void removing()
{
f.remove(pic4);

f.revalidate();
f.repaint();
}
BufferedImage ScaledImage(Image a,int w,int h)
{
BufferedImage b;
Graphics2D g2;
b=new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
g2=b.createGraphics();
g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
g2.drawImage(a,0,0,w,h,null);
g2.dispose();
return b;
}
*/

}