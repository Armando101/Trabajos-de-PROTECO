public class Rectangulo {
	double base;
	double altura;

	public Rectangulo(double b, double a) {
		this.base = b;
		this.altura = a;
	}

	public Rectangulo () {
		this.base = 0;
		this.altura = 0;
	}


	public double calcularArea() {
		return base*altura;
	}

	public double calcularPerimetro() {
		return 2*(base + altura);
	}

	public double getBase() {
		return base;
	}

	public double getAltura() {
		return altura;
	}

	public void setBase(double b) {
		base = b;
	}

	public void setAltura(double a) {
		altura = a;
	}

	public Rectangulo agrandar (int x) {
		Rectangulo rx = new Rectangulo();
		rx.setBase(x*base);
		rx.setAltura(x*altura);
		return rx;
	}

}