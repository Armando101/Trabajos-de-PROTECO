import java.io.Console;
import java.util.Map;
import java.util.HashMap;

public class MapTest {
	static Map<Persona, Animal> mascotas = new HashMap<Persona, Animal>();

	public static void main(String[] args) {
		Persona p1 = new Persona("Juan", "Perez");
		Persona p2 = new Persona("Pepe", "Gonzales");
		Animal a1 = new Animal("Perro");
		Animal a2 = new Animal("Canario");
		
		mascotas.put(p1, a1);
		mascotas.put(p2, a2);

		System.out.println(p1 + " tiene un " + mascotas.get(p1).getNombre());
		System.out.println(p2 + " tiene un " + mascotas.get(p2).getNombre());
		ImprimirMapa();
		System.out.println("Mapa contiene a Pepe: " + mascotas.containsKey(p2));
		mascotas.remove(p2);
		System.out.println("Mapa contiene a Pepe: " + mascotas.containsKey(p2));
		ImprimirMapa();

	/*	Estas lineas son para leer desde consola
		Console c = System.console();
		String line = c.readLine();
		System.out.println(line);
	*/
	}

	public static void ImprimirMapa() {
		System.out.println("\nContenido de mapa:");
		for (Persona p : mascotas.keySet()) {
			System.out.println(p + " : " + mascotas.get(p));
		}
		System.out.println("Total: " + mascotas.size() + "entradas\n");

	}

}