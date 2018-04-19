/**
*	@author Armando Rivera
*/
public class Circulo {

	static final double PI = Math.PI; //Este atributo es constante
	
	double d;	//Diametro
	double r;	//Radio

	/**
	*	Clase Circulo
	*	@param r -Recibe el radio del circulo
	*/
	public Circulo(double r) {
		this.d=2*r;
		this.r=r;
	}

	/**
	*		Constructor por default
	*	Asigna un valor de cero tanto al diamtro 
	*	como al perimetro.
	*/
	public Circulo(){
		this.r = 0;
		this.d = 0;
	}

	/**
	* @return Regresa el area del circulo
	*/
	public double calcularArea () {
		return PI * (Math.pow(r,2)); 
	}	//Este metodo eleva r a la segunda potencia

	/**
	* @return Regresa el perimetro del circulo
	*/
	public double calcularPerimetro() {
		return PI * d;
	}

	/**
	*	@param Recibe el radio del circulo y
	*	automaticamente cambia el diametro
	*/
	public void setRadio(float radio) {
		r = radio;
		d = 2*radio;
	}

	public double getRadio() {
		return r;
	}

	public double getDiametro() {
		return d;
	}

}