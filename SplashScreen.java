import javax.swing.*;
import java.awt.*;
 public class SplashScreen  extends JWindow
 {
   
      Image img = Toolkit.getDefaultToolkit().getImage("screen1.gif");
      ImageIcon imgicon = new ImageIcon(img);
      SplashScreen()
     {
      
      try
      {
          setSize(500,300);
          setLocationRelativeTo(null);
         show();
          Thread.sleep(9100);
          dispose();
          javax.swing.JOptionPane.showMessageDialog((java.awt.Component)
             null,"@Accept Terms and Conditions:-","Welcome",
             javax.swing.JOptionPane.DEFAULT_OPTION);
            }
            catch(Exception exception)
            {
                javax.swing.JOptionPane.showMessageDialog((java.awt.Component)
                null,"Error"+exception.getMessage(),"Error:",
                javax.swing.JOptionPane.DEFAULT_OPTION);
                
            }
        }
       public void paint(Graphics g)
       {
           g.drawImage(img,0,0,this);
    }
}