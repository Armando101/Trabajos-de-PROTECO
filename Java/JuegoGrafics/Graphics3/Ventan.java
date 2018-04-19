import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventan extends JFrame {
	public Ventan() {
		super("Figuras");

		Lienzo lienzo = new Lienzo();
		this.add(lienzo);

		setSize(350, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Ventan();
	}
}