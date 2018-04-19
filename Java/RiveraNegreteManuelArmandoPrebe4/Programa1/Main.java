/**
*	@author Armando Rivera
*/
public class Main {
	public static void main(String[] args) {
		Auto a1 = new Auto();
		Auto a2 = new Auto(2010,"BMW", "Alanco");
		Auto a3 = new Auto(2005, "Ford", "Azul");

		a1.setAnio(2015);
		a1.setMarca("Toyota");
		a1.pintar("Rojo");

		System.out.println("El auto 2 es marca " + a2.getMarca());
		System.out.println("El auto 3 es de color " + a3.getColor());
		System.out.printf("El auto 1 es del anio %d \n\n", a1.getAnio());

		a3.pintar("Negro");

		System.out.println("Ahora el auto 3 es de color " + a3.getColor());

		System.out.println(a3.encender());
		a2.correr(110);
		a1.correr(150);
	}
}