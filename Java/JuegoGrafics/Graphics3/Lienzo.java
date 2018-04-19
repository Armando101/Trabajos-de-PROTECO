import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public  class Lienzo extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g;
		
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);

		//Recibe por parametros: Posicion (x,y), Base, Altura(50, 50)
		g2d.fillRect(30, 20, 50, 50);
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(120, 20, 90, 60);
		g2d.setColor(Color.orange);
		//Parametros Posicion (x,y)  Base, Altura	Curvatura
		g2d.fillRoundRect(250, 20, 70, 50, 25, 25);
		g2d.setColor(Color.BLUE);
		g2d.fill(new Ellipse2D.Double(10,100,80,100));
	}
}