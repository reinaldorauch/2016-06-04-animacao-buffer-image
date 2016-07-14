import java.awt.*;
import java.awt.geom.*;
import java.lang.Math;
import java.lang.Thread;

public class CarroDesenhado extends Frame
{
    CarroDesenhado()
    {
        addWindowListener(new FecharJanela());
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

    public void paint(Graphics g)
    {
    	AffineTransform rotation = new AffineTransform();
        AffineTransform translation = new AffineTransform();
    	AffineTransform step = new AffineTransform();
        Shape gp = createDrawing();

    	double angleStep = Math.toRadians(3.6);

        Graphics2D g2d = (Graphics2D) g;


        for (int index = 0; index < 100; index++) {
            rotation.rotate(angleStep);
            translation.translate(6, 6);
            step.setToTranslation(150, 100);
			step.concatenate(translation);
            step.concatenate(rotation);
            g2d.draw(step.createTransformedShape(gp));
            g2d.clearRect(0, 0, getWidth(), getHeight());
            // g2d.draw(translation.createTransformedShape(gp));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Got interrupted");
            }
		}

		g2d.draw(gp);
    }

    public static void main(String[] argv)
    {
        CarroDesenhado f = new CarroDesenhado();
        f.setTitle("Texto");
        f.setSize(1366,768);
        f.setVisible(true);
    }
}



