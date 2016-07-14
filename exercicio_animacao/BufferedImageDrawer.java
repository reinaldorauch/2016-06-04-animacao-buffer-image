import java.awt.*;
import java.awt.image.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.awt.geom.*;

public class BufferedImageDrawer extends Frame
{

  public BufferedImage bi;

  public Graphics2D g2dbi;

  private Graphics2D g2d;

  public BufferedImageDrawer(BufferedImage buffIm, int width, int height)
  {

    bi = buffIm;

    g2dbi = bi.createGraphics();

    addKeyListener(new KeyInputHandler());

    addWindowListener(new FecharJanela());

    this.setTitle("Animacao");
    this.setSize(width,height);
    this.setVisible(true);

  }

  public void paint(Graphics g)
  {
    update(g);
  }

  public void update(Graphics g)
  {
    int i;

    g2d = (Graphics2D) g;

    g2d.drawImage(bi,0,0,null);
  }

  public class FecharJanela extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
    }
  }

  private class KeyInputHandler extends KeyAdapter {

    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        //
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        //
      }
      if (e.getKeyCode() == KeyEvent.VK_UP) {
        //
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        //
      }
    }


    public void keyReleased(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        //
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        //
      }
      if (e.getKeyCode() == KeyEvent.VK_UP) {
        //
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        //
      }
    }

    public void keyTyped(KeyEvent e) {
      if (e.getKeyChar() == 27) {
        System.exit(0);
      }
    }
  }
}


