import javax.swing.JComponent;
impo


class Ventana extends JFrame{

	public Ventana(){
		super("Figuras");

		Lienzo lienzo = new Lienzo();
		this.add(lienzo);

		setSize(350,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ventana();
	}
}