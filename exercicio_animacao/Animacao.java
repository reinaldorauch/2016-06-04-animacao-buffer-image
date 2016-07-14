import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class Animacao extends TimerTask
{
  private BufferedImageDrawer buffid;
  private AffineTransform af;
  private double buffid;

  Animacao(BufferedImageDrawer bid, int width, int height,int delay)
  {
    af = new AffineTransform();
    rect = new Rectangle2D.Double(0,0,50,50);
    buffid = bid;
  }

  public void run()
  {
    buffid.g2dbi.draw();
    buffid.repaint();
  }

  public static void main(String[] argv)
  {
    int width = 800;
    int height = 600;
    int delay = 30;

    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    BufferedImageDrawer bid = new BufferedImageDrawer(bi, width, height);

    Animacao an = new Animacao(bid, width, height, delay);

    Timer t = new Timer();
    t.scheduleAtFixedRate(an, 0,delay);
  }
}
