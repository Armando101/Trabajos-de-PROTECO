import java.io.Console;
public class Main {
	public static void main(String[] args) {
	
		Console o = System.console();		
		Traductor t = new Traductor(); 
		String opcion = "";
		
		while (!opcion.equals("Salir")) {
	
			System.out.printf("\n\t\tBienvenido al PrebeTraductor\n\n");	//Bienvenida
			System.out.println("\t\tIngrese una de las siguientes opciones\n");
										//Opciones
			System.out.printf("\t1)Traducir del Ingles al Espanol\t2)Traducir del Espanol al Ingles\n");
			System.out.printf("\t3)Agregar palabras al Traductor\t\t4)Ver todas las palabras del Traductor\n");
			System.out.printf("\t\t\t\t\tSalir\n\n");

			opcion = o.readLine();			//Seleccion de opcion
			t.Opciones(opcion);				//Hace la accion
			
			System.out.printf("\nPresione enter");
			Console r = System.console();	//Variable auxiliar para presionar una tecla y pasar a la siguiente opcion
			r.readLine();

			System.out.print("\033[H\033[2J");		//Borra la pantalla
			System.out.flush();

		}


	}
}