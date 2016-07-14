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

  private double angleStep;

  private Shape theShape;

  private AffineTransform rotation;
  private AffineTransform translation;
  private AffineTransform step;

  private boolean paused;

  private int frameHeight;
  private int frameWidth;

  private int color;

  public BufferedImageDrawer(BufferedImage buffIm, int width, int height)
  {
    bi = buffIm;

    g2dbi = bi.createGraphics();

    addKeyListener(new KeyInputHandler());

    addWindowListener(new FecharJanela());

    frameWidth = width;
    frameHeight = height;

    this.setTitle("Animacao");
    this.setSize(width, height);
    this.setVisible(true);
  }

  private Shape createDrawing()
  {
    GeneralPath gp = new GeneralPath();
    gp.moveTo(50,50);
    gp.lineTo(200,50);
    gp.lineTo(200,100);
    gp.lineTo(50,100);
    gp.lineTo(50,50);

    AffineTransform toOrigem = new AffineTransform();
    toOrigem.translate(-150, -100);

    return toOrigem.createTransformedShape(gp);
  }

  public void init()
  {
    g2dbi.setPaint(Color.WHITE);
    theShape = createDrawing();
    rotation = new AffineTransform();
    translation = new AffineTransform();
    step = new AffineTransform();
    angleStep = Math.toRadians(3.6);
    color = 0;
  }

  public void draw()
  {
    g2dbi.setPaint(Color.WHITE);
    // g2dbi.setPaint(color++);
    rotation.rotate(angleStep);
    translation.translate(6, 6);
    step.setToTranslation(150, 100);
    step.concatenate(translation);
    step.concatenate(rotation);
    g2dbi.draw(step.createTransformedShape(theShape));
  }

  private void resetCanvas()
  {
    init();
    g2dbi.setPaint(Color.BLACK);
    g2dbi.fillRect(0, 0, frameWidth, frameHeight);
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

  public boolean isPaused()
  {
    return paused;
  }

  public class FecharJanela extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
    }
  }

  private class KeyInputHandler extends KeyAdapter
  {
    public void keyPressed(KeyEvent e)
    {
      if (e.getKeyCode() == KeyEvent.VK_P) {
        paused = true;
        return;
      }

      if (e.getKeyCode() == KeyEvent.VK_R) {
        resetCanvas();
        return;
      }
    }

    public void keyReleased(KeyEvent e)
    {
      if (e.getKeyCode() == KeyEvent.VK_P) {
        paused = false;
      }
    }

    public void keyTyped(KeyEvent e)
    {
      if (e.getKeyChar() == 27) {
        System.exit(0);
      }
    }
  }
}
