/** 
 *	Clase Auto
 *	Contiene tres atributos los cuales son
 *	anio de estreno, Marca y color del auto
 *	Contiene tres metodos los cuales son:
 *  Encender Enciende el auto
 *	Correr  Pone a circular el auto
 *	Pintar  Pinta el auto de otro color
 *	@author Armando Rivera
*/
public class Auto extends Thread{
	int anio;
	String marca;
	String color;


	public Auto() {	//Constructor por defecto, si no recibe paramentros
		anio = 0;
		marca = "null";
		color = "null";

	}

	public Auto(int a, String m, String c) {	//Constructor que recibe parametros
		this.anio = a;
		this.marca = m;
		this.color = c;
	}

	/**
	*	@return Regresa el anio de lanzamiento del auto
	*/
	public int getAnio() {
		return anio;
	}

	/**
	*	@return Regresa la marca del auto
	*/
	
	public String getMarca() {
		return marca;
	}
	
	/**
	*	@return Regresa el color del auto
	*/
	
	public String getColor() {
		return color;
	}


	/**
	*	@param  a  anio de lanzamiento
	*/
	public void setAnio(int a) {
		anio = a;
	}


	/**
	*	@param  m marca del auto
	*/
	public void setMarca(String m) {
		marca = m;
	}


	/**
	*	@param   c Color del auto
	*/
	public void setColor(String c) {
		color = c;
	}


	//Metos de la clase auto


	/**
	*	@return Regresa una cadena
	*/
	public String encender() {
		return "Esta encendiendo el auto " + marca;
	}

	
	/**
	*	Corre el auto a una velocidad ingresada
	*
	*	@param  km kilometros a los que esta corriendo el auto
	*/
	public void correr(int km) {
		if (km > 120) 
			System.out.println("No puede correr a mas de 120 km/h");
		else 	
			System.out.printf("Corriendo a %d km/h\n\n", km);
	}


	/**
	*	Pintar el auto de otro color
	*
	*	@param  col Color al que se quiere pintar el auto
	*/
	public void pintar(String col) {
		if (col == color) 
			System.out.println("Su auto ya esta pintado de " + color);
		else {
			System.out.println("Pintado su auto de " + col);
			System.out.println("..........");
			color = col;
			try {
			Thread.sleep(1000);
			System.out.println("..........");
			Thread.sleep(1000);
			System.out.println("..........");
			Thread.sleep(4000);
			}catch(InterruptedException e) {}
			//System.out.print("\033[H\033[2J");	//Limpia la pantalla
			//System.out.flush();
			System.out.println("Su Auto esta pintado de " + col);
			
		}
	}
}