import java.io.*;
import java.awt.*;
class TestPPT
{
TestPPT()
{
test();
}
public void test()
{
String filename = "Accident_Prediction.pptx";
Desktop d = Desktop.getDesktop();
String cmd=System.getProperty("user.dir").toString()+"\\"+filename;
try
{
d.open(new File(cmd));
}
catch(Exception e)
{
}
}
}
