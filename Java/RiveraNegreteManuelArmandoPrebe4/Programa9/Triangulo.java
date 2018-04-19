public class Triangulo implements Figura {

	double base;
	double altura;

	public Triangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double Area() {
		return base*altura/2;
	}

	@Override
	public double Perimetro() {
		return base*3;
	}


	



}