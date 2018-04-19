/**
*	Esta clase crea dos objetos Rectangulo y Circulo
*	Calcula el are y perimettro de ellos
* @author Armando Rivera
*/
public class Main{
	public static void main(String[] args) {
		
		double radio = 4;

		Circulo c = new Circulo(radio);

		System.out.printf("\nEl radio del Circulo es: %.2f\nEl diametro del Circulo es: %.2f\n", c.getRadio(), c.getDiametro());
		System.out.printf("El Area del Circulo es: %.2f \n", c.calcularArea());
		System.out.printf("El Perimetro del Circulo es: %.2f \n\n\n", c.calcularPerimetro());

		Rectangulo r = new Rectangulo();	//Se crea ste objeto a partir de numeros aleatorios
		System.out.printf("La base del Rectangulo es: %.2f\nLa Altura del rectangulo es %.2f\n", r.getBase(), r.getAltura());
		System.out.printf("El Area del Rectangulo es: %.2f \n", r.calcularArea());
		System.out.printf("El Perimetro del Rectangulo es: %.2f \n\n\n", r.calcularPerimetro());



	}
}