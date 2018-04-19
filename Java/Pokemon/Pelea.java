import java.util.Scanner;
public class Pelea{
	public static void main(String[] args) {

		boolean turno =true;

		System.out.println("Este es el juego de peleas pokemon");
		System.out.println("Elije el nombre de un pokemon");
		System.out.printf("\n\tPara el jugador 1)\n");
		System.out.println("Bulbasur");
		System.out.printf("Charmander\n\n");

		Scanner entradaEcanner=new Scanner(System.in);
		String entrada = entradaEcanner.nextLine();

		System.out.printf("\n\tPara el jugador 2)\n\n");

		Scanner entradaEcanner2=new Scanner(System.in);
		String entrada2 = entradaEcanner2.nextLine();

		Pokemon uno = new Pokemon(entrada);
		Pokemon dos = new Pokemon(entrada2);

		System.out.print("\033[H\033[2J");
		System.out.flush();

		
		System.out.println("\n\n\tQue comience la pelea");
		
		while(uno.Vivo() && dos.Vivo()) {
		System.out.printf("	Charmadner				Bulbasur\n\n");

		System.out.printf("	 Ataques			Ataques\n\n");
		System.out.println(" 1) Lanzar Fuego			1) Lanzar Roca");
		System.out.println(" 2) Furia Dragon			2) Cabezazo");
		System.out.println(" 3) Grunido				3) Rodar");
		System.out.println(" 4) Humo				4) Destello");

		uno.NiveldeVida();
		dos.NiveldeVida();

		if (turno) {		//Jugador uno recibeel turno true
			System.out.println("Jugador 1) "+ uno.getNombre());
			System.out.println("Ingresa el Ataque");
			
			Scanner entAtak=new Scanner(System.in);
			String entA = entAtak.nextLine();

			Ataque ataqueUno = new Ataque(entA);	//Realiza el ataque
			ataqueUno.daniar();
			dos.modificarVida(ataqueUno.getDanio());
			}
		else {
			System.out.println("Jugador 2) "+ dos.getNombre());
			System.out.println("Ingresa el Ataque");
			
			Scanner entAtakB=new Scanner(System.in);
			String entB = entAtakB.nextLine();

			Ataque ataqueDos = new Ataque(entB);	//Realiza el ataque
			ataqueDos.daniar();
			uno.modificarVida(ataqueDos.getDanio());
		
		}


		if (turno)			//Va cambiando de turno con el jugador uno y dos
			turno=false;
		else 
			turno=true;

		System.out.print("\033[H\033[2J");
		System.out.flush();

		}			
		uno.NiveldeVida();
		dos.NiveldeVida();

		if (uno.getVida()>dos.getVida()) 
			System.out.println("El ganador es " + uno.getNombre());
		else
			System.out.println("El ganador es "+ dos.getNombre());	
		

	}
}