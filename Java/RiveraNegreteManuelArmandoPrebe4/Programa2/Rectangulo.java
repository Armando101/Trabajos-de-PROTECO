/**
*	@author Armando Rivera
*/
public class Rectangulo {
	double b;	//Base del Rectangulo
	double h;	//Altura del Rectangulo

	public Rectangulo(double b, double h) {
		this.b = b;
		this.h = h;
	}

	public Rectangulo() {
		this.b = (Math.random() * 20) + 1;
		this.h = (Math.random() * 20) + 1;
	}


	/**
	* @return Regresa el area del Rectangulo
	*/
	public double calcularArea () {
		return b*h;
	}

	/**
	* @return Regresa el perimetro del Rectagulo
	*/
	public double calcularPerimetro() {
		return 2*(b+h);
	}

	/**
	*	@param Recibe la base del Rectangulo
	*/
	public void setBase(float base) {
		b = base;
	}

	/**
	*	@param Recibe la altura del Rectangulo
	*/
	public void setAltura(float altura) {
		h = altura;
	}

	public double getBase() {
		return b;
	}

	public double getAltura() {
		return h;
	}
}