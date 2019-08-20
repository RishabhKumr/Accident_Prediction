import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.awt.Graphics;
public class LoginForm
{
 
 JLabel l1, l2, l3,l4,l5,l6,pic,pic1,pic2,pic3,wel;
 JTextField tf1;
 JButton btn1;
 JPasswordField p1;
 JFrame frame,pop;
 LoginForm() {
  frame = new JFrame("Login");
  l4 = new JLabel("<HTML><u>Accident Prediction System<u><HTML>");
  l4.setForeground(Color.red);
  l4.setFont(new Font("Serif", Font.BOLD, 40));

 
  l1 = new JLabel("<html><u>Login<u><html>");
  l1.setForeground(Color.blue);
  l1.setFont(new Font("Serif", Font.BOLD, 20));
 
  l2 = new JLabel("Username");
  l3 = new JLabel("Password");
  l6 = new JLabel("<html><u><i><b>HW&D</b></i></u></html>");
  tf1 = new JTextField();
  p1 = new JPasswordField();
  btn1 = new JButton("<HTML><u><i><blink>Login</blink></i></u></HTML>");
  
  l5 = new JLabel("@Developed by RISHABH KUMAR");
  l5.setForeground(Color.blue);
  l5.setFont(new Font("Times New Roman", Font.BOLD, 17));
 
  l1.setBounds(100, 100, 400, 30);
  l2.setBounds(100, 145, 200, 30);
  l3.setBounds(100, 195, 200, 30);
  l4.setBounds(500, 10,500, 40);
  l5.setBounds(100, 650,500, 40);
  l6.setBounds(368, 650,500, 40);
  tf1.setBounds(250, 145, 200, 30);
  p1.setBounds(250, 195, 200, 30);
  btn1.setBounds(100, 255, 100, 30);
  frame.add(l1);
  frame.add(l2);
  frame.add(tf1);
  frame.add(l3);
  frame.add(p1);
  frame.add(btn1);
  frame.add(l4);
  frame.add(l5);
  frame.add(l6);
  frame.setSize(1366,767);
  frame.setLayout(null);
  frame.setVisible(true);
  setimage(950,100,400,250);
  btn1.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {
   String uname = tf1.getText();
   String pass = p1.getText();
   if(uname.equals("root") && pass.equals("12345"))
   {
   FileDialog1 obj = new FileDialog1();
   }
   else
   {
    newPopUp("Incorrect password");
   }
  }
  }
  );
 }
void newPopUp(String msg)
{
pop=new JFrame();
pop.setBounds(534,234,300,300);
pop.setResizable(false);
pop.setLayout(null);
pop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
wel=new JLabel(msg);
wel.setBounds(100,100,100,100);
pop.add(wel);
pop.revalidate();
pop.repaint(); 
pop.setVisible(true);
}
void setimage(int x,int y,int w,int h)
{
try
{
BufferedImage bf = ImageIO.read(new File("image1.jpg"));
BufferedImage bf1 = ImageIO.read(new File("imag.png"));
BufferedImage bf2 = ImageIO.read(new File("ml.png"));
BufferedImage bf3 = ImageIO.read(new File("download.png"));
bf=ScaledImage(bf,w,h);
bf1=ScaledImage(bf1,w,h);
bf2=ScaledImage(bf2,w,h);
bf3=ScaledImage(bf3,w,h);
pic=new JLabel(new ImageIcon(bf));
pic1=new JLabel(new ImageIcon(bf1));
pic2=new JLabel(new ImageIcon(bf2));
pic3=new JLabel(new ImageIcon(bf3));
pic.setBounds(x,y,w,h);
pic1.setBounds(950,350,400,280);
pic2.setBounds(550,100,390,250);
pic3.setBounds(550,370,390,250);
frame.add(pic);
frame.add(pic1);
frame.add(pic2);
frame.add(pic3);
frame.revalidate();
frame.repaint();
}
catch(Exception e)
{
}
}
void removing()
{
frame.remove(pic);

frame.revalidate();
frame.repaint();
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
 public static void main(String[] args)
 {
      SplashScreen splash = new SplashScreen();
    //  Thread.sleep(500);
  new LoginForm();
  new Welcome();
 // SplashScreen splash = new SplashScreen();
 // splash = SplashScreen.getSplashScreen();

      /*  Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("g is null");
            return;
        }*/
  /* javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        }); */
    } 
   
 }


