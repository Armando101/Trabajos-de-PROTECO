import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EventosMouse extends JFrame {

	private JPanel mousePanel;
	private JLabel barraEstado;

	public EventosMouse() {
		super("Demostrando eventos del mouse");
		mousePanel = new JPanel();
		mousePanel.setBackground(Color.RED);
		add(mousePanel, BorderLayout.CENTER);
		
		barraEstado = new JLabel("Mouse fuera del Panel");
		add(barraEstado, BorderLayout.SOUTH); 
		
		MouseHandler manejador = new MouseHandler();
		mousePanel.addMouseListener(manejador);
		mousePanel.addMouseMotionListener(manejador);

	}

	private class MouseHandler implements MouseMotionListener, MouseListener{
		//@Override
		public void mouseExited(MouseEvent e) {
			barraEstado.setText("Saliste del Panel");
			mousePanel.setBackground(Color.WHITE);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			barraEstado.setText(String.format("Click en [%d, %d]", e.getX(), e.getY()));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			barraEstado.setText(String.format("Presionando en [%d, %d]", e.getX(), e.getY()));			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			barraEstado.setText(String.format("Soltado en [%d, %d]", e.getX(), e.getY()));
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			mousePanel.setBackground(Color.CYAN);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			barraEstado.setText(String.format("Arrastrado en [%d, %d]", e.getX(), e.getY()));
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			barraEstado.setText(String.format("Movido en [%d, %d]", e.getX(), e.getY()));
		}
	}

	public static void main(String[] args) {
		EventosMouse eventos = new EventosMouse();
		//eventos.setLayout(new BorderLayout());
		eventos.setVisible(true);
		eventos.setSize(600,600);
		eventos.setLocation(300,300);
		eventos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}











