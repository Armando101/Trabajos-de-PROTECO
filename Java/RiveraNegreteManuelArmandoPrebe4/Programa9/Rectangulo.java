public class Rectangulo implements Figura {

	double base;
	double altura;

	public Rectangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double Area() {
		return base*altura;
	}

	@Override
	public double Perimetro() {
		return 2*(base + altura);
	}

}