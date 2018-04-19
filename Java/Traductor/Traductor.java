import java.io.Console;
import java.util.Map;
import java.util.HashMap;

public class Traductor {
	
	static Map<String, String> tr = new HashMap<String, String>();
			//Ingles, Espanol

	public Traductor() {
		//Este constructor agregara las 5 palabras por defecto

		tr.put("Hello", "Hola");	
		tr.put("Bye", "Adios");	
		tr.put("NoteBook", "Cuaderno");	
		tr.put("Pencil", "Lapiz");	
		tr.put("Magazin", "Revista");	
		
	}

	public void Opciones (String o) {
		
		switch (o) {
			
			case "1" :
			System.out.println("Ingrese una palabra en Ingles");
			Console c = System.console();
			String p = c.readLine();
			IngEsp(p);
			break;

			case "2" :
			System.out.println("Ingrese una palabra en Espanol");
			Console e = System.console();
			String esp = e.readLine();
			EspIng(esp);
			break;

			case "3" :
			System.out.println("Ingrese una palabra en Ingles");
			Console i = System.console();
			String ing = i.readLine();
			Agregar(ing);
			break;	

			case "4":
			VerTraductor();
			break;

			case "Salir":
			System.out.println("Vuelve pronto");
			System.out.println();
			break;

			default:
			System.out.println("Opcion invalida");
			break;
		}
	}

	public static void IngEsp(String p) {
		if (tr.containsKey(p))		
			System.out.printf("\nTraducir palabra: " + p + "\nTraduccion: " + tr.get(p) + "\n");
		else if (tr.containsValue(p))
			System.out.println("Quiza quiso seleccionar la traduccion al Ingles");
		else
			System.out.println("La palabra no esta registrada para mostrar la traduccion");
	}
	public static void EspIng(String p) {
		if (tr.containsValue(p)) {
			for (String i : tr.keySet())
				if (tr.get(i).equals(p)) 
				System.out.printf("\nTraducir palabra: " + p + "\nTraduccion: "+ i + "\n");
		}
		else if (tr.containsKey(p)) 
			System.out.println("Quiza quiso seleccionar la traduccion al Espanol");
		else 
			System.out.println("La palabra no esta registrada");
	}
	public static void Agregar(String p) {

		if (tr.containsValue(p) || tr.containsKey(p)) {
			System.out.println("La palabra ya esta en el traductor");
			return;
		}

		System.out.println("Ingrese la palabra en Espanol");
		Console esp = System.console();
		String pesp = esp.readLine();

		tr.put(p, pesp);
		System.out.println("Palabra aniadida con exito");
	}
	public static void VerTraductor() {

		for (String p : tr.keySet())
			System.out.println(p + " : " + tr.get(p));
	}
}