import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
class Resizer
{
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
}