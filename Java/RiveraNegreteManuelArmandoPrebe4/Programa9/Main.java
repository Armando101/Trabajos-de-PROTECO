/**
*	
*	La Clase Figura contien los metodos Perimetro y Area
*	El polimorfismo esta en que cada Figura tiene diferentes formas para obtener su area y perimetro
*	Estos metodos se sobreescriben en cada clase en particular
*	
*	@author Armando Rivera
*
*/

public class Main {
	public static void main(String[] args) {
			
			Circulo c = new Circulo(4);
			Rectangulo r = new Rectangulo(2,5);
			Triangulo t = new Triangulo(5,8);


			System.out.printf("El area del Circulo es: %.2f\n", c.Area());
			System.out.printf("El perimetro del es: %.2f\n\n", c.Perimetro());

			System.out.printf("El area del Rectangulo es: %.2f\n", r.Area());
			System.out.printf("El perimetro del Rectangulo es: %.2f\n\n", r.Perimetro());

			System.out.printf("El area del Triangulo es: %.2f\n", t.Area());
			System.out.printf("El perimetro del Triangulo es: %.2f\n\n", t.Perimetro());

	}
}