import java.awt.*;
import javax.swing.*;
public class AccidentGraph extends JFrame {
    private final int WIDTH = 400;
    private final int HEIGHT = 300;
    private Container drawable;
    private JPanel canvas;
    AccidentGraph(double[] someData) {
        super("Accident Graph");
        drawable = getContentPane();
        canvas = new GraphCanvas(someData);
        drawable.add(canvas);
        setSize(WIDTH, HEIGHT);
    }
    public class GraphCanvas extends JPanel {
        private double[] data;
        private int points;
        private double[] XData;
        private double[] YData;
        public GraphCanvas(double[] someData) {
            super();
            data = someData;
            points = data.length / 2;
            XData = new double[points];
            YData = new double[points];
            for(int i = 0; i < points; i++) {
                XData[i] = data[i * 2];
                YData[i] = data[i * 2 + 1];
            }
        }
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            for(int i = 0; i < points - 1; i++) {
                int x0 = (int) (XData[i] + 0.5);
                int x1 = (int) (XData[i + 1] + 0.5);
                int y0 = (int) (YData[i] +0.5);
                int y1 = (int) (YData[i + 1] + 0.5);
                g2.drawLine(x0, y0, x1, y1);
                if (i == 0)
                  g2.drawString(("" + x0 + ", " + y0), x0 - 20, y0 + 10);
                if (i == points - 2)
                  g2.drawString(("" + x1 + ", " + y1), x1, y1);
            }
        }
    }
    public static void main(String[] args) {
        double[] d = { 0.0 , 0.0,
                       1.0, 14.0,
                       2.0, 16.0,
                       3.0, 12.0,
                       4.0, 11.0,
                       5.0, 24.0,
                       6.0, 40.0,
                      7.0, 45.0,
                      8.0,  85.0,
                      9.0,  30.0,
                    10.0,15.0,
                11.0,14.0,
            12.0,9.0,
              13.0,18.0,
            14.0,5.0,
             15.0,6.0,
              16.0,8.0,
            17.0,9.0,
        18.0,19.0,
        19.0,16.0,
        20.0,10.0,
        21.0,11.0,
      22.0,4.0,
    23.0,3.0,
    };
        Frame f = new AccidentGraph(d);
        f.show();
    }
}