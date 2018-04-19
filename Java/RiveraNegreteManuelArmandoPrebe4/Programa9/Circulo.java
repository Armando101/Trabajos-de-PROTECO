public class Circulo implements Figura {

	double radio;
	static final double PI = Math.PI;

	public Circulo(double radio) {
		this.radio = radio;
	}

	@Override
	public double Area() {
		return PI* Math.pow(radio,2);
	}

	@Override
	public double Perimetro() {
		return radio*2*PI;
	}


}