import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Lienzo extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	//Limea necesaria para pintar dentro del panel

		Graphics2D g2d = (Graphics2D)g;

		//Muesta cadena en coordenadas (10, 20)
		g2d.drawString("Hola mundo", 10, 20);	
	}
}