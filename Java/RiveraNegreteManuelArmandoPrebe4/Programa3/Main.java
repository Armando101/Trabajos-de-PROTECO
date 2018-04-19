import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Persona p = new Persona();

		System.out.println("Ingresa tu nombre");
		Scanner n = new Scanner(System.in);
		String 	nom = n.nextLine();
		p.setNombre(nom);	//Ingresa una cadena
		System.out.println("");

		System.out.println("Ingresa tu edad");
		Scanner ed = new Scanner(System.in);
		String eda = ed.nextLine();	
		p.setEdad(Integer.parseInt(eda)); 
		//Convierte la cadena a entero y la pasa como parametro
		System.out.println("");

		System.out.println("Ingresa tu estatura");
		Scanner es = new Scanner(System.in);
		String est = es.nextLine();
		p.setEstatura(Double.parseDouble(est));
		//Convierte la cadena a Double y la pasa 
		//Como parametro
		
		System.out.println("");
		System.out.println("Ingresa tu peso");
		Scanner pe = new Scanner(System.in);
		String pes = pe.nextLine();
		p.setPeso(Double.parseDouble(pes));


		System.out.printf("\n\n\tTus datos son:\n\nNombre: %s\nEdad: %d\nEstatura: %.2f\nPeso: %.2f\n\n", p.getNombre(), p.getEdad(), p.getEstatura(), p.getPeso());






	}
}